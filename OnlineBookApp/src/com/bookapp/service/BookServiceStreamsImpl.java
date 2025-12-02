package com.bookapp.service;

import java.util.List;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.util.BookDetails;

public class BookServiceStreamsImpl implements IBookService {

	@Override
	public List<Book> getAll() {
		return BookDetails.getBooks();
	}

	@Override
	public List<Book> getByAuthorContains(String author) throws BookNotFoundException {
		List<Book> matches = BookDetails.getBooks().stream().filter(book -> {
			String bookAuthor = book.getAuthor().toLowerCase();
			String queriedAuthor = author.toLowerCase();
			return bookAuthor.contains(queriedAuthor);
		}).toList();
		if (matches.isEmpty()) {
			throw new BookNotFoundException(
					String.format("Book Not Found: Books with author: '%s' not found.", author));
		}
		return matches;
	}

	@Override
	public List<Book> getByCategory(String category) throws BookNotFoundException {
		List<Book> matches = BookDetails.getBooks().stream()
				.filter(book -> book.getCategory().equalsIgnoreCase(category)).toList();
		if (matches.isEmpty()) {
			throw new BookNotFoundException(
					String.format("Book Not Found: Books with category: '%s' not found.", category));
		}
		return matches;
	}

	@Override
	public List<Book> getByPriceLessThan(double price) throws BookNotFoundException {
		List<Book> matches = BookDetails.getBooks().stream().filter(book -> book.getPrice() <= price).toList();
		if (matches.isEmpty()) {
			throw new BookNotFoundException(
					String.format("Book Not Found: Books with price up to ₹%.2f not found.", price));
		}
		return matches;
	}

	@Override
	public List<Book> getByDatePublished(int year) throws BookNotFoundException {
		List<Book> matches = BookDetails.getBooks().stream().filter(book -> book.getDatePublished().getYear() == year)
				.toList();
		if (matches.isEmpty()) {
			throw new BookNotFoundException(
					String.format("Book Not Found: Books published in year: '%d' not found.", year));
		}
		return matches;
	}

	@Override
	public List<Book> getByAuthorContainsAndCategory(String author, String category) throws BookNotFoundException {
		List<Book> matches = BookDetails.getBooks().stream().filter(book -> {
			String bookAuthor = book.getAuthor().toLowerCase();
			String queriedAuthor = author.toLowerCase();
			return bookAuthor.contains(queriedAuthor) && book.getCategory().equalsIgnoreCase(category);
		}).toList();
		if (matches.isEmpty()) {
			throw new BookNotFoundException(String.format(
					"Book Not Found: Books with author: '%s' & under category: '%s' not found.", author, category));
		}
		return matches;
	}

	@Override
	public Book getById(int bookId) throws BookNotFoundException {
		return BookDetails.getBooks().stream().filter(book -> book.getBookId() == bookId).findFirst()
				.orElseThrow(() -> new BookNotFoundException(
						String.format("Book Not Found: Book with ID: '%d' not found.", bookId)));
	}

}
