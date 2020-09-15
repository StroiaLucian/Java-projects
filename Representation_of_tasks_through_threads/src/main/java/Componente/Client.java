package Componente;

public class Client implements Comparable {
	private int timp_ajungere;
	private int timp_terminare;
	private int timp_procesare;
	private char identificator;
	public Client(char identificator,int timp_ajungere, int timp_procesare) {
		this.identificator=identificator;
		this.timp_ajungere=timp_ajungere;
	this.timp_procesare=timp_procesare;
	}
	public int getTimp_terminare() {
		return timp_terminare;
	}
	
	public int getTimp_ajungere() {
		return timp_ajungere;
	}


	public void setTimp_ajungere(int timp_ajungere) {
		this.timp_ajungere = timp_ajungere;
	}


	public int getTimp_procesare() {
		return timp_procesare;
	}


	public void setTimp_procesare(int timp_procesare) {
		this.timp_procesare = timp_procesare;
	}


	public void setTimp_terminare(int waiting_period)
	{
		this.timp_terminare=timp_ajungere+timp_procesare+waiting_period;
	}
	public int compareTo(Object o) {
		Client c1=(Client) o;
		if(this.timp_ajungere>c1.getTimp_ajungere()) return 1;
		else if(this.timp_ajungere==c1.getTimp_ajungere()) return 0;
		else return -1;
		
	
	}
	@Override
	public String toString() {
		return "Client "+identificator+" are timpul de ajungere " + timp_ajungere + " timp de procesare "+timp_procesare;
	}
	
	public String afisare(int a)
	{	
		return "Clientul "+identificator+"~ ";
	}
	public char getNumar() {
		return identificator;
	}
	public void setNumar(char identificator) {
		this.identificator=identificator;
	}
	

}
 