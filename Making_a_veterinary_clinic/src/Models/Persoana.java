package Models;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Persoana implements Serializable {
protected int id;
protected String nume;
protected int varsta;
protected String cnp;

public Persoana(int id,String nume, int varsta, String cnp) {
	super();
	this.id=id;
	this.nume = nume;
	this.varsta = varsta;
	this.cnp = cnp;
}

public String getNume() {
	return nume;
}

public void setNume(String nume) {
	this.nume = nume;
}

public int getVarsta() {
	return varsta;
}

public void setVarsta(int varsta) {
	this.varsta = varsta;
}

public String getCnp() {
	return cnp;
}

public void setCnp(String cnp) {
	this.cnp = cnp;
}


public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

@Override
public String toString() {
	return "id="+id+", nume=" + nume + ", varsta=" + varsta + ", cnp=" + cnp;
}

}
