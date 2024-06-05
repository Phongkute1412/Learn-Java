package chapter05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Lesson03 {

	/*
	 * Build a product management application (information for each product includes
	 * name and price) according to the following menu: 1. Enter product list from
	 * keyboard 2. Sort in descending order by price and output to the screen 3.
	 * Find and delete products by name entered from the keyboard 4. Export the
	 * average price of the products
	 */

	public static ArrayList<Product> products = new ArrayList<>();

	public static void main(String[] args) {
		boolean loop = true;
		Scanner scanner = new Scanner(System.in);

		while (loop) {
			System.out.println("+--------------------------------------------+");
			System.out.println("1. Enter product list from keyboard");
			System.out.println("2. Sort in descending order by price and output to the screen");
			System.out.println("3. Find and delete products by name entered from the keyboard");
			System.out.println("4. Export the average price of the products");
			System.out.println("5. End");
			System.out.println("+--------------------------------------------+");
			System.out.print("Select function: ");

			int function = scanner.nextInt();
			scanner.nextLine();

			switch (function) {
			case 1:
				enterProductName(scanner);
				break;
			case 2:
				if (products.size() == 0) {
					System.out.println("List of products is empty. Please choose again");
				} else {
					Collections.sort(products, new Comparator<Product>() {
						public int compare(Product p1, Product p2) {
							return Double.compare(p2.getPrice(), p1.getPrice());
						}
					});
					exportImportedList();
				}
				break;
			case 3:
				if (products.size() == 0) {
					System.out.println("List of products is empty. Please choose again");
				} else {
					deleteElement(scanner);
					exportImportedList();
				}
				break;
			case 4:
				if (products.size() == 0) {
					System.out.println("List of products is empty. Please choose again");
				} else {
					averageTotalPrice();
				}
				break;
			case 5:
				System.out.println("End program.");
				loop = false;
				break;
			}
		}
	}

	public static ArrayList<Product> enterProductName(Scanner scanner) {
		System.out.println("+--------------------------------------------+");
		while (true) {
			System.out.print("Enter product name: ");
			String name = scanner.nextLine();
			System.out.print("Enter product price: ");
			int price = scanner.nextInt();
			scanner.nextLine();

			products.add(new Product(name, price));

			System.out.print("Do you want stop (Y/N)?: ");
			String ans = scanner.nextLine();
			if (ans.equalsIgnoreCase("Y")) {
				break;
			}
		}
		return products;
	}

	public static void exportImportedList() {
		if (products.size() == 0) {
			System.out.println("+--------------------------------------------+");
			System.out.println("List of products is empty. Please choose again");
		} else {
			System.out.println("+--------------------------------------------+");
			System.out.println("Export the imported list: ");
			for (Product product : products) {
				System.out.println(product.toString());
			}
		}
	}

	public static void deleteElement(Scanner scanner) {
		System.out.print("Enter the product's name you want to delete: ");
		String name = scanner.nextLine();

		boolean found = false;
		for (Product product : products) {
			if (product.getName().equalsIgnoreCase(name)) {
				products.remove(product);
				found = true;
				break;
			}
		}

		if (found) {
			System.out.println("Product has been removed.");
		} else {
			System.out.println("No products found with the name: " + name);
		}
	}

	public static void averageTotalPrice() {
		double total = 0;
		for (Product product : products) {
			total += product.getPrice();
		}

		double averageTotal = (products.size() > 0) ? total / products.size() : 0;
		System.out.println("Average price of products: " + averageTotal);
	}
}