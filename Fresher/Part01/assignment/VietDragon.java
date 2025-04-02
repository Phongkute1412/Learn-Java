package assignment;

import java.util.Scanner;

public class VietDragon {

	public static void main(String[] args) {

		boolean loop = true;
		Scanner scanner = new Scanner(System.in);

		while (loop) {
			System.out.println("+-----------------------------------------------------------+");
			System.out.println("1. Enter the employee list.");
			System.out.println("2. Display the employee list.");
			System.out.println("3. Find and display employee according to the employee code.");
			System.out.println("4. Delete employee according to the employee code.");
			System.out.println("5. Update employee information according to the code entered.");
			System.out.println("6. Find employees by basic salary range.");
			System.out.println("7. Sort employees by name.");
			System.out.println("8. Sort employees by salary.");
			System.out.println("9. Display 5 employees with the highest salary.");
			System.out.println("10. End.");
			System.out.println("+-----------------------------------------------------------+");

			int function = Function.getValidFunction(scanner);

			switch (function) {
			case 1:
				Function.enterEmployee(scanner);
				break;
			case 2:
				Function.exportImportedList();
				break;
			case 3:
				Function.exportEmployeeByCode(scanner);
				break;
			case 4:
				Function.deleteEmployeeByCode(scanner);
				break;
			case 5:
				Function.updateEmployeeByCode(scanner);
				break;
			case 6:
				Function.exportEmployeeByIncomeRange(scanner);
				break;
			case 7:
				Function.exportSortEmployeeByName();
				break;
			case 8:
				Function.exportSortEmployeeByIncome();
				break;
			case 9:
				Function.export5EmployeeHighestSalary();
				break;
			case 10:
				System.out.println("End program.");
				loop = false;
				break;
			default:
				System.out.println("Please try again.");
			}
		}
		scanner.close();
	}
}
