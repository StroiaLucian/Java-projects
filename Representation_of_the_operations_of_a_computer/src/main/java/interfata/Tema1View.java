package interfata;
import polinoame.*;

import javax.swing.border.Border;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Tema1View extends JFrame {

private JFrame frame;
private JTextArea enunt1 = new JTextArea("Introduceti primul polinom:");
private JTextArea enunt2 = new JTextArea("Introduceti cel de-al doilea polinom:");
private JTextArea resultenunt = new JTextArea("Rezultatul in urma operatiei alese este:");
private JTextArea titlu = new JTextArea("Operatii cu polinoame");
private JTextField firstPolinom = new JTextField(50);
private JTextField secondPolinom = new JTextField(50);
private JTextField resultPolinom = new JTextField(50);
private JButton adunare= new JButton("Operatia de adunare");
private JButton scadere= new JButton("Operatia de scadere");
private JButton inmultire= new JButton("Operatia de inmultire");
private JButton impartire= new JButton("Operatia de impartire");
private JButton integrare= new JButton("Operatia de integrare");
private JButton derivare= new JButton("Operatia de derivare");
private JButton reset= new JButton("Reset");

Tema1View(){
	frame = new JFrame();   
	JPanel panel= new JPanel();
	frame.setSize(700,700);
	panel.setLayout(null);
	titlu.setBounds(230,50,250,50);
	titlu.setBackground(getBackground());
	titlu.setEditable(false);
	titlu.setFont(new Font("Times New Roman", Font.BOLD, 23));
	firstPolinom.setBounds(70, 150, 250, 25);
	enunt1.setBounds(70,120,200,30);
	enunt1.setEditable(false);
	enunt1.setBackground(getBackground());
	panel.add(titlu);
	panel.add(enunt1);
	panel.add(firstPolinom);
	secondPolinom.setBounds(70, 250, 250, 25);
	enunt2.setBounds(70,230,200,30);
	enunt2.setEditable(false);
	enunt2.setBackground(getBackground());
	panel.add(secondPolinom);
	panel.add(enunt2);
	resultPolinom.setBounds(70, 400, 350, 25);
	resultPolinom.setEditable(false);
	resultPolinom.setBackground(Color.white);
	resultenunt.setBounds(70,380,250,30);
	resultenunt.setEditable(false);
	resultenunt.setBackground(getBackground());
	panel.add(resultPolinom);
	panel.add(resultenunt);
	adunare.setBounds(330, 150, 170, 50);
	panel.add(adunare);
	scadere.setBounds(510,150,170,50);
	panel.add(scadere);
	inmultire.setBounds(330,210,170,50);
	panel.add(inmultire);
	impartire.setBounds(510,210,170,50);
	panel.add(impartire);
	integrare.setBounds(330,270,170,50);
	panel.add(integrare);
	derivare.setBounds(510,270,170,50);
	panel.add(derivare);
	reset.setBounds(510,400,170,50);
	panel.add(reset);
	frame.add(panel);
	frame.setVisible(true);
}
public boolean Eroare(String expresie) {
	int k=1;
	char c=expresie.charAt(0);
	boolean ok=true;
	while(k!=expresie.length())
	{
		if(c=='-' && (expresie.charAt(k)=='-' ||expresie.charAt(k)=='+'))
			ok=false;
		if(c=='+' && (expresie.charAt(k)=='-' ||expresie.charAt(k)=='+'))
			ok=false;
		if(c=='x' && expresie.charAt(k)=='x')
			ok=false;
		if(c!='x' && c!='^' && c!='*' && c!='+'&& c!='-' && (c<47 || c>56))
			{System.out.println(c);
			ok=false;
			}
		c=expresie.charAt(k);
		k++;
	}
	for(char d: expresie.toCharArray())
	if(d>=97 && d<=122)
	{
		if(!(d=='x'))
		{
			ok=false;
			break;
		}
	}
	return ok;
}
public void adunareListener(ActionListener listenerForAdunare) {
	adunare.addActionListener(listenerForAdunare);
}
public void scadereListener(ActionListener listenerForScadere) {
	scadere.addActionListener(listenerForScadere);
}
public void inmultireListener(ActionListener listenerForInmultire) {
	inmultire.addActionListener(listenerForInmultire);
}
public void impartireListener(ActionListener listenerForImpartire) {
	impartire.addActionListener(listenerForImpartire);
}
public void integrareListener(ActionListener listenerForIntegrare) {
	integrare.addActionListener(listenerForIntegrare);
}
public void derivareListener(ActionListener listenerForDerivare) {
	derivare.addActionListener(listenerForDerivare);
}
public void resetListener(ActionListener listenerForReset) {
	reset.addActionListener(listenerForReset);
}
public String getFirstPolinom() {
	return firstPolinom.getText();
}
public void setFirstPolinom(JTextField firstPolinom) {
	this.firstPolinom = firstPolinom;
}
public String getSecondPolinom() {
	return secondPolinom.getText();
}
public void setSecondPolinom(JTextField secondPolinom) {
	this.secondPolinom = secondPolinom;
}
public String getResultPolinom() {
	return resultPolinom.getText();
}
public void setResultPolinom(String resultPolinom) {
	this.resultPolinom.setText(resultPolinom);
}
public JButton getAdunare() {
	return adunare;
}
public void setAdunare(JButton adunare) {
	this.adunare = adunare;
}
public JButton getScadere() {
	return scadere;
}
public void setScadere(JButton scadere) {
	this.scadere = scadere;
}
public JButton getInmultire() {
	return inmultire;
}
public void setInmultire(JButton inmultire) {
	this.inmultire = inmultire;
}
public JButton getImpartire() {
	return impartire;
}
public void setImpartire(JButton impartire) {
	this.impartire = impartire;
}
public JButton getIntegrare() {
	return integrare;
}
public void setIntegrare(JButton integrare) {
	this.integrare = integrare;
}
public JButton getDerivare() {
	return derivare;
}
public void setDerivare(JButton derivare) {
	this.derivare = derivare;
}


}
