package bussinesLogic;

public interface IRestaurantProcessing {
	public void addProducts(MenuItem m1);
	public void deleteProducts();
	public void uppdateProducts();
	public void createNewOrder();
	public void computePriceForOrder();
	public void generateBill();
}
