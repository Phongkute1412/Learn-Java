package chapter03;

import java.util.Arrays;
import java.util.Scanner;

public class Lesson04 {

	/*
	 * Write a program to enter 2 arrays of students' names and grades. Export the 2
	 * imported arrays, each student has more academic ability Ordinary: grade < 5
	 * Average good: 5 <= grade < 6.5 Good: 6.5 <= grade < 7.5 Very Good: 7.5 <=
	 * grade < 9 Excellent: grade >= 9 Sort the imported student list in ascending
	 * order by grade.
	 */

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter number of students: ");
		int size = scanner.nextInt();
		scanner.nextLine();

		String[] name = new String[size];
		double[] grade = new double[size];
		String[] academicAbility = new String[size];

		System.out.println("Enter student information");
		for (int i = 0; i < size; i++) {
			System.out.print("Enter the first and last name of the " + (i + 1) + " student: ");
			name[i] = scanner.nextLine();

			System.out.print("Enter the grade of the " + (i + 1) + " student: ");
			grade[i] = scanner.nextDouble();
			scanner.nextLine();

			if (grade[i] >= 5 && grade[i] < 6.5) {
				academicAbility[i] = "Average good";
			} else if (grade[i] >= 6.5 && grade[i] < 7.5) {
				academicAbility[i] = "Good";
			} else if (grade[i] >= 7.5 && grade[i] < 9) {
				academicAbility[i] = "Very Good";
			} else if (grade[i] >= 9) {
				academicAbility[i] = "Excellent";
			} else {
				academicAbility[i] = "Ordinary";
			}
		}

		System.out.println("- The entered student first and last name array is: " + Arrays.toString(name));
		System.out.println("- The array of student grades entered is: " + Arrays.toString(grade));
		System.out.println("- The student's academic performance according to the entered grades is: "
				+ Arrays.toString(academicAbility));

		for (int i = 0; i < grade.length - 1; i++) {
			for (int j = i + 1; j < grade.length; j++) {
				if (grade[i] > grade[j]) {
					double temp1 = grade[i];
					grade[i] = grade[j];
					grade[j] = temp1;

					String temp2 = name[i];
					name[i] = name[j];
					name[j] = temp2;

					String temp3 = academicAbility[i];
					academicAbility[i] = academicAbility[j];
					academicAbility[j] = temp3;
				}
			}
		}

		System.out.println("---------------------");
		System.out.println("Student information in ascending order of grades:");
		System.out.println("---------------------");

		for (int i = 0; i < name.length; i++) {
			System.out.println("- Full name: " + name[i]);
			System.out.println("- Grade: " + grade[i]);
			System.out.println("- Academic ability: " + academicAbility[i]);
			System.out.println("---------------------");
		}

		scanner.close();
	}
}
