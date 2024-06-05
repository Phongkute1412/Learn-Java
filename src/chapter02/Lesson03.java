package chapter02;

import java.util.Scanner;

public class Lesson03 {

	/*
	 * Write a program to input the amount of electricity used for the month and
	 * calculate the electricity bill using the progressive method. If the amount of
	 * electricity used is from 0 to 50, the price for each amount of electricity is
	 * 1000. If the amount of electricity used is over 50, the price for each amount
	 * of electricity exceeding the limit is 1200.
	 */

	public static void main(String[] args) {
		electricityBillCalculator();
	}

	public static void electricityBillCalculator() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the amount of electricity used for the month: ");
		int electricityUsed = scanner.nextInt();
		int billAmount;

		if (electricityUsed > 50) {
			billAmount = (50 * 1000) + ((electricityUsed - 50) * 1200);
		} else {
			billAmount = electricityUsed * 1000;
		}

		System.out.println("The electricity bill for the month is: " + billAmount + " VND");
		scanner.close();
	}
}