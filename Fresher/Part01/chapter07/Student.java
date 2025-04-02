package chapter07;

public abstract class Student {

	private String name;
	private String major;

	abstract double getGrade();

	public Student() {
	}

	public Student(String name, String major) {
		super();
		this.name = name;
		this.major = major;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getAcademicAbility() {
		String academicAbility = null;
		if (getGrade() >= 5 && getGrade() < 6.5) {
			academicAbility = "Average Good";
		} else if (getGrade() >= 6.5 && getGrade() < 7.5) {
			academicAbility = "Good";
		} else if (getGrade() >= 7.5 && getGrade() < 9) {
			academicAbility = "Very Good";
		} else if (getGrade() >= 9) {
			academicAbility = "Excellent";
		} else {
			academicAbility = "Ordinary";
		}
		return academicAbility;
	}

	public void export() {
		System.out.println("Student's full name: " + getName());
		System.out.println("Student's major: " + getMajor());
		System.out.println("Student's grade: " + getGrade());
		System.out.println("Student's academic ability: " + getAcademicAbility());
	}
}