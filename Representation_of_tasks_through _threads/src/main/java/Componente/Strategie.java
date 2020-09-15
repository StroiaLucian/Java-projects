package Componente;

import java.util.ArrayList;

import Interfata.View;

public class Strategie {
	View my_view;
	public Strategie(View my_view)
	{
		this.my_view=my_view;
	}
	public int aflare_minim(ArrayList<Coada> sir_cozi,Client d)
	{
		int valoare_minima=sir_cozi.get(0).getPerioada_asteptare().intValue();
		int index=0;
		
		for(Coada c:sir_cozi)
		{
		if(c.getPerioada_asteptare().intValue()<valoare_minima)
			{valoare_minima=c.getPerioada_asteptare().intValue();
			index=sir_cozi.indexOf(c);
			}
		}
		
		int a=sir_cozi.get(index).adaugare(d);
		return a;
	}
	public int adaugare_clienti(ArrayList<Coada> sir_cozi, Client c)
	{
	int a=this.aflare_minim(sir_cozi,c); // aflam indexul cozii care are timpul de asteptare cel mai mic.
	return a;
	}

}
