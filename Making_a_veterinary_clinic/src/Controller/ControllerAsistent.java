package Controller;
import View.*;
import javafx.util.Pair;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.JTable;

import org.jdesktop.swingx.JXDatePicker;


import Models.*;

public class ControllerAsistent {
	private AsistentPage gui;
	private PersistentaFactory pf= new PersistentaFactory();
	private Persistenta d = pf.obtinePersistenta("conturi.txt");
	private Persistenta b = pf.obtinePersistenta("rapoarte4.json");
	private Persistenta p=pf.obtinePersistenta("animale.txt");
	private Persistenta c= pf.obtinePersistenta("programari.txt");
	private Utilizator actual;
	public ControllerAsistent(Utilizator actual) {
		gui=new AsistentPage();
		this.actual=actual;
		gui.addlistener1(new listener_Button1());
		gui.addlistener2(new listener_Button2());
		gui.addlistener3(new listener_Button3());
		gui.addlistener4(new listener_Button4());
		gui.addlistener5(new listener_Button5());
		gui.addlistener6(new listener_Button6());
		gui.addlistener7(new listener_Button7());
		ArrayList<Animal> a=vizualizareAnimale(actual);
		ArrayList<String> trimitere= new ArrayList<String>();
		for(Animal an:a)
		{
			trimitere.add(an.toString());
		}
		gui.setPanelTabel(gui.adaugareTabel("Id,Nume,Tip,Varsta,Simptome,Diagnostic,Tratament,Doctor",trimitere,true));
	}
	//INTRODUCERE ANIMALE
	public void introducereAnimale(Utilizator actual,int id, String nume, String specie, int varsta, String simptome, String diagnostic, String tratament, String doctor)
	{
		actual.creareFiseMedicaleAnimale(new Animal(id,nume,specie,varsta,simptome,diagnostic,tratament,doctor),(PersistentaAnimale)p);
	}
	public static boolean isNumeric(String str) { 
		  try {  
		    Integer.parseInt(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
		}
	public boolean stringContainsNumber( String s )
	{
	    return Pattern.compile( "[0-9]" ).matcher( s ).find();
	}
	public boolean verificaIdAnimale(int id)
	{
		ArrayList<Animal> a=vizualizareAnimale(actual);
		for(Animal an:a)
		{
			if(an.getIdentificator()==id)
			{
				return true;
			}
		}
		return false;
	}
	class listener_Button1 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			try {
				if(!gui.getTexIntroducereID().isEmpty() || !gui.getTextIntroducereNume().isEmpty() || !gui.getTextIntroducereVarsta().isEmpty() || !gui.getTextIntroducereSimptome().isEmpty() || !gui.getTextIntroducereDiagnostic().isEmpty() || !gui.getTextIntroducereDoctor().isEmpty() || !gui.getTextIntroducereSpecie().isEmpty() || !gui.getTextIntroducereTratament().isEmpty()) {
				if(isNumeric(gui.getTexIntroducereID()) && isNumeric(gui.getTextIntroducereVarsta()) )
				{
					if(!stringContainsNumber(gui.getTextIntroducereNume()) && !stringContainsNumber(gui.getTextIntroducereSpecie()) && !stringContainsNumber(gui.getTextIntroducereDoctor())) 
					{
						if(!verificaIdAnimale(Integer.parseInt(gui.getTexIntroducereID())))
						{introducereAnimale(actual,Integer.parseInt(gui.getTexIntroducereID()), gui.getTextIntroducereNume(),gui.getTextIntroducereSpecie(),Integer.parseInt(gui.getTextIntroducereVarsta()),gui.getTextIntroducereSimptome(),gui.getTextIntroducereDiagnostic(),gui.getTextIntroducereTratament(),gui.getTextIntroducereDoctor());
						gui.setTextFieldSucces("SUCCES!");
						gui.setTexIntroducereID("");
						gui.setTextIntroducereNume("");
						gui.setTextIntroducereDiagnostic(""); 
						gui.setTextIntroducereDoctor("");
						gui.setTextIntroducereSimptome("");
						gui.setTextIntroducereTratament("");
						gui.setTextIntroducereVarsta("");
						gui.setTextIntroducereSpecie("");
						ArrayList<Animal> a=vizualizareAnimale(actual);
						ArrayList<String> trimitere= new ArrayList<String>();
						for(Animal an:a)
							trimitere.add(an.toString());
				
						gui.setPanelTabel(gui.adaugareTabel("Id,Nume,Tip,Varsta,Simptome,Diagnostic,Tratament,Doctor",trimitere,true));
						}
						else {
							gui.setTextFieldSucces("Id existent!");
						}
					}else
					{
						gui.setTextFieldSucces("Nume,tip sau doctor invalid!");
					}
					
					}else
				{
					gui.setTextFieldSucces("Varsta sau id invalid!");
				}
				}
				else gui.setTextFieldSucces("EROARE!");
			
			}catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
	}
	
	//VIZUALIZARE ANIMALE
	public ArrayList<Animal> vizualizareAnimale(Utilizator actual)
	{
		return actual.vizualizareFiseMedicaleAnimale((PersistentaAnimale)p);
		
	}
	
	class listener_Button2 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			try {
				gui.setTextFieldSucces("");
				ArrayList<Animal> a=vizualizareAnimale(actual);
				ArrayList<String> trimitere= new ArrayList<String>();
				for(Animal an:a)
				{
					trimitere.add(an.toString());
				}
				gui.setPanelTabel(gui.adaugareTabel("Id,Nume,Tip,Varsta,Simptome,Diagnostic,Tratament,Doctor",trimitere,true));
			}catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}

	}
	
	//EDITAREA
	public void editare(Utilizator actual, ArrayList<Animal> lista) {
		actual.serializareAnimale(lista, (PersistentaAnimale)p);
	}
	class listener_Button3 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			try {
				if(gui.getPanelTabel().isVisible()) {	
				JTable date=gui.getTable();
				String[][] datee= new String[date.getRowCount()][date.getColumnCount()];
				ArrayList<Animal> aux= new ArrayList<Animal>();
				for(int i=0;i<date.getRowCount();i++)
					for(int j=0;j<date.getColumnCount();j++)
					{
						datee[i][j]=(String) date.getValueAt(i, j);
					}

				for(int i=0;i<date.getRowCount();i++)
				{	String[] auxiliar=datee[i][3].split(" ");
					aux.add(new Animal(Integer.parseInt(datee[i][0]),datee[i][1],datee[i][2],Integer.parseInt(auxiliar[0]),datee[i][4],datee[i][5],datee[i][6],datee[i][7]));
				}
				System.out.println("ajunge aici");
				editare(actual, aux);
				}

			}catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
	}

	//STERGERE
	
	public void stergereAnimal(Utilizator actual,int id)
	{
		actual.stergereAnimalUtilizator(id,(PersistentaAnimale)p);
	}
	class listener_Button4 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			try {
				if(gui.getTable().isColumnSelected(0)) {
				stergereAnimal(actual,Integer.parseInt((String) gui.getTable().getValueAt(gui.getTable().getSelectedRow(),0)));
				gui.setTextFieldSucces("");
				ArrayList<Animal> a=vizualizareAnimale(actual);
				ArrayList<String> trimitere= new ArrayList<String>();
				for(Animal an:a)
				{
					trimitere.add(an.toString());
				}
				gui.setPanelTabel(gui.adaugareTabel("Id,Nume,Tip,Varsta,Simptome,Diagnostic,Tratament,Doctor",trimitere,true));
				}
			}catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
	}
	//FILTRAREA
		public ArrayList<String> filtrare(Utilizator a, String criteriu)
		{
			return a.filtrareFiseMedicaleAnimaleDoctor(criteriu, (PersistentaAnimale)p); // aici introducem criteriul dorit
		}
		
		
		class listener_Button5 implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				try {
					if(gui.getTextFieldCriteriu().length()>0)
					{
						String criteriu=gui.getComboBoxCriteriu()+"="+gui.getTextFieldCriteriu();
						ArrayList<String> animale=filtrare(actual,criteriu);
						if(animale.size()>0){
							gui.setPanelTabel(gui.adaugareTabel("Id,Nume,Tip,Varsta,Simptome,Diagnostic,Tratament,Doctor",animale,false));
						}else gui.setTextFieldCriteriu("Nu s-a gasit");
					}else gui.setTextFieldCriteriu("Text introdus gol");
				}catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}

		}

		public ArrayList<ProgramConsultatii> afisareProgramConsultatii(Utilizator a)
		{
			return a.vizualizareProgramConsultatii((PersistentaProgramConsultatii)c);
		}
		public void salvareProgramConsultatii(Utilizator actual,ProgramConsultatii lista) {
			actual.salvareProgramConsultatii(lista, (PersistentaProgramConsultatii)c);
		}
		class listener_Button6 implements ActionListener{
			@SuppressWarnings({ "deprecation", "rawtypes", "unchecked" })
			public void actionPerformed(ActionEvent e) {
				try {
		
					if(gui.getTable().isColumnSelected(0))
					{
						JXDatePicker picker = gui.getPicker();
						String[] zile_saptamana= new String[] {"Duminica","Luni","Marti","Miercuri","Joi","Vineri","Sambata"};			
						ArrayList<Animal> a=vizualizareAnimale(actual);
						Animal selectat=null;
						for(Animal an:a) {
							if(an.getIdentificator()==Integer.parseInt((String)gui.getTable().getValueAt(gui.getTable().getSelectedRow(),0)))
							{
							selectat=an;
							break;
							}
						}
						String numele_doctorului_animalului_selectat=selectat.getDoctor();
						String numele_animalului_selectat= selectat.getNume();
						ArrayList<ProgramConsultatii> consultatii=afisareProgramConsultatii(actual);
						ProgramConsultatii retinere=null;
						
						for(ProgramConsultatii an:consultatii)
						{	
							if(an.getDoctor().getNume().equalsIgnoreCase(numele_doctorului_animalului_selectat))
							{
								retinere=an;
								break;
							}
						}
						ArrayList<Pair<String,Pair<Boolean,String>>> retinee= new ArrayList<Pair<String,Pair<Boolean,String>>>();
						ArrayList<Pair<String,ArrayList<Pair<String,Pair<Boolean,String>>>>> retine2= new ArrayList<Pair<String,ArrayList<Pair<String,Pair<Boolean,String>>>>>();
						String ziua="";
						for(Pair an: retinere.getProgram())
						{
							if(zile_saptamana[picker.getDate().getDay()].equalsIgnoreCase((String) an.getKey()))
							{
								retinee=(ArrayList<Pair<String,Pair<Boolean,String>>>) an.getValue();
								ziua=(String) an.getKey();
							}else
								retine2.add(an);
						}
						boolean ok=false;
						int index=0;
						ArrayList<Pair<String,Pair<Boolean,String>>> arrayNou= new ArrayList<Pair<String,Pair<Boolean,String>>>();
						for(Pair an:retinee)
						{
							if(an.getKey().equals((gui.getComboOra().getSelectedItem())))
							{
								if(((Pair<Boolean, String>) an.getValue()).getKey().equals(false))
									{
									
									arrayNou.add(new Pair(gui.getComboOra().getSelectedItem(),new Pair(true,numele_animalului_selectat))); 
									gui.setTextFieldSucces2("SUCCES!");
									ok=true;
									}
								else {arrayNou.add(an);
									gui.setTextFieldSucces2("EROARE!");
									ok=false;
								}
								
							}
							else arrayNou.add(an); 
						}
						retine2.add(new Pair(ziua,arrayNou));
						for(Pair an:retine2)
							System.out.println("ZIUA->"+an.getKey()+":"+an.getValue());
						ProgramConsultatii ax= new ProgramConsultatii(retinere.getDoctor(),retine2);					
						salvareProgramConsultatii(actual,ax);
						
						
				}
				}catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}

		}
		//SALVARE RAPOARTE
		public ArrayList<ContUtilizator> afisareDoctorAsistentConturi(Utilizator ContUtilizator){
			
			return actual.vizualizareContUtilizator((PersistentaConturiUtilizatori)d);
		}
		public void scriereFormate(Utilizator actual,ArrayList<Animal> a, ArrayList<Utilizator> u ){
			
				actual.salvareRapoarte(a, u, (PersistentaRapoarte) b);
		}
		class listener_Button7 implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				try {
					if(gui.getComboSalvare().getSelectedItem().equals("Animale"))
					{	
						
						scriereFormate(actual,vizualizareAnimale(actual), new ArrayList<Utilizator>());
						gui.setTextFieldSucces3("SUCCES!");
					}
					else if(gui.getComboSalvare().getSelectedItem().equals("Doctori"))
					{
						ArrayList<ContUtilizator> intermediar= afisareDoctorAsistentConturi(actual);
						ArrayList<Utilizator> ceTrimit= new ArrayList<Utilizator>();
						for(ContUtilizator a: intermediar)
							if(a.getUtilizator().getTip().equalsIgnoreCase("doctor"))
							{
								ceTrimit.add(a.getUtilizator());
							}
						scriereFormate(actual,new ArrayList<Animal>(),ceTrimit);
						gui.setTextFieldSucces3("SUCCES!");

					}
					 
				}catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
		}
        
}
	
	


	
