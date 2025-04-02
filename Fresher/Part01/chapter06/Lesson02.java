package chapter06;

import java.util.ArrayList;
import java.util.Scanner;

public class Lesson02 {

	/*
	 * Enter into the array 5 products (Each product includes name, price and
	 * brand). Export information about products whose company is Nokia.
	 */

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Product> products = new ArrayList<Product>();
		int count = 0;

		while (count < 5) {
			System.out.println("Product " + (count + 1));
			System.out.print("Enter product name: ");
			String name = scanner.nextLine();
			System.out.print("Enter product price: ");
			int price = scanner.nextInt();
			scanner.nextLine();
			System.out.print("Enter product brand: ");
			String brand = scanner.nextLine();

			products.add(new Product(name, price, brand));
			count++;
		}

		System.out.println("+--------------------------------------------+");
		System.out.println("Export information about products whose company is Nokia:");

		for (Product product : products) {
			if (product.getBrand().equalsIgnoreCase("Nokia")) {
				System.out.println(product.toString());
			}
		}

		scanner.close();
	}
}
