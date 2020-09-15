package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class AdministratorPage {
	private JFrame frameAdministrator=new JFrame();
	private JPanel contentPane= new JPanel();
	private JButton btnInregistrareDoctor = new JButton("Inregistrare doctor/asistent");
	private JButton btnStergereDoctor = new JButton("\u0218tergere informatii doctor/asistent");
	private JButton btnEditareDoctor = new JButton("Editare informatii doctor/asistent");
	private JButton btnVizualizareDoctor = new JButton("Vizualizare informatii doctor/asistent");
	private JTextField texIntroducereNume;
	private JTextField textIntroducereVarsta;
	private JTextField textIntroducereCNP;
	private JTextField textIntroducereProfesie;
	private JTextField textIntroducereUsername;
	private JTextField textIntroducereParola;
	private JTextField txtNume;
	private JTextField txtVrst;
	private JTextField txtCnp;
	private JTextField txtProfesie;
	private JTextField txtUsername;
	private JTextField txtParola;
	private JTextField textIntroducereId;
	private JTextField txtId;
	private JTextField textSuccesInregistrare;
	private JPanel panel= new JPanel();
	private JTable table;

	public AdministratorPage() {
		frameAdministrator.setBounds(80, 30, 1200, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		frameAdministrator.setContentPane(contentPane);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(SystemColor.text);
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		texIntroducereNume = new JTextField();
		texIntroducereNume.setBackground(new Color(173, 255, 47));
		texIntroducereNume.setBounds(100, 332, 178, 20);
		desktopPane.add(texIntroducereNume);
		texIntroducereNume.setColumns(10);
		
		textIntroducereVarsta = new JTextField();
		textIntroducereVarsta.setBackground(new Color(173, 255, 47));
		textIntroducereVarsta.setColumns(10);
		textIntroducereVarsta.setBounds(100, 173, 178, 20);
		desktopPane.add(textIntroducereVarsta);
		
		textIntroducereCNP = new JTextField();
		textIntroducereCNP.setBackground(new Color(173, 255, 47));
		textIntroducereCNP.setColumns(10);
		textIntroducereCNP.setBounds(100, 204, 178, 20);
		desktopPane.add(textIntroducereCNP);
		
		textIntroducereProfesie = new JTextField();
		textIntroducereProfesie.setBackground(new Color(173, 255, 47));
		textIntroducereProfesie.setColumns(10);
		textIntroducereProfesie.setBounds(100, 235, 178, 20);
		desktopPane.add(textIntroducereProfesie);
		
		textIntroducereUsername = new JTextField();
		textIntroducereUsername.setBackground(new Color(173, 255, 47));
		textIntroducereUsername.setColumns(10);
		textIntroducereUsername.setBounds(100, 266, 178, 20);
		desktopPane.add(textIntroducereUsername);
		
		textIntroducereParola = new JTextField();
		textIntroducereParola.setBackground(new Color(173, 255, 47));
		textIntroducereParola.setColumns(10);
		textIntroducereParola.setBounds(100, 301, 178, 20);
		desktopPane.add(textIntroducereParola);
		
		textIntroducereId = new JTextField();
		textIntroducereId.setBackground(new Color(173, 255, 47));
		textIntroducereId.setColumns(10);
		textIntroducereId.setBounds(100, 142, 178, 20);
		desktopPane.add(textIntroducereId);
		
		
		
		txtNume = new JTextField();
		txtNume.setBackground(new Color(50, 205, 50));
		txtNume.setEditable(false);
		txtNume.setHorizontalAlignment(SwingConstants.RIGHT);
		txtNume.setText("Nume:");
		txtNume.setColumns(10);
		txtNume.setBounds(33, 332, 67, 20);
		desktopPane.add(txtNume);
		
		txtVrst = new JTextField();
		txtVrst.setBackground(new Color(50, 205, 50));
		txtVrst.setEditable(false);
		txtVrst.setHorizontalAlignment(SwingConstants.RIGHT);
		txtVrst.setText("V\u00E2rst\u0103:");
		txtVrst.setColumns(10);
		txtVrst.setBounds(33, 173, 67, 20);
		desktopPane.add(txtVrst);
		
		txtCnp = new JTextField();
		txtCnp.setBackground(new Color(50, 205, 50));
		txtCnp.setEditable(false);
		txtCnp.setHorizontalAlignment(SwingConstants.RIGHT);
		txtCnp.setText("CNP:");
		txtCnp.setColumns(10);
		txtCnp.setBounds(33, 204, 67, 20);
		desktopPane.add(txtCnp);
		
		txtProfesie = new JTextField();
		txtProfesie.setBackground(new Color(50, 205, 50));
		txtProfesie.setEditable(false);
		txtProfesie.setHorizontalAlignment(SwingConstants.RIGHT);
		txtProfesie.setText("Profesie:");
		txtProfesie.setColumns(10);
		txtProfesie.setBounds(33, 235, 67, 20);
		desktopPane.add(txtProfesie);
		
		txtUsername = new JTextField();
		txtUsername.setBackground(new Color(50, 205, 50));
		txtUsername.setEditable(false);
		txtUsername.setHorizontalAlignment(SwingConstants.RIGHT);
		txtUsername.setText("Username:");
		txtUsername.setColumns(10);
		txtUsername.setBounds(33, 266, 67, 20);
		desktopPane.add(txtUsername);
		
		txtParola = new JTextField();
		txtParola.setBackground(new Color(50, 205, 50));
		txtParola.setEditable(false);
		txtParola.setHorizontalAlignment(SwingConstants.RIGHT);
		txtParola.setText("Parola");
		txtParola.setColumns(10);
		txtParola.setBounds(33, 301, 67, 20);
		desktopPane.add(txtParola);
		
		txtId = new JTextField();
		txtId.setBackground(new Color(50, 205, 50));
		txtId.setEditable(false);
		txtId.setHorizontalAlignment(SwingConstants.RIGHT);
		txtId.setText("Id");
		txtId.setColumns(10);
		txtId.setBounds(33, 142, 67, 20);
		desktopPane.add(txtId);
		
		
		
		
		
		btnStergereDoctor.setForeground(Color.BLACK);
		btnStergereDoctor.setBackground(new Color(255, 255, 102));
		btnStergereDoctor.setBounds(33, 519, 245, 23);
		desktopPane.add(btnStergereDoctor);
		
		
		btnEditareDoctor.setForeground(Color.BLACK);
		btnEditareDoctor.setBackground(new Color(255, 255, 102));
		btnEditareDoctor.setBounds(33, 481, 245, 23);
		desktopPane.add(btnEditareDoctor);
		

		btnVizualizareDoctor.setForeground(Color.BLACK);
		btnVizualizareDoctor.setBackground(new Color(255, 255, 102));
		btnVizualizareDoctor.setBounds(33, 413, 245, 23);
		desktopPane.add(btnVizualizareDoctor);
		

		btnInregistrareDoctor.setForeground(Color.BLACK);
		btnInregistrareDoctor.setBackground(new Color(255, 255, 102));
		btnInregistrareDoctor.setBounds(33, 447, 245, 23);
		desktopPane.add(btnInregistrareDoctor);
		
		panel.setBounds(460, 25, 664, 331);
		desktopPane.add(panel);
		
		textSuccesInregistrare = new JTextField();
		textSuccesInregistrare.setBounds(288, 448, 180, 20);
		desktopPane.add(textSuccesInregistrare);
		textSuccesInregistrare.setColumns(10);
		
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Stroia Lucian Dorin\\Desktop\\Proiectarea sistemelor\\Tema 1\\images\\admin.png"));
		lblNewLabel_1.setBounds(460, 333, 243, 344);
		desktopPane.add(lblNewLabel_1);
		frameAdministrator.setVisible(true);
		frameAdministrator.setResizable(false);
	}
	public JPanel adaugareTabel(String header,ArrayList<String>animale,boolean sePoate) {
	    //headers for the table
		panel.removeAll();
		table=new JTable();
		String[] headerSplit= header.split(",");
		String[] coloane = new String[headerSplit.length];
	    for(int i=0;i<headerSplit.length;i++)
	    	{
	    	coloane[i]=headerSplit[i];
	    	}
	    String helperString[]= animale.get(0).split(",");
		Object[][] data = new Object[animale.size()][helperString.length];
	    int i=0;
	    for(String s:animale)
	    {    
	    if(s!="\n")
	    {
	    String rand[]= s.split(",");
	    for(int j=0;j<helperString.length;j++)
	    {	
	    	data[i][j]=rand[j].substring(rand[j].lastIndexOf("=")+1);
	    	
	    		
	    }
	    i++;
	    }
	    }
	    
	    DefaultTableModel tableModel;
	    if(!sePoate)
	    {tableModel = new DefaultTableModel(data, coloane) {

	        @Override
	        public boolean isCellEditable(int row, int column) {
	           return false;
	        }
	    };
	    }
	    else {
	    	tableModel = new DefaultTableModel(data, coloane) {
	            @Override
	            public boolean isCellEditable(int row, int column) {
	              
	               return true;
	            }
	        };
	    }
	    table.setModel(tableModel);
	    table.setBackground(new Color(169, 204, 227));
	    for (int k=0;k<table.getColumnCount();k++) {
	        TableColumn column = table.getColumnModel().getColumn(k);
	        column.setMinWidth(133);
	        column.setMaxWidth(133);
	        column.setPreferredWidth(133);
	        k++;
	    }
	    JScrollPane scrollPane = new JScrollPane(table);
	    panel.setLayout(new BorderLayout());
	    panel.add(scrollPane);
	    panel.setPreferredSize(new Dimension(500, 200));
	    panel.setVisible(true);
	    panel.revalidate();
	    return panel;
	}
	
	public void addlistener2(ActionListener a)
	{
		btnInregistrareDoctor.addActionListener(a);
	}
	public void addlistener4(ActionListener a)
	{
		btnStergereDoctor.addActionListener(a);
	}
	public void addlistener3(ActionListener a)
	{
		btnEditareDoctor.addActionListener(a);
	}
	public void addlistener1(ActionListener a)
	{
		btnVizualizareDoctor.addActionListener(a);
	}

	public JFrame getFrameAdministrator() {
		return frameAdministrator;
	}
	public void setFrameAdministrator(JFrame frameAdministrator) {
		this.frameAdministrator = frameAdministrator;
	}
	public void setTexIntroducereNume(String TexIntroducereNume) {
		this.texIntroducereNume.setText(TexIntroducereNume); 
		this.texIntroducereNume.setForeground(Color.RED);
	}

	public void setTextIntroducereVarsta(String textIntroducereVarsta) {
		this.textIntroducereVarsta.setText(textIntroducereVarsta);
	}
	public void setTextIntroducereId(String textIntroducereId) {
		this.textIntroducereId.setText(textIntroducereId);
	}
	public void setTextIntroducereCNP(String textIntroducereCNP) {
		this.textIntroducereCNP.setText(textIntroducereCNP);
	}

	public void setTextIntroducereProfesie(String textIntroducereProfesie) {
		this.textIntroducereProfesie.setText(textIntroducereProfesie);
	}

	public void setTextIntroducereUsername(String textIntroducereUsername) {
		this.textIntroducereUsername.setText(textIntroducereUsername);
	}

	public void setTextIntroducereParola(String textIntroducereParola) {
		this.textIntroducereParola.setText(textIntroducereParola);
	}
	public String getTexIntroducereNume() {
		return texIntroducereNume.getText();
	}
	public String getTextIntroducereVarsta() {
		return textIntroducereVarsta.getText();
	}

	public String getTextIntroducereCNP() {
		return textIntroducereCNP.getText();
	}

	public String getTextIntroducereProfesie() {
		return textIntroducereProfesie.getText();
	}


	public String getTextIntroducereUsername() {
		return textIntroducereUsername.getText();
	}


	public String getTextIntroducereParola() {
		return textIntroducereParola.getText();
	}

	
	public String getTextIntroducereId() {
		return textIntroducereId.getText();
	}

	public String getTextSuccesInregistrare() {
		return textSuccesInregistrare.getText();
	}

	public void setTextSuccesInregistrare(String textSuccesInregistrare) {
		this.textSuccesInregistrare.setText(textSuccesInregistrare);
	}
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
	public JPanel getPanel() {
		return panel;
	}
	public JTable getTable() {
		return table;
	}
	public void setTable(JTable table) {
		this.table = table;
	}
	
	
}
