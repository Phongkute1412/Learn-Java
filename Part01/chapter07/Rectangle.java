package chapter07;

public class Rectangle {

	private double width;
	private double length;

	public Rectangle() {
	}

	public Rectangle(double width, double length) {
		super();
		this.width = width;
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public double getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public double getPerimeter() {
		return (getWidth() + getLength()) * 2;
	}

	public double getArea() {
		return getWidth() * getLength();
	}

	public void export() {
		System.out.println("Width of the rectangle: " + getWidth());
		System.out.println("Length of the rectangle: " + getLength());
		System.out.println("Perimeter of the rectangle: " + getPerimeter());
		System.out.println("Area of the rectangle: " + getArea());
	}
}
