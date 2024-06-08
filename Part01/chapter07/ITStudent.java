package chapter07;

public class ITStudent extends Student {

	private double java;
	private double css;
	private double html;

	public ITStudent() {
		super();
	}

	public ITStudent(String name, double java, double css, double html) {
		super(name, "IT");
		this.java = java;
		this.css = css;
		this.html = html;
	}

	public double getJava() {
		return java;
	}

	public void setJava(double java) {
		this.java = java;
	}

	public double getHtml() {
		return html;
	}

	public void setHtml(double html) {
		this.html = html;
	}

	public double getCss() {
		return css;
	}

	public void setCss(double css) {
		this.css = css;
	}

	@Override
	double getGrade() {
		return (2 * getJava() + getHtml() + getCss()) / 4;
	}

	public void export() {
		System.out.println("Student's full name: " + getName());
		System.out.println("Student's major: " + getMajor());
		System.out.println("Student's java score: " + getJava());
		System.out.println("Student's css score: " + getCss());
		System.out.println("Student's html score: " + getHtml());
		System.out.println("Student's grade: " + getGrade());
		System.out.println("Student's academic ability: " + getAcademicAbility());
	}
}