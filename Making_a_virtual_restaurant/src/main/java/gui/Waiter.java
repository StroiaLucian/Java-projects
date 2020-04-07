package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Waiter {
	private JFrame frame=new JFrame();
	private JPanel contentPane;
	private JTextField txtWaiter;
	private JButton btnBack=new JButton("BACK");
	private JTextField txtAnsw;
	private JTextField txtAnsw2;
	private JTextField txtId;
	private JTextField txtId2;
	private JTextField txtMasa;
	private JTextField txtMasa2;
	private JTextField txtdata;
	private JTextField txtdata2;
	private JComboBox combo=new JComboBox();
	private JButton btnVizualizareTabel=new JButton("Vizualizare Tabel Orders");
	private JButton btnAdd=new JButton("Adauga produs");
	private JButton btnFinish=new JButton("Finalizare comanda");
	private JButton btnComputePrice=new JButton("Aflati pretul comenzii curente");
	private JButton btnBill=new JButton("Generare nota de plata");
	
	public Waiter(ArrayList<String> meniu) {


		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 650, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		frame.setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(50, 250, 180));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		txtWaiter = new JTextField();
		txtWaiter.setEditable(false);
		txtWaiter.setBackground(new Color(0, 0, 0));
		txtWaiter.setForeground(Color.RED);
		txtWaiter.setFont(new Font("Times New Roman", Font.BOLD, 30));
		txtWaiter.setText("Waiter");
		txtWaiter.setBounds(275, 29, 96, 42);
		panel.add(txtWaiter);
		
		txtAnsw = new JTextField();
		txtAnsw.setEditable(false);
		txtAnsw.setBackground(new Color(0, 0, 0));
		txtAnsw.setForeground(Color.RED);
		txtAnsw.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtAnsw.setText("Answer");
		txtAnsw.setBounds(375, 269, 70, 22);
		panel.add(txtAnsw);
		
		txtAnsw2 = new JTextField();
		txtAnsw2.setEditable(false);
		txtAnsw2.setBackground(Color.white);
		txtAnsw2.setForeground(new Color(0,0,0));
		txtAnsw2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		txtAnsw2.setBounds(445, 269, 176, 22);
		panel.add(txtAnsw2);
		
		combo.setModel(new DefaultComboBoxModel(meniu.toArray()));
		combo.setEditable(false);
		combo.setBounds(280,79,340,20);
		panel.add(combo);
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setBackground(new Color(0, 0, 0));
		txtId.setForeground(Color.RED);
		txtId.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtId.setText("Id");
		txtId.setBounds(25, 79, 56, 22);
		panel.add(txtId);
	
		txtId2 = new JTextField();
		txtId2.setBackground(Color.white);
		txtId2.setForeground(new Color(0, 0, 0));
		txtId2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtId2.setBounds(85, 79, 66, 22);
		panel.add(txtId2);
		
		txtMasa = new JTextField();
		txtMasa.setEditable(false);
		txtMasa.setBackground(new Color(0, 0, 0));
		txtMasa.setForeground(Color.RED);
		txtMasa.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtMasa.setText("Masa");
		txtMasa.setBounds(25, 109, 56, 22);
		panel.add(txtMasa);
		

		txtMasa2 = new JTextField();
		txtMasa2.setBackground(Color.white);
		txtMasa2.setForeground(new Color(0, 0, 0));
		txtMasa2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtMasa2.setBounds(85, 109, 66, 22);
		panel.add(txtMasa2);
		
		txtdata = new JTextField();
		txtdata.setEditable(false);
		txtdata.setBackground(new Color(0, 0, 0));
		txtdata.setForeground(Color.RED);
		txtdata.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtdata.setText("Data");
		txtdata.setBounds(25, 139, 56, 22);
		panel.add(txtdata);
		

		txtdata2 = new JTextField();
		txtdata2.setBackground(Color.white);
		txtdata2.setForeground(new Color(0, 0, 0));
		txtdata2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtdata2.setBounds(85, 139, 126, 22);
		panel.add(txtdata2);
		

		btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnAdd.setBackground(new Color(255, 93, 10));
		btnAdd.setForeground(new Color(0, 0, 0));
		btnAdd.setBounds(25, 200, 239, 23);
		panel.add(btnAdd);
		

		btnFinish.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnFinish.setBackground(new Color(255, 93, 10));
		btnFinish.setForeground(new Color(0, 0, 0));
		btnFinish.setBounds(25, 230, 239, 23);
		panel.add(btnFinish);
			

		btnComputePrice.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnComputePrice.setBackground(new Color(255, 93, 10));
		btnComputePrice.setForeground(new Color(0, 0, 0));
		btnComputePrice.setBounds(25, 320, 239, 23);
		panel.add(btnComputePrice);
			

		btnBill.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnBill.setBackground(new Color(255, 93, 10));
		btnBill.setForeground(new Color(0, 0, 0));
		btnBill.setBounds(25, 260, 239, 23);
		panel.add(btnBill);
		

		btnVizualizareTabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnVizualizareTabel.setBackground(new Color(255, 93, 10));
		btnVizualizareTabel.setForeground(new Color(0, 0, 0));
		btnVizualizareTabel.setBounds(25, 290, 239, 23);
		panel.add(btnVizualizareTabel);
			
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnBack.setBackground(new Color(255, 93, 10));
		btnBack.setForeground(new Color(0, 0, 0));
		btnBack.setBounds(500, 317, 89, 23);
		panel.add(btnBack);
			
		frame.add(panel);
		panel.setVisible(true);
		frame.setVisible(true);
	}
	public void addListenerBWaiter(ActionListener listenerBWaiter) {
		btnBack.addActionListener(listenerBWaiter);
	}
	public void addListenerVizualizare(ActionListener listenerVizualizare)
	{
		btnVizualizareTabel.addActionListener(listenerVizualizare);
	}
	public void addListenerBill(ActionListener listenerBill)
	{
		btnBill.addActionListener(listenerBill);
	}
	public void addListenerComputePrice(ActionListener listenerComputePrice)
	{
		btnComputePrice.addActionListener(listenerComputePrice);
	}
	public void addListenerFinish(ActionListener listenerFinish)
	{
		btnFinish.addActionListener(listenerFinish);
	}
	public void addListenerAdd(ActionListener listenerAdd)
	{
		btnAdd.addActionListener(listenerAdd);
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
	public String getTxtMasa2() {
		return txtMasa2.getText();
	}
	public void setTxtMasa2(String txtMasa2) {
		this.txtMasa2.setText(txtMasa2);
	}
	public String getTxtdata2() {
		return txtdata2.getText();
	}
	public void setTxtdata2(String txtdata2) {
		this.txtdata2.setText(txtdata2);
	}
	
	public String getTxtAnsw2() {
		return txtAnsw2.getText();
	}
	public void setTxtAnsw2(String txtAnsw2) {
		this.txtAnsw2.setText(txtAnsw2);
	}
	public JComboBox getCombo() {
		return combo;
	}
	public void setCombo(JComboBox combo) {
		this.combo = combo;
	}
}

