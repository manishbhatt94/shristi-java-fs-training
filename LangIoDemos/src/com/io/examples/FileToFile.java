package com.io.examples;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileToFile {

	public static void main(String[] args) {

		FileReader reader = null;
		FileWriter writer = null;
		try {
			reader = new FileReader("demo.txt");
			writer = new FileWriter("hello.txt");
			int data = reader.read();
			while (data != -1) {
				writer.write(data);
				data = reader.read();
			}
			System.out.println("Data written to file hello.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
