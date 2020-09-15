package Models;
import java.io.*; 

@SuppressWarnings("serial")
public class Animal implements Serializable {
private int identificator;
private String nume;
private String tip;
private int varsta;
private String simptome;
private String diagnostic;
private String tratament;
private String doctor;
public Animal(int identificator, String nume, String tip, int varsta, String simptome, String diagnostic, String tratament, String doctor)
{	super();
	this.identificator=identificator;
	this.nume=nume;
	this.tip=tip;
	this.varsta=varsta;
	this.simptome=simptome;
	this.diagnostic=diagnostic;
	this.tratament=tratament;
	this.doctor=doctor;
}
public String getNume() {
	return nume;
}
public void setNume(String nume) {
	this.nume = nume;
}
public String getTip() {
	return tip;
}
public void setTip(String tip) {
	this.tip = tip;
}
public int getVarsta() {
	return varsta;
}
public void setVarsta(int varsta) {
	this.varsta = varsta;
}

public int getIdentificator() {
	return identificator;
}
public void setIdentificator(int identificator) {
	this.identificator = identificator;
}
public String getSimptome() {
	return simptome;
}
public void setSimptome(String simptome) {
	this.simptome = simptome;
}
public String getDiagnostic() {
	return diagnostic;
}
public void setDiagnostic(String diagnostic) {
	this.diagnostic = diagnostic;
}
public String getTratament() {
	return tratament;
}
public void setTratament(String tratament) {
	this.tratament = tratament;
}
public String getDoctor() {
	return doctor;
}
public void setDoctor(String doctor) {
	this.doctor = doctor;
}
@Override
public String toString() {
	return "id="+identificator+", nume=" + nume + ", tip=" + tip + ", varsta=" + varsta + " ani"+", simptome="+simptome+", diagnostic="+diagnostic+", tratament="+tratament+", doctor="+doctor;
}

}
