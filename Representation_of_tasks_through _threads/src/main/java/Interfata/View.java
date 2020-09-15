package Interfata;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class View extends JFrame {
private JFrame frame1;
private JFrame frame2;
private JTextArea titlu=new JTextArea("Aplicatie Tema 2");
private JTextArea e_interval1=new JTextArea("Intervalul de timp in care vin clientii:");
private JTextArea e_interval2=new JTextArea("Intervalul de timp pentru servirea unui client:");
private JTextArea e_clienti=new JTextArea("Introduceti numarul de clienti:");
private JTextArea e_simulare=new JTextArea("Timpul de simulare:");
private JTextArea e_nr_cozi=new JTextArea("Numarul de cozi:");
private JTextArea liniuta=new JTextArea("-");
private JTextArea liniuta2=new JTextArea("-");
private JTextField min1=new JTextField();
private JTextField max1=new JTextField();
private JTextField min2=new JTextField();
private JTextField max2=new JTextField();
private JTextField min3=new JTextField();
private JTextField max3=new JTextField();
private JButton B1= new JButton("1");
private JButton B2= new JButton("2");
private JButton B3= new JButton("3");
private JButton B4= new JButton("4");
private JButton B5= new JButton("5");
private JButton B6= new JButton("6");
private JButton START= new JButton("START");
public View()
{
	frame1=new JFrame();
	JPanel panel= new JPanel();
	frame1.setSize(700,700);
	panel.setLayout(null);
	titlu.setBounds(230,50,250,50);
	titlu.setBackground(getBackground());
	titlu.setEditable(false);
	titlu.setFont(new Font("Times New Roman", Font.BOLD, 23));
	panel.add(titlu);
	e_interval1.setBounds(20,150,315,35);
	e_interval1.setEditable(false);
	e_interval1.setBackground(getBackground());
	e_interval1.setFont(new Font("Times New Roman", Font.BOLD, 20));
	panel.add(e_interval1);
	min1.setBounds(350,155,40,20);
	min1.setEditable(true);
	min1.setBackground(Color.white);
	min1.setFont(new Font("Times New Roman", Font.BOLD, 20));
	panel.add(min1);
	
	liniuta.setBounds(397,150,50,15);
	liniuta.setEditable(false);
	liniuta.setFont(new Font("Times New Roman", Font.BOLD, 20));
	liniuta.setBackground(getBackground());
	panel.add(liniuta);	
	
	max1.setBounds(415,155,40,20);
	max1.setEditable(true);
	max1.setBackground(Color.white);
	max1.setFont(new Font("Times New Roman", Font.BOLD, 20));
	panel.add(max1);
	
	e_interval2.setBounds(20,210,380,50);
	e_interval2.setEditable(false);
	e_interval2.setBackground(getBackground());
	e_interval2.setFont(new Font("Times New Roman", Font.BOLD, 20));
	panel.add(e_interval2);
	
	min2.setBounds(440,215,40,20);
	min2.setEditable(true);
	min2.setBackground(Color.white);
	min2.setFont(new Font("Times New Roman", Font.BOLD, 20));
	panel.add(min2);
	
	liniuta2.setBounds(483,210,60,15);
	liniuta2.setEditable(false);
	liniuta2.setFont(new Font("Times New Roman", Font.BOLD, 20));
	liniuta2.setBackground(getBackground());
	panel.add(liniuta2);	
	
	max2.setBounds(495,215,40,20);
	max2.setEditable(true);
	max2.setBackground(Color.white);
	max2.setFont(new Font("Times New Roman", Font.BOLD, 20));
	panel.add(max2);
	

	e_simulare.setBounds(20,275,200,30);
	e_simulare.setEditable(false);
	e_simulare.setBackground(getBackground());
	e_simulare.setFont(new Font("Times New Roman", Font.BOLD, 20));
	panel.add(e_simulare);
	
	min3.setBounds(220,280,40,20);
	min3.setEditable(true);
	min3.setBackground(Color.white);
	min3.setFont(new Font("Times New Roman", Font.BOLD, 20));
	panel.add(min3);

	e_nr_cozi.setBounds(20,330,150,50);
	e_nr_cozi.setEditable(false);
	e_nr_cozi.setBackground(getBackground());
	e_nr_cozi.setFont(new Font("Times New Roman", Font.BOLD, 20));
	panel.add(e_nr_cozi);
	B1.setBounds(200,320,50,50);
	panel.add(B1);
	B2.setBounds(280,320,50,50);
	panel.add(B2);
	B3.setBounds(360,320,50,50);
	panel.add(B3);
	B4.setBounds(440,320,50,50);
	panel.add(B4);
	B5.setBounds(520,320,50,50);
	panel.add(B5);
	B6.setBounds(600,320,50,50);
	panel.add(B6);
	
	e_clienti.setBounds(20, 400, 270, 20);
	e_clienti.setBackground(getBackground());
	e_clienti.setFont(new Font("Times New Roman", Font.BOLD, 20));
	e_clienti.setEditable(false);
	panel.add(e_clienti);
	
	max3.setBounds(290, 400, 40, 20);
	max3.setBackground(Color.white);
	max3.setFont(new Font("Times New Roman",Font.BOLD,20));
	panel.add(max3);
	
	START.setBounds(160,470,350,100);
	START.setBackground(Color.RED);
	START.setFont(new Font("Times New Roman", Font.BOLD, 50));
	START.setForeground(Color.white);
	panel.add(START);
	

	frame1.add(panel);
	frame1.setVisible(true);
}


public void addListenerButon(ActionListener listenerStart) {
	// TODO Auto-generated method stub
	START.addActionListener(listenerStart);
}

public void addListener1(ActionListener listener1) {
	// TODO Auto-generated method stub
	B1.addActionListener(listener1);
}
public void addListener2(ActionListener listener2) {
	// TODO Auto-generated method stub
	B2.addActionListener(listener2);
}
public void addListener3(ActionListener listener3) {
	// TODO Auto-generated method stub
	B3.addActionListener(listener3);
}
public void addListener4(ActionListener listener4) {
	// TODO Auto-generated method stub
	B4.addActionListener(listener4);
}
public void addListener5(ActionListener listener5) {
	// TODO Auto-generated method stub
	B5.addActionListener(listener5);
}
public void addListener6(ActionListener listener6) {
	// TODO Auto-generated method stub
	B6.addActionListener(listener6);
}
public int getMin1() {
	return Integer.parseInt(min1.getText());
}



public int getMax1() {
	return Integer.parseInt(max1.getText());
}



public int  getMin2() {
	return Integer.parseInt(min2.getText());
}


public int getMax2() {
	return Integer.parseInt(max2.getText());
}



public int getMin3() {
	return Integer.parseInt(min3.getText());
}

public JFrame getFrame1() {
	return frame1;
}

public void setFrame1(JFrame frame1) {
	this.frame1 = frame1;
}

public JFrame getFrame2() {
	return frame2;
}

public void setFrame2(JFrame frame2) {
	this.frame2 = frame2;
}

public int getMax3() {
	return Integer.parseInt(max3.getText());
}

public void setMax3(JTextField max3) {
	this.max3 = max3;
}




}
