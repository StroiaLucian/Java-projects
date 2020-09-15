package Models;

import java.io.Serializable;
import java.util.ArrayList;
import javafx.util.Pair;

@SuppressWarnings("serial")
public class ProgramConsultatii  implements Serializable {
private Utilizator doctor;
//private ArrayList<Pair<String,ArrayList<Pair<String,Boolean>>>> program;
private ArrayList<Pair<String,ArrayList<Pair<String,Pair<Boolean,String>>>>> program;

public ProgramConsultatii(Utilizator doctor, ArrayList<Pair<String,ArrayList<Pair<String,Pair<Boolean,String>>>>> program)
{
	this.doctor=doctor;
	this.program=program;
}

public Utilizator getDoctor() {
	return doctor;
}

public void setDoctor(Utilizator doctor) {
	this.doctor = doctor;
}

public ArrayList<Pair<String,ArrayList<Pair<String,Pair<Boolean,String>>>>> getProgram() {
	return program;
}

public void setProgram(ArrayList<Pair<String,ArrayList<Pair<String,Pair<Boolean,String>>>>> program) {
	this.program = program;
}

@Override
public String toString() {
	return "ProgramConsultatii [doctor=" + doctor + ", program=" + program + "]";
}

}
