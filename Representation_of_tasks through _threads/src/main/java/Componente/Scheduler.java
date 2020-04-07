package Componente;
import java.util.ArrayList;

import Interfata.SimulationFrame;
import Interfata.View;
public class Scheduler {
private ArrayList<Coada> sir_de_cozi;
private int nr_cozi;
private int nr_clienti;
private Strategie strategia;
private View my_view;

public Scheduler(int nr_cozi, int nr_clienti,View my_view,SimulationFrame vedere2) {
	
	this.nr_clienti=nr_clienti;
	this.nr_cozi=nr_cozi;
	sir_de_cozi= new ArrayList<Coada>(nr_cozi);
	int i=0;
	while(i<nr_cozi)
	{	Coada c=new Coada(nr_clienti,i+1,my_view,vedere2);
		sir_de_cozi.add(c);
		Thread t=new Thread(c);
		t.start();
		i++;
	}
	strategia=new Strategie(my_view);
}

public int  imparteClienti(Client c)
{	
	int d=strategia.adaugare_clienti(sir_de_cozi, c);
	return d;
}
public ArrayList<Coada> getSir_de_cozi() {
	return sir_de_cozi;
}
}
