package chapter01;

import java.util.Scanner;

public class Lesson03 {

	/*
	 * Write a program to input from the keyboard the edge of a cube. Calculate and
	 * export the volume of a cube.
	 */

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the edge of a cube: ");
		int edge = scanner.nextInt();

		System.out.println("(Approach1) The volume of a cube: " + (edge * edge * edge));
		System.out.println("(Approach2) The volume of a cube: " + Math.pow(edge, 3));

		scanner.close();
	}
}
