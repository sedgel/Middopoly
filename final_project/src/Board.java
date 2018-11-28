
public class Board {

	// instance variables
	private int[] position;
	private int[] price;
	private boolean[] purchased;
	private int[] rent;
	
	//constructors
	public Board(int[] position, int[] price, boolean[] purchased, int[] rent) {
		this.position = position;
		this.price = price;
		this.purchased = purchased;
		this.rent = rent;
	}
	
	
	// getters
	public int position(int p) {
		return position[p];
	}
	
	public int price(int p) {
		return price[p];
	}
	
	public boolean purchased(int p) {
		return purchased[p];
	}
	
	public int rent(int p) {
		return rent[p];
	}
	
	//setters
	public void bought(int p) {
		purchased[p] = false;
	}
}
