
public class PackagedItem extends MenuItem {
	
	
	
	public PackagedItem (String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	@Override
	boolean isInventory() {
		// TODO Auto-generated method stub
		return true;
	}

}
