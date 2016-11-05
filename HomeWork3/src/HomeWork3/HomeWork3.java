package HomeWork3;

import java.util.Scanner;

/**
 * In this homework, I realized to add the right amount of product
 * categories as the user wishes. The ability to make an inventory
 * for any of the categories, and across the whole database.
 * Implemented change the price of goods that exist in the current category
 *
 * Created by Sergey777s on 04.11.16.
 *
 */
public class HomeWork3 {

	public static void main(String args[]) {
		Inventory inventory = new Inventory();
		Scanner scanner = new Scanner(System.in);
		Boolean yesAnswer = false;
		Boolean yesAnswerExit = false;
		int userAnswer;


		System.out.println("Welcome to 1C GitHub edition!!!");
		Product product;
		do {
			System.out.println("please input your category of goods:");
			String category = scanner.nextLine();

			do {
				String name;
				double price;
				int quantity;
				System.out.println("Write name of product: ");
				name = scanner.nextLine();

				System.out.println("Write price of product: ");
				price = scanner.nextDouble();
				System.out.println("Write quantity of product: ");
				quantity = scanner.nextInt();
				product = new Product(name, price, quantity, category);
				inventory.add(product);
				System.out.println("To continue add products in category " + category + " press 1 or anydigit to close this category:");
				userAnswer = scanner.nextInt();
				scanner.nextLine();
				yesAnswer = (userAnswer == 1) ? true : false;
			} while (yesAnswer);

			System.out.println("if you want to input other category of goods please press 2 or anydigit for exit adding goods:");
			userAnswer = scanner.nextInt();
			scanner.nextLine();
			yesAnswerExit = (userAnswer == 2) ? true : false;
		} while (yesAnswerExit);

		System.out.println("Write name of category what you want to check ot any digit to check all base:");
		if (scanner.hasNextInt()) {
			inventory.printAll();
		} else
			inventory.printAllinCategory(scanner.nextLine());
	}
}
