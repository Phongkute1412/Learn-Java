package chapter07;

public class MARStudent extends Student {

	private double marketting;
	private double sales;

	public MARStudent() {
		super();
	}

	public MARStudent(String name, double marketting, double sales) {
		super(name, "Marketing");
		this.marketting = marketting;
		this.sales = sales;
	}

	public double getMarketting() {
		return marketting;
	}

	public void setMarketting(double marketting) {
		this.marketting = marketting;
	}

	public double getSales() {
		return sales;
	}

	public void setSales(double sales) {
		this.sales = sales;
	}

	@Override
	double getGrade() {
		return (2 * getMarketting() + getSales()) / 3;
	}

	public void export() {
		System.out.println("Student's full name: " + getName());
		System.out.println("Student's major: " + getMajor());
		System.out.println("Student's marketing score: " + getMarketting());
		System.out.println("Student's sales score: " + getSales());
		System.out.println("Student's grade: " + getGrade());
		System.out.println("Student's academic ability: " + getAcademicAbility());
	}
}