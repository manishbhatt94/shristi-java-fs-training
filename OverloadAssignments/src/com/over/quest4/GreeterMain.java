package com.over.quest4;

public class GreeterMain {

	public static void main(String[] args) {
		Greeter obj1 = new Greeter("Sara");
		obj1.greetUser("welcome", "Great day");
		obj1.greetUser("Good Day", "Have Tea", "Enjoy Learning");

		Greeter obj2 = new Greeter();
		obj2.sayHello("Sri", "Priya");
		obj2.sayHello("Sara", "Anna", "Reena", "Rohan");
		obj2.sayHello("Jo", "Roni");
	}
}
