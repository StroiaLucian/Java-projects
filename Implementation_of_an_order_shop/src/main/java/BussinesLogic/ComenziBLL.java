package BussinesLogic;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.swing.table.DefaultTableModel;

import BussinesLogic.Validators.*;
import DatabaseAcces.*;
import Model.Clienti;
import Model.Comenzi;
import Model.Produse;

/**
 * @Author: Technical University of Cluj-Napoca, Romania Distributed Systems
 *          Research Laboratory, http://dsrl.coned.utcluj.ro/
 * @Since: Apr 03, 2017
 */
public class ComenziBLL {

	private ComenziDAO comenziDAO;

	public ComenziBLL() {
		comenziDAO = new ComenziDAO();
	}

	public Comenzi findComenziById(int id) {
		
		Comenzi c = comenziDAO.findById(id);
		if (c == null) {
			throw new NoSuchElementException("The order with id =" + id + " was not found!");
		}
		return c;
	}

	public List<Comenzi> findall()
	{
		List<Comenzi> aux=comenziDAO.findAll();
		return aux;
	}
	public String insert(Comenzi t)
	{
	String valori="";
	valori='"'+t.getCumparator()+'"';
	
		return comenziDAO.insert(valori);
		
	}
	public DefaultTableModel creareTabel(List<Comenzi> afisare) {
		
	return comenziDAO.createTabel(afisare);
	}

}
