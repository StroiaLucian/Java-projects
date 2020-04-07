package bussinesLogic;

public class BaseProduct extends MenuItem {
	
	public BaseProduct(int id, int price, String name) {
		super(id, price, name);
	}
	
	public void computePrice() {	
	}
	public String toString() {
		return super.toString()+"Este un Base Product.";
	}

}
