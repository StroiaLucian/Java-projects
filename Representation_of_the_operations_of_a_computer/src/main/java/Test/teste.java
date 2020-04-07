package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import polinoame.Adunare;
import polinoame.Derivare;
import polinoame.Inmultire;
import polinoame.Integrare;
import polinoame.Polinom;
import polinoame.Scadere;

public class teste {
	String RezultatADD="3x^3+8x^2+5x+95";
	String RezultatSUB="-x^3+5x-16x^2+105";
	String RezultatINM="2x^5+10x^4-25x+60x^3-8x^5+20x^2-48x^4+200x^3-500+1200x^2";
	String RezultatDER="+3x^2+5-8x";
	String RezultatINT="+(1/4)*x^4+(5/2)*x^2-(-4/3)*x^3+(100/1)*x^1";
	Polinom p1=new Polinom("x^3+5x-4x^2+100");
	Polinom p2=new Polinom("2x^3+5+12x^2-10");
	@Test
	public void AdunareTest() throws Exception{
		try{p1.sectionarePolinom();
		p2.sectionarePolinom();
		Adunare a1=new Adunare();
		Polinom rezultatul=a1.add(p1, p2);
		rezultatul.sectionarePolinom();
		assertEquals(RezultatADD, rezultatul.toString());
		}catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	@Test
	public void ScadereTest() throws Exception{
		try{p1.sectionarePolinom();
		p2.sectionarePolinom();
		Scadere s1=new Scadere();
		Polinom rezultatul=s1.sub(p1, p2);
		rezultatul.sectionarePolinom();
		assertEquals(RezultatSUB, rezultatul.toString());
		}catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	@Test
	public void InmultireTest() throws Exception{
		try{p1.sectionarePolinom();
		p2.sectionarePolinom();
		Inmultire i1=new Inmultire();
		Polinom rezultatul=i1.mul(p1, p2);
		rezultatul.sectionarePolinom();
		assertEquals(RezultatINM, rezultatul.toString());
		}catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	@Test
	public void DerivareTest() throws Exception{
		try{
		p1.sectionarePolinom();
		Derivare d1=new Derivare();
		Polinom rezultatul=d1.der(p1);
		assertEquals(RezultatDER, rezultatul.toString());
		}catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	@Test
	public void IntegrareTest() throws Exception{
		try{
		p1.sectionarePolinom();
		Integrare i1=new Integrare();
		String rezultatul=i1.inte(p1);
		System.out.println(rezultatul);
		System.out.println(RezultatINT);
		assertEquals(RezultatINT, rezultatul);
		}catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}
