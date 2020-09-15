package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;



import Models.*;
import View.*;

public class ControllerMain {
private MainPage gui;
private ControllerDoctor gui2;
private ControllerAsistent gui3;
private ControllerAdministrator gui4;
private Utilizator utilizator;
private PersistentaFactory pf= new PersistentaFactory();
private Persistenta p= pf.obtinePersistenta("conturi.txt");

public ControllerMain()
{
	gui=new MainPage();
	gui.addlistener1(new listener_Button());
}
public Utilizator verificaCont(String username,String parola)
{
// acum avem accest la metodele din persistena de conturi.
	//practic trebuie sa realizam o verificare daca username-ul si parola luate din interfata coincid cu vreun utilizator stocat in fisier.
	ContUtilizator aux=((PersistentaConturiUtilizatori) p).verificareUtilizator(username,parola);
	if(aux.getUtilizator()!=null) {Utilizator utilizator_actual=aux.getUtilizator();
	return utilizator_actual;
	}
	else return null;
}
/*
 *pentru testarea fara logare.
class listener_Button implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		try {
				gui2= new ControllerDoctor(new Utilizator(1,"Lucian","12","12312","doctor"));
				gui3= new ControllerAsistent(new Utilizator(1,"Lucian","12","12312","asistent"));
				gui4= new ControllerAdministrator(new Utilizator(1,"Lucian","12","12312","administrator"));	
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
*/
class listener_Button implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		try {
			if(gui.getUsername().isEmpty()||gui.getPassword().isEmpty())
			{
				gui.setUsername("Username/parola gol");
			}
			else{
			utilizator=verificaCont(gui.getUsername(),gui.getPassword());//aici am deja utilzatorul. pot sa trec la verificari.
			if(utilizator!=null) {
				gui.getFrame().dispose();
				if(utilizator.getTip().equalsIgnoreCase("doctor"))//aici mai trebuie o conditie sa vedem ce frame deschidem.
					{
					gui2= new ControllerDoctor(utilizator);
					}
				else if(utilizator.getTip().equalsIgnoreCase("asistent"))
					gui3= new ControllerAsistent(utilizator);
				else gui4= new ControllerAdministrator(utilizator);

			}else if(gui.getUsername().isEmpty()||gui.getPassword().isEmpty())
			{
				gui.setUsername("Username/parola gol");
			
			}else
			{
				gui.setUsername("Username/parola gresita");
			}
			}
	
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
}
