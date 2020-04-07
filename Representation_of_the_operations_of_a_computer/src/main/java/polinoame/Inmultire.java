package polinoame;

import java.util.ArrayList;

public class Inmultire {
	public Inmultire()
	{
		super();
	}
	
	public Polinom mul(Polinom polinom1,Polinom polinom2) throws Exception
	{ArrayList<Monom> rezultat=new ArrayList<Monom>();
	for(Monom m1: polinom1.getSirDeMonoame())
		for(Monom m2:polinom2.getSirDeMonoame())
		{
			if(m2.getGradulMonomului()==0 && m1.getGradulMonomului()==0) rezultat.add(new Monom(m1.getCoeficientulMonomului()*m2.getCoeficientulMonomului(),0));
			else if(m1.getGradulMonomului()==0 && m2.getGradulMonomului()!=0) rezultat.add(new Monom(m1.getCoeficientulMonomului()*m2.getCoeficientulMonomului(),m2.getGradulMonomului()));
			else if(m2.getGradulMonomului()==0 && m1.getGradulMonomului()!=0) rezultat.add(new Monom(m1.getCoeficientulMonomului()*m2.getCoeficientulMonomului(),m1.getGradulMonomului()));
			else rezultat.add(new Monom(m1.getCoeficientulMonomului()*m2.getCoeficientulMonomului(),m1.getGradulMonomului()+m2.getGradulMonomului()));
		}
	Polinom rezultatul_bun=new Polinom(rezultat);
	return rezultatul_bun;
	}
}
