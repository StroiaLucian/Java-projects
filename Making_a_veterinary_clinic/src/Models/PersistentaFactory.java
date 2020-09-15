package Models;

public class PersistentaFactory {
	
public Persistenta  obtinePersistenta(String numeFisier) {
	if( numeFisier.equalsIgnoreCase("animale.txt")) {
		return(new PersistentaAnimale(numeFisier));
	}
	else if(numeFisier.equalsIgnoreCase("utilizatori.txt")) {
		return (new PersistentaUtilizatori(numeFisier));

	}
	else if(numeFisier.equalsIgnoreCase("conturi.txt")) {
		return (new PersistentaConturiUtilizatori(numeFisier));

	}
	else if(numeFisier.equalsIgnoreCase("programari.txt")) {
		return (new PersistentaProgramConsultatii(numeFisier));

	}
	else if(numeFisier.equalsIgnoreCase("rapoarte4.json")) {
		return (new PersistentaRapoarte(numeFisier));

	}
	return null;
	}
}
