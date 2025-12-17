package com.productapp.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class TableSeeder<T> {

	private static final int INSERT_BATCH_SIZE = 50;

	@SuppressWarnings("unused")
	private final Connection connection;

	private final JdbcExecutor executor;

	public TableSeeder(Connection connection) {
		this.connection = connection;
		this.executor = new JdbcExecutor(connection);
	}

	/**
	 * Seeds a table with generated entities.
	 *
	 * @param createTableSql SQL to create the table if not exists
	 * @param truncateSql    SQL to truncate the table
	 * @param countSql       SQL to count rows in the table
	 * @param insertSql      SQL to insert a row
	 * @param expectedCount  expected number of seed rows
	 * @param seedEntities   list of entities to seed
	 * @param paramMapper    maps an entity to Object[] insert parameters
	 */
	public void seed(String createTableSql, String truncateSql, String countSql, String insertSql, int expectedCount,
			List<T> seedEntities, Function<T, Object[]> paramMapper) throws SQLException {

		// Create table if not exists
		executor.update(createTableSql);

		// Check current count
		int count = executor.queryOne(countSql, rs -> rs.getInt(1)).orElse(0);

		if (count != expectedCount) {
			System.out.println("Seeder - Table contains non-seed data. Truncating & reseeding...");
			executor.update(truncateSql);

			try {
				executor.beginTransaction();

				int processed = 0;
				List<Object[]> buffer = new ArrayList<>();

				for (T entity : seedEntities) {
					buffer.add(paramMapper.apply(entity));
					processed++;
					if (processed % INSERT_BATCH_SIZE == 0) {
						executor.batchUpdate(insertSql, buffer);
						buffer.clear();
						System.out.println("Seeder - Executed intermediate batch of " + INSERT_BATCH_SIZE);
					}
				}

				if (!buffer.isEmpty()) {
					executor.batchUpdate(insertSql, buffer);
				}

				executor.commit();
				System.out.println("Seeder - Seeding successful. Rows inserted: " + seedEntities.size());
			} catch (SQLException e) {
				executor.rollback();
				throw e;
			}
		}
	}
}
