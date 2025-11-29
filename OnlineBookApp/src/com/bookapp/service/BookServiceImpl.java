package com.bookapp.service;

import java.util.ArrayList;
import java.util.List;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.util.BookDetails;

public class BookServiceImpl implements IBookService {

	@Override
	public List<Book> getAll() {
		return BookDetails.getBooks();
	}

	@Override
	public List<Book> getByAuthorContains(String author) throws BookNotFoundException {
		List<Book> matches = new ArrayList<>();
		for (Book book : BookDetails.getBooks()) {
			String bookAuthor = book.getAuthor().toLowerCase();
			String queriedAuthor = author.toLowerCase();
			if (bookAuthor.contains(queriedAuthor)) {
				matches.add(book);
			}
		}
		if (matches.isEmpty()) {
			throw new BookNotFoundException(
					String.format("Book Not Found: Books with author: '%s' not found.", author));
		}
		return matches;
	}

	@Override
	public List<Book> getByCategory(String category) throws BookNotFoundException {
		List<Book> matches = new ArrayList<>();
		for (Book book : BookDetails.getBooks()) {
			if (book.getCategory().equalsIgnoreCase(category)) {
				matches.add(book);
			}
		}
		if (matches.isEmpty()) {
			throw new BookNotFoundException(
					String.format("Book Not Found: Books with category: '%s' not found.", category));
		}
		return matches;
	}

	@Override
	public List<Book> getByPriceLessThan(double price) throws BookNotFoundException {
		List<Book> matches = new ArrayList<>();
		for (Book book : BookDetails.getBooks()) {
			if (book.getPrice() <= price) {
				matches.add(book);
			}
		}
		if (matches.isEmpty()) {
			throw new BookNotFoundException(
					String.format("Book Not Found: Books with price up to ₹%.2f not found.", price));
		}
		return matches;
	}

	@Override
	public List<Book> getByDatePublished(int year) throws BookNotFoundException {
		List<Book> matches = new ArrayList<>();
		for (Book book : BookDetails.getBooks()) {
			if (book.getDatePublished().getYear() == year) {
				matches.add(book);
			}
		}
		if (matches.isEmpty()) {
			throw new BookNotFoundException(
					String.format("Book Not Found: Books published in year: '%d' not found.", year));
		}
		return matches;
	}

	@Override
	public List<Book> getByAuthorContainsAndCategory(String author, String category) throws BookNotFoundException {
		List<Book> matches = new ArrayList<>();
		for (Book book : BookDetails.getBooks()) {
			String bookAuthor = book.getAuthor().toLowerCase();
			String queriedAuthor = author.toLowerCase();
			if (bookAuthor.contains(queriedAuthor) && book.getCategory().equalsIgnoreCase(category)) {
				matches.add(book);
			}
		}
		if (matches.isEmpty()) {
			throw new BookNotFoundException(String.format(
					"Book Not Found: Books with author: '%s' & under category: '%s' not found.", author, category));
		}
		return matches;
	}

	@Override
	public Book getById(int bookId) throws BookNotFoundException {
		for (Book book : BookDetails.getBooks()) {
			if (book.getBookId() == bookId) {
				return book;
			}
		}
		throw new BookNotFoundException(String.format("Book Not Found: Book with ID: '%d' not found.", bookId));
	}

}
