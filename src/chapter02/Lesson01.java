package chapter02;

import java.util.Scanner;

public class Lesson01 {

	/*
	 * Write a program that allows you to solve a first-order equation in which the
	 * coefficients a and b are entered from the keyboard.
	 */

	public static void main(String[] args) {
		firstOrderEquation();
	}

	public static void firstOrderEquation() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("We have a first-order equation: ax + b = 0");
		System.out.print("Enter coefficient a: ");
		double a = scanner.nextDouble();
		System.out.print("Enter coefficient b: ");
		double b = scanner.nextDouble();
		System.out.println("First-order equation: " + a + "x + " + b + " = 0");

		if (a == 0) {
			if (b == 0) {
				System.out.println("The equation has infinitely many solutions");
			} else {
				System.out.println("The equation has no solution");
			}
		} else if (b == 0) {
			System.out.println("The equation with solution x is: 0");
		} else {
			System.out.println("The equation with solution x is: " + (-b / a));
		}

		scanner.close();
	}
}
