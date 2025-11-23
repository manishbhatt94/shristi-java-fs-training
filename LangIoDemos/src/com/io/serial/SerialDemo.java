package com.io.serial;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerialDemo {

	public static void main(String[] args) {

		User user = new User("manish", 11, "Compton");

		System.out.println("Serialzing " + user);
		// Process of serialization
		try (FileOutputStream fs = new FileOutputStream("user.ser");
				ObjectOutputStream os = new ObjectOutputStream(fs)) {
			os.writeObject(user);
			System.out.println("Serialized and saved to file user.ser");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
