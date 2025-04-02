package chapter05;

import java.util.ArrayList;
import java.util.Scanner;

public class Lesson01 {

	/*
	 * Enter a list of real numbers with arbitrary quantities from the keyboard then
	 * export the imported list and its total.
	 */

	public static void main(String[] args) {

		ArrayList<Double> arr = new ArrayList<Double>();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.print("Enter a number: ");
			Double number = scanner.nextDouble();
			scanner.nextLine();
			arr.add(number);

			System.out.print("Do you want stop (Y/N)?: ");
			String ans = scanner.nextLine();
			if (ans.equalsIgnoreCase("Y")) {
				break;
			}
		}

		double total = 0;
		System.out.println("--------------------------");
		System.out.println("The imported list: ");
		System.out.println("--------------------------");
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
			total = total + arr.get(i);
		}
		System.out.println("--------------------------");
		System.out.println("Total: " + total);
		scanner.close();
	}
}
