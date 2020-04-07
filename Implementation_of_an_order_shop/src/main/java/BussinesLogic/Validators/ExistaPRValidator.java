package BussinesLogic.Validators;

import BussinesLogic.ProduseBLL;
import Model.Produse;

public class ExistaPRValidator implements Validators {

	public boolean validate(Object a) {
		Produse t=(Produse)a;
		ProduseBLL d= new ProduseBLL();
		if(d.findProduseById(t.getIdproduse())==null)
		return true;
		else return false;
		}

}
