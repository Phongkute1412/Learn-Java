package chapter06;

public class Student {

	private String name;
	private String email;
	private String phone;
	private String IDnumber;

	public Student() {
	}

	public Student(String name, String email, String phone, String iD) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.IDnumber = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getID() {
		return IDnumber;
	}

	public void setID(String iD) {
		this.IDnumber = iD;
	}

	public String toString() {
		return "Student: " + name + ", email: " + email + ", phone: " + phone + ", ID: " + IDnumber;
	}
}
