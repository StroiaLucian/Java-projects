package polinoame;

import java.util.ArrayList;
public class Scadere {
	
	public Scadere() {
		super();
	}
	public Polinom sub(Polinom p1,Polinom p2){
	int i=0;
	int ok=0;
	int j=1;
	int k=0;
	Polinom rezultat=new Polinom();
	ArrayList<Monom>aux=new ArrayList<Monom>();
	for(Monom m1:p1.getSirDeMonoame())
		{aux.add(new Monom(m1.getCoeficientulMonomului(),m1.getGradulMonomului()));
		k++;}
	for(Monom m1:p2.getSirDeMonoame())
		{
		aux.add(new Monom(-m1.getCoeficientulMonomului(),m1.getGradulMonomului()));
		k++;}
	while(i<k-1){
		while(j<k){
			if(aux.get(i).getGradulMonomului()==aux.get(j).getGradulMonomului())
			{aux.get(i).setCoeficientulMonomului(aux.get(i).getCoeficientulMonomului()+aux.get(j).getCoeficientulMonomului());
				aux.get(j).setCoeficientulMonomului(0);
				aux.get(j).setGradulMonomului(0);}
			j++;}
		i++;
		j=i+1;}
	for(Monom m1:aux)
	{if(m1.getCoeficientulMonomului()==0 && m1.getGradulMonomului()==0)
			ok=1; // o chestie in plus
		else rezultat.getSirDeMonoame().add(m1);}
	return rezultat;}
	
	public boolean asemenea(Polinom a, Polinom b)
	{	int ok=0;
		for(Monom m1:a.getSirDeMonoame())
		{	for(Monom m2:b.getSirDeMonoame())
			{
				if (m1.getGradulMonomului()==m2.getGradulMonomului() && m1.getCoeficientulMonomului()==m2.getCoeficientulMonomului())
					{ok=1;
				break;}
			}
		ok=0;}
		if(ok==0) return true;
		else return false;
	}
}
