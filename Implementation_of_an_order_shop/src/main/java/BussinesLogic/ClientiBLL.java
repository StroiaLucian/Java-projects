package BussinesLogic;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.swing.table.DefaultTableModel;

import BussinesLogic.Validators.*;
import DatabaseAcces.*;
import Model.Clienti;

/**
 * @Author: Technical University of Cluj-Napoca, Romania Distributed Systems
 *          Research Laboratory, http://dsrl.coned.utcluj.ro/
 * @Since: Apr 03, 2017
 */
public class ClientiBLL {

	private ClientiDAO clientiDAO;

	public ClientiBLL() {
			clientiDAO = new ClientiDAO();
	}

	public Clienti findClientiById(int id) {
		Clienti c = clientiDAO.findById(id);
		return c;
	}
	
	
	
	public String insert(Clienti t)
	{
	EmailValidator e=new EmailValidator();
	PhoneValidator p=new PhoneValidator();
	String valori="";
	valori='"'+t.getNume()+'"'+","+'"'+t.getPrenume()+'"'+","+'"'+t.getMail()+'"'+","+'"'+t.getTelefon()+'"'+","+'"'+t.getAdresa()+'"';
	if(e.validate(t) && p.validate(t))
		{
		return clientiDAO.insert(valori);
		}
		else if(e.validate(t)==false) return "Email nu este valid!";
		else if(p.validate(t)==false) return "Nr telefon invalid!";
	return null;
	}
	public String update(Clienti t)
	{
		ExistaValidator ex=new ExistaValidator();
		ArrayList<String> valori=new ArrayList<String>();
		valori.add(t.getIdClienti()+"");
		valori.add(t.getNume());
		valori.add(t.getPrenume());
		valori.add(t.getMail());
		valori.add(t.getTelefon());
		valori.add(t.getAdresa());
		if(!ex.validate(t))
			return clientiDAO.update(valori, t.getIdClienti()+"");
		else return "Update invalid!";
	}
	public String delete(Clienti t)
	{
		ExistaValidator ex=new ExistaValidator();
		if(!ex.validate(t))
			return clientiDAO.delete(t.getIdClienti()+"");
		else return "Delete invalid!";
	}
	public List<Clienti> findall()
	{
		List<Clienti> aux=clientiDAO.findAll();
		return aux;
	}
	public DefaultTableModel creareTabel(List<Clienti> afisare) {	
	return clientiDAO.createTabel(afisare);
	}
}