package chapter04;

import java.util.Scanner;

public class Product {

	/*
	 * Create a Product class with 3 attributes: name, price and discount. The class
	 * also includes two methods: calculating import tax (10% of product price) and
	 * exporting information to the screen. Information output to the screen
	 * includes: Product's name: Unit price: Discount: Import Tax:
	 */

	private String productName;
	private double unitPrice;
	private double discount;

	public Product() {
	}

	public Product(String productName, double unitPrice, double discount) {
		this.productName = productName;
		this.unitPrice = unitPrice;
		this.discount = discount;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public Product input(String productName, double unitPrice, double discount) {
		Product pr = new Product(productName, unitPrice, discount);
		return pr;
	}

	public void input(Product pr) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the product name: ");
		String productName = scanner.nextLine();
		pr.setProductName(productName);

		System.out.print("Enter product price: ");
		Double unitPrice = scanner.nextDouble();
		scanner.nextLine();
		pr.setUnitPrice(unitPrice);

		System.out.print("Enter discount: ");
		Double discount = scanner.nextDouble();
		scanner.nextLine();
		pr.setDiscount(discount);

		scanner.close();
	}

	public void export() {
		System.out.println("Name: " + getProductName());
		System.out.println("Price: " + getUnitPrice());
		System.out.println("Discount: " + getDiscount());
		System.out.println("---------------------------");
	}

	public double getImportTax() {
		System.out.println("Import Tax of " + getProductName() + " product is: " + getUnitPrice() * 10 / 100);
		return getUnitPrice() * 10 / 100;
	}
}
