package Model;

public class Comenzi {
	
	private int idComenzi;
	private String cumparator;

	public Comenzi(String cumparator) {
		super();
		this.cumparator = cumparator;
		//this.produs = produs;
		//this.cantitate = cantitate;
	}
	public Comenzi()
	{
		
	}
	
	public Comenzi(int idComenzi, String cumparator) {
		super();
		this.idComenzi = idComenzi;
		this.cumparator = cumparator;
	}
	public int getIdComenzi() {
		return idComenzi;
	}
	public void setIdComenzi(int idComenzi) {
		this.idComenzi = idComenzi;
	}
	public String getCumparator() {
		return cumparator;
	}
	public void setCumparator(String cumparator) {
		this.cumparator = cumparator;
	}

	@Override
	public String toString() {
		return "Comenzi [idComenzi=" + idComenzi + ", cumparator=" + cumparator + "]";
	}
	
	
}
