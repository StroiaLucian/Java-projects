package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.JTable;

import Models.*;
import View.*;

public class ControllerAdministrator {
	private AdministratorPage gui;

	private PersistentaFactory pf= new PersistentaFactory();
	private Persistenta p1= pf.obtinePersistenta("conturi.txt");
	private Persistenta p2= pf.obtinePersistenta("utilizatori.txt");
	private Utilizator actual;
	public ControllerAdministrator(Utilizator actual) {
		this.actual=actual;
		gui=new AdministratorPage();
		gui.addlistener1(new listener_Button1());
		gui.addlistener2(new listener_Button2());
		gui.addlistener3(new listener_Button3());
		gui.addlistener4(new listener_Button4());
		ArrayList<Utilizator> a=afisareDoctorAsistentUtilizatori(actual);
		ArrayList<String> trimitere= new ArrayList<String>();
		for(Utilizator an:a)
		{

			trimitere.add("id="+an.getId()+", nume="+an.getNume()+", varsta="+an.getVarsta()+" ani"+", cnp="+an.getCnp()+", tip="+an.getTip());
		}
		gui.setPanel(gui.adaugareTabel("Id,Nume,Varsta,CNP,Tip",trimitere,true));
		
	}

	public void introducereDoctorAsistent(Utilizator actual,Utilizator utilizator, String user, String parola)
	{
		ContUtilizator cont= new ContUtilizator(user,parola,utilizator);
		actual.creareContUtilizator(cont,(PersistentaConturiUtilizatori)p1);
		actual.creareUtilizator(utilizator,(PersistentaUtilizatori)p2);
	}

	public static boolean isNumeric(String str) { 
		  try {  
		    Long.parseLong(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
		}
	public boolean stringContainsNumber( String s )
	{
	    return Pattern.compile( "[0-9]" ).matcher( s ).find();
	}
	public boolean cautareIdNou(int Id, String CNP)
	{
		ArrayList<Utilizator> a= afisareDoctorAsistentUtilizatori(actual);
		for(Utilizator an:a)
		{
			if(an.getId()==Id || an.getCnp().equalsIgnoreCase(CNP))
			{
				return true;
			}
		}
		return false;
	}
	class listener_Button2 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
		
			
					try {
					
						if(!gui.getTextIntroducereId().isEmpty() || !gui.getTexIntroducereNume().isEmpty() || !gui.getTextIntroducereVarsta().isEmpty() || !gui.getTextIntroducereCNP().isEmpty() || !gui.getTextIntroducereParola().isEmpty() || !gui.getTextIntroducereProfesie().isEmpty() || !gui.getTextIntroducereUsername().isEmpty()) 
						{	
							if(isNumeric(gui.getTextIntroducereId()) && isNumeric(gui.getTextIntroducereVarsta()) && isNumeric(gui.getTextIntroducereCNP()) )
							{
							if(gui.getTextIntroducereCNP().length()==13) {
								if(!cautareIdNou(Integer.parseInt(gui.getTextIntroducereId()),gui.getTextIntroducereCNP()))
								{
									if(!stringContainsNumber(gui.getTexIntroducereNume()) && !stringContainsNumber(gui.getTextIntroducereProfesie())) {
										if(gui.getTextIntroducereProfesie().equalsIgnoreCase("doctor")|| gui.getTextIntroducereProfesie().equalsIgnoreCase("asistent"))
										{
											introducereDoctorAsistent(actual,new Utilizator(Integer.parseInt(gui.getTextIntroducereId()),gui.getTexIntroducereNume(),gui.getTextIntroducereVarsta(),gui.getTextIntroducereCNP(),gui.getTextIntroducereProfesie()),gui.getTextIntroducereUsername(),gui.getTextIntroducereParola());
											gui.setTextSuccesInregistrare("SUCCES!");
											gui.setTexIntroducereNume("");
											gui.setTextIntroducereCNP("");
											gui.setTextIntroducereId("");
											gui.setTextIntroducereParola("");
											gui.setTextIntroducereProfesie("");
											gui.setTextIntroducereUsername("");
											gui.setTextIntroducereVarsta("");
											ArrayList<Utilizator> a=afisareDoctorAsistentUtilizatori(actual);
											ArrayList<String> trimitere= new ArrayList<String>();
											for(Utilizator an:a)
											trimitere.add(an.toString());
											gui.setPanel(gui.adaugareTabel("Id,Nume,Varsta,CNP,Tip",trimitere,true));
										}else gui.setTextSuccesInregistrare("Profesie gresita!");
										
									}else gui.setTextSuccesInregistrare("Nume sau profesie gresita!");
									
								}else gui.setTextSuccesInregistrare("Id sau CNP existent");
								
							}
							
							else {
								gui.setTextSuccesInregistrare("CNP incorect!");
							}
							}
							else {
								System.out.println(gui.getTextIntroducereId()+" "+ gui.getTextIntroducereCNP()+" "+ gui.getTextIntroducereVarsta());
								gui.setTextSuccesInregistrare("Id,varsta sau CNP gresit!");
							}
						    }else gui.setTextSuccesInregistrare("EROARE!");
							
						
						
					}catch(Exception ex)
					{
						ex.printStackTrace();
					}
				}
	}
	//AFISARE
	public ArrayList<Utilizator> afisareDoctorAsistentUtilizatori(Utilizator actual){
		
		return actual.vizualizareUtilizator((PersistentaUtilizatori)p2);
	}
	
