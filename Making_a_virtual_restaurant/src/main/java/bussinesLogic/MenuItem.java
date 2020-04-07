package bussinesLogic;

import java.io.Serializable;

public abstract class MenuItem implements Serializable{
	private int id;
	private int price;
	private String name;
	
	public MenuItem(int id, int price, String name) {
		this.id = id;
		this.price = price;
		this.name = name;
	}
	
	public MenuItem() {
	}

	public abstract void computePrice();
	
	public String toString() {
		return "Produsul :"+name+" cu id:"+id+"  are pretul: "+price+". ";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	};
	
}
