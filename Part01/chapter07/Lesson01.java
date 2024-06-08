package chapter07;

import java.util.Scanner;

public class Lesson01 {

	/*
	 * Build a rectangle class with two properties: width and length and perimeter
	 * and area methods to calculate perimeter and area. The export method will
	 * output the width, length, area, and perimeter to the screen.
	 * 
	 * Construct a square class that inherits from the rectangle class and overrides
	 * the export method to output side, area, and perimeter information.
	 * 
	 * Write a program that imports 2 rectangles and a square and then outputs them
	 * to the screen.
	 */

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter width of the rectangle: ");
		double width = scanner.nextDouble();
		scanner.nextLine();

		System.out.print("Enter length of the rectangle: ");
		double length = scanner.nextDouble();
		scanner.nextLine();
		Rectangle rectangle = new Rectangle(width, length);

		System.out.println("--------------------------------------");

		System.out.print("Enter edge of the square: ");
		double edge = scanner.nextDouble();
		scanner.nextLine();
		Square square = new Square(edge);

		System.out.println("--------------------------------------");
		rectangle.export();
		System.out.println("--------------------------------------");
		square.export();

		scanner.close();
	}
}
