package chapter07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Lesson04 {

	/*
	 * Write a student management program 1. Enter student list 2. Export student
	 * list information 3. Export a list of students with good academic performance
	 * 4. Sort the student list by score 5. end
	 */

	public static ArrayList<Student> students = new ArrayList<>();

	public static void main(String[] args) {
		boolean loop = true;
		Scanner scanner = new Scanner(System.in);

		while (loop) {
			System.out.println("+--------------------------------------------+");
			System.out.println("1. Enter student list.");
			System.out.println("2. Export student list information.");
			System.out.println("3. Export a list of students by academic ability performance.");
			System.out.println("4. Sort the student list by grade.");
			System.out.println("5. End.");
			System.out.println("+--------------------------------------------+");
			System.out.print("Select function: ");

			int function = scanner.nextInt();
			scanner.nextLine();

			switch (function) {
			case 1:
				enterStudent(scanner);
				break;
			case 2:
				exportImportedList();
				break;
			case 3:
				if (students.size() == 0) {
					System.out.println("List of students is empty. Please choose again");
				} else {
					exportListOfStudentsByAcademicAbility(scanner);
				}
				break;
			case 4:
				Collections.sort(students, new Comparator<Student>() {
					public int compare(Student st1, Student st2) {
						return Double.compare(st1.getGrade(), st2.getGrade());
					}
				});
				exportImportedList();
				break;
			case 5:
				System.out.println("End program.");
				loop = false;
				break;
			}
		}
		scanner.close();
	}

	public static ArrayList<Student> enterStudent(Scanner scanner) {
		System.out.println("+--------------------------------------------+");
		while (true) {
			System.out.print("Enter student name: ");
			String name = scanner.nextLine();

			while (true) {
				System.out.print("Enter student major ('IT' for IT and 'MAR' for Marketing): ");
				String major = scanner.nextLine();
				if (major.equalsIgnoreCase("IT")) {
					System.out.print("Enter Java score: ");
					double java = scanner.nextDouble();
					System.out.print("Enter HTML score: ");
					double html = scanner.nextDouble();
					System.out.print("Enter CSS score: ");
					double css = scanner.nextDouble();
					scanner.nextLine(); // Consume the remaining newline

					ITStudent itStudent = new ITStudent(name, java, html, css);
					students.add(itStudent);
					break;

				} else if (major.equalsIgnoreCase("MAR")) {
					System.out.print("Enter Marketing score: ");
					double marketing = scanner.nextDouble();
					System.out.print("Enter Sales score: ");
					double sales = scanner.nextDouble();
					scanner.nextLine(); // Consume the remaining newline

					MARStudent marStudent = new MARStudent(name, marketing, sales);
					students.add(marStudent);
					break;

				} else {
					System.out.println("Invalid major entered. Please try again");
				}
			}

			System.out.print("Do you want stop (Y/N)?: ");
			String ans = scanner.nextLine();
			if (ans.equalsIgnoreCase("Y")) {
				break;
			}
		}
		return students;
	}

	public static void exportImportedList() {
		if (students.size() == 0) {
			System.out.println("+--------------------------------------------+");
			System.out.println("List of students is empty. Please choose again");
		} else {
			System.out.println("+--------------------------------------------+");
			System.out.println("Export the imported list: ");
			for (Student student : students) {
				student.export();
				System.out.println("+--------------------------------------------+");
			}
		}
	}

	public static void exportListOfStudentsByAcademicAbility(Scanner scanner) {
		System.out.print("Enter the academic ability you want to export: ");
		String academicAbility = scanner.nextLine();

		for (Student student : students) {
			if (student.getAcademicAbility().equalsIgnoreCase(academicAbility)) {
				student.export();
				System.out.println("+--------------------------------------------+");
			}
		}
	}
}