package BillGeneratorApplication;

public class ItemsAndPrices {
	private String[] Foods = new String[10];
	private double[] prices = new double[10];
	
	ItemsAndPrices() {
		Foods[0] = "Veg soup         ";
		Foods[1] = "Non veg soup     ";
		Foods[2] = "Parotta          ";
		Foods[3] = "Dosa             ";
		Foods[4] = "Chappati         ";
		Foods[5] = "Veg briyani      ";
		Foods[6] = "Chicken briyani  ";
		Foods[7] = "Mutton briyani   ";
		Foods[8] = "Egg briyani      ";
		Foods[9] = "Omelete/Half boil";
		prices[0] = 80;
		prices[1] = 100;
		prices[2] = 15;
		prices[3] = 15;
		prices[4] = 15;
		prices[5] = 100;
		prices[6] = 130;
		prices[7] = 180;
		prices[8] = 120;
		prices[9] = 15;
	}

	public String[] getFoods() {
		return Foods;
	}

	public void setFoods(String[] foods) {
		Foods = foods;
	}

	public double[] getPrices() {
		return prices;
	}

	public void setPrices(double[] prices) {
		this.prices = prices;
	}
}
