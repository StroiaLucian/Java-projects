package interfata;
import polinoame.*;

public class main {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		Tema1View my_view= new Tema1View();
		Tema1Model my_model=new Tema1Model();
		Tema1Controller my_controll= new Tema1Controller(my_view,my_model);
		}catch (Exception e)
		{
		System.out.println(e.getMessage());
		}

}
}
