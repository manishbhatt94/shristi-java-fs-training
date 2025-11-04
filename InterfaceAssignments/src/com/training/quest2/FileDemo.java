package com.training.quest2;

import java.util.Scanner;

public class FileDemo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter archive filename which you need to extract:");
		System.out.print("Enter filename here: ");
		String filename = scanner.next();

		System.out.println("\nChoose which extractor has to be used for extracting your archive file");
		System.out.println("Enter 'z' for zip file extractor");
		System.out.println("Enter 'j' for jar file extractor");
		System.out.println("Enter 'r' for rar file extractor");
		System.out.print("Enter choice ('z' / 'j' / 'r'): ");
		String choice = scanner.next().toLowerCase();
		scanner.close();

		IExtractor extractor = null;

		switch (choice) {
		case "z":
			System.out.println("\nUsing Zip extractor for extracting archive file:");
			extractor = new ZipExtractor();
			break;

		case "j":
			System.out.println("\nUsing Jar extractor for extracting archive file:");
			extractor = new JarExtractor();
			break;

		case "r":
			System.out.println("\nUsing Rar extractor for extracting archive file:");
			extractor = new RarExtractor();
			break;

		default:
			System.out.println("Invalid choice entered. Re-run the program & try again.");
			System.exit(0);
		}

		extractor.extractFiles(filename);
	}
}
