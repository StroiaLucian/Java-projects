package BussinesLogic.Validators;

import BussinesLogic.ClientiBLL;
import Model.Clienti;

public class ExistaValidator implements Validators{

	public boolean validate(Object t) {
		Clienti aux=(Clienti) t;
		ClientiBLL a= new ClientiBLL();
		if(a.findClientiById(aux.getIdClienti())==null)
		return true;
		else return false;
	}
}
