import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class DeliCounter {

	public static final String[] ACTIONS = { "Restore Inventory", "Save Inventory", "List Total Packaged Item Value",
			"List Menu", "Order Item", "Add New Package", "Add New Cooked Item", "Exit" };

	public static void main(String[] args) {

		ArrayList<MenuItem> menu = new ArrayList<>();

		Scanner kybd = new Scanner(System.in);
		DeliCounter deli = new DeliCounter();

		displayMenu(ACTIONS);
		int activity = kybd.nextInt();
		while (!ACTIONS[activity].equalsIgnoreCase("Exit")) {

			if (ACTIONS[activity].equalsIgnoreCase("Restore Inventory")) {
				menu = restoreInventory();
			} else if (ACTIONS[activity].equalsIgnoreCase("Save Inventory")) {
				saveInventory(menu);
			} else if (ACTIONS[activity].equalsIgnoreCase("List Total Packaged Item Value")) {
				displayPackageValue(menu);
			} else if (ACTIONS[activity].equalsIgnoreCase("List Menu")) {
				displayMenu(menu);
			} else if (ACTIONS[activity].equalsIgnoreCase("Order Item")) {
				System.out.println("Which item number do you want? ");
				int itemNum = kybd.nextInt();
				orderItem(itemNum, menu);
			} else if (ACTIONS[activity].equalsIgnoreCase("Add New Package")) {
				MenuItem newItem = newPackagedItem(kybd);
				menu.add(newItem);
			} else if (ACTIONS[activity].equalsIgnoreCase("Add New Cooked Item")) {
				MenuItem newItem = addCooked(kybd);
				menu.add(newItem);
			} else {
				System.out.println("Invalid input ignored");
			}
			displayMenu(ACTIONS);
			activity = kybd.nextInt();
		}
	}

	private static MenuItem addCooked(Scanner kybd) {
		System.out.println("Add a new cooked item: ");
		String n;
		double p;
		int t;

		
		PreparedItem pI;
		System.out.println("Item name:");
		n  = kybd.next();
		System.out.println("Item price:");
		p = kybd.nextDouble();
		System.out.println("Prep time:");
		t = kybd.nextInt();

		pI = new PreparedItem(n, p, t);
		
		return pI;
	}

	private static MenuItem newPackagedItem(Scanner kybd) {
		System.out.println("Add a new packaged item: ");
		String n;
		double p;
		int q;

		PackagedItem pI;
		System.out.println("Item name:");
		n  = kybd.next();
		System.out.println("Item price:");
		p = kybd.nextDouble();
		System.out.println("Quantity:");
		q = kybd.nextInt();
		pI = new PackagedItem(n, p, q);
		return pI;
	}

	private static void orderItem(int itemNum, ArrayList<MenuItem> menu) {

		System.out.println("You ordered " + menu.get(itemNum).name);
		System.out.println("The price is " + menu.get(itemNum).price);
		if (menu.get(itemNum).isInventory()) {
			menu.get(itemNum).quantity -= 1;
		}else {
			menu.remove(itemNum);
		}
	}

	private static void displayMenu(ArrayList<MenuItem> items) {
		System.out.println("\n");

		for (MenuItem m : items) {
			System.out.println("["+ m.name + "]");
		}
		System.out.println("\n");
	}

	private static void displayPackageValue(ArrayList<MenuItem> menu) {
		double sum = 0;
		
		for (int i = 0; i < menu.size(); i++) {
			sum += (menu.get(i).price) * (menu.get(i).quantity);
		}
		System.out.println(sum);

	}

	private static void saveInventory(ArrayList<MenuItem> menu) {

	}

	private static ArrayList<MenuItem> restoreInventory() {
		return null;
	}

	public static void displayMenu(String[] items) {
		System.out.println("\n");
		for (int i = 0; i < items.length; i++) {
			System.out.println("[" + i + "] " + items[i]);
		}
		System.out.println("\n");
	}

}
