package chapter03;

import java.util.Scanner;

public class Lesson01 {

	/*
	 * Write a program to enter an integer from the keyboard and indicate whether
	 * that number is a prime number or not (a prime number is a number that is only
	 * divisible by 1 and itself).
	 */

	public static void main(String[] args) {
		primeNumberCheckerApp1();
	}

	public static void primeNumberCheckerApp1() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter an integer: ");
		int number = scanner.nextInt();
		int count = 0;

		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				count++;
			}
		}

		if (number <= 1) {
			System.out.println(number + " is not prime number.");
		} else if (count == 0) {
			System.out.println(number + " is a prime number.");
		} else {
			System.out.println(number + " is not a prime number.");
		}

		scanner.close();
	}

	public static void primeNumberCheckerApp2() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter an integer: ");
		int number = scanner.nextInt();
		scanner.close();

		if (isPrime(number)) {
			System.out.println(number + " is a prime number.");
		} else {
			System.out.println(number + " is not a prime number.");
		}
	}

	public static boolean isPrime(int num) {
		if (num <= 1) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}