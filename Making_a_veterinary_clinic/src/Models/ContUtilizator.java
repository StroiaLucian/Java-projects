package Models;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ContUtilizator implements Serializable {
private String user;
private String parola;
private Utilizator utilizator; 
public ContUtilizator(String user, String parola, Utilizator utilizator) {
	super();
	this.user = user;
	this.parola = parola;
	this.utilizator=utilizator;
}
public String getUser() {
	return user;
}
public void setUser(String user) {
	this.user = user;
}
public String getParola() {
	return parola;
}
public void setParola(String parola) {
	this.parola = parola;
}

public Utilizator getUtilizator() {
	return utilizator;
}
public void setUtilizator(Utilizator utilizator) {
	this.utilizator = utilizator;
}
@Override
public String toString() {
	return "id="+utilizator.getId()+", user=" + user + ", parola=" + parola ;
}


}
