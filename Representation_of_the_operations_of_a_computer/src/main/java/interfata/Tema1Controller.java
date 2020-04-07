package interfata;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import polinoame.*;

public class Tema1Controller {
		private Tema1View my_view;
		private Tema1Model my_model;
		private String polinom1;
		private String polinom2;
		private String rezultat;
		
		public Tema1Controller(Tema1View my_view,Tema1Model my_model) {
		this.my_view = my_view;
		this.my_model=my_model;
		this.my_view.adunareListener(new addListener());
		this.my_view.scadereListener(new subListener());
		this.my_view.inmultireListener(new mulListener());
		this.my_view.impartireListener(new divListener());
		this.my_view.integrareListener(new intListener());
		this.my_view.derivareListener(new derListener());	
		this.my_view.resetListener(new rstListener());	
		
		}		
		class addListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
		try{
		my_view.setResultPolinom("");
		my_model.setRezultat("");	
		polinom1 = my_view.getFirstPolinom();
		polinom2 = my_view.getSecondPolinom();
		if(my_view.Eroare(polinom1) && my_view.Eroare(polinom2))
		{my_model.adunarePolinoame(polinom1,polinom2);
		if(my_model.getRezultat().contains("Eroare"))
		{my_model.setRezultat(my_model.getRezultat().replace("Eroare", ""));	
		if(my_model.getRezultat().equalsIgnoreCase("")) my_model.setRezultat("0");
		my_view.setResultPolinom(my_model.getRezultat());
		}
		else 
			my_view.setResultPolinom(my_model.getRezultat());
		}
		else my_view.setResultPolinom("Eroare la introducerea polinoamelor");
		}
		catch(Exception e1){
		System.out.println(e1.getMessage());
		}
		}
		}
		class subListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
			try{
			my_view.setResultPolinom("");
			my_model.setRezultat("");
			polinom1 = my_view.getFirstPolinom();
			polinom2 = my_view.getSecondPolinom();		
			if(my_view.Eroare(polinom1) && my_view.Eroare(polinom2))
			{my_model.scaderePolinoame(polinom1,polinom2);
			if(my_model.getRezultat().contains("Eroare"))
			{my_model.setRezultat(my_model.getRezultat().replace("Eroare", ""));	
			if(my_model.getRezultat().equalsIgnoreCase("")) my_model.setRezultat("0");
			my_view.setResultPolinom(my_model.getRezultat());
			}
			else 
				my_view.setResultPolinom(my_model.getRezultat());
			}
			else my_view.setResultPolinom("Eroare la introducerea polinoamelor");
			}
			catch(Exception e1){
			System.out.println(e1.getMessage());
			}
			}
			}
		class mulListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
			try{
			my_view.setResultPolinom("");
			my_model.setRezultat("");
			polinom1 = my_view.getFirstPolinom();
			polinom2 = my_view.getSecondPolinom();		
			if(my_view.Eroare(polinom1) && my_view.Eroare(polinom2))
			{my_model.inmultirePolinoame(polinom1,polinom2);
			my_view.setResultPolinom(my_model.getRezultat());
			}
			else my_view.setResultPolinom("Eroare la introducerea polinoamelor");
			}
			catch(Exception e1){
			System.out.println(e1.getMessage());
			}
			}
			}
		class divListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
			try{
			my_view.setResultPolinom("");
			my_model.setRezultat("");
			polinom1 = my_view.getFirstPolinom();
			polinom2 = my_view.getSecondPolinom();		
			if(my_view.Eroare(polinom1) && my_view.Eroare(polinom2))
			{	my_model.impartirePolinoame(polinom1,polinom2);
			my_view.setResultPolinom(my_model.getRezultat());
			}
			else my_view.setResultPolinom("Eroare la introducerea polinoamelor");
			}
			catch(Exception e1){
			System.out.println(e1.getMessage());
			}
			}
			}
		class intListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
			try{
			my_view.setResultPolinom("");
			my_model.setRezultat("");
			polinom1 = my_view.getFirstPolinom();
			polinom2 = my_view.getSecondPolinom();		
			if(my_view.Eroare(polinom1))
			{my_model.integrarePolinoame(polinom1);
			my_view.setResultPolinom(my_model.getRezultat());
			}
			else my_view.setResultPolinom("Eroare la introducerea polinoamelor");
			}
			catch(Exception e1){
			System.out.println(e1.getMessage());
			}
			}
			}
		class derListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
			try{
			my_view.setResultPolinom("");
			my_model.setRezultat("");
			polinom1 = my_view.getFirstPolinom();
			if(my_view.Eroare(polinom1))
			{my_model.derivarePolinoame(polinom1);
			my_view.setResultPolinom(my_model.getRezultat());
			}
			else my_view.setResultPolinom("Eroare la introducerea polinoamelor");
			}
			catch(Exception e1){
			System.out.println(e1.getMessage());
			}
			}
			}
		class rstListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
			polinom1="";
			polinom2="";
			my_view.setResultPolinom("");
			my_model.setRezultat("");
			}
			}
}
		
