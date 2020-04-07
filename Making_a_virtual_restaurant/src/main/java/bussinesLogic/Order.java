package bussinesLogic;

public class Order {
	public int orderId;
	public String date;
	public int table;
	public Order(int orderId, String date, int table) {
		super();
		this.orderId = orderId;
		this.date = date;
		this.table = table;
	}
	public int hashCode()
	{	System.out.println(this.orderId);
		return this.orderId;
	}
	/*public boolean equals(Object o)
	{
		if(this.orderId!=((Order)o).orderId)
		{
			return false;
		}
		else return true;
			
		
	}*/
@Override
	public String toString() {
		return "Order " + orderId + ", date=" + date + ", table=" + table;
	}
}
