package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JTable;
import Models.Animal;
import Models.Persistenta;
import Models.PersistentaAnimale;
import Models.PersistentaFactory;
import Models.PersistentaProgramConsultatii;
import Models.ProgramConsultatii;
import Models.Statistica;
import Models.StatisticaBuillder;
import Models.Utilizator;
import View.*;
import javafx.util.Pair;

public class ControllerDoctor {
	private DoctorPage gui;
	private PersistentaFactory pf= new PersistentaFactory();
	private Persistenta p= pf.obtinePersistenta("animale.txt");
	private Persistenta c= pf.obtinePersistenta("programari.txt");
	private Utilizator actual;
	private ProgramConsultatii program;
	
	public ControllerDoctor(Utilizator actual) {
		this.actual=actual;
		this.program= new ProgramConsultatii(this.actual,this.creareProgramGol());
		
		gui=new DoctorPage();
		gui.addlistener1(new listener_Button1());
		gui.addlistener2(new listener_Button2());
		gui.addlistener3(new listener_Button3());
		gui.addlistener4(new listener_Button4());
		gui.addlistener5(new listener_Button5());
		gui.addlistener6(new listener_Button6());
		ArrayList<Animal> a=afisareAnimale(actual);
		ArrayList<String> trimitere= new ArrayList<String>();
		for(Animal an:a)
		{
			trimitere.add(an.toString());
		}
		gui.setPanelTabel(gui.adaugareTabel("Id,Nume,Tip,Varsta,Simptome,Diagnostic,Tratament,Doctor",trimitere,true));
		this.program= new ProgramConsultatii(this.actual,this.creareProgramGol());
		if(a.size()==1)
		{
			actual.salvareProgramConsultatii(this.program, (PersistentaProgramConsultatii) c);
		}

	}
	@SuppressWarnings({ "unchecked", "rawtypes" })//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	public ArrayList<Pair<String,ArrayList<Pair<String,Pair<Boolean,String>>>>> creareProgramGol() {
		ArrayList<Pair<String,ArrayList<Pair<String,Pair<Boolean,String>>>>> gol= new ArrayList<Pair<String,ArrayList<Pair<String,Pair<Boolean,String>>>>>();
		ArrayList<Pair<String,Pair<Boolean,String>>> intervale= new ArrayList<Pair<String,Pair<Boolean,String>>>();
		String[] intervale_ore= new String[] {"08-10","10-12","12-14","14-16","16-18","18-20"};
		String nume="-";
		for(int i=0;i<6;i++)
			intervale.add(new Pair(intervale_ore[i],new Pair(false,nume)));
		gol.add(new Pair("Luni",intervale));
		gol.add(new Pair("Marti",intervale));
		gol.add(new Pair("Miercuri",intervale));
		gol.add(new Pair("Joi",intervale));
		gol.add(new Pair("Vineri",intervale));
		return gol;   	
	}
	////AFISARE
	public ArrayList<Animal> afisareAnimale(Utilizator a)
	{
		 ArrayList<Animal> nou= new ArrayList<Animal>();
		 int i=0;
		 for(Animal an:  a.vizualizareFiseMedicaleAnimale((PersistentaAnimale)p))
		 {
			 if(an.getDoctor().equalsIgnoreCase(a.getNume()))
				 nou.add(an);
		 }
		 if(nou.size()>0) return nou;
		 else {
			 //int identificator, String nume, String tip, int varsta, String simptome, String diagnostic, String tratament, String doctor
			 nou.add(new Animal(0,"-","-",0,"-","-","-",actual.getNume()));
			 return nou;
		 }
	}
	
	class listener_Button1 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			try {
				ArrayList<Animal> a=afisareAnimale(actual);
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

	//FILTRAREA
	public ArrayList<String> filtrare(Utilizator a, String criteriu)
	{
		return a.filtrareFiseMedicaleAnimaleDoctor(criteriu, (PersistentaAnimale)p); // aici introducem criteriul dorit
	
	}

	class listener_Button3 implements ActionListener{
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

	//EDITARE
	public void editare(Utilizator actual, ArrayList<Animal> lista) {
		actual.serializareAnimale(lista, (PersistentaAnimale)p);
	}
	class listener_Button2 implements ActionListener{
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
					editare(actual, aux);
					}

				}catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
		}
	//STATISTICI

	class listener_Button4 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			try {
				ArrayList<Animal> a=afisareAnimale(actual);
				StatisticaBuillder statisticaBuilder= new StatisticaBuillder();
				Statistica statistica= statisticaBuilder.creareStatistica(a,gui.getComboBoxStatistici());
				gui.chart1(statistica.createDemoPanel());
				gui.chart2(statistica.createDemoPanel2());

			}catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
	}
	//VIZUALIZARE PROGRAM CONSULTATII
	public ArrayList<ProgramConsultatii> afisareProgramConsultatii(Utilizator a)
	{
		return a.vizualizareProgramConsultatii((PersistentaProgramConsultatii)c);
	}
	class listener_Button5 implements ActionListener{
		@SuppressWarnings({ "rawtypes", "unchecked" })
		public void actionPerformed(ActionEvent e) {
			try {
				ArrayList<Pair<String,ArrayList<Pair<String,Pair<Boolean,String>>>>> nou= new ArrayList<Pair<String,ArrayList<Pair<String,Pair<Boolean,String>>>>>();
				ArrayList<ProgramConsultatii> nou2=afisareProgramConsultatii(actual);
				for(ProgramConsultatii a:nou2) {
					if(a.getDoctor().toString().equalsIgnoreCase(actual.toString())){
						nou=a.getProgram();
						break;
					}
				}				
				program.setProgram(nou);
				ArrayList<String> trimitere= new ArrayList<String>();
				int cat=0;
				for(Pair an:program.getProgram())
				{
					//an.getValue()// Asta este un arrayList cu interval ore,o pereche cu valoare booleana daca e ocupat intervalul sau nu si numele animalului.
					for(Pair an2:(ArrayList<Pair<String,Pair<Boolean,String>>>)an.getValue())
					{
						if(cat==0)
						trimitere.add(an.getKey()+","+an2.getKey()+","+((Pair) an2.getValue()).getKey()+","+((Pair) an2.getValue()).getValue());
						else trimitere.add(" "+","+an2.getKey()+","+((Pair) an2.getValue()).getKey()+","+((Pair) an2.getValue()).getValue());
						cat++;
					}
					cat=0;
				}				
				gui.setPanelProgram(gui.adaugareProgram("Zi,Interval,Ocupat,Animal",trimitere,true));
			}catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
	}
	//SALVARE PROGRAM CONSULTATII

	public void salvareProgramConsultatii(Utilizator actual,ProgramConsultatii lista) {
		actual.salvareProgramConsultatii(lista, (PersistentaProgramConsultatii)c);
	}
	class listener_Button6 implements ActionListener{
		@SuppressWarnings({ "unchecked", "rawtypes" })
		public void actionPerformed(ActionEvent e) {
			try {
				if(gui.getPanelProgram().isVisible()) {	
				JTable date=gui.getTable2();
				String[][] datee= new String[date.getRowCount()][date.getColumnCount()];
				ArrayList<Pair<String,ArrayList<Pair<String,Pair<Boolean,String>>>>> aux= new ArrayList<Pair<String,ArrayList<Pair<String,Pair<Boolean,String>>>>>();
				for(int i=0;i<date.getRowCount();i++)
					for(int j=0;j<date.getColumnCount();j++)
					{
						datee[i][j]=(String) date.getValueAt(i, j);
					}
				int cont=0;
				String nume="";
				ArrayList<Pair<String,Pair<Boolean,String>>> perechi=new ArrayList<Pair<String,Pair<Boolean,String>>>();
				for(int i=0;i<date.getRowCount();i++)
				{	
						System.out.println("ajungeee");

						if(cont==0) nume=datee[i][0];
						perechi.add(new Pair(datee[i][1],new Pair(Boolean.parseBoolean(datee[i][2]), datee[i][3])));
					

						cont++;
						if(cont==6)
						{
						aux.add(new Pair(nume,perechi));
						perechi=new ArrayList<Pair<String,Pair<Boolean,String>>>();
						nume="";
						cont=0;
						}
				}
				
				ProgramConsultatii ax= new ProgramConsultatii(actual,aux);
				
				salvareProgramConsultatii(actual,ax);
				}
			}catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
	}
}

	

