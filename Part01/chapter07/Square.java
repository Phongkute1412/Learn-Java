package chapter07;

public class Square extends Rectangle {

	public Square() {
		super();
	}

	public Square(double edge) {
		super(edge, edge);
	}

	public double getEdge() {
		return getWidth();
	}

	public void export() {
		System.out.println("Edge of the square: " + getEdge());
		System.out.println("Perimeter of the square: " + getPerimeter());
		System.out.println("Area of the square: " + getArea());
	}
}
