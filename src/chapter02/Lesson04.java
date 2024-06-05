package chapter02;

import java.util.Scanner;

public class Lesson04 {

	/*
	 * Write a program to organize a menu with 3 functions to call the above 3
	 * exercises and a function to exit the application.
	 */

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("+--------------------------------------------+");
		System.out.println("1. Solve first-order equations");
		System.out.println("2. Solve quadratic equations");
		System.out.println("3. Calculate electricity bill");
		System.out.println("+--------------------------------------------+");
		System.out.print("Select function: ");

		int function = scanner.nextInt();

		switch (function) {
		case 1:
			Lesson01.firstOrderEquation();
			break;
		case 2:
			Lesson02.quadraticEquation();
			break;
		case 3:
			Lesson03.electricityBillCalculator();
			break;
		}

		scanner.close();
	}
}