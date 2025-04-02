package assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Function {

	public static ArrayList<Employee> employees = new ArrayList<>();

	public static ArrayList<Employee> enterEmployee(Scanner scanner) {
		System.out.println("+-----------------------------------------------------------+");
		while (true) {
			System.out.print("Enter employee name: ");
			String name = scanner.nextLine();

			while (true) {
				System.out.print("Enter employee position ('A' for Administrative and 'M' for Manager): ");
				String position = scanner.nextLine();
				if (position.equalsIgnoreCase("A")) {
					long currentTimeMillis = System.currentTimeMillis();
					String code = toUpperFirstChar(name) + Long.toString(currentTimeMillis) + "A";
					System.out.print("Enter salary: ");
					double salary = scanner.nextDouble();
					System.out.print("Enter sales: ");
					double sales = scanner.nextDouble();
					System.out.print("Enter commission: ");
					double commission = scanner.nextDouble();
					scanner.nextLine(); // Consume the remaining newline

					Administrative administrativeEmployee = new Administrative(code, name, salary, sales, commission);
					employees.add(administrativeEmployee);
					break;

				} else if (position.equalsIgnoreCase("M")) {
					long currentTimeMillis = System.currentTimeMillis();
					String code = toUpperFirstChar(name) + Long.toString(currentTimeMillis) + "M";
					System.out.print("Enter salary: ");
					double salary = scanner.nextDouble();
					System.out.print("Enter management salary: ");
					double management = scanner.nextDouble();
					scanner.nextLine(); // Consume the remaining newline

					Manager managerEmployee = new Manager(code, name, salary, management);
					employees.add(managerEmployee);
					break;

				} else {
					System.out.println("Invalid position entered. Please try again");
				}
			}

			System.out.print("Do you want stop (Y/N)?: ");
			String ans = scanner.nextLine();
			if (ans.equalsIgnoreCase("Y")) {
				break;
			}
		}
		return employees;
	}

	public static void exportImportedList() {
		System.out.println("+-----------------------------------------------------------+");
		if (employees.size() == 0) {
			System.out.println("List of employees is empty. Please choose again");
		} else {
			System.out.println("The employees list: ");
			for (Employee employee : employees) {
				employee.export();
			}
		}
	}

	public static void exportEmployeeByCode(Scanner scanner) {
		System.out.println("+-----------------------------------------------------------+");
		if (employees.size() == 0) {
			System.out.println("List of employees is empty. Please choose again");
		} else {
			System.out.print("Enter the employee code: ");
			String employeeCode = scanner.nextLine();

			boolean found = true;
			for (Employee employee : employees) {
				if (employee.getCode().equalsIgnoreCase(employeeCode)) {
					employee.export();
					found = false;
					break;
				}
			}

			if (found) {
				System.out.println("No employee found with the code: " + employeeCode);
			}
		}
	}

	public static void deleteEmployeeByCode(Scanner scanner) {
		System.out.println("+-----------------------------------------------------------+");
		if (employees.size() == 0) {
			System.out.println("List of employees is empty. Please choose again");
		} else {
			System.out.print("Enter the employee code: ");
			String employeeCode = scanner.nextLine();

			boolean found = false;
			for (Employee employee : employees) {
				if (employee.getCode().equalsIgnoreCase(employeeCode)) {
					employees.remove(employee);
					found = true;
					break;
				}
			}

			if (found) {
				System.out.println("Employee has been removed.");
			} else {
				System.out.println("No employee found with the employee code: " + employeeCode);
			}
		}
	}

	public static void deleteEmployeeByCode(String code) {
		for (Employee employee : employees) {
			if (employee.getCode().equalsIgnoreCase(code)) {
				employees.remove(employee);
				break;
			}
		}
	}

	public static void updateEmployeeByCode(Scanner scanner) {
		System.out.println("+-----------------------------------------------------------+");
		if (employees.size() == 0) {
			System.out.println("List of employees is empty. Please choose again");
		} else {
			System.out.print("Enter the employee code: ");
			String employeeCode = scanner.nextLine();
			boolean found = false;

			for (Employee employee : employees) {
				if (employee.getCode().equalsIgnoreCase(employeeCode)) {
					found = true;
					String employeeCodeReal = employee.getCode();
					System.out.println("+-----------------------------------------------------------+");
					System.out.println("What information do you want to update?");

					while (true) {
						System.out.println("+-----------------------------------------------------------+");
						System.out.println("1. Name.");
						System.out.println("2. Salary.");
						System.out.println("3. Position.");
						if (employeeCodeReal.charAt(employeeCodeReal.length() - 1) == 'A') {
							System.out.println("4. Sales.");
							System.out.println("5. Commission.");
						} else {
							System.out.println("4. Management salary.");
						}
						System.out.println("0. End");
						System.out.println("+-----------------------------------------------------------+");

						System.out.print("Select: ");
						int update = scanner.nextInt();
						scanner.nextLine();

						switch (update) {
						case 1:
							System.out.print("Old name: " + employee.getName() + " | Update name: ");
							String updateName = scanner.nextLine();
							employee.setName(updateName);
							break;
						case 2:
							System.out.print("Old salary: " + employee.getSalary() + " | Update salary: ");
							double updateSalary = scanner.nextDouble();
							scanner.nextLine();
							employee.setSalary(updateSalary);
							break;
						case 3:
							if (employee instanceof Administrative) {
								System.out.print("Old position: Administrative | Update position ('M' for Manager): ");
								String updatePosition = scanner.nextLine();
								if (updatePosition.equalsIgnoreCase("M")) {
									System.out.print("Enter salary: ");
									double salary = scanner.nextDouble();
									System.out.print("Enter management salary: ");
									double management = scanner.nextDouble();
									scanner.nextLine();
									deleteEmployeeByCode(employeeCodeReal);
									employeeCodeReal = employeeCodeReal.substring(0, employeeCodeReal.length() - 1)
											+ "M";
									Manager managerEmployee = new Manager(employeeCodeReal, employee.getName(), salary,
											management);
									employees.add(managerEmployee);
								}
							} else {
								System.out.print("Old position: Manager | Update position ('A' for Manager): ");
								String updatePosition = scanner.nextLine();
								if (updatePosition.equalsIgnoreCase("A")) {
									System.out.print("Enter salary: ");
									double salary = scanner.nextDouble();
									System.out.print("Enter sales: ");
									double sales = scanner.nextDouble();
									System.out.print("Enter commission: ");
									double commission = scanner.nextDouble();
									scanner.nextLine();
									deleteEmployeeByCode(employeeCodeReal);
									employeeCodeReal = employeeCodeReal.substring(0, employeeCodeReal.length() - 1)
											+ "A";
									Administrative administrativeEmployee = new Administrative(employeeCodeReal,
											employee.getName(), salary, sales, commission);
									employees.add(administrativeEmployee);
								}
							}
							break;
						case 4:
							if (employee instanceof Administrative) {
								Administrative adminEmployee = (Administrative) employee;
								System.out.print("Old sales: " + adminEmployee.getSales() + " | Update sales: ");
								double updateSales = scanner.nextDouble();
								adminEmployee.setSales(updateSales);
							} else {
								Manager managerEmployee = (Manager) employee;
								System.out.print("Old management salary: " + managerEmployee.getManagement()
										+ " | Update management salary: ");
								double updateManagementSalary = scanner.nextDouble();
								managerEmployee.setManagement(updateManagementSalary);
							}
							break;
						case 5:
							if (employee instanceof Administrative) {
								Administrative adminEmployee = (Administrative) employee;
								System.out.print(
										"Old commission: " + adminEmployee.getCommission() + " | Update commission: ");
								double updateCommission = scanner.nextDouble();
								adminEmployee.setCommission(updateCommission);
							}
							break;
						case 0:
							System.out.println("End update.");
							break;
						}
						if (update == 0 || update == 3) {
							break;
						}
					}
					break;
				}
			}

			if (found) {
				System.out.println("Update successful.");
			} else {
				System.out.println("No employee found with the code: " + employeeCode);
			}
		}
	}

	public static void exportEmployeeByIncomeRange(Scanner scanner) {
		System.out.println("+-----------------------------------------------------------+");
		if (employees.size() == 0) {
			System.out.println("List of employees is empty. Please choose again");
		} else {
			System.out.print("List of employees with income ranging from: ");
			double fromIncome = scanner.nextDouble();
			System.out.print("to:  ");
			double toIncome = scanner.nextDouble();
			scanner.nextLine();

			boolean found = true;
			for (Employee employee : employees) {
				if (fromIncome <= employee.getIncome() && employee.getIncome() <= toIncome) {
					employee.export();
					found = false;
				}
			}

			if (found) {
				System.out.println("No employee found with the income from " + fromIncome + " to " + toIncome);
			}
		}
	}

	public static void exportSortEmployeeByName() {
		System.out.println("+-----------------------------------------------------------+");
		if (employees.size() == 0) {
			System.out.println("List of employees is empty. Please choose again");
		} else {
			Collections.sort(employees, new Comparator<Employee>() {
				public int compare(Employee emp1, Employee emp2) {
					return emp2.getName().compareTo(emp1.getName());
				}
			});
			exportImportedList();
		}
	}

	public static void exportSortEmployeeByIncome() {
		System.out.println("+-----------------------------------------------------------+");
		if (employees.size() == 0) {
			System.out.println("List of employees is empty. Please choose again");
		} else {
			Collections.sort(employees, new Comparator<Employee>() {
				public int compare(Employee emp1, Employee emp2) {
					return Double.compare(emp2.getIncome(), emp1.getIncome());
				}
			});
			exportImportedList();
		}
	}

	public static void export5EmployeeHighestSalary() {
		System.out.println("+-----------------------------------------------------------+");
		if (employees.size() == 0) {
			System.out.println("List of employees is empty. Please choose again");
		} else {
			Collections.sort(employees, new Comparator<Employee>() {
				public int compare(Employee emp1, Employee emp2) {
					return Double.compare(emp2.getIncome(), emp1.getIncome());
				}
			});
			if (employees.size() < 5) {
				System.out.println("Employee list less than 5 people");
				for (int i = 0; i < employees.size(); i++) {
					employees.get(i).export();
				}
			} else {
				System.out.println("List of 5 employees with highest salary:");
				for (int i = 0; i < 5; i++) {
					employees.get(i).export();
				}
			}
		}
	}

	public static int getValidFunction(Scanner scanner) {
		int function = -1;
		boolean validInput = false;

		while (!validInput) {
			System.out.print("Select function: ");
			try {
				function = scanner.nextInt();
				validInput = true;
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter a number.");
				scanner.next(); // Consume the invalid input
			}
			scanner.nextLine(); // Consume the newline character
		}
		return function;
	}

	public static String toUpperFirstChar(String s) {
		String[] name = s.split(" ");

		StringBuilder nameUpperFirstChar = new StringBuilder();
		for (int i = 0; i < name.length; i++) {
			nameUpperFirstChar.append(name[i].substring(0, 1).toUpperCase());
		}
		return nameUpperFirstChar.toString();
	}
}