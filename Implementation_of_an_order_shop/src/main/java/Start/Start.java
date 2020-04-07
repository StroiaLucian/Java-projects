package Start;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import BussinesLogic.ClientiBLL;
import BussinesLogic.ComenziBLL;
import BussinesLogic.ProduseBLL;
import DatabaseAcces.ClientiDAO;
import GUI.Controller;
import GUI.View;
import Model.Clienti;
import Model.Comenzi;
import Model.Produse;
import BussinesLogic.ClientiBLL;
import Model.Clienti;

/**
 * @Author: Technical University of Cluj-Napoca, Romania Distributed Systems
 *          Research Laboratory, http://dsrl.coned.utcluj.ro/
 * @Since: Apr 03, 2017
 */
public class Start {
	protected static final Logger LOGGER = Logger.getLogger(Start.class.getName());

	public static void main(String[] args) throws SQLException {
		View my_view=new View();
		Controller con1=new Controller(my_view);
		
	}
}
