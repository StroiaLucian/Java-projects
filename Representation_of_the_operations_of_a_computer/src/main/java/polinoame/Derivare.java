package polinoame;

public class Derivare {
	public Derivare()
	{
		super();
	}
	public Polinom der(Polinom polinom1)
	{	
		for(Monom m1:polinom1.getSirDeMonoame())
	{
		if(m1.getGradulMonomului()==0)
		m1.setCoeficientulMonomului(0);
		
		else{m1.setCoeficientulMonomului(m1.getCoeficientulMonomului()*m1.getGradulMonomului());
		int a=m1.getGradulMonomului();
		m1.setGradulMonomului(--a);
		}
	}
		return polinom1;
		
	}
}
