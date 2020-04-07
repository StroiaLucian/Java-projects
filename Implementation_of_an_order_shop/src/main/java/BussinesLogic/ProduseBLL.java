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

public class ProduseBLL {
	private List<Validators<Produse>> validators;
	
	private ProduseDAO produseDAO;

	public ProduseBLL() {
		validators = new ArrayList<Validators<Produse>>();
		validators.add(new CantitatePRValidator());
		validators.add(new ExistaPRValidator());

		produseDAO = new ProduseDAO();
	}

	public Produse findProduseById(int id) {
		Produse p = produseDAO.findById(id);
		return p;
	}	
	
	public List<Produse> findall()
	{
		List<Produse> aux=produseDAO.findAll();
		return aux;
	}
	public String insert(Produse t)
	{
	CantitatePRValidator c=new CantitatePRValidator();
	String valori="";
	valori='"'+t.getNume()+'"'+","+t.getCantitate();
	if(c.validate(t))
	{	
		return produseDAO.insert(valori);	
	}
	else if(c.validate(t)==false) return "Cantitatea introdusa nu este valida!";
	return null;
	}
	public String delete(Produse t)
	{
		ExistaPRValidator ex=new ExistaPRValidator();
		if(!ex.validate(t))
			return produseDAO.delete(t.getIdproduse()+"");
		else return "Delete invalid!";
	}
	public String update(Produse t)
	{
		ExistaPRValidator ex=new ExistaPRValidator();
		ArrayList<String> valori=new ArrayList<String>();
		valori.add(t.getIdproduse()+"");
		valori.add(t.getNume());
		valori.add(t.getCantitate()+"");
		if(!ex.validate(t))
			return produseDAO.update(valori, t.getIdproduse()+"");
		else return "Update invalid!";
	}
	public DefaultTableModel creareTabel(List<Produse> afisare) {	
	return produseDAO.createTabel(afisare);
	}
}
