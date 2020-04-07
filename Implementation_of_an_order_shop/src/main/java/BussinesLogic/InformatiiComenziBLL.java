package BussinesLogic;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.swing.table.DefaultTableModel;

import BussinesLogic.Validators.*;
import DatabaseAcces.*;
import Model.Clienti;
import Model.informatiicomenzi;
import Model.Produse;

/**
 * @Author: Technical University of Cluj-Napoca, Romania Distributed Systems
 *          Research Laboratory, http://dsrl.coned.utcluj.ro/
 * @Since: Apr 03, 2017
 */
public class InformatiiComenziBLL {

	private InformatiiComenziDAO informatiiComenziDAO;

	public InformatiiComenziBLL() {
		informatiiComenziDAO = new InformatiiComenziDAO();
	}

	public informatiicomenzi findInfoById(int id) {
		
		informatiicomenzi c = informatiiComenziDAO.findById(id);
		return c;
	}

	public List<informatiicomenzi> findall()
	{
		List<informatiicomenzi> aux=informatiiComenziDAO.findAll();
		return aux;
	}
	public String insert(informatiicomenzi t)
	{
	String valori="";
	valori=t.getIdCumparator()+","+'"'+t.getProdus()+'"'+','+t.getCantitate();
		return informatiiComenziDAO.insert(valori);

	}
	public DefaultTableModel creareTabel(List<informatiicomenzi> afisare) {
	return informatiiComenziDAO.createTabel(afisare);
	}

}
