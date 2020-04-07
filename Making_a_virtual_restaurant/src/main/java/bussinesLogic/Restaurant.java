package bussinesLogic;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import javax.swing.table.DefaultTableModel;
import dataAcces.FileWriterClass;
import dataAcces.RestaurantSerializator;
import gui.Administrator;
import gui.Chef;
import gui.CompositeProductsIngredients;
import gui.Start;
import gui.Table;
import gui.Waiter;
public class Restaurant extends Observable implements IRestaurantProcessing {
	private ArrayList<MenuItem> listOfProducts=new ArrayList<MenuItem>();
	private Order o1=null;
	private ArrayList<MenuItem> listOfProductsPerOrder;
	private HashMap<Order, ArrayList<MenuItem>> map=new HashMap<Order, ArrayList<MenuItem>>();
	private Start f1;
	private Administrator a1;
	private Chef c1;
	private Waiter w1;
	private CompositeProductsIngredients co1;
	private int ok=0;
	private int ok3=0;
	private CompositeProduct m1=null;			
	private Table t;
	private int price=0;
	private String aux_2=new String();
	private RestaurantSerializator r_aux;
	public Restaurant() 
	{f1=new Start();
	f1.addListenerWaiter(new listenerWaiter());
	f1.addListenerAdministrator(new listenerAdministrator());
	f1.addListenerChef(new listenerChef());
	c1=new Chef();
	c1.getFrame().setVisible(false);
	r_aux=new RestaurantSerializator();
	listOfProducts=r_aux.deserialization();
	listOfProductsPerOrder=new ArrayList<MenuItem>();
	}	
class listenerWaiter implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		try {
			Restaurant.this.addObserver(c1);
			ArrayList<String> meniu=new ArrayList<String>();
			for(MenuItem m:listOfProducts)
			{	if(m instanceof BaseProduct)
				meniu.add(m.getName());
			else if(m instanceof CompositeProduct) {
				StringBuilder aux=new StringBuilder();
				for(MenuItem m1:((CompositeProduct) m).getListOfIngredients())
				{
					aux.append(m1.getName()+",");
				}
				meniu.add(m.getName()+"-"+aux);
			}
			}
			w1=new Waiter(meniu);
			w1.addListenerBWaiter(new listenerBWaiter());			
			w1.addListenerAdd(new listenerAdd());
			w1.addListenerBill(new listenerBill());
			w1.addListenerComputePrice(new listenerComputePrice());
			w1.addListenerFinish(new listenerFinish());
			w1.addListenerVizualizare(new listenerVizualizare());
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
class listenerAdd implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		try {
			if(w1.getTxtId2().isEmpty() || w1.getTxtdata2().isEmpty() || w1.getTxtMasa2().isEmpty())
			{
				w1.setTxtAnsw2("Completati campurile!");
			}else {if(ok3==1)
			{	
				price=0;
				listOfProductsPerOrder=new ArrayList<MenuItem>();
				ok3=0;	
			}
			w1.setTxtAnsw2("Obiect adaugat cu succes!");
			
		createItemsForOrder();	
		}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
class listenerBill implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		try {
			if(o1==null && listOfProductsPerOrder.size()==0)
			{
				w1.setTxtAnsw2("Please enter an order!");
			}
			generateBill();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
class listenerComputePrice implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		try {
		//computePriceForOrder();
			if(listOfProductsPerOrder.size()==0)
			{
				w1.setTxtAnsw2("Empty order!");
			}
			else w1.setTxtAnsw2("TOTAL:"+price+" lei");

		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
class listenerFinish implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		try {
		if(w1.getTxtId2().isEmpty() || w1.getTxtdata2().isEmpty() || w1.getTxtMasa2().isEmpty())
		{
			w1.setTxtAnsw2("Completati campurile!");
		}else {	
		w1.setTxtAnsw2("SUCCES!");
		createNewOrder();
		computePriceForOrder();	
		map.put(o1, listOfProductsPerOrder);
		setChanged();
		notifyObservers();
		w1.setTxtAnsw2("");
		ok3=1;
		}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
class listenerVizualizare implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		try {
			t=new Table();
			t.addListenerTAB(new listenerTAB());
			t.getTable().setModel(creareTabelOrders(map));
		    t.construireTabel();
			t.getResultFrame().setVisible(true);
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
class listenerChef implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		try {
			c1.getFrame().setVisible(true);
			c1.addListenerBChef(new listenerBChef());
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
class listenerAdministrator implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		try {
			a1=new Administrator();
			co1=new CompositeProductsIngredients();
			co1.addListenerSfarsit(new listenerSfarsit());
			a1.addListenerBAdministrator(new listenerBAdministrator());
			a1.addListenerInsert(new listenerInsert());
			a1.addListenerUpdate(new listenerUpdate());
			a1.addListenerDelete(new listenerDelete());
			a1.addListenerView(new listenerView());
			co1.getFrame().setVisible(false);
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
class listenerInsert implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		try {
		if(a1.getBtnCheck1().isSelected()&&a1.getBtnCheck2().isSelected())
		{
			System.out.println("Alegeti doar o singura optiune!");
		}
		if(!a1.getBtnCheck1().isSelected()&&!a1.getBtnCheck2().isSelected())
		{
			System.out.println("Alegeti o optiune!");
		}
		else if(a1.getBtnCheck1().isSelected()&& !a1.getBtnCheck2().isSelected())
		{						
		assert  !a1.getTxtId2().isEmpty() : "Id null";  
		assert  !a1.getTxtName2().isEmpty() : "Name null";
		assert  !a1.getTxtPrice2().isEmpty() : "Price null";
			if(cauta(Integer.parseInt(a1.getTxtId2())))
			{
			a1.setTxtAlert("Id existent!");	
			}else
			{addProducts(new BaseProduct(Integer.parseInt(a1.getTxtId2()),Integer.parseInt(a1.getTxtPrice2()),a1.getTxtName2()));
		assert listOfProducts.size()<listOfProducts.size()+1:" Inserarea esuata!";
			}
			}
		else if(a1.getBtnCheck2().isSelected()&& !a1.getBtnCheck1().isSelected())
		{	
			co1.getFrame().setVisible(true);
			if(ok==0)
			{   
				
				assert  !a1.getTxtId2().isEmpty() : "Id null";  
				assert  !a1.getTxtName2().isEmpty() : "Name null";
				if(cauta(Integer.parseInt(a1.getTxtId2())))
				{
				a1.setTxtAlert("Id existent!");	
				}else
				m1=new CompositeProduct(Integer.parseInt(a1.getTxtId2()),0,a1.getTxtName2());
				ok=1;
			}
			else {
				
				if(co1.getBtnSfarsitB().isSelected()==true && !co1.getBtnSfarsitC().isSelected())
				{
					assert !a1.getTxtId2().isEmpty() : "Id null";  
					assert !a1.getTxtName2().isEmpty() : "Name null";
					assert !a1.getTxtPrice2().isEmpty() : "Price null";
					m1.getListOfIngredients().add(new BaseProduct(Integer.parseInt(a1.getTxtId2()),Integer.parseInt(a1.getTxtPrice2()),a1.getTxtName2()));
					if(!cauta(Integer.parseInt(a1.getTxtId2())))
					{		listOfProducts.add(new BaseProduct(Integer.parseInt(a1.getTxtId2()),Integer.parseInt(a1.getTxtPrice2()),a1.getTxtName2()));
				assert listOfProducts.size()<listOfProducts.size()+1:" Inserarea esuata!";
					}
					}else if(co1.getBtnSfarsitC().isSelected() && !co1.getBtnSfarsitB().isSelected())
				{
					assert  !a1.getTxtId2().isEmpty() : "Id null";  
					assert  !a1.getTxtName2().isEmpty() : "Name null";
					assert  !a1.getTxtPrice2().isEmpty() : "Price null";
					m1.getListOfIngredients().add(new CompositeProduct(Integer.parseInt(a1.getTxtId2()),Integer.parseInt(a1.getTxtPrice2()),a1.getTxtName2()));
					if(!cauta(Integer.parseInt(a1.getTxtId2())))
					{listOfProducts.add(new CompositeProduct(Integer.parseInt(a1.getTxtId2()),Integer.parseInt(a1.getTxtPrice2()),a1.getTxtName2()));
					assert listOfProducts.size()<listOfProducts.size()+1:" Inserarea esuata!";
					}
					}
				if(!co1.getBtnSfarsitB().isSelected()&&!co1.getBtnSfarsitC().isSelected())
				{
					System.out.println("Alegeti un tip de produs!");
				}
				if(co1.getBtnSfarsitB().isSelected()&&co1.getBtnSfarsitC().isSelected())
				{
					System.out.println("Alegeti doar un tip de produs!");
				}
			}
			
		}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
class listenerSfarsit implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		try {
		ok=0;
		co1.getFrame().setVisible(false);
		m1.computePrice();
		addProducts(m1); 
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
class listenerUpdate implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		try {
			if(a1.getTxtId2().isEmpty() || a1.getTxtName2().isEmpty() || a1.getTxtPrice2().isEmpty())
			{	
			a1.setTxtAlert("Completati campurile!");
			}else
			{
				a1.setTxtAlert("Update cu succes!");			
		uppdateProducts();
			}
			}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
class listenerDelete implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		try {
			if(a1.getTxtId2().isEmpty() || a1.getTxtName2().isEmpty() || a1.getTxtPrice2().isEmpty())
			{	
			a1.setTxtAlert("Completati campurile!");
			}
			else {
				a1.setTxtAlert("Delete cu succes!");		
				deleteProducts();
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
class listenerView implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		try {
			t=new Table();
			t.addListenerTAB(new listenerTAB());
			t.getTable().setModel(creareTabelProduse(listOfProducts));
		    t.construireTabel();
			t.getResultFrame().setVisible(true);
			}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
class listenerTAB implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		try {
			t.getResultFrame().dispose();
			}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
class listenerBWaiter implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		try {
			w1.getFrame().dispose();
			}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
class listenerBAdministrator implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		try {
			a1.getFrame().dispose();
			r_aux.serialization(listOfProducts);
			}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
class listenerBChef implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		try {
			c1.getFrame().dispose();
			}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
public void addProducts(MenuItem m1)
	{
	listOfProducts.add(m1);
	}
public void uppdateProducts()
{
	int id_auxiliar=Integer.parseInt(a1.getTxtId2());		
	for(MenuItem m1:listOfProducts)
	{
			
		if(m1.getId()==id_auxiliar)
		{
			m1.setName(a1.getTxtName2());
			m1.setPrice(Integer.parseInt(a1.getTxtPrice2()));
			break;
		}	
	}
	
}
public void deleteProducts()
{
	int id_auxiliar=Integer.parseInt(a1.getTxtId2());		
	MenuItem m_aux=null;
	for(MenuItem m1:listOfProducts)
	{
			
		if(m1.getId()==id_auxiliar)
		{
			m_aux=m1;
			break;
		}	
	}
	listOfProducts.remove(m_aux);

}
public DefaultTableModel creareTabelOrders(HashMap<Order, ArrayList<MenuItem>> m)
{	
	String[] primaColoana = new String[4] ;
	primaColoana[0]="ID";
	primaColoana[1]="TABLE";
	primaColoana[2]="DATE";
	primaColoana[3]="ITEMS FROM ORDER";
	DefaultTableModel tabelModel= new DefaultTableModel();
	tabelModel.setColumnIdentifiers(primaColoana);
	if(m.size()==0)
	return tabelModel;
	
	int i=0;
	Object[] obiecte = new Object[4];
	for (Map.Entry<Order, ArrayList<MenuItem>> entry : map.entrySet()) {
		   // System.out.println(entry.getKey()+" "+entry.getValue().get(i));
			
			obiecte[0]=entry.getKey().orderId;
			obiecte[1]=entry.getKey().table;
			obiecte[2]=entry.getKey().date;
			for(MenuItem a:entry.getValue())
			{
				aux_2+=a.getName()+",";
			}
			aux_2=aux_2.substring(0,aux_2.length()-1);			
			obiecte[3]=aux_2;
			tabelModel.addRow(obiecte);
			aux_2="";
	}
	aux_2="";
	return tabelModel;
}
public DefaultTableModel creareTabelProduse(ArrayList<MenuItem> a)
{
		String[] primaColoana = new String[5] ;
		primaColoana[0]="ID";
		primaColoana[1]="TIP";
		primaColoana[2]="NUME";
		primaColoana[3]="PRET";
		primaColoana[4]="CONTINE";
		DefaultTableModel tabelModel= new DefaultTableModel();
		tabelModel.setColumnIdentifiers(primaColoana);
		int i;
		if (a == null) {
		return tabelModel;
		}// daca lista de clienti este goala, atunci se creeaza un tabel care contine doar capul de tabel
		i=0;
		int j=0;
		Object[] obiecte = new Object[5];// o sa avem atat variabile de tip intreg cat si variabile de tip String
			while(i!=a.size())
		{
				MenuItem a_aux=a.get(i);// am luat primul element de tipul MenuItem
				if(a_aux instanceof BaseProduct)
				{
				obiecte[0]=a_aux.getId();
				obiecte[1]="Base Product";
				obiecte[2]=a_aux.getName();
				obiecte[3]=a_aux.getPrice();
				obiecte[4]="";
				}else if(a_aux instanceof CompositeProduct)
				{	
					obiecte[0]=a_aux.getId();
					obiecte[1]="Composite Product";
					obiecte[2]=a_aux.getName();
					obiecte[3]=a_aux.getPrice();
					String aux="";
					for(MenuItem m:((CompositeProduct) a_aux).getListOfIngredients())
						aux+=m.getName()+",";
						obiecte[4]=aux;
				}
			i++;
		tabelModel.addRow(obiecte);
		}
		return tabelModel;
}
public void createItemsForOrder() {
	MenuItem m_aux=null;
	int ok=0;
	for(MenuItem m:listOfProducts)
	{	if(m.getName().equalsIgnoreCase(w1.getCombo().getSelectedItem().toString()))
			{
			m_aux=m;
			ok=1;
			break;
			}
	}
	if(ok==0) {
	for(MenuItem m:listOfProducts)
		{
			String aux="";	
			int index = w1.getCombo().getSelectedItem().toString().indexOf("-");
			aux=w1.getCombo().getSelectedItem().toString().substring(0, index);			
			if(aux.equalsIgnoreCase(m.getName()))
			{
			m_aux=m;
			break;
			}
		}
	}
	if(m_aux!=null)
	listOfProductsPerOrder.add(m_aux);
}
public void createNewOrder() {
	
	o1=new Order(Integer.parseInt(w1.getTxtId2()),w1.getTxtdata2(),Integer.parseInt(w1.getTxtMasa2()));
}
public void computePriceForOrder() {

		for(MenuItem m:listOfProductsPerOrder)
		{
	    price+=m.getPrice();
		}
}
public void generateBill() {
	FileWriterClass a=new FileWriterClass();
	a.chitanta(listOfProductsPerOrder, price);	
}
public boolean cauta(int index)
{	for(MenuItem m:listOfProducts)
		if(m.getId()==index)
		return true;
return false;	
}
}