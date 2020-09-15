package Models;

import java.util.ArrayList;

public class StatisticaBuillder {

	public Statistica creareStatistica(ArrayList<Animal> animale, String dupaCe) {
		Statistica s= new Statistica();
		for(Animal a:animale)
			s.AdaugareAnimale(a);
		s.setDupaCe(dupaCe);
		return s;
	}
}
