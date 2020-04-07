package Model;

public class Clienti {

	private int idClienti;
	private String nume;
	private String prenume;
	private String mail;
	private String telefon;
	private String adresa;
	public Clienti()
	{
		
	}
	
	public Clienti(String nume, String prenume, String mail, String telefon, String adresa) {
		super();
		this.nume = nume;
		this.prenume = prenume;
		this.mail = mail;
		this.telefon = telefon;
		this.adresa = adresa;
	}

	public Clienti(int idClienti, String nume, String prenume, String mail, String telefon, String adresa) {
		super();
		this.idClienti = idClienti;
		this.nume = nume;
		this.prenume = prenume;
		this.mail = mail;
		this.telefon = telefon;
		this.adresa = adresa;
	}
	
	
	
	public int getIdClienti() {
		return idClienti;
	}
	public void setIdClienti(int idClienti) {
		this.idClienti = idClienti;
	}
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public String getPrenume() {
		return prenume;
	}
	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	@Override
	public String toString() {
		return "Clienti [idClienti=" + idClienti + ", nume=" + nume + ", prenume=" + prenume + ", mail=" + mail
				+ ", telefon=" + telefon + ", adresa=" + adresa + "]";
	}
}
