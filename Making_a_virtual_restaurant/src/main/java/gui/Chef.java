package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Chef implements Observer {
	
	private JFrame frame=new JFrame();
	private JPanel contentPane;
	private JTextField txtChef;
	private JTextArea txtAlert=new JTextArea();
	private JButton btnBack=new JButton("BACK");
	public Chef() {
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setBounds(100, 100, 650, 400);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	contentPane.setLayout(new BorderLayout(0, 0));
	frame.setContentPane(contentPane);

	JPanel panel = new JPanel();
	panel.setBackground(new Color(50, 250, 250));
	contentPane.add(panel, BorderLayout.CENTER);
	panel.setLayout(null);
	
	txtChef = new JTextField();
	txtChef.setEditable(false);
	txtChef.setBackground(new Color(0, 0, 0));
	txtChef.setForeground(Color.RED);
	txtChef.setFont(new Font("Times New Roman", Font.BOLD, 30));
	txtChef.setText("Chef");
	txtChef.setBounds(285, 29, 75, 42);
	panel.add(txtChef);
	
	
	txtAlert.setEditable(false);
	txtAlert.setBackground(new Color(255, 255, 255));
	txtAlert.setForeground(Color.BLACK);
	txtAlert.setFont(new Font("Times New Roman", Font.BOLD, 16));
	txtAlert.setBounds(150,75, 350, 230);
	panel.add(txtAlert);

	btnBack.setFont(new Font("Times New Roman", Font.BOLD, 15));
	btnBack.setBackground(new Color(255, 93, 10));
	btnBack.setForeground(new Color(0, 0, 0));
	btnBack.setBounds(500, 317, 89, 23);
	panel.add(btnBack);

	frame.add(panel);
	panel.setVisible(true);
	frame.setVisible(true);
	}
	
	public void addListenerBChef(ActionListener listenerBChef) {
		btnBack.addActionListener(listenerBChef);
	}

	public JFrame getFrame() {
		return frame;
	}

	public String getTxtAlert() {
		return txtAlert.getText();
	}

	public void setTxtAlert(String txtAlert) {
		this.txtAlert.setText(txtAlert);
	}

	public void update(Observable arg0, Object arg1) {
		txtAlert.append("A fost procesata o nou comanda!"+"\n");
	}
	
	
}
