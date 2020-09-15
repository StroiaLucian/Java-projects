package Componente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;

import Interfata.SimulationFrame;
import Interfata.View;
public class SimulationManager implements Runnable {
private View vedere;
private int vin_min;
private int vin_max;
private int serv_min;
private int serv_max;
private int sim_time;
private int nr_cozi;
private int nr_clienti;
private Scheduler sch;
private SimulationFrame vedere2;
private ArrayList<Client> sir_clienti_random=new ArrayList<Client>(nr_clienti);
public SimulationManager(int nr_cozi,View v,SimulationFrame vedere2)
{
	vedere=v;
	this.vedere2=vedere2;
	vin_min=vedere.getMin1();
	vin_max=vedere.getMax1();
	serv_min=vedere.getMin2();
	serv_max=vedere.getMax2();
	sim_time=vedere.getMin3();
	nr_clienti=vedere.getMax3();
	this.nr_cozi=nr_cozi;
	sch=new Scheduler(nr_cozi,nr_clienti,vedere,vedere2);
	this.generare_clienti();
	
	
}
public void generare_clienti() 
{	int n=nr_clienti;
	char i='A';
	while(n>0)
	{
	int venire = (int)(Math.random() * ( vin_max- vin_min)) + vin_min;
	int procesare=(int)(Math.random() * ( serv_max- serv_min)) + serv_min;
	Client auxiliar=new Client(i,venire,procesare);
	sir_clienti_random.add(auxiliar);
	venire=0;
	procesare=0;
	n--;
	i++;
	}
	Collections.sort(sir_clienti_random);
}

public void run() {
	int timp_actual=0;
	while(timp_actual<sim_time)
	{
	for(Client c:sir_clienti_random)
	{
		if(c.getTimp_ajungere()==timp_actual)
		{
			int a=sch.imparteClienti(c);
			vedere2.setInformatii(vedere2.getInformatii()+"\n"+c.toString()+" a fost adaugat in coada "+a);
			if(a==1)
			{
				vedere2.setCoada1(vedere2.getCoada1()+c.afisare(0));
			}
			if(a==2)
			{
				vedere2.setCoada2(vedere2.getCoada2()+c.afisare(0));
			}
			if(a==3)
			{
				vedere2.setCoada3(vedere2.getCoada3()+c.afisare(0));
			}
			if(a==4)
			{
				vedere2.setCoada4(vedere2.getCoada4()+c.afisare(0));
			}
			if(a==5)
			{
				vedere2.setCoada5(vedere2.getCoada5()+c.afisare(0));
			}
			if(a==6)
			{
				vedere2.setCoada6(vedere2.getCoada6()+c.afisare(0));
			}
			
		}
		
	}
	timp_actual++;
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	}
}

public int getVin_min() {
	return vin_min;
}
public void setVin_min(int vin_min) {
	this.vin_min = vin_min;
}
public int getVin_max() {
	return vin_max;
}
public void setVin_max(int vin_max) {
	this.vin_max = vin_max;
}
public int getServ_min() {
	return serv_min;
}
public void setServ_min(int serv_min) {
	this.serv_min = serv_min;
}
public int getServ_max() {
	return serv_max;
}
public void setServ_max(int serv_max) {
	this.serv_max = serv_max;
}
public int getSim_time() {
	return sim_time;
}
public void setSim_time(int sim_time) {
	this.sim_time = sim_time;
}
public int getNr_cozi() {
	return nr_cozi;
}
public void setNr_cozi(int nr_cozi) {
	this.nr_cozi = nr_cozi;
}
public int getNr_clienti() {
	return nr_clienti;
}
public void setNr_clienti(int nr_clienti) {
	this.nr_clienti = nr_clienti;
}
public Scheduler getSch() {
	return sch;
}
public void setSch(Scheduler sch) {
	this.sch = sch;
}
public ArrayList<Client> getSir_clienti_random() {
	return sir_clienti_random;
}
public void setSir_clienti_random(ArrayList<Client> sir_clienti_random) {
	this.sir_clienti_random = sir_clienti_random;
}


}
