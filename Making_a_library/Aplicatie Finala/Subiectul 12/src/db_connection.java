import java.sql.*;
import javax.swing.JTextField;

public class db_connection {
	public Connection conexiune;
	public void conectare() throws Exception
	{
		conexiune=DriverManager.getConnection("jdbc:mysql://localhost/subiect12","root","");
		
	}

	public ResultSet afisare(String ce) throws SQLException{
		Statement afisare=conexiune.createStatement();
		ResultSet rez=afisare.executeQuery("SELECT * FROM "+ce);
		return rez;
	}
	public ResultSet interogarea1() throws SQLException{
		CallableStatement interogare=null;
		interogare=conexiune.prepareCall("{call Procedura1()}");
		ResultSet rez=interogare.executeQuery();
		return rez;
	}	
	public ResultSet interogarea2() throws SQLException {
		Statement interogare= conexiune.createStatement();		                                                                                                                                                                                                                                                                                                                           
		ResultSet rez = interogare.executeQuery("SELECT id_carte, id_imp,CAST(datar-datai AS UNSIGNED)-nr_zile zile_intarziere FROM Imprumut WHERE datar is not null and CAST(datar-datai AS UNSIGNED)>nr_zile");
		return rez;
	}
	
	public ResultSet interogarea3(JTextField textFieldas) throws SQLException {
		CallableStatement interogare= conexiune.prepareCall("{call Procedura2(?)}");
		String auxiliar= textFieldas.getText();
		interogare.setString(1, auxiliar);
		ResultSet rez = interogare.executeQuery();
		return rez;
	}
	public ResultSet interogarea4() throws SQLException {
		Statement interogare= conexiune.createStatement();		                                                                                                                                                                                                                                                                                                                           
		ResultSet rez = interogare.executeQuery("SELECT DISTINCT nume,telefon FROM Persoana p JOIN Imprumut i ON (p.id_persoana=i.id_imp) WHERE datar is NULL;");
		return rez;
	}
	public ResultSet interogarea5() throws SQLException {
		Statement interogare= conexiune.createStatement();		                                                                                                                                                                                                                                                                                                                           
		ResultSet rez = interogare.executeQuery("SELECT nume FROM Persoana WHERE id_persoana= ANY( SELECT id_persoana FROM Persoana JOIN Autor a ON(id_persoana=a.id_aut) JOIN Carte c ON(c.id_carte=a.id_carte) WHERE c.titlu='India');");
		return rez;
	}
	public ResultSet interogarea6() throws SQLException {
		Statement interogare= conexiune.createStatement();		                                                                                                                                                                                                                                                                                                                           
		ResultSet rez = interogare.executeQuery("SELECT DISTINCT id_carte FROM Autor WHERE id_carte= ANY(SELECT a1.id_carte FROM Autor a1 JOIN Autor a2 ON(a1.id_carte=a2.id_carte)  WHERE (a1.id_aut<a2.id_aut));");
				return rez;
	}
	public ResultSet interogarea7() throws SQLException {
		Statement interogare= conexiune.createStatement();		                                                                                                                                                                                                                                                                                                                           
		ResultSet rez = interogare.executeQuery("SELECT titlu,MAX(mycount) FROM (SELECT carte.titlu,COUNT(imprumut.id_carte) mycount FROM Carte join Imprumut on (Carte.id_carte=imprumut.id_carte) GROUP BY carte.titlu) A");
				return rez;
	}
	public ResultSet interogarea8() throws SQLException {
		Statement interogare= conexiune.createStatement();		                                                                                                                                                                                                                                                                                                                           
		ResultSet rez = interogare.executeQuery("SELECT AVG(nr_pagini) as \"Nr mediu de pagini\",gen FROM Carte GROUP BY gen;");
				return rez;
	}
}
