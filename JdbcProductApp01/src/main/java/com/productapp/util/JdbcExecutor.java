package com.productapp.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * A lightweight JDBC utility class to simplify query and update operations.
 * Provides methods for single/multi-row queries, updates, batch updates,
 * transaction handling, and streaming large result sets.
 */
public class JdbcExecutor {

	private final Connection connection;

	public JdbcExecutor(Connection connection) {
		this.connection = connection;
	}

	// -------------------- Query Methods --------------------

	/** Query returning multiple rows */
	public <T> List<T> queryAll(String sql, ResultSetMapper<T> mapper, Object... params) throws SQLException {
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			setParams(stmt, params);
			try (ResultSet rs = stmt.executeQuery()) {
				List<T> results = new ArrayList<>();
				while (rs.next()) {
					results.add(mapper.map(rs));
				}
				return results;
			}
		}
	}

	/** Query returning a single row (optimized, no unnecessary looping) */
	public <T> Optional<T> queryOne(String sql, ResultSetMapper<T> mapper, Object... params) throws SQLException {
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			setParams(stmt, params);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					return Optional.of(mapper.map(rs));
				} else {
					return Optional.empty();
				}
			}
		}
	}

	/** Stream query results lazily (use try-with-resources to close) */
	public <T> Stream<T> queryStream(String sql, ResultSetMapper<T> mapper, Object... params) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement(sql);
		setParams(stmt, params);
		ResultSet rs = stmt.executeQuery();

		Iterator<T> iterator = new Iterator<>() {
			private boolean hasNextChecked = false;
			private boolean hasNextValue = false;

			@Override
			public boolean hasNext() {
				if (!hasNextChecked) {
					try {
						hasNextValue = rs.next();
					} catch (SQLException e) {
						throw new RuntimeException(e);
					}
					hasNextChecked = true;
				}
				return hasNextValue;
			}

			@Override
			public T next() {
				if (!hasNext()) {
					throw new IllegalStateException("No more rows");
				}
				hasNextChecked = false;
				try {
					return mapper.map(rs);
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
		};

		return StreamSupport.stream(Spliterators.spliteratorUnknownSize(iterator, Spliterator.ORDERED), false)
				.onClose(() -> {
					try {
						rs.close();
						stmt.close();
					} catch (SQLException e) {
						throw new RuntimeException(e);
					}
				});
	}

	// -------------------- Update Methods --------------------

	/** Single update/insert/delete */
	public int update(String sql, Object... params) throws SQLException {
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			setParams(stmt, params);
			return stmt.executeUpdate();
		}
	}

	/** Single insert - also returns inserted record's auto-increment key */
	public int updateAndReturnKey(String sql, Object... params) throws SQLException {
		try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			setParams(stmt, params);
			int affectedRows = stmt.executeUpdate();
			if (affectedRows == 0) {
				throw new SQLException("Insert failed, no rows affected.");
			}
			try (ResultSet keys = stmt.getGeneratedKeys()) {
				if (keys.next()) {
					return keys.getInt(1);
				} else {
					throw new SQLException("Insert failed, no ID obtained.");
				}
			}
		}
	}

	/** Batch update/insert */
	public int[] batchUpdate(String sql, List<Object[]> batchParams) throws SQLException {
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			for (Object[] params : batchParams) {
				setParams(stmt, params);
				stmt.addBatch();
			}
			return stmt.executeBatch();
		}
	}

	// -------------------- Transaction Methods --------------------

	public void beginTransaction() throws SQLException {
		connection.setAutoCommit(false);
	}

	public void commit() throws SQLException {
		connection.commit();
		connection.setAutoCommit(true);
	}

	public void rollback() throws SQLException {
		connection.rollback();
		connection.setAutoCommit(true);
	}

	// -------------------- Helper --------------------

	private void setParams(PreparedStatement stmt, Object... params) throws SQLException {
		for (int i = 0; i < params.length; i++) {
			stmt.setObject(i + 1, params[i]);
		}
	}

	// -------------------- Functional Interface --------------------

	@FunctionalInterface
	public interface ResultSetMapper<T> {
		T map(ResultSet rs) throws SQLException;
	}
}
