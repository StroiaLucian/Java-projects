package polinoame;

public class Monom implements Comparable{
	private int coeficientulMonomului;
	private int gradulMonomului;
	
	public Monom(int coeficientulMonomului, int gradulMonomului) {
		this.coeficientulMonomului = coeficientulMonomului;
		this.gradulMonomului = gradulMonomului;
	}
	public int getCoeficientulMonomului() {
		return coeficientulMonomului;
	}
	public void setCoeficientulMonomului(int coeficientulMonomului) {
		this.coeficientulMonomului = coeficientulMonomului;
	}
	public int getGradulMonomului() {
		return gradulMonomului;
	}
	public void setGradulMonomului(int gradulMonomului) {
		this.gradulMonomului = gradulMonomului;
	}
	public String toString() {
		if(this.coeficientulMonomului==1&& this.gradulMonomului==1) return"+"+"x";
		else if(this.coeficientulMonomului==-1&& this.gradulMonomului==1) return"-"+"x";
		else if(this.coeficientulMonomului==1&& this.gradulMonomului<0) return"+1";
		else if(this.coeficientulMonomului==-1&& this.gradulMonomului<0) return"-1";
		else if(this.coeficientulMonomului==1&& this.gradulMonomului!=0) return"+"+"x^"+this.gradulMonomului;
		else if(this.coeficientulMonomului==-1&& this.gradulMonomului!=0) return"-"+"x^"+this.gradulMonomului;
		else if(this.coeficientulMonomului<0 && this.gradulMonomului==1) return this.coeficientulMonomului+"x";
		else if(this.coeficientulMonomului>0 && this.gradulMonomului==1) return "+"+this.coeficientulMonomului+"x";
		else if(this.coeficientulMonomului>0 && this.gradulMonomului!=0)return "+"+this.coeficientulMonomului+"x^"+this.gradulMonomului;
		else if(this.coeficientulMonomului<0 && this.gradulMonomului!=0) return this.coeficientulMonomului+"x^"+this.gradulMonomului;
		else if(this.coeficientulMonomului>0 && this.gradulMonomului==0) return "+"+this.coeficientulMonomului;
		else if(this.coeficientulMonomului<0 && this.gradulMonomului==0) return this.coeficientulMonomului+"";
		else if(this.coeficientulMonomului==0 && this.gradulMonomului==0) return "";
		else return "Eroare"; 
	}
	public int compareTo(Object a) {
		Monom aux=(Monom) a;
		if(this.gradulMonomului>aux.gradulMonomului ) return -1;
		else if(this.gradulMonomului==aux.gradulMonomului ) return 0;
		else return 1;
	}
	
	
}
