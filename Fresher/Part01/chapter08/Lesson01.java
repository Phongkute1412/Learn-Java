package chapter08;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lesson01 {

	/*
	 * Create a final class named Chapter08 and add static methods and write code as
	 * required by the following articles. Add a static method named sum() with a
	 * parameter of type double. Write code for this method to perform the sum of
	 * the input parameters.
	 */

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		double sumAPP1 = Chapter08.sum(1, 2, 3, 4, 5, 6);
		System.out.println("The sum is: " + sumAPP1);
		System.out.println("The min is: " + Chapter08.min(3, 2, 1, 4, 5, 6));
		System.out.println("The max is: " + Chapter08.max(3, 2, 6, 4, 5, 1));

		List<Double> numbers = enterNumbers(scanner);
		double[] doubleArray = numbersArray(numbers);

		double sumAPP2 = Chapter08.sum(doubleArray);
		System.out.println("The sum is: " + sumAPP2);
		System.out.println("The min is: " + Chapter08.min(doubleArray));
		System.out.println("The max is: " + Chapter08.max(doubleArray));

		System.out.print("The string is: ");
		String s = scanner.nextLine();
		Chapter08.toUpperFirstChar(s);

		scanner.close();
	}

	public static List<Double> enterNumbers(Scanner scanner) {
		List<Double> numbers = new ArrayList<>();

		System.out.println("Enter numbers. Type 'done' to finish:");

		while (true) {
			String input = scanner.nextLine();
			if (input.equalsIgnoreCase("done")) {
				break;
			}
			try {
				double number = Double.parseDouble(input);
				numbers.add(number);
			} catch (NumberFormatException e) {
				System.out.println("Invalid input. Please enter a number or 'done' to finish.");
			}
		}
		return numbers;
	}

	public static double[] numbersArray(List<Double> numbers) {
		double[] numbersArray = new double[numbers.size()];
		for (int i = 0; i < numbers.size(); i++) {
			numbersArray[i] = numbers.get(i);
		}
		return numbersArray;
	}
}
