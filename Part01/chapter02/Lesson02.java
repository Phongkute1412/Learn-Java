package chapter02;

import java.util.Scanner;

public class Lesson02 {

	/*
	 * Write a program that allows you to solve a quadratic equation in which the
	 * coefficients a, b and c are entered from the keyboard.
	 */

	public static void main(String[] args) {
		quadraticEquation();
	}

	public static void quadraticEquation() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("We have a first-order equation: ax^2 + bx + c = 0");
		System.out.print("Enter coefficient a: ");
		double a = scanner.nextDouble();
		System.out.print("Enter coefficient b: ");
		double b = scanner.nextDouble();
		System.out.print("Enter coefficient c: ");
		double c = scanner.nextDouble();
		System.out.println("Quadratic equation: " + a + "x^2 + " + b + "x " + c + " = 0");

		if (a == 0) {
			if (b == 0) {
				if (c == 0) {
					System.out.println("The equation has infinitely many solutions");
				} else {
					System.out.println("The equation has no solution");
				}
			} else {
				System.out.println("The equation with solution x is: " + (-c / b));
			}
		} else {
			double delta = b * b - 4 * a * c;

			if (delta > 0) {
				double x1 = (-b - Math.sqrt(delta)) / (2 * a);
				double x2 = (-b + Math.sqrt(delta)) / (2 * a);
				System.out.println("The equation has two distinct solutions: x1 = " + x1 + "; x2 = " + x2);
			} else if (delta == 0) {
				double x = -b / (2 * a);
				System.out.println("The equation has a double solution: x = " + x);
			} else {
				double realPart = -b / (2 * a);
				double imaginaryPart = Math.sqrt(-delta) / (2 * a);
				System.out.println("Phương trình có hai nghiệm phức:");
				System.out.println("x1 = " + realPart + " + " + imaginaryPart + "i");
				System.out.println("x2 = " + realPart + " - " + imaginaryPart + "i");
			}
		}

		scanner.close();
	}
}
