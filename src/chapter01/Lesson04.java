package chapter01;

import java.util.Scanner;

public class Lesson04 {

	/*
	 * Write a program to enter the coefficients of a quadratic equation. Calculate
	 * the delta and output the delta root to the screen.
	 */

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("We have a quadratic equation: ax^2 + bx + c = 0");
		System.out.print("Enter coefficient a: ");
		int a = scanner.nextInt();
		System.out.print("Enter coefficient b: ");
		int b = scanner.nextInt();
		System.out.print("Enter coefficient c: ");
		int c = scanner.nextInt();
		System.out.println("Quadratic equation: " + a + "x^2 + " + b + "x + " + c + " = 0");

		if (a != 0 && b * b <= 4 * a * c) {
			double delta = b * b - 4 * a * c;
			System.out.println("The square root of delta is: " + Math.sqrt(delta));
		} else {
			System.out.println("No delta");
		}

		scanner.close();
	}
}
