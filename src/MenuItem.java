
// stub to help DeliCounter compile initially

abstract class MenuItem {
	String name;
	double price;
	int quantity;
	int prepTime;

	abstract boolean isInventory ();
	
	@Override
	public String toString() {
		return name;
	}
}
