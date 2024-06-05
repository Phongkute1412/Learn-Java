package chapter03;

import java.util.Arrays;
import java.util.Scanner;

public class Lesson03 {

	/*
	 * Write a program to input an array of integers from the keyboard. Sort and
	 * export the newly entered array to the screen. Output the element with the
	 * smallest value to the screen. Calculate and output to the screen the average
	 * of elements divisible by 3
	 */

	public static void main(String[] args) {
		inputAnArrayOfIntegersApp1();
	}

	public static void inputAnArrayOfIntegersApp1() {
		Scanner scanner = new Scanner(System.in);
		double avg = 0;
		double avgCount = 0;

		System.out.print("Enter the elements of the array, separated by spaces: ");
		String input = scanner.nextLine();

		String[] parts = input.split(" ");
		int[] arr = new int[parts.length];

		for (int i = 0; i < parts.length; i++) {
			arr[i] = Integer.parseInt(parts[i]);
			if (arr[i] % 3 == 0) {
				avg = avg + arr[i];
				avgCount++;
			}
		}

		System.out.println("- The imported array is: " + Arrays.toString(arr));
		Arrays.sort(arr);
		System.out.println("- The sorted array is: " + Arrays.toString(arr));
		System.out.println("- Average of elements divisible by 3: " + (avg / avgCount));

		scanner.close();
	}

	public static void inputAnArrayOfIntegersApp2() {
		Scanner scanner = new Scanner(System.in);
		double avg = 0;
		double avgCount = 0;

		System.out.print("Enter array size: ");
		int size = scanner.nextInt();
		int[] arr = new int[size];

		System.out.println("Enter the elements of the array");
		for (int i = 0; i < size; i++) {
			System.out.print("Enter the " + (i + 1) + " element: ");
			arr[i] = scanner.nextInt();
			if (arr[i] % 3 == 0) {
				avg = avg + arr[i];
				avgCount++;
			}
		}

		System.out.println("- The imported array is: " + Arrays.toString(arr));
		Arrays.sort(arr);
		System.out.println("- The sorted array is: " + Arrays.toString(arr));
		System.out.println("- Average of elements divisible by 3: " + (avg / avgCount));

		scanner.close();
	}
}
