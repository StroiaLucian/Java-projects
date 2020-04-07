package Model;

public class informatiicomenzi {

private int idinformatiicomenzi;
private int idCumparator;
private String produs;
private int cantitate;


public informatiicomenzi()
{
	
}
public informatiicomenzi(int idCumparator, String produs, int cantitate) {
	super();
	this.idCumparator=idCumparator;
	this.produs = produs;
	this.cantitate = cantitate;
}
public int getIdinformatiicomenzi() {
	return idinformatiicomenzi;
}
public void setIdinformatiicomenzi(int idinformatiicomenzi) {
	this.idinformatiicomenzi = idinformatiicomenzi;
}
public int getIdCumparator() {
	return idCumparator;
}
public void setIdCumparator(int idCumparator) {
	this.idCumparator = idCumparator;
}
public String getProdus() {
	return produs;
}
public void setProdus(String produs) {
	this.produs = produs;
}
public int getCantitate() {
	return cantitate;
}
public void setCantitate(int cantitate) {
	this.cantitate = cantitate;
}

}
