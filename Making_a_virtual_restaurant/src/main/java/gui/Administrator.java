package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Administrator extends JFrame {
	private JFrame frame=new JFrame();
	private JPanel contentPane;
	private JTextField txtAdministrator;
	private JButton btnBack=new JButton("BACK");
	private JButton btnInsert=new JButton("Insert Item");
	private JButton btnUpdate=new JButton("Update Item");
	private JButton btnDelete=new JButton("Delete Item");
	private JButton btnView=new JButton("View Menu Items");
	private JRadioButton btnCheck1 = new JRadioButton("Base Product");
	private JRadioButton btnCheck2 = new JRadioButton("Composite Product");
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtPrice;
	private JTextField txtId2;
	private JTextField txtName2;
	private JTextField txtPrice2;
	private JTextField txtAlert;
	public Administrator() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 650, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		frame.setContentPane(contentPane);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(50, 150, 250));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		txtAdministrator = new JTextField();
		txtAdministrator.setEditable(false);
		txtAdministrator.setBackground(new Color(0, 0, 0));
		txtAdministrator.setForeground(Color.RED);
		txtAdministrator.setFont(new Font("Times New Roman", Font.BOLD, 30));
		txtAdministrator.setText("Administrator");
		txtAdministrator.setBounds(225, 29, 186, 42);
		panel.add(txtAdministrator);
		
	
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setBackground(new Color(50, 150, 150));
		txtId.setForeground(Color.RED);
		txtId.setFont(new Font("Times New Roman", Font.BOLD, 16));
		txtId.setText("Id");
		txtId.setBounds(50, 100, 50, 20);
		panel.add(txtId);
		
		txtId2 = new JTextField();
		txtId2.setBackground(Color.white);
		txtId2.setForeground(Color.RED);
		txtId2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		txtId2.setBounds(100, 100, 50, 20);
		panel.add(txtId2);
		
		txtName = new JTextField();
		txtName.setEditable(false);
		txtName.setBackground(new Color(50, 150, 150));
		txtName.setForeground(Color.RED);
		txtName.setFont(new Font("Times New Roman", Font.BOLD, 16));
		txtName.setText("Name");
		txtName.setBounds(50, 130, 50, 20);
		panel.add(txtName);	

		txtName2 = new JTextField();
		txtName2.setBackground(Color.white);
		txtName2.setForeground(Color.RED);
		txtName2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		txtName2.setBounds(100, 130, 100, 20);
		panel.add(txtName2);	
		
		
		txtPrice = new JTextField();
		txtPrice.setEditable(false);
		txtPrice.setBackground(new Color(50, 150, 150));
		txtPrice.setForeground(Color.RED);
		txtPrice.setFont(new Font("Times New Roman", Font.BOLD, 16));
		txtPrice.setText("Price");
		txtPrice.setBounds(50, 160,50, 20);
		panel.add(txtPrice);
		
		txtPrice2 = new JTextField();
		txtPrice2.setBackground(Color.white);
		txtPrice2.setForeground(Color.RED);
		txtPrice2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		txtPrice2.setBounds(100, 160,50, 20);
		panel.add(txtPrice2);
		
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnBack.setBackground(new Color(255, 93, 10));
		btnBack.setForeground(new Color(0, 0, 0));
		btnBack.setBounds(500, 317, 89, 23);
		panel.add(btnBack);

		btnInsert.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnInsert.setBackground(new Color(255, 93, 10));
		btnInsert.setForeground(new Color(0, 0, 0));
		btnInsert.setBounds(350, 100, 160, 20);
		panel.add(btnInsert);

		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnUpdate.setBackground(new Color(255, 93, 10));
		btnUpdate.setForeground(new Color(0, 0, 0));
		btnUpdate.setBounds(350, 130, 160, 20);
		panel.add(btnUpdate);
			
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnDelete.setBackground(new Color(255, 93, 10));
		btnDelete.setForeground(new Color(0, 0, 0));
		btnDelete.setBounds(350, 160, 160, 20);
		panel.add(btnDelete);

		btnView.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnView.setBackground(new Color(255, 93, 10));
		btnView.setForeground(new Color(0, 0, 0));
		btnView.setBounds(350, 190, 160, 20);
		panel.add(btnView);
	
		txtAlert = new JTextField();
		txtAlert.setEditable(false);
		txtAlert.setBackground(new Color(255, 255, 255));
		txtAlert.setForeground(Color.BLACK);
		txtAlert.setFont(new Font("Times New Roman", Font.BOLD, 16));
		txtAlert.setBounds(350, 220, 160, 22);
		panel.add(txtAlert);
		
		btnCheck1.setBackground(new Color(255, 93, 10));
		btnCheck1.setForeground(new Color(0, 0, 0));
		btnCheck1.setBounds(50, 210, 160, 20);
		panel.add(btnCheck1);
		
		btnCheck2.setBackground(new Color(255, 93, 10));
		btnCheck2.setForeground(new Color(0, 0, 0));
		btnCheck2.setBounds(50, 240, 160, 20);
		panel.add(btnCheck2);
		
		frame.add(panel);
		panel.setVisible(true);
		frame.setVisible(true);
	}
	public void addListenerBAdministrator(ActionListener listenerBAdministrator) {
		btnBack.addActionListener(listenerBAdministrator);
	}
	public void addListenerCheck1(ActionListener listenerCheck1) {
		btnCheck1.addActionListener(listenerCheck1);
	}
	public void addListenerCheck2(ActionListener listenerCheck2) {
		btnCheck2.addActionListener(listenerCheck2);
	}
	public void addListenerInsert(ActionListener listenerInsert) {
		btnInsert.addActionListener(listenerInsert);
	}
	public void addListenerUpdate(ActionListener listenerUpdate) {
		btnUpdate.addActionListener(listenerUpdate);
	}
	public void addListenerDelete(ActionListener listenerDelete) {
		btnDelete.addActionListener(listenerDelete);
	}
	public void addListenerView(ActionListener listenerView) {
		btnView.addActionListener(listenerView);
	}
	public JFrame getFrame() {
		return frame;
	}
	public String getTxtId2() {
		return txtId2.getText();
	}
	public void setTxtId2(String txtId2) {
		this.txtId2.setText(txtId2);
		}
	public String getTxtName2() {
		return txtName2.getText();
	}
	public void setTxtName2(String txtName2) {
		this.txtName2.setText(txtName2);
	}
	public String getTxtPrice2() {
		return txtPrice2.getText();
	}
	public void setTxtPrice2(String txtPrice2) {
		this.txtPrice2.setText(txtPrice2);
	}
	public JRadioButton getBtnCheck1() {
		return btnCheck1;
	}
	public void setBtnCheck1(JRadioButton btnCheck1) {
		this.btnCheck1 = btnCheck1;
	}
	public JRadioButton getBtnCheck2() {
		return btnCheck2;
	}
	public void setBtnCheck2(JRadioButton btnCheck2) {
		this.btnCheck2 = btnCheck2;
	}
	public String getTxtAlert() {
		return txtAlert.getText();
	}
	public void setTxtAlert(String txtAlert) {
		this.txtAlert.setText(txtAlert);
	}
	
	
}