	class listener_Button1 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			try {
				ArrayList<Utilizator> a=afisareDoctorAsistentUtilizatori(actual);
				ArrayList<String> trimitere= new ArrayList<String>();
				for(Utilizator an:a)
				{

					trimitere.add("id="+an.getId()+", nume="+an.getNume()+", varsta="+an.getVarsta()+" ani"+", cnp="+an.getCnp()+", tip="+an.getTip());
				}
				gui.setPanel(gui.adaugareTabel("Id,Nume,Varsta,CNP,Tip",trimitere,true));
			}catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
	}
	//EDITARE
	public ArrayList<ContUtilizator> afisareDoctorAsistentContUtilizatori(Utilizator actual){
		
		return actual.vizualizareContUtilizator((PersistentaConturiUtilizatori)p1);
	}	
	public void editare(Utilizator actual, ArrayList<Utilizator> lista) {
	ArrayList<ContUtilizator> ceTrebuie= new ArrayList<ContUtilizator>();
	ceTrebuie=afisareDoctorAsistentContUtilizatori(actual);
	int i=0;
	for(ContUtilizator a:ceTrebuie)
	{
		a.setUtilizator(lista.get(i));
		i++;
	}
		actual.serializareConturiUtilizatori(ceTrebuie, (PersistentaConturiUtilizatori) p1);
		actual.serializareUtilizatori(lista, (PersistentaUtilizatori) p2);
	}
	class listener_Button3 implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				try {
					if(gui.getPanel().isVisible()) {	
					JTable date=gui.getTable();
					String[][] datee= new String[date.getRowCount()][date.getColumnCount()];
					ArrayList<Utilizator> aux= new ArrayList<Utilizator>();
					for(int i=0;i<date.getRowCount();i++)
						for(int j=0;j<date.getColumnCount();j++)
						{
							datee[i][j]=(String) date.getValueAt(i, j);
						}

					for(int i=0;i<date.getRowCount();i++)
					{	String[] auxiliar=datee[i][2].split(" ");
						aux.add(new Utilizator(Integer.parseInt(datee[i][0]),datee[i][1],auxiliar[0],datee[i][3],datee[i][4]));
					}
					editare(actual, aux);
					}

				}catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
		}
	//STERGERE
	public void stergereUtilizatoriSiConturi(Utilizator actual,int id)
	{
		actual.stergereContUtilizator(id, (PersistentaConturiUtilizatori) p1);
		actual.stergereUtilizator(id, (PersistentaUtilizatori) p2);
	}
	class listener_Button4 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			try {
				if(gui.getTable().isColumnSelected(0)) {
				stergereUtilizatoriSiConturi(actual,Integer.parseInt((String) gui.getTable().getValueAt(gui.getTable().getSelectedRow(),0)));
				ArrayList<Utilizator> a=afisareDoctorAsistentUtilizatori(actual);
				ArrayList<String> trimitere= new ArrayList<String>();
				for(Utilizator an:a)
				{

					trimitere.add("id="+an.getId()+", nume="+an.getNume()+", varsta="+an.getVarsta()+" ani"+", cnp="+an.getCnp()+", tip="+an.getTip());
				}
				gui.setPanel(gui.adaugareTabel("Id,Nume,Varsta,CNP,Tip",trimitere,true));
				}
			}catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
	}
	
}

