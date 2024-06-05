package chapter04;

public class Lesson01 {

	/*
	 * Write a program to create 2 information products entered from the keyboard,
	 * then call the export method to export the information of the 2 created
	 * product objects.
	 */

	public static void main(String[] args) {
		Product pr1 = new Product();
		Product pr2 = new Product("Laptop", 630, 50);

		Product input = new Product();
		Product pr3 = input.input("Iphone", 600, 50);

		pr1.input(pr1);
		pr1.export(pr1);
		pr2.export(pr2);
		pr3.export(pr3);

		pr1.getImportTax(pr1);
		pr2.getImportTax(pr2);
		pr3.getImportTax(pr3);
	}
}
