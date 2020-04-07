package BussinesLogic.Validators;

import Model.Produse;

public class CantitatePRValidator implements Validators {

	public boolean validate(Object t) {
		Produse a=(Produse) t;
		if(a.getCantitate()<0) return false;
		return true;	
	
	}

}
