package chapter03;

import java.util.Scanner;

public class Lesson02 {

	/*
	 * Write a program to output the multiplication table to the screen
	 */

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print(
				"Enter the number for which you want to export the multiplication table (Enter \\\"all\\\" if you want to see the multiplication table from 1 to 9: ");
		String number = scanner.nextLine();

		if (isInteger(number)) {
			int multi = Integer.parseInt(number);
			for (int i = 1; i < 11; i++) {
				System.out.println(multi + " * " + i + " = " + (multi * i));
			}
		} else if (number.contentEquals("all")) {
			for (int i = 1; i < 10; i++) {
				for (int j = 1; j < 11; j++) {
					System.out.println(i + " * " + j + " = " + i * j);
				}
				System.out.println("------------");
			}
		} else {
			System.out.println("Invalid value");
		}

		scanner.close();
	}

	public static boolean isInteger(String a) {
		try {
			Integer.parseInt(a);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
