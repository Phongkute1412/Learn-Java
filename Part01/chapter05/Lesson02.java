package chapter05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Lesson02 {

	/*
	 * Write a program that performs the following functions: 1. Enter a list of
	 * first and last names 2. Export the imported list 3. Export random list 4.
	 * Arrange discounts and export lists 5. Find and delete the full name entered
	 * from the keyboard 6. End
	 */

	public static ArrayList<String> arr = new ArrayList<>();

	public static void main(String[] args) {
		boolean loop = true;
		Scanner scanner = new Scanner(System.in);

		while (loop) {
			System.out.println("+--------------------------------------------+");
			System.out.println("1. Enter a list of first and last names");
			System.out.println("2. Export the imported list");
			System.out.println("3. Export random list");
			System.out.println("4. Arrange discounts and export lists");
			System.out.println("5. Find and delete the full name entered from the keyboard");
			System.out.println("6. End");
			System.out.println("+--------------------------------------------+");
			System.out.print("Select function: ");

			int function = scanner.nextInt();
			scanner.nextLine();

			switch (function) {
			case 1:
				enterFullName(scanner);
				break;
			case 2:
				exportImportedList();
				break;
			case 3:
				Collections.shuffle(arr);
				exportImportedList();
				break;
			case 4: // In Java, the strings are arranged in lexicographical (alphabetical) order by
					// default.
				Collections.sort(arr, Collections.reverseOrder());
				exportImportedList();
				break;
			case 5:
				if (arr.size() == 0) {
					System.out.println("List of first and last names is empty. Please choose again");
				} else {
					deleteElement(scanner);
				}
				break;
			case 6:
				System.out.println("End program.");
				loop = false;
				break;
			}
		}
	}

	public static ArrayList<String> enterFullName(Scanner scanner) {
		System.out.println("+--------------------------------------------+");
		while (true) {
			System.out.print("Enter first and last name: ");
			String name = scanner.nextLine();
			arr.add(name);

			System.out.print("Do you want stop (Y/N)?: ");
			String ans = scanner.nextLine();
			if (ans.equalsIgnoreCase("Y")) {
				break;
			}
		}
		return arr;
	}

	public static void exportImportedList() {
		if (arr.size() == 0) {
			System.out.println("+--------------------------------------------+");
			System.out.println("List of first and last names is empty. Please choose again");
		} else {
			System.out.println("+--------------------------------------------+");
			System.out.println("Export the imported list: ");
			for (String s : arr) {
				System.out.println(s);
			}
		}
	}

	public static void deleteElement(Scanner scanner) {
		System.out.print("Enter the Full Name you want to delete: ");
		String a = scanner.nextLine();
		arr.removeIf(name -> name.equals(a));
	}
}
