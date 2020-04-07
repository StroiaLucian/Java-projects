package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class CompositeProductsIngredients extends JFrame {
	private JFrame frame=new JFrame();
	private JPanel contentPane;
	private JTextField txtAvertizare;
	private JTextField txtAvertizare2;
	private JButton btnSfarsit=new JButton("SFARSIT");
	private JRadioButton btnSfarsitC=new JRadioButton("Composite");
	private JRadioButton btnSfarsitB=new JRadioButton("Base");

	public CompositeProductsIngredients()
	{
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(736, 100, 450, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		frame.setContentPane(contentPane);
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		txtAvertizare = new JTextField();
		txtAvertizare.setEditable(false);
		txtAvertizare.setBackground(Color.RED);
		txtAvertizare.setForeground(new Color(0, 0, 0));
		txtAvertizare.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtAvertizare.setText("Introduceti produse suplimentare!");
		txtAvertizare.setBounds(5, 29, 296, 42);
		panel.add(txtAvertizare);
	
		txtAvertizare2 = new JTextField();
		txtAvertizare2.setEditable(false);
		txtAvertizare2.setBackground(Color.RED);
		txtAvertizare2.setForeground(new Color(0, 0, 0));
		txtAvertizare2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtAvertizare2.setText("CAUZA: Composite Product!");
		txtAvertizare2.setBounds(5, 69, 296, 42);
		panel.add(txtAvertizare2);
	

		btnSfarsit.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSfarsit.setBackground(new Color(255, 93, 10));
		btnSfarsit.setForeground(new Color(0, 0, 0));
		btnSfarsit.setBounds(5, 120, 160, 20);
		panel.add(btnSfarsit);
		
		btnSfarsitC.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSfarsitC.setBackground(new Color(255, 93, 10));
		btnSfarsitC.setForeground(new Color(0, 0, 0));
		btnSfarsitC.setBounds(170, 120, 100, 20);
		panel.add(btnSfarsitC);
		
		btnSfarsitB.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSfarsitB.setBackground(new Color(255, 93, 10));
		btnSfarsitB.setForeground(new Color(0, 0, 0));
		btnSfarsitB.setBounds(280, 120, 100, 20);
		panel.add(btnSfarsitB);
		
		
		frame.add(panel);
		frame.setVisible(true);
	}
	
	public void addListenerSfarsit(ActionListener listenerSfarsit) {
		btnSfarsit.addActionListener(listenerSfarsit);
	}
	public JButton getBtnSfarsit() {
		return btnSfarsit;
	}
	public void setBtnSfarsit(JButton btnSfarsit) {
		this.btnSfarsit = btnSfarsit;
	}
	public JFrame getFrame() {
		return frame;
	}
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	public JRadioButton getBtnSfarsitC() {
		return btnSfarsitC;
	}
	public void setBtnSfarsitC(JRadioButton btnSfarsitC) {
		this.btnSfarsitC = btnSfarsitC;
	}
	public JRadioButton getBtnSfarsitB() {
		return btnSfarsitB;
	}
	public void setBtnSfarsitB(JRadioButton btnSfarsitB) {
		this.btnSfarsitB = btnSfarsitB;
	}
	
	
}
