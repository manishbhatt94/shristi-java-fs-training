package com.io.examples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReadWrite {

	public static void main(String[] args) {

		// InputStreamReader is a bridge from byte streams to character streams
		// It reads bytes and decodes them into characters
		InputStreamReader isr = new InputStreamReader(System.in);
		// Create an object of BufferedReader which can read only characters
		BufferedReader br = new BufferedReader(isr);

		System.out.println("Enter input to be read:");
		try {
			char val = (char) br.read();
			while (val != 'q') {
				System.out.print(val);
				val = (char) br.read();
			}
			System.out.println("\nEncountered quit 'q' char. Reading done!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
