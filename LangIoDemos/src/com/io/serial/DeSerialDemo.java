package com.io.serial;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeSerialDemo {

	public static void main(String[] args) {

		System.out.println("DeSerialzing user object from file user.ser");

		// Process of serialization
		try (FileInputStream fs = new FileInputStream("user.ser"); ObjectInputStream os = new ObjectInputStream(fs)) {
			User user = (User) os.readObject();
			System.out.println("Successfully deserialized User object " + user + " from file user.ser");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

/*
 * DeSerializing without updating the user.ser file
 *
 * DeSerialzing user object from file user.ser java.io.InvalidClassException:
 * com.io.serial.User; local class incompatible: stream classdesc
 * serialVersionUID = 1, local class serialVersionUID = 2 at
 * java.base/java.io.ObjectStreamClass.initNonProxy(ObjectStreamClass.java:496)
 * at
 * java.base/java.io.ObjectInputStream.readNonProxyDesc(ObjectInputStream.java:
 * 1927) at
 * java.base/java.io.ObjectInputStream.readClassDesc(ObjectInputStream.java:
 * 1785) at
 * java.base/java.io.ObjectInputStream.readOrdinaryObject(ObjectInputStream.java
 * :2101) at
 * java.base/java.io.ObjectInputStream.readObject0(ObjectInputStream.java:1620)
 * at java.base/java.io.ObjectInputStream.readObject(ObjectInputStream.java:487)
 * at java.base/java.io.ObjectInputStream.readObject(ObjectInputStream.java:445)
 * at LangIoDemos/com.io.serial.DeSerialDemo.main(DeSerialDemo.java:15)
 */
