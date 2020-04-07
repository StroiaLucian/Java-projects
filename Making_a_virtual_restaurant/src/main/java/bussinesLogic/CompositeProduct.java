package bussinesLogic;

import java.util.ArrayList;

public class CompositeProduct extends MenuItem{

	private ArrayList<MenuItem> listOfIngredients;
	public CompositeProduct(int id, int price, String name) {
		super(id, price, name);
		listOfIngredients=new ArrayList<MenuItem>();
	}
	
	public void computePrice() {
	for(MenuItem m1:listOfIngredients)
	{
	this.setPrice(this.getPrice()+m1.getPrice());	
	}
	}
	
	public String toString() {
		String s="";
		for(MenuItem m:this.listOfIngredients)
		{
			s+=m.getName()+",";
		}
		return super.toString()+"Este un Composite Product si contine: "+s;
	}

	public ArrayList<MenuItem> getListOfIngredients() {
		return listOfIngredients;
	}

	public void setListOfIngredients(ArrayList<MenuItem> listOfIngredients) {
		this.listOfIngredients = listOfIngredients;
	}
	
}
