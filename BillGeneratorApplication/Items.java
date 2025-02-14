package BillGeneratorApplication;

public class Items {
	private String foodName;
	private double Amount;
	private int quantity;
	private double foodPrice;
	private static double total;
	
	Items(String foodName,double foodPrice,int quantity){
		this.foodName = foodName;
		this.foodPrice = foodPrice;
		this.quantity = quantity;
		Amount = quantity * foodPrice;
		total += Amount;
	}
	
	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public double getAmount() {
		return Amount;
	}

	public void setAmount(double amount) {
		Amount = amount;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity += quantity;
	}

	public double getFoodPrice() {
		return foodPrice;
	}

	public void setFoodPrice(double foodPrice) {
		this.foodPrice = foodPrice;
	}
    //check if the item is available or not
	public static boolean search(Items[] items,int quantity,String foodName) {
		for(Items item:items) {
			if(item != null) {
			if(item.getFoodName().equals(foodName)) {
				item.setQuantity(quantity);
				item.setAmount(item.getQuantity() * item.getFoodPrice());
				Items.setTotal(quantity * item.getFoodPrice());
				return true;
			}
			}
		}
		return false;
	}

	public static double getTotal() {
		return total;
	}

	public static void setTotal(double total) {
		Items.total += total;
	}
}
