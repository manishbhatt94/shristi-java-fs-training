package com.training.scan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TwoDim {

	public static void main(String[] args) {
		/*
		 * Create a two dimensional array of type String and populate it using values
		 * from scanner. Iterate through the array and get the names that starts with
		 * ‘s’ and populate in a one dim array .Iterate the one dim array and print it.
		 */
		TwoDim obj = new TwoDim();

		String[][] text = obj.readStringMatrix();

		System.out.println("\nRead the below string 2-D array from input:");
		System.out.println(Arrays.deepToString(text));

		System.out
				.println("Searching for elements in the 2-D array," + "that start with the letter 's' (ignoring case)");

		List<String> matches = new ArrayList<>();

		for (String[] row : text) {
			for (String item : row) {
				if (item.toLowerCase().startsWith("s")) {
					matches.add(item);
				}
			}
		}

		if (matches.size() > 0) {
			System.out.println("Found below matches:");
			System.out.println(matches);
		} else {
			System.out.println("No matches found!");
		}
	}

	private String[][] readStringMatrix() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the dimensions for the string 2-D array\n"
				+ "(i.e. number of rows & number of columns for the 2-D array when prompted below)\n");
		System.out.print("Number of rows? ");
		int nrows = sc.nextInt();
		System.out.print("Number of columns? ");
		int ncols = sc.nextInt();

		sc.nextLine();

		String[][] arr = new String[nrows][ncols];

		System.out.println("\nEnter the string matrix, as instructed in prompts");

		for (int i = 0; i < nrows; i++) {
			System.out.println("\n> Enter row number " + (i + 1) + " - as prompted below (column-wise)");
			for (int j = 0; j < ncols; j++) {
				System.out.println(">> Enter string at Row #" + (i + 1) + " and Column #" + (j + 1) + " (below):");
				arr[i][j] = sc.nextLine().trim();
			}
		}

		sc.close();

		return arr;
	}
}
