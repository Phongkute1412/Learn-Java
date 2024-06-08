package chapter01;

import java.util.Scanner;

public class Lesson02 {

	/*
	 * Write a program to input from the keyboard the two sides of a rectangle.
	 * Calculate and output the perimeter, area and small side of a rectangle.
	 */

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the length of the rectangle: ");
		int length = scanner.nextInt();
		System.out.print("Enter the width of the rectangle: ");
		int width = scanner.nextInt();

		System.out.println("The perimeter of the rectangle is: " + (length + width) * 2);
		System.out.println("The area of the rectangle is: " + (length * width));
		System.out.println("The small side of the rectangle is: " + Math.min(length, width));

		scanner.close();
	}

}
