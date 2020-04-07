import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import net.proteanit.sql.DbUtils;
public class controller {
	public view my_view;
	public db_connection my_connection;
	
	public controller(view a, db_connection b)
	{
		my_view=a;
		my_connection=b;
		my_view.addlistener1(new listener1());
		my_view.addlistener_ButonNext(new listener_ButonNext());
		my_view.addlistener_ButonBack(new listener_Buton_Back());
		my_view.addlistener_ButonSubiect(new listener_ButonSubiect());
		my_view.addlistener_ButtonOffSubject(new listener_ButtonOffSubject());
		my_view.addlistener_ButonRevenire(new listener_ButtonRevenire());
		my_view.addlistener_btnAccesatiInterogarea(new listener_btnAccesatiInterogarea());
		my_view.addlistener_ButonPersoana(new listener_btnTabelulPersoana());
		my_view.addlistener_ButonCarte(new listener_btnTabelulCarte());
		my_view.addlistener_ButonImprumut(new listener_btnTabelulImprumut());
		my_view.addlistener_ButonAutor(new listener_btnTabelulAutor());
		my_view.addlistener_btnVizualizatiSubiectulPartial(new listener_btnVizualizatiSubiectulPartial());
		my_view.addlistener_ButtonOffSubjectPartial(new listener_ButtonOffSubjectPartial());
	}
	

	class listener_ButtonOffSubjectPartial implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			try {
				my_view.getFrameSP().dispose();
				
			}catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
	}
	class listener_btnVizualizatiSubiectulPartial implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			try {
				
					my_view.PartialSubjectFrame();
					
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			
		}
	}
	
	
	class listener_btnTabelulPersoana implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			try {
				ResultSet rezultat1=my_connection.afisare("persoana");
				my_view.createResultFrame();
				my_view.getTable().setModel(DbUtils.resultSetToTableModel(rezultat1));
				my_view.getResultFrame().setVisible(true);
				
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			
		}
	}
	class listener_btnTabelulCarte implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			try {
				ResultSet rezultat1=my_connection.afisare("carte");
				my_view.createResultFrame();
				my_view.getTable().setModel(DbUtils.resultSetToTableModel(rezultat1));
				my_view.getResultFrame().setVisible(true);
				
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			
		}
	}
	
	class listener_btnTabelulImprumut implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			try {
				ResultSet rezultat1=my_connection.afisare("imprumut");
				my_view.createResultFrame();
				my_view.getTable().setModel(DbUtils.resultSetToTableModel(rezultat1));
				my_view.getResultFrame().setVisible(true);
				
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			
		}
	}
	
	class listener_btnTabelulAutor implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			try {
				ResultSet rezultat1=my_connection.afisare("autor");
				my_view.createResultFrame();
				my_view.getTable().setModel(DbUtils.resultSetToTableModel(rezultat1));
				my_view.getResultFrame().setVisible(true);
				
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			
		}
	}
	
	class listener1 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				my_view.getFrame().dispose();
				my_view.createFrame();
				my_connection.conectare();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
	}
	class listener_ButonNext implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				String s=my_view.getComboBox().getSelectedItem().toString();
				switch (s)
				{case("Sa se gaseasca titlul, genul si nr_pagini pentru cartile cu numar de pagini par ordonat dupa numar pagini si gen."):
				
					{ResultSet rezultat1=my_connection.interogarea1();
					my_view.createResultFrame();
					my_view.getTable().setModel(DbUtils.resultSetToTableModel(rezultat1));
					my_view.getResultFrame().setVisible(true);
					break;
					}
				case("Sa se gaseasca id_carte, id_imp si numar zile intarziere pentru imprumuturile cu restituire intarziata."):
				{
					ResultSet rezultat2=my_connection.interogarea2();
					my_view.createResultFrame();
					my_view.getTable().setModel(DbUtils.resultSetToTableModel(rezultat2));
					my_view.getResultFrame().setVisible(true);
					break;
				}
				case("Sa se gaseasca perechi de carti gen BELETRISTICA scrise de acelasi autor"):
				{
					my_view.TypeFrame();
					break;
				}
				case("Sa se gaseasca numele si numarul de telefon pentru persoanele care au carti nerestituite."):	
				{
				ResultSet rezultat4=my_connection.interogarea4();
				my_view.createResultFrame();
				my_view.getTable().setModel(DbUtils.resultSetToTableModel(rezultat4));
				my_view.getResultFrame().setVisible(true);	
				break;
				}
				case("Sa se gaseasca numele autorului cartii cu titlul India ."):	
				{
					ResultSet rezultat5=my_connection.interogarea5();
					my_view.createResultFrame();
					my_view.getTable().setModel(DbUtils.resultSetToTableModel(rezultat5));
					my_view.getResultFrame().setVisible(true);
					break;
				}
				case("Sa se gaseasca id-ul cartilor cu mai multi autori."):	
				{
					ResultSet rezultat6=my_connection.interogarea6();
					my_view.createResultFrame();
					my_view.getTable().setModel(DbUtils.resultSetToTableModel(rezultat6));
					my_view.getResultFrame().setVisible(true);	
					break;
				}
				case("Sa se gaseasca titlul cartilor cele mai imprumutate."):	
				{
					ResultSet rezultat7=my_connection.interogarea7();
					my_view.createResultFrame();	
					my_view.getTable().setModel(DbUtils.resultSetToTableModel(rezultat7));
					my_view.getResultFrame().setVisible(true);
					break;
				}
				case("Sa se gaseasca numarul de pagini mediu pentru fiecare gen."):	
				{
					ResultSet rezultat8=my_connection.interogarea8();
					my_view.createResultFrame();
					my_view.getTable().setModel(DbUtils.resultSetToTableModel(rezultat8));
					my_view.getResultFrame().setVisible(true);
					break;
				}
				}
				
				
			}
			catch(Exception numele)
			{
				numele.printStackTrace();
			}
		}
	}
	
	class listener_Buton_Back implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		my_view.getResultFrame().dispose();		
		}
	}
	class listener_ButonSubiect implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			my_view.SubjectFrame();
			my_view.getSubjectFrame().setVisible(true);	
			
		}
	}
	class listener_ButtonOffSubject implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			my_view.getSubjectFrame().dispose();
					}
	}
	class listener_ButtonRevenire implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			my_view.getFrame2().dispose();
			my_view.getFrame();
			my_view.getFrame().setVisible(true);
		}
	}
		

	class listener_btnAccesatiInterogarea implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			my_view.getFrameT().dispose();
			ResultSet rezultat3=null;
			try {
				rezultat3 = my_connection.interogarea3(my_view.getAccesati());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			my_view.createResultFrame();
			my_view.getTable().setModel(DbUtils.resultSetToTableModel(rezultat3));
			my_view.getResultFrame().setVisible(true);
		}
	}
		
	}


