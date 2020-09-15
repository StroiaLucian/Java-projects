package Models;

import java.io.Serializable;
import java.util.ArrayList;

import Controller.*;

public class Utilizator extends Persoana implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3368314568210061963L;
	/**
	 * 
	 */
	private int id;
	private String tip;
public Utilizator(int id,String nume, String varsta, String cnp, String tip) {
	super(id,nume, Integer.parseInt(varsta), cnp);
	this.tip=tip;
	this.id=id;
}



public ArrayList<ProgramConsultatii> vizualizareProgramConsultatii(PersistentaProgramConsultatii p) {
	if(this.tip.equalsIgnoreCase("doctor")|| this.tip.equalsIgnoreCase("asistent")){
		return p.afisareConsultatii();
	}
	return null;
}
public void salvareProgramConsultatii(ProgramConsultatii a, PersistentaProgramConsultatii p) {
	if( this.tip.equalsIgnoreCase("doctor")|| this.tip.equalsIgnoreCase("asistent")){
	p.creareConsultatii(a);
	}
}

public void serializareAnimale(ArrayList<Animal> lista_animale,PersistentaAnimale p) {
	if(this.tip.equalsIgnoreCase("doctor")|| this.tip.equalsIgnoreCase("asistent"))
	{
		p.serializare(lista_animale);
	}
}


public void serializareUtilizatori(ArrayList<Utilizator> lista_utilizatori,PersistentaUtilizatori p) {
	if(this.tip.equalsIgnoreCase("administrator"))
	{
		p.serializare(lista_utilizatori);
	}
}

public void serializareConturiUtilizatori(ArrayList<ContUtilizator> lista_conturi_utilizatori,PersistentaConturiUtilizatori p) {
	if(this.tip.equalsIgnoreCase("administrator"))
	{
		p.serializare(lista_conturi_utilizatori);
	}
}

public ArrayList<Animal> vizualizareFiseMedicaleAnimale(PersistentaAnimale p) {
	if(this.tip.equalsIgnoreCase("doctor") || this.tip.equalsIgnoreCase("asistent")){
		return p.afisareAnimale();
	}
	return null;
}
public void creareFiseMedicaleAnimale(Animal a, PersistentaAnimale p) {
	if(this.tip.equalsIgnoreCase("asistent") || this.tip.equalsIgnoreCase("doctor")){
	p.creareAnimale(a);
	}
}
public ArrayList<String> filtrareFiseMedicaleAnimaleDoctor(String criteriu, PersistentaAnimale p)
{
	if(this.tip.equalsIgnoreCase("asistent")){
		ArrayList<Animal> aux=p.afisareAnimale();
		ArrayList<String> string_returnare=new ArrayList<String>();
		for(Animal a:aux)
		{
			if(criteriu.contains("diagnostic"))
			{
				if(a.getDiagnostic().equalsIgnoreCase(criteriu.substring(11, criteriu.length())))
				{
					string_returnare.add(a.toString());
				}
			}
			else if(criteriu.contains("doctor"))
			{
				if(a.getDoctor().equalsIgnoreCase(criteriu.substring(7, criteriu.length())))
				{
					string_returnare.add(a.toString());
				}
			}
			else if(criteriu.contains("tip"))
			{
				if(a.getTip().equalsIgnoreCase(criteriu.substring(4, criteriu.length())))
				{
					string_returnare.add(a.toString());
				}
			}
		}
		return string_returnare;
	}else if(this.tip.equalsIgnoreCase("doctor") )
	{
		ArrayList<Animal> aux=new ArrayList<Animal>();
		for(Animal a:p.afisareAnimale())
			if(a.getDoctor().equalsIgnoreCase(this.getNume()))
				aux.add(a);
		
		ArrayList<String> string_returnare=new ArrayList<String>();
		for(Animal a:aux)
		{
			if(criteriu.contains("diagnostic"))
			{
				if(a.getDiagnostic().equalsIgnoreCase(criteriu.substring(11, criteriu.length())))
				{
					string_returnare.add(a.toString());
				}
			}else if(criteriu.contains("tratament"))
			{
				if(a.getTratament().equalsIgnoreCase(criteriu.substring(10, criteriu.length())))
				{
					string_returnare.add(a.toString());
				}
			}
		}
		return string_returnare;
		
	}
	return null;
}
public void stergereAnimalUtilizator(int id,PersistentaAnimale p) {
	if(this.tip.equalsIgnoreCase("asistent") || this.tip.equalsIgnoreCase("doctor"))
	{
		p.stergereAnimalPersistenta(id);
	}
}

public void stergereContUtilizator(int id,PersistentaConturiUtilizatori p) {
	if(this.tip.equalsIgnoreCase("administrator")) {
		p.stergereConturiUtilizatorPersistenta(id);
	}
}
public void stergereUtilizator(int id,PersistentaUtilizatori p) {
	if(this.tip.equalsIgnoreCase("administrator")) {
		p.stergereUtilizatorPersistenta(id);
	}
}

public void creareContUtilizator(ContUtilizator cont, PersistentaConturiUtilizatori p){
	if(this.tip.equalsIgnoreCase("administrator")) {
		p.creareConturiUtilizatori(cont);
	}
}
public void creareUtilizator(Utilizator a, PersistentaUtilizatori p){
	if(this.tip.equalsIgnoreCase("administrator")) {
		p.creareUtilizatori(a);
	}
}
public ArrayList<Utilizator> vizualizareUtilizator(PersistentaUtilizatori p) {
	if(this.tip.equalsIgnoreCase("administrator")){
		return p.afisareUtilizatori();
	}
	return null;
}
public ArrayList<ContUtilizator> vizualizareContUtilizator(PersistentaConturiUtilizatori p) {
	if(this.tip.equalsIgnoreCase("administrator")||this.tip.equalsIgnoreCase("asistent")){
		return p.afisareConturiUtilizatori();
	}
	return null;
}
public void salvareRapoarte(ArrayList<Animal> a, ArrayList<Utilizator> b, PersistentaRapoarte p)
{
	if(this.tip.equalsIgnoreCase("asistent") )
{
	p.salvareRapoarte(a, b);
}
	
}
public String getTip() {
	return tip;
}
public void setTip(String tip) {
	this.tip = tip;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

@Override
public String toString() {
	return super.toString() +", tip=" + tip;
}

}
