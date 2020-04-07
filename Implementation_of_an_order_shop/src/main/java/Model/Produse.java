package Model;

public class Produse {

	private int idproduse;
	private String nume;
	private int cantitate;
	
	
	public Produse(int idproduse, String nume, int cantitate) {
		super();
		this.idproduse = idproduse;
		this.nume = nume;
		this.cantitate = cantitate;
	}
	public Produse()
	{
		
	}
	
	public Produse(String nume, int cantitate) {
		super();
		this.nume = nume;
		this.cantitate = cantitate;
	}
	public int getIdproduse() {
		return idproduse;
	}
	public void setIdproduse(int idproduse) {
		this.idproduse = idproduse;
	}
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public int getCantitate() {
		return cantitate;
	}
	public void setCantitate(int cantitate) {
		this.cantitate = cantitate;
	}
	@Override
	public String toString() {
		return "Produse [idproduse=" + idproduse + ", nume=" + nume + ", cantitate=" + cantitate + "]";
	}
	
}
