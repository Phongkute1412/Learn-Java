package assignment;

public class Employee {

	private String code;
	private String name;
	private double salary;

	public Employee() {
	}

	public Employee(String code, String name, double salary) {
		this.code = code;
		this.name = name;
		this.salary = salary;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getIncome() {
		return getSalary();
	}

	public double getIncomeTax() {
		double tax = 0;
		if (9 < getIncome() && getIncome() < 15) {
			tax = (getIncome() / 100) * 10;
			System.out.println("Pay 10% personal income tax: " + tax);
		} else if (getIncome() >= 15) {
			tax = (getIncome() / 100) * 12;
			System.out.println("Pay 12% personal income tax: " + tax);
		} else {
			System.out.println("Do not pay personal income tax");
		}
		return tax;
	}

	public void export() {
		System.out.println("+-----------------------------------------------------------+");
		System.out.println("Information: " + getCode() + " - " + getName());
		System.out.println("Income: " + getIncome());
		getIncomeTax();
		System.out.println("+-----------------------------------------------------------+");
	}
}
