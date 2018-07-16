import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

abstract class DessertItem {
	int tax = 0;
	public String itemType;
	int quantity;
	int cost;

	abstract double getCost(String itemType, int quantity);

	int getTax() {
		return tax;
	}
}

class Candy extends DessertItem {

	public Candy() {
		// TODO Auto-generated constructor stub
	}

	public Candy(String itemType, int quantity, int cost) {
		this.itemType = itemType;
		this.quantity = quantity;
		this.cost = cost;
	}

	@Override
	double getCost(String itemType, int quantity) {
		Storage s1 = new Storage();
		double totalCost = 0;

		Iterator<Candy> c = s1.candy.iterator();
		while (c.hasNext()) {
			if (c.next().itemType == itemType) {

				c.next().quantity -= quantity;

				totalCost = c.next().cost + (c.next().cost * 10) / 100;
			}

		}

		return totalCost;
	}

}

class Cookie extends DessertItem {

	public Cookie() {
		// TODO Auto-generated constructor stub
	}

	public Cookie(String itemType, int quantity, int cost) {
		this.itemType = itemType;
		this.quantity = quantity;
		this.cost = cost;
	}

	@Override
	double getCost(String itemType, int quantity) {
		Storage s1 = new Storage();
		double totalCost = 0;

		Iterator<Cookie> co = s1.cookie.iterator();
		while (co.hasNext()) {
			if (co.next().itemType == itemType) {
				co.next().quantity -= quantity;
				totalCost = co.next().cost + (co.next().cost * 8) / 100;
			}

		}
		// TODO Auto-generated method stub
		return totalCost;
	}

}

class IceCream extends DessertItem {

	public IceCream() {
		// TODO Auto-generated constructor stub
	}

	public IceCream(String itemType, int quantity, int cost) {
		this.itemType = itemType;
		this.quantity = quantity;
		this.cost = cost;
		System.out.println(this.itemType + "  " + this.quantity + "  "
				+ this.cost);
	}

	@Override
	double getCost(String itemType, int quantity) {
	
		return (Storage.getprice(itemType, quantity));
	}

}

class Storage {
	public  static ArrayList<IceCream> ice = new ArrayList<IceCream>();
	public  static ArrayList<Candy> candy = new ArrayList<Candy>();
	public  static ArrayList<Cookie> cookie = new ArrayList<Cookie>();

	public static double getprice(String iType, int quantity) {
		
		System.out.println(ice);

		double totalCost = 0;

		System.out.println("Hello");
		System.out.println(iType+" "+quantity);

		for (int i = 0; i < ice.size(); i++) {
			System.out.println(ice.get(i).cost + "  " + i+"  "+ice.get(i).itemType);
			if (ice.get(i).itemType .equals(iType) ) {
				System.out.println("Hello");
				//System.out.println(it.next().itemType);
				ice.get(i).quantity -= quantity;
				//System.out.println(it.next().cost);
				System.out.println("Hello");
				totalCost = ice.get(i).cost+ ((ice.get(i).cost * 12) / 100);
			}
		}
		
		return totalCost;

	}

}

public class ShopTest {

	public static void main(String[] args) {
	
		IceCream i = new IceCream();
		Candy ca = new Candy();
		Cookie co = new Cookie();

		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		int price = 0, items = 0;

		String type = "";

		int exit = 0;
		do {
			System.out.println("Enter 1 for owner and 2 for customer");

			int get = sc.nextInt();
			if (get == 1) {

				System.out.println("Enter 1 to add Icecream 2 to add candies and 3 to add cookies");

				int getItem = sc.nextInt();
				if (getItem == 1) {
					System.out.println("Name, quantity and price of Icecream");
					type = sc1.nextLine();
					items = sc.nextInt();
					price = sc.nextInt();
					Storage.ice.add(new IceCream(type, items, price));

				}
				if (getItem == 2) {
					System.out.println("Name, quantity and price of Candy");
					type = sc1.nextLine();
					items = sc.nextInt();
					price = sc.nextInt();
					Storage.candy.add(new Candy(type, items, price));
				}
				if (getItem == 3) {
					System.out.println("Name, quantity and price of Cookie");
					type = sc1.nextLine();
					items = sc.nextInt();
					price = sc.nextInt();
					items = 3;
					price = 20;
					Storage.cookie.add(new Cookie(type, items, price));

				}

			}
			if (get == 2) {

				System.out
						.println("Enter 1 to order Icecream 2 to order candies and 3 to order cookies");

				int getItem = sc.nextInt();
				if (getItem == 1) {
					System.out.println("Name and quantity of Icecream");
					type = sc1.nextLine();
					items = sc.nextInt();
					System.out.println("price is-" + i.getCost(type, items)
							+ " rupees");

				}
				if (getItem == 2) {
					System.out.println("Name and quantity of Candy");
					type = sc1.nextLine();
					items = sc.nextInt();
					System.out.println("price is-" + ca.getCost(type, items)
							+ " dollers");

				}
				if (getItem == 3) {
					System.out.println("Name and quantity of Icecream");
					type = sc1.nextLine();
					items = sc.nextInt();
					System.out.println("price is-" + co.getCost(type, items)
							+ " euro");

				}
			}
			System.out.println("Enter 0 to continue");
			exit = sc.nextInt();

		} while (exit == 0);

	}
}
