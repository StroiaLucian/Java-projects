package interfata;
import java.util.ArrayList;
import java.util.Collections;

import polinoame.*;
public class Tema1Model {
	private String rezultat="";
	public void adunarePolinoame(String p1, String p2) throws Exception
	{	String auxiliar="";
		Adunare a1=new Adunare();
		int i=0;
		Polinom polinom1=new Polinom(p1);
		polinom1.sectionarePolinom();
		System.out.println(polinom1);
		Polinom polinom2=new Polinom(p2);
		polinom2.sectionarePolinom();
		System.out.println(polinom2);
		Polinom rezultatul= new Polinom();
		rezultatul=a1.add(polinom1, polinom2);
		auxiliar=rezultatul.toString();	
		if(auxiliar.equalsIgnoreCase(""))
			this.rezultat="0";
		else
		{char b=auxiliar.charAt(0);
			if(auxiliar.charAt(0)=='+')
		{
			i++;
			this.rezultat+=' ';
			 	while(i<auxiliar.length())
				{ b=auxiliar.charAt(i);	
				this.rezultat+=b;
				i++;
				}
		}
		else
			for(char c: auxiliar.toCharArray())
			{
				this.rezultat+=c;
			}
		}
		
	}
	public void scaderePolinoame(String p1, String p2) throws Exception
	{	String auxiliar="";
		int i=0;
		Scadere s1=new Scadere();
		Polinom polinom1=new Polinom(p1);
		polinom1.sectionarePolinom();
		Polinom polinom2=new Polinom(p2);
		polinom2.sectionarePolinom();
		Polinom rezultatul= new Polinom();
		if(s1.asemenea(polinom2, polinom1))
		{rezultatul=s1.sub(polinom1, polinom2);
		auxiliar=rezultatul.toString();		
		char b=auxiliar.charAt(0);
		if(auxiliar.charAt(0)=='+')
		{	i++;
			this.rezultat+=' ';
			 	while(i<auxiliar.length())
				{ b=auxiliar.charAt(i);	
				this.rezultat+=b;
				i++;}}
		else for(char c: auxiliar.toCharArray())
			this.rezultat+=c;
		}
		else this.rezultat="0";
	}
	public void inmultirePolinoame(String p1, String p2) throws Exception
	{
		Polinom polinom1=new Polinom(p1);
		polinom1.sectionarePolinom();
		Polinom polinom2=new Polinom(p2);
		polinom2.sectionarePolinom();
		Inmultire i1=new Inmultire();
		Polinom rez=i1.mul(polinom1,polinom2);
		this.rezultat=rez.toString();
	}
	public void impartirePolinoame(String p1, String p2) throws Exception
	{
		Impartire imp1=new Impartire();
		Polinom polinom1=new Polinom(p1);
		polinom1.sectionarePolinom();
		Polinom polinom2=new Polinom(p2);
		polinom2.sectionarePolinom();
		Polinom rez=imp1.imp(polinom1, polinom2);
		//this.rezultat=rez.toString();
		this.rezultat="In curs de dezvoltare";
	}
	public void integrarePolinoame(String p1) throws Exception
	{	String auxiliar="";
		int i=0;
		Polinom polinom1=new Polinom(p1);
		polinom1.sectionarePolinom();
		Integrare int1=new Integrare();
		auxiliar=int1.inte(polinom1);		
		char b=auxiliar.charAt(0);
		if(auxiliar.charAt(0)=='+')
		{	i++;
			this.rezultat+=' ';
			 	while(i<auxiliar.length())
				{ b=auxiliar.charAt(i);	
				this.rezultat+=b;
				i++;}}
		else for(char c: auxiliar.toCharArray())
			this.rezultat+=c;
	}
	public void derivarePolinoame(String p1) throws Exception
	{	String auxiliar="";
		int i=0;
		Polinom polinom1=new Polinom(p1);
		polinom1.sectionarePolinom();
		Derivare d1=new Derivare();
		Polinom rezultatul=new Polinom();
		rezultatul=d1.der(polinom1);
		auxiliar=rezultatul.toString();		
		char b=auxiliar.charAt(0);
		if(auxiliar.charAt(0)=='+')
		{	i++;
			this.rezultat+=' ';
			 	while(i<auxiliar.length())
				{ b=auxiliar.charAt(i);	
				this.rezultat+=b;
				i++;}}
		else for(char c: auxiliar.toCharArray())
			this.rezultat+=c;
		}
	public String getRezultat() {
		return rezultat;
	}
	public void setRezultat(String rezultat) {
		this.rezultat = rezultat;
	}
	
}

