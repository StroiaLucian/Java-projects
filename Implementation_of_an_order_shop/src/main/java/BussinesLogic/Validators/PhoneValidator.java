package BussinesLogic.Validators;

import Model.Clienti;

public class PhoneValidator implements Validators<Clienti>{

	public boolean validate(Clienti t) {
		int nr=0;
		for(char c:t.getTelefon().toCharArray())
		{
			if (!(c>=48 && c<=58))
			{
				return false;			
			}else nr++;
		}
		if(nr!=10) 	return false;
	return true;
	}

	
}
