package assignment;

public class Administrative extends Employee {

	private double sales;
	private double commission;

	public Administrative() {
	}

	public Administrative(String code, String name, double salary, double sales, double commission) {
		super(code, name, salary);
		this.sales = sales;
		this.commission = commission;
	}

	public double getSales() {
		return sales;
	}

	public void setSales(double sales) {
		this.sales = sales;
	}

	public double getCommission() {
		return commission;
	}

	public void setCommission(double commission) {
		this.commission = commission;
	}

	public double getIncome() {
		return getSalary() + (getSales() * getCommission()) / 100;
	}

}
