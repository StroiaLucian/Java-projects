package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

public class Table extends JFrame {
	
	private JFrame resultFrame=new JFrame();
	private JButton btnBack=new JButton("BACK");
	private JTable table=new JTable();
	private JScrollBar horizontalScrollBar=new JScrollBar();
	public Table() {
		
	}
	public void construireTabel()
	{
		resultFrame=new JFrame();
		resultFrame.setBackground(new Color(0, 255, 255));
		resultFrame.getContentPane().setBackground(Color.black);
		resultFrame.setBounds(100, 100, 556, 509);
		resultFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		JScrollPane scrollPane = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(10, 10, 470, 420);
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnBack.setBackground(new Color(255, 0, 0));
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.setBounds(451, 450, 85, 21);
		resultFrame.getContentPane().add(btnBack);
		resultFrame.getContentPane().add(scrollPane);
		resultFrame.setResizable(true);
		resultFrame.setVisible(true);
	}
	public JTable getTable() {
		return table;
	}
	public void setTable(JTable table) {
		this.table = table;
	}
	public JFrame getResultFrame() {
		return resultFrame;
	}
	public void setResultFrame(JFrame resultFrame) {
		this.resultFrame = resultFrame;
	}
	public void addListenerTAB(ActionListener listenerTAB) {
		btnBack.addActionListener(listenerTAB);
	}
}
