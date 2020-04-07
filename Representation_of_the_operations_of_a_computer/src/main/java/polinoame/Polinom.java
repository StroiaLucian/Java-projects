package polinoame;
import java.util.ArrayList;
import java.util.Collection;
 public class Polinom {
	private ArrayList<Monom> sirDeMonoame=new ArrayList<Monom>();;
	private String sirulCareTrebuieTransformat;
	private ArrayList<String> sirulDeSiruri;
	private int numarposibil;
	public Polinom(String a)
	{
		sirulCareTrebuieTransformat=a;
	}
	public Polinom() {
	}
	public Polinom(ArrayList<Monom> rezultat) {
		sirDeMonoame=rezultat;// TODO Auto-generated constructor stub
	}
	public int aflareCoeficient(String sir)throws Exception
	{	
		int a=0;
		int ok=0;
		char c=sir.charAt(0);
		if(sir.charAt(0)=='+' && sir.charAt(1)=='x')
		{
			a=1;
			return a;
		}
		if(sir.charAt(0)=='-' && sir.charAt(1)=='x')
		{
			a=-1;
			return a;
		}
		if(c=='x')
		{
			a=1;
			return a;
		}else
		{
		if(c=='-' && sir.charAt(1)=='x')
			return -1;
		for(char b: sir.toCharArray())
		 {
		if(b!='x' && b!='*') 
		{
		if(b>47 && b<58)
		{
		a=a*10;
		a+=b-'0';
		}else if(b=='-')
		ok=1;
		else if(b=='+')
		{
			ok=0;
		}
		else throw new Exception ("coeficientul primului monom nu este un numar intreg!");
		}else break;
		}
		if(ok==1)
		return -a;
		else return a;
		}
		
	}
	
	public int aflareGrad(String sir)
	{	
		int a=0;
		char c='0';
		int i=1;
		int k=0;
		int ok=0;
		if(sir.indexOf('x',0)==-1)
		{
			return a;
		}else
		if(sir.indexOf('^', 0)==-1)
		{a=1;
			return a;
		}
		else
			{
			c=sir.charAt(sir.indexOf('^')+i);
			while(c>47 && c<58)
			{	
				a*=10;
				a+=c-'0';
				k++;
				if(sir.length()-sir.indexOf('^', 0)-1>k)
				c=sir.charAt(sir.indexOf('^')+(++i));
				else break;
			}
			return a;
			}
		}
	public void taiere(int deUnde,char caracterul, String aux) {
		while(deUnde<this.sirulCareTrebuieTransformat.length())
		{
			if(caracterul!='+' && caracterul!='-')
			{
				aux+=caracterul;
			}
			else
			{
				sirulDeSiruri.add(aux);
				aux="";
				aux+=caracterul;
			}
			caracterul=this.sirulCareTrebuieTransformat.charAt(deUnde);
			deUnde++;
			if(deUnde==this.sirulCareTrebuieTransformat.length())
			{	aux+=caracterul;
				sirulDeSiruri.add(aux);
			}
		}
		
	}
	
	public ArrayList<String> transformare() throws Exception
	{	String aux="";
		int ok=0;
		if(this.getSirulCareTrebuieTransformat().charAt(0)!='-' && this.getSirulCareTrebuieTransformat().charAt(0)!='+')
			{numarposibil++;
			ok=1;
			} // acest if este pentru a determina daca pe prima pozitie nu se afla - sau +, inseamna ca e urmeaza practic primul monom care are coeficient pozitiv. ex: 23x;
		
		
		for(char fin:this.sirulCareTrebuieTransformat.toCharArray())
		{	
			if(ok==1)// daca primul monom e de forma descrisa mai sus, ex 23x 
			{
				ok=0;// aici facem practic un sal peste primul element
			}else
			if(fin=='+' || fin=='-')
				numarposibil++;
		}
		sirulDeSiruri= new ArrayList<String>(numarposibil); // este alocat cu cate monoame o sa existe in polinomul nostru
		if(this.sirulCareTrebuieTransformat.charAt(0)=='-') // daca primul sir caracter citit este -
		{
		aux+=this.sirulCareTrebuieTransformat.charAt(0);// in aux avem salvat -
		char b=this.sirulCareTrebuieTransformat.charAt(1);
		int j=2;
		this.taiere(j, b, aux);
		}// daca primul caracter citit nu este -!!!
		else
		{	char d=this.sirulCareTrebuieTransformat.charAt(0);
			int k=1;
			aux="";
			this.taiere(k, d, aux);
		}
		return sirulDeSiruri;
	}
	
	public void sectionarePolinom() throws Exception
	{	ArrayList<String> siru=this.transformare();
		ArrayList<Monom> auxiliar=new ArrayList<Monom>();
		ArrayList<Monom> rezultat=new ArrayList<Monom>();		
		int ok=0;
		for(String a: siru)// cu acest for, pe baza sirului de Stringuri micute, formam monoamele prin aflarea coefiecientului si a gradului.
		{
		Monom Monom1=new Monom(this.aflareCoeficient(a),this.aflareGrad(a));
		for(Monom m1:sirDeMonoame)
		{
			if(Monom1.getGradulMonomului()==m1.getGradulMonomului())
			{
				m1.setCoeficientulMonomului(m1.getCoeficientulMonomului()+Monom1.getCoeficientulMonomului());
				ok=1;
			}
		}
		if(ok==0)
			sirDeMonoame.add(Monom1);
		ok=0;
		}
	}
	
	public String toString() 
	{	String auxiliar="";
		for(Monom m1:this.sirDeMonoame)
			auxiliar+=m1.toString();
	return auxiliar;
	}
	public ArrayList<Monom> getSirDeMonoame() {
		return sirDeMonoame;
	}
	
	public String getSirulCareTrebuieTransformat() {
		return sirulCareTrebuieTransformat;
	}
	public int getNumarposibil() {
		return numarposibil;
	}
	public void setNumarposibil(int numarposibil) {
		this.numarposibil = numarposibil;
	}
	public ArrayList<String> getSirulDeSiruri() {
		return sirulDeSiruri;
	}
	public void setSirulDeSiruri(ArrayList<String> sirulDeSiruri) {
		this.sirulDeSiruri = sirulDeSiruri;
	}
}
