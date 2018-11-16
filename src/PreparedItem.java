
public class PreparedItem extends MenuItem {

	
	
	public PreparedItem(String name, double price, int prepTime) {
		this.name = name;
		this.price = price;
		this.prepTime = prepTime;
		quantity = 1;
	}
	
	@Override
	boolean isInventory() {
		// TODO Auto-generated method stub
		return false;
	}

}
