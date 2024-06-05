package chapter01;

import java.util.Scanner;

public class Lesson01 {

	/*
	 * Write a program that allows you to enter the student's full name and average
	 * score from the keyboard and then print it to the screen with the format:
	 * <<full name>> <<score>> score.
	 */

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Your full name: ");
		String name = scanner.nextLine();

		System.out.print("Your average score: ");
		double score = scanner.nextDouble();

		System.out.println(name + " " + score + " score");

		scanner.close();
	}
}
