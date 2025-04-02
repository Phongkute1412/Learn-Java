package chapter06;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lesson03 {

	/*
	 * Enter into the array 5 students (each student includes full name, email,
	 * phone number, identity card). Check and report errors if the email format,
	 * phone number and ID card are entered incorrectly.
	 */

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Student> students = new ArrayList<Student>();
		int count = 0;

		Pattern patternEmail = Pattern.compile("^(?=.{1,64}@)[A-Za-z0-9\\+_-]+(\\.[A-Za-z0-9\\+_-]+)*@"
				+ "[^-][A-Za-z0-9\\+-]+(\\.[A-Za-z0-9\\+-]+)*(\\.[A-Za-z]{2,})$");
		Pattern patternPhone = Pattern.compile("^\\d{10}$");
		Pattern patternID = Pattern.compile("[0-9]{9}");

		while (count < 5) {
			boolean checkEmail = true;
			boolean checkPhone = true;
			boolean checkID = true;

			System.out.println("Student " + (count + 1));
			System.out.print("Enter student name: ");
			String name = scanner.nextLine();

			String email = null;
			while (checkEmail) {
				System.out.print("Enter student email: ");
				email = scanner.nextLine();

				Matcher matcherEmail = patternEmail.matcher(email);
				if (matcherEmail.matches()) {
					System.out.println("--- Valid email address. ---");
					checkEmail = false;
				} else {
					System.out.println("xxx Invalid email address. Please try again xxx");
				}
			}

			String phone = null;
			while (checkPhone) {
				System.out.print("Enter student phone number: ");
				phone = scanner.nextLine();

				Matcher matcherPhone = patternPhone.matcher(phone);
				if (matcherPhone.matches()) {
					System.out.println("--- Valid phone number. ---");
					checkPhone = false;
				} else {
					System.out.println("xxx Invalid phone number. Please try again xxx");
				}
			}

			String ID = null;
			while (checkID) {
				System.out.print("Enter student ID: ");
				ID = scanner.nextLine();

				Matcher matcherID = patternID.matcher(ID);
				if (matcherID.matches()) {
					System.out.println("--- Valid ID. ---");
					checkID = false;
				} else {
					System.out.println("xxx Invalid ID. Please try again xxx");
				}
			}

			students.add(new Student(name, email, phone, ID));
			count++;
			System.out.println("----------------------------------------------");
		}

		for (Student student : students) {
			System.out.println(student.toString());
		}

		scanner.close();
	}
}
