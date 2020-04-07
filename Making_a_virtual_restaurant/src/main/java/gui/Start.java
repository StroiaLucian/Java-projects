package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Start extends JFrame {
	private JFrame frame=new JFrame();
	private JPanel contentPane;
	private JTextField txtPrincipal;
	private JButton btnWaiter=new JButton("Waiter");
	private JButton btnAdministrator=new JButton("Administrator");
	private JButton btnChef=new JButton("Chef");
	public Start()
	{
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setBounds(100, 100, 650, 400);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	contentPane.setLayout(new BorderLayout(0, 0));
	frame.setContentPane(contentPane);

	JPanel panel = new JPanel();
	panel.setBackground(new Color(60, 13, 255));
	contentPane.add(panel, BorderLayout.CENTER);
	panel.setLayout(null);
	
	txtPrincipal = new JTextField();
	txtPrincipal.setEditable(false);
	txtPrincipal.setBackground(new Color(0, 0, 0));
	txtPrincipal.setForeground(Color.RED);
	txtPrincipal.setFont(new Font("Times New Roman", Font.BOLD, 30));
	txtPrincipal.setText("Restaurant");
	txtPrincipal.setBounds(256, 29, 145, 42);
	panel.add(txtPrincipal);
	txtPrincipal.setColumns(10);
	
	btnWaiter.setFont(new Font("Times New Roman", Font.BOLD, 16));
	btnWaiter.setBackground(new Color(255, 93, 10));
	btnWaiter.setBounds(35, 152, 155, 47);
	panel.add(btnWaiter);
	
	btnAdministrator.setBackground(new Color(255, 93, 10));
	btnAdministrator.setFont(new Font("Times New Roman", Font.BOLD, 16));
	btnAdministrator.setBounds(250, 152, 155, 47);
	panel.add(btnAdministrator);
	
	btnChef.setBackground(new Color(255, 93, 10));
	btnChef.setFont(new Font("Times New Roman", Font.BOLD, 16));
	btnChef.setBounds(459, 152, 155, 47);
	panel.add(btnChef);
	
	frame.add(panel);
	panel.setVisible(true);
	frame.setVisible(true);
	}
	public void addListenerWaiter(ActionListener listenerWaiter) {
		btnWaiter.addActionListener(listenerWaiter);
		}

	public void addListenerAdministrator(ActionListener listenerAdministrator) {
		btnAdministrator.addActionListener(listenerAdministrator);
		}
	public void addListenerChef(ActionListener listenerChef) {
		btnChef.addActionListener(listenerChef);
		}
	
}
