package com.training.quest3;

import java.util.Scanner;

public class CompressorMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter filenames (space separated) which have to be compressed in an archive file:");
		System.out.println("Enter filenames (space separated) below:");
		String names = scanner.nextLine().trim();
		String[] files = names.split("\\s+");

		System.out.println("\nChoose which archive you want for compressing your files");
		System.out.println("Enter 'z' for zip file compressor");
		System.out.println("Enter 'j' for jar file compressor");
		System.out.println("Enter 'r' for rar file compressor");
		System.out.print("Enter choice ('z' / 'j' / 'r'): ");
		String choice = scanner.next().toLowerCase();
		scanner.close();

		IFileCompressor compressor = null;

		switch (choice) {
		case "z":
			System.out.println("\nUsing Zip compressor for archiving your files:");
			compressor = new ZipCompressor();
			break;

		case "j":
			System.out.println("\nUsing Jar compressor for archiving your files:");
			compressor = new JarCompressor();
			break;

		case "r":
			System.out.println("\nUsing Rar compressor for archiving your files:");
			compressor = new RarCompressor();
			break;

		default:
			System.out.println("Invalid choice entered. Re-run the program & try again.");
			System.exit(0);
		}

		compressor.compressFiles(files);
	}
}
