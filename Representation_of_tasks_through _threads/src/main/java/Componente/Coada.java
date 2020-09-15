package Componente;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

import Interfata.SimulationFrame;
import Interfata.View;
public class Coada implements Runnable {
private ArrayBlockingQueue<Client> clienti;
private AtomicInteger perioada_asteptare=new AtomicInteger();
private int nr_clienti;
private int numar;
private View vedere;
private SimulationFrame vedere2;
private float Suma=0;
public Coada(int nr_clienti,int numar,View vedere,SimulationFrame vedere2)
{	this.vedere2=vedere2;
	this.vedere=vedere;
	this.nr_clienti=nr_clienti;
	perioada_asteptare.set(0);
	this.numar=numar;
	clienti=new ArrayBlockingQueue<Client>(nr_clienti);
}
public Coada() {
	// TODO Auto-generated constructor stub
}
public void run() {
	// TODO Auto-generated method stub
	
	while(true)
	{
		try {
		Client c=clienti.take();//luam urmatorul client pentru executies
		Thread.sleep(c.getTimp_procesare()*1000);//oprim threadul pentru un timp egal cu timpul de procesare al clientului
		Suma=(Suma+perioada_asteptare.intValue());
		float b=Suma/nr_clienti;
		String rezultat=String.format("%.2f", b);
		vedere2.setTimpul_Mediu(rezultat);
		this.perioada_asteptare.set(this.perioada_asteptare.intValue()-c.getTimp_procesare());//decrementam perioada de asteptare
		
		vedere2.setInformatii(vedere2.getInformatii()+"\n"+"!Clientul "+c.getNumar()+" a fost scos din coada"+this.numar+", avand timpul de terminare "+c.getTimp_terminare());
		if(numar==1)
		{	String s=vedere2.getCoada1().substring(12);
			vedere2.setCoada1(s);
		}
		if(numar==2)
		{	String s=vedere2.getCoada2().substring(12);
			vedere2.setCoada2(s);
		}
		if(numar==3)
		{	String s=vedere2.getCoada3().substring(12);
			vedere2.setCoada3(s);
		}
		if(numar==4)
		{	String s=vedere2.getCoada4().substring(12);
			vedere2.setCoada4(s);
		}
		if(numar==5)
		{	String s=vedere2.getCoada5().substring(12);
			vedere2.setCoada5(s);
		}
		if(numar==6)
		{	String s=vedere2.getCoada6().substring(12);
			vedere2.setCoada6(s);
		}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		}
}
public int adaugare(Client c)
{	c.setTimp_terminare(perioada_asteptare.intValue()); // setam timpul de terminare al clientului respectiv.
	clienti.add(c);
	this.setPerioada_asteptare(c.getTimp_procesare());// setam perioada de asteptare pentru urmatorul client.
	
	return this.numar;
}
public void setNr_clienti(int nr)
{
	this.nr_clienti=nr;
}

public AtomicInteger getPerioada_asteptare() {
	return perioada_asteptare;
}
public void setPerioada_asteptare(int perioada_asteptare) {
	this.perioada_asteptare.addAndGet(perioada_asteptare);
}
public BlockingQueue<Client> getClienti() {
	return clienti;
}
public void setClienti(ArrayBlockingQueue<Client> clienti) {
	this.clienti = clienti;
}
public int getNumar() {
	return numar;
}
public void setNumar(int numar) {
	this.numar = numar;
}
@Override
public String toString() {
	return "Coada cu numarul "+numar+" [clienti=" + clienti + "]";
}

}
