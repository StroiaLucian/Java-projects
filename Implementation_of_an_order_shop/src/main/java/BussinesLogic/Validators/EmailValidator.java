package BussinesLogic.Validators;

import Model.Clienti;

public class EmailValidator implements Validators<Clienti> {

	public boolean validate(Clienti t) {
		if(t.getMail().toLowerCase().contains("@yahoo.com")) {
			return true;
		}
		
		else {
			return false;
		}
		}
}
