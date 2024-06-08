package chapter06;

import java.util.Scanner;

public class Lesson01 {

	/*
	 * Enter first and last name from the keyboard. Output first name, last name and
	 * middle name to the screen in which first and last names are output IN CAPS.
	 */

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter your full name: ");
		String name = scanner.nextLine();

		String lastname = name.substring(0, name.indexOf(" "));
		String middlename = name.substring(name.indexOf(" ") + 1, name.lastIndexOf(" "));
		String firstname = name.substring(name.lastIndexOf(" ") + 1);

		System.out.println("Your last name is: " + lastname.toUpperCase());
		System.out.println("Your middle name is: " + middlename);
		System.out.println("Your first name is: " + firstname.toUpperCase());

		scanner.close();
	}
}
