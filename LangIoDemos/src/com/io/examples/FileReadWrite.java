package com.io.examples;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReadWrite {

	public static void main(String[] args) {

		FileReader reader = null;
		try {
			reader = new FileReader("demo1.txt");
			int data = reader.read();
			while (data != -1) {
				System.out.print((char) data);
				data = reader.read();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
