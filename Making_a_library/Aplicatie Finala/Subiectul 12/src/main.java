public class main {

	public static void main(String[] args)
	{	
		view my_view= new view();
		db_connection my_connection= new db_connection();
		controller my_controller= new controller(my_view, my_connection);
		
	
	}
	
}
