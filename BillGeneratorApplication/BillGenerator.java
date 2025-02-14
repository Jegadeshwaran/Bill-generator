package BillGeneratorApplication;

import java.util.Scanner;

public class BillGenerator {
	
	public static Items[] createItems() {
		ItemsAndPrices ItemPrice = new ItemsAndPrices();
		String[] foods = ItemPrice.getFoods();
		double[] prices = ItemPrice.getPrices();
		Items[] totalItem = new Items[foods.length];
		Items item;
		int count =0;
		char addMore ;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("\n");
			System.out.println("                 FoodieFiesta ");
			System.out.println("                FAMILY DINNING ");
			System.out.println("           R.S Nagar Tiruppur 637231 ");
			System.out.println("             GSTIN:36ABKJD08647Z3 ");
			System.out.println("               \uD83D\uDCDE: 1234567890 ");
			System.out.println("------------------- MENU -------------------");
			for(int i=0;i<foods.length;i++) {
				System.out.print((i+1)+"."+foods[i]+"\t");
				System.out.print(prices[i]);
				System.out.println();
			}
			System.out.println("select food");
			int select = sc.nextInt();
			while(!(select>0 && select<foods.length)){
				System.out.println("enter valid food");
				select = sc.nextInt();
			}
			System.out.println("enter quantity");
			while(!sc.hasNextInt()) {
				System.out.println("enter valid quantity");
				sc.next();
			}
			int quantity = sc.nextInt();
			if(!Items.search(totalItem,quantity,foods[select-1])) {
				item = new Items(foods[select-1],prices[select-1],quantity);
				totalItem[count] = item;
				count++;
			}
			System.out.println("want to add more?");
			 addMore = sc.next().charAt(0);
			while(addMore != 'Y' && addMore != 'y' && addMore != 'N' && addMore != 'n') {
				System.out.println("enter Y or N");
				addMore = sc.next().charAt(0);
			}
			
		}while(addMore == 'y' || addMore =='Y');
		return totalItem;
	}

	public static void main(String[] args) {
		int choose;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("1.GenerateBill");
			System.out.println("2.Exit");
			choose = sc.nextInt();
			switch(choose) {
			case 1: Customer person = new Customer();
					Items[] totalItem = createItems();
					Bill.totalBill(person,totalItem);
					break;
			case 2: System.out.println("Application stopped");
			        sc.close();
				   System.exit(0);
				   
			default:System.out.println("please enter valid input");
			}
			}while(true);
	}

}
