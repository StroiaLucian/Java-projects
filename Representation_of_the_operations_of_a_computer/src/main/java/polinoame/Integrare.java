package polinoame;

import java.util.ArrayList;

public class Integrare {
	public Integrare()
	{
		super();
	}
	public String inte(Polinom polinom1)
	{		
		ArrayList<String> supra=new ArrayList<String>();
		for(Monom m1:polinom1.getSirDeMonoame())
	{	int a=m1.getGradulMonomului()+1;
		supra.add(m1.getCoeficientulMonomului()+"/"+a);
		m1.setGradulMonomului(m1.getGradulMonomului()+1);
		
	}
	String rezultat="";
	int k=0;
	for(Monom m2: polinom1.getSirDeMonoame())
	{	
		if(m2.getCoeficientulMonomului()<0)
		rezultat+="-"+"("+supra.get(k)+")*x^"+m2.getGradulMonomului();
	else if(m2.getCoeficientulMonomului()==0)
		rezultat+="";
	else if(m2.getCoeficientulMonomului()>0)
		rezultat+="+"+"("+supra.get(k)+")*x^"+m2.getGradulMonomului();
		k++;
	}
	return rezultat;
	}
}
