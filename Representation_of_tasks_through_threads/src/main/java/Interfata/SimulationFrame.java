package Interfata;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SimulationFrame {
	private JFrame frame2;
	private JTextArea coada1=new JTextArea();
	private JTextArea coada2=new JTextArea();
	private JTextArea coada3=new JTextArea();
	private JTextArea coada4=new JTextArea();
	private JTextArea coada5=new JTextArea();
	private JTextArea coada6=new JTextArea();
	private JTextArea e_c1=new JTextArea("Coada 1:");
	private JTextArea e_c2=new JTextArea("Coada 2:");
	private JTextArea e_c3=new JTextArea("Coada 3:");
	private JTextArea e_c4=new JTextArea("Coada 4:");
	private JTextArea e_c5=new JTextArea("Coada 5:");
	private JTextArea e_c6=new JTextArea("Coada 6:");
	private JTextArea e_Informatii=new JTextArea("Informatii");
	private JTextArea Informatii=new JTextArea();
	private JTextArea e_Timpul_Mediu=new JTextArea("Timpul mediu de asteptare:");
	private JTextArea e_Ora_Varf= new JTextArea("Ora de varf este:");
	private JTextArea ora_Varf=new JTextArea();
	private JTextArea timpul_Mediu=new JTextArea();
	private JScrollPane scroll;
	public SimulationFrame() {
		frame2=new JFrame();
		JPanel panel2= new JPanel();
		frame2.setSize(1300,750);
		panel2.setLayout(null);
		coada1.setBounds(250, 10, 1000, 50);
		coada1.setBackground(Color.WHITE);
		coada1.setEditable(false);
		panel2.add(coada1);
		e_c1.setBounds(100, 20, 80, 30);
		e_c1.setBackground(Color.GREEN);
		e_c1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		e_c1.setEditable(false);
		panel2.add(e_c1);
		coada2.setBounds(250, 70, 1000, 50);
		coada2.setBackground(Color.WHITE);
		coada2.setEditable(false);
		panel2.add(coada2);
		e_c2.setBounds(100, 80, 80, 30);
		e_c2.setBackground(Color.GREEN);
		e_c2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		e_c2.setEditable(false);
		panel2.add(e_c2);
		coada3.setBounds(250, 130, 1000, 50);
		coada3.setBackground(Color.WHITE);
		coada3.setEditable(false);
		panel2.add(coada3);
		e_c3.setBounds(100, 150, 80, 30);
		e_c3.setBackground(Color.GREEN);
		e_c3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		e_c3.setEditable(false);
		panel2.add(e_c3);
		coada4.setBounds(250, 190, 1000, 50);
		coada4.setBackground(Color.WHITE);
		coada4.setEditable(false);
		panel2.add(coada4);
		e_c4.setBounds(100, 200, 80, 30);
		e_c4.setBackground(Color.GREEN);
		e_c4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		e_c4.setEditable(false);
		panel2.add(e_c4);
		coada5.setBounds(250, 250, 1000, 50);
		coada5.setBackground(Color.WHITE);
		coada5.setEditable(false);
		panel2.add(coada5);
		e_c5.setBounds(100, 270, 80, 30);
		e_c5.setBackground(Color.GREEN);
		e_c5.setFont(new Font("Times New Roman", Font.BOLD, 20));
		e_c5.setEditable(false);
		panel2.add(e_c5);
		coada6.setBounds(250, 310, 1000, 50);
		coada6.setBackground(Color.WHITE);
		coada6.setEditable(false);
		panel2.add(coada6);
		e_c6.setBounds(100, 320, 80, 30);
		e_c6.setBackground(Color.GREEN);
		e_c6.setFont(new Font("Times New Roman", Font.BOLD, 20));
		e_c6.setEditable(false);
		panel2.add(e_c6);
		e_Informatii.setBounds(790,370,110,30);
		e_Informatii.setBackground(Color.GREEN);
		e_Informatii.setFont(new Font("Times New Roman", Font.BOLD, 24));
		e_Informatii.setEditable(false);
		panel2.add(e_Informatii);
		
		e_Timpul_Mediu.setBounds(20,420,282,30);
		e_Timpul_Mediu.setBackground(Color.GREEN);
		e_Timpul_Mediu.setFont(new Font("Times New Roman", Font.BOLD, 24));
		e_Timpul_Mediu.setEditable(false);
		panel2.add(e_Timpul_Mediu);
	
		timpul_Mediu.setBounds(308,420,50, 30);
		timpul_Mediu.setForeground(Color.black);
		timpul_Mediu.setBackground(Color.WHITE);
		timpul_Mediu.setFont(new Font("Times New Roman", Font.BOLD, 24));
		timpul_Mediu.setEditable(false);
		panel2.add(timpul_Mediu);
		
		Informatii.setEditable(false);
		scroll= new JScrollPane(Informatii,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(450, 400, 800, 300);
		scroll.setVisible(true);
		panel2.add(scroll);
		frame2.add(panel2);
		frame2.setVisible(true);
	}
	
	public String getCoada1() {
		return coada1.getText();
	}

	public void setCoada1(String coada1) {
		this.coada1.setText(coada1);
	}

	public String getCoada2() {
		return coada2.getText();
	}

	public void setCoada2(String coada2) {
		this.coada2.setText(coada2);
	}

	public String getCoada3() {
		return coada3.getText();
	}

	public void setCoada3(String coada3) {
		this.coada3.setText(coada3);
	}

	public String getCoada4() {
		return coada4.getText();
	}

	public void setCoada4(String coada4) {
		this.coada4.setText(coada4);
	}

	public String getCoada5() {
		return coada5.getText();
	}

	public void setCoada5(String coada5) {
		this.coada5.setText(coada5);
	}

	public String getCoada6() {
		return coada6.getText();
	}

	public void setCoada6(String coada6) {
		this.coada6.setText(coada6);
	}

	public String getInformatii() {
		return Informatii.getText();
	}

	public void setInformatii(String informatii) {
		Informatii.setText(informatii); 
	}

	public void setTimpul_Mediu(String timpul_Mediu) {
		this.timpul_Mediu.setText(timpul_Mediu);
	}


	


}
