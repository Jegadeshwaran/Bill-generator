package BillGeneratorApplication;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Bill {
	
	private final static float SGST = 12.0f;
	private final static float CGST = 12.0f;
	private static double discount;
	private static double netTotal;
	private static double grandTotal;
	private static double charges;
	
	private static double getSGST() {
		double sgst = (netTotal/100)*SGST;
		return Math.round(sgst);
	}
	private static double getCGST() {
		double cgst = (netTotal/100)*CGST;
		return Math.round(cgst);
	}
	private static double getGrandTotal() {
		grandTotal = netTotal + getCGST()+getSGST();
		return grandTotal;
	}
	
	public static void totalBill(Customer customer,Items[] totalItem) {
		String service = "";
		char serviceType = customer.getServiceType().charAt(0);
		if(serviceType =='d' || serviceType=='D') {
			 service = "Service charge";
			 charges = 25.0f;
		}
		if(serviceType =='T' || serviceType=='t') {
			service = "package charge";
			charges = 50.0f;
		}
		System.out.println("\n");
		System.out.println("                 FoodieFiesta ");
		System.out.println("                FAMILY DINNING ");
		System.out.println("           R.S Nagar Tiruppur 637231 ");
		System.out.println("             GSTIN:36ABKJD08647Z3 ");
		System.out.println("               \uD83D\uDCDE: 1234567890 ");
		System.out.println("\n------------------- INVOICE -------------------");
		LocalDate currentDate = LocalDate.now();
		LocalTime currentTime = LocalTime.now();
		Random random = new Random();
		int billNo = random.nextInt(1000 - 100 + 1) + 100;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String formattedTime = currentTime.format(formatter);
		String formattedDate = currentDate.format(formatter1);
		System.out.println("Customer Name: "+ customer.getName()+"\t\tDate:" + formattedDate + " ");
		System.out.println("Billno:" + billNo + "       \t\tTime:" + formattedTime + "   ");
		System.out.println("===============================================");
		System.out.println("Item               \tQty\tRate\tTotal  ");
		System.out.println("-----------------------------------------------");
		for(Items item:totalItem) {
			if(item !=null) {
			System.out.print(item.getFoodName()+"\t");
			System.out.print(item.getQuantity()+"\t");
			System.out.print(item.getFoodPrice()+"\t");
			System.out.print(item.getAmount());
			System.out.println();
			}
		}
		System.out.println("-----------------------------------------------");
		System.out.println("                 \t"+"Sub Total"+"\t"+Items.getTotal());
		if(Items.getTotal()>500) {
			double d = (Items.getTotal()/100)*10;
			discount = Math.round(d);
		}
		netTotal = Items.getTotal() -discount +charges;
		if(discount>0) {
			System.out.println("                 \t"+"Discount@10%\t"+discount);
		}
		System.out.println("                 \t"+service+"\t"+charges);
		System.out.println("-----------------------------------------------");
		System.out.println("                 \t"+"Net Total"+"\t"+netTotal);
		System.out.println("                 \t"+"SGST@18%"+"\t"+getSGST());
		System.out.println("                 \t"+"CGST@18%"+"\t"+getCGST());
		System.out.println("-----------------------------------------------");
		System.out.println("                 \t"+"Grand Total"+"\t"+getGrandTotal());
		System.out.println("\n----------------- Thank you -------------------");
		System.out.println(customer.getServiceType());
		System.out.println();
	}
}
