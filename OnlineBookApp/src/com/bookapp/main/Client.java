package com.bookapp.main;

import java.util.Scanner;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.service.BookServiceImpl;
import com.bookapp.service.IBookService;
import com.bookapp.util.BookDetails;

enum AppMenuOption {
	LIST_ALL("Show all books.", null), LIST_BY_AUTHOR("Show books by author name.", "Enter author name"),
	LIST_BY_CATEGORY("Show books by genre / category.",
			"Enter book genre / category (e.g. Fantasy, Thriller, Satire, Romance. etc.)"),
	LIST_BY_MAX_PRICE("Show books with price less than a particular value.", "Enter maximum price amount"),
	LIST_BY_PUBLISH_YEAR("Show books published in a particular year.", "Enter publish year"),
	LIST_BY_AUTHOR_CATEGORY("Show books by author belonging to a genre.",
			"Enter author name, & genre (in separate lines - first author & press enter, then genre & press enter"),
	GET_BY_ID("Find book by ID.", "Enter book ID"), SHOW_MENU("Show App Menu again.", null), EXIT_APP("Exit App", null);

	String optionDesc;
	String optionSubDesc;

	private AppMenuOption(String optionDesc, String optionSubDesc) {
		this.optionDesc = optionDesc;
		this.optionSubDesc = optionSubDesc;
	}

}

public class Client {

	private final Scanner scanner;

	public Client() {
		scanner = new Scanner(System.in);
	}

	public static void main(String[] args) {

		Client client = new Client();
		client.runApp();
	}

	private void runApp() {
		System.out.println("Welcome to 'The Stream Reader' Book App!\n");
		showAppOptionMenu();

		while (true) {
			AppMenuOption choice = null;
			try {
				choice = getMenuChoice();
				handleUserChoice(choice);
			} catch (IllegalArgumentException e) {
				// IllegalArgumentException throw by
				// Enum.valueOf & also handleUserChoice
				System.out.println("Option entered is not valid. Try again!");
				continue;
			}
		}
	}

	private void showAppOptionMenu() {
		System.out.println("'The Stream Reader' Book App - Options Menu");
		System.out.println(
				"Check the below options menu to use our app.\n" + "Enter one of the option's code to proceed:\n");

		for (AppMenuOption menuOption : AppMenuOption.values()) {
			System.out.printf("[Option: %s] %s%n", menuOption.name(), menuOption.optionDesc);
		}
	}

	private AppMenuOption getMenuChoice() {
		System.out.println("\nEnter option code:");
		String input = scanner.nextLine().trim().toUpperCase();
		AppMenuOption choice = AppMenuOption.valueOf(input);
		return choice;
	}

	private void handleUserChoice(AppMenuOption choice) {
		System.out.println("\n" + choice.optionDesc);
		if (choice.optionSubDesc != null) {
			System.out.println(choice.optionSubDesc);
		}

		IBookService service = new BookServiceImpl();

		try {
			switch (choice) {
			case LIST_ALL: {
				BookDetails.printBooksList(service.getAll());
				break;
			}

			case LIST_BY_AUTHOR: {
				String author = scanner.nextLine().trim();
				BookDetails.printBooksList(service.getByAuthorContains(author));
				break;
			}

			case LIST_BY_CATEGORY: {
				String category = scanner.nextLine().trim();
				BookDetails.printBooksList(service.getByCategory(category));
				break;
			}

			case LIST_BY_MAX_PRICE: {
				double maxPrice = scanner.nextDouble();
				scanner.nextLine();
				BookDetails.printBooksList(service.getByPriceLessThan(maxPrice));
				break;
			}

			case LIST_BY_PUBLISH_YEAR: {
				int publishYear = scanner.nextInt();
				scanner.nextLine();
				BookDetails.printBooksList(service.getByDatePublished(publishYear));
				break;
			}

			case LIST_BY_AUTHOR_CATEGORY: {
				String author = scanner.nextLine().trim();
				String category = scanner.nextLine().trim();
				BookDetails.printBooksList(service.getByAuthorContainsAndCategory(author, category));
				break;
			}

			case GET_BY_ID: {
				int bookId = scanner.nextInt();
				scanner.nextLine();
				System.out.println("\n" + service.getById(bookId) + "\n");
				break;
			}

			case SHOW_MENU: {
				showAppOptionMenu();
				break;
			}

			case EXIT_APP: {
				System.out.println("Exiting App now!");
				System.exit(0);
				break;
			}

			default:
				throw new IllegalArgumentException("Invalid choice.");
			}
		} catch (BookNotFoundException e) {
			System.out.println("\nFilter criteria did not yield results. " + e.getMessage());
			System.out.println("Please check your input & re-enter details for this option again.");
			handleUserChoice(choice);
		}
	}

}
