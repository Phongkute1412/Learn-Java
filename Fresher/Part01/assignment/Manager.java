package assignment;

public class Manager extends Employee {

	double management;

	public Manager() {
	}

	public Manager(String code, String name, double salary, double management) {
		super(code, name, salary);
		this.management = management;
	}

	public double getManagement() {
		return management;
	}

	public void setManagement(double management) {
		this.management = management;
	}

	public double getIncome() {
		return getSalary() + getManagement();
	}
}
