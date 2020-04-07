package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class View extends JFrame{

	private JPanel contentPane;
	private JFrame resultFrame=new JFrame();
	private JFrame frame=new JFrame();
	private JFrame frameClienti=new JFrame();
	private JFrame frameProduse=new JFrame();
	private JFrame frameComenzi=new JFrame();
	private JButton btnProduse = new JButton("Produse");
	private JButton btnComenzi = new JButton("Comenzi");
	private JButton btnClienti = new JButton("Clienti");
	private JButton btnBackCL = new JButton("BACK");
	private JButton btnVizCL = new JButton("Vizualizare tabel");
	private JButton btnInsCL = new JButton("Inserare");
	private JButton btnStergCL = new JButton("Stergere");
	private JButton btnUpCL = new JButton("Update");
	private JButton btnBackPR = new JButton("BACK");
	private JButton btnVizPR = new JButton("Vizualizare tabel");
	private JButton btnInsPR = new JButton("Inserare");
	private JButton btnStergPR = new JButton("Stergere");
	private JButton btnUpPR = new JButton("Update");
	private JButton btnBackCO = new JButton("BACK");
	private JButton btnBackR=new JButton("BACK");
	private JButton btnVizCO = new JButton("Vizualizare tabel Comenzi");
	private JButton btnInsCO = new JButton("Finalizare");
	private JButton btnAdaugaProduse= new JButton("Adauga produs");
	private JButton btnVizPR2= new JButton("Vizualizare tabel Produse");
	private JButton btnSuplimentar= new JButton("Info suplimentar");
	private JButton btnChitanta= new JButton("Generare chitanta");
	
	
	private JTextField txtAplicatieMarketing;
	private JTextField txtIdPro;
	private JTextField txtClienti;
	private JTextField txtNume;
	private JTextField txtPrenume;
	private JTextField txtId;
	private JTextField txtTelefon;
	private JTextField txtAdresa;
	private JTextField textField_idClienti;
	private JTextField textField_numeClienti;
	private JTextField textField_prenumeClienti;
	private JTextField textField_mailClienti;
	private JTextField textField_telefonClienti;
	private JTextField textField_adresaClienti;
	private JTextField textField_afisare;
	private JTextField textField_afisarePR;
	private JTextField txtMail;
	private JTextField txtNumePR;
	private JTextField txtProduse;
	private JTextField txtCantitate;
	private JTextField txtIdPR;
	private JTextField textField_idProduse;
	private JTextField textField_numeProduse;
	private JTextField textField_cantitateProduse;
	private JTextField txtCumparator;
	private JTextField txtProdus;
	private JTextField txtIdCO;
	private JTextField textField_idComenzi;
	private JTextField textField_cumparatorComenzi;
	private JTextField textField_produsComenzi;
	private JTextField textField_afisareCO;
	private JTextField textField_cantitateComenzi;
	private JTextField textField_idPro;
	private JTextField txtCantitateCO;
	private JTextField txtComenzi;
	private JScrollPane scrollPane;
	private JTable table=new JTable();
	public View()
	{
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 650, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		frame.setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 0));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		txtAplicatieMarketing = new JTextField();
		txtAplicatieMarketing.setEditable(false);
		txtAplicatieMarketing.setBackground(new Color(0, 255, 255));
		txtAplicatieMarketing.setForeground(Color.RED);
		txtAplicatieMarketing.setFont(new Font("Times New Roman", Font.BOLD, 30));
		txtAplicatieMarketing.setText("Aplicatie Marketing");
		txtAplicatieMarketing.setBounds(199, 29, 256, 42);
		panel.add(txtAplicatieMarketing);
		txtAplicatieMarketing.setColumns(10);
		
		btnClienti.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnClienti.setForeground(new Color(0, 0, 0));
		btnClienti.setBackground(new Color(0, 255, 102));
		btnClienti.setBounds(35, 152, 155, 47);
		panel.add(btnClienti);
		
		btnProduse.setBackground(new Color(0, 255, 102));
		btnProduse.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnProduse.setBounds(250, 152, 155, 47);
		panel.add(btnProduse);
		
		btnComenzi.setBackground(new Color(0, 255, 102));
		btnComenzi.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnComenzi.setBounds(459, 152, 155, 47);
		panel.add(btnComenzi);
		frame.add(panel);
		frame.setVisible(true);
	}	
	public void frameClienti()
	{
		frameClienti.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameClienti.setBounds(100, 100, 660, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		frameClienti.setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(new Color(255, 255, 0));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		txtClienti = new JTextField();
		txtClienti.setEditable(false);
		txtClienti.setBackground(new Color(0, 255, 255));
		txtClienti.setForeground(new Color(255, 0, 0));
		txtClienti.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 26));
		txtClienti.setText("Clienti");
		txtClienti.setBounds(278, 11, 78, 37);
		panel.add(txtClienti);
		txtClienti.setColumns(10);
		
		btnVizCL.setForeground(new Color(255, 255, 255));
		btnVizCL.setBackground(new Color(255, 0, 0));
		btnVizCL.setBounds(451, 105, 143, 23);
		panel.add(btnVizCL);
		
		btnInsCL.setForeground(new Color(255, 255, 255));
		btnInsCL.setBackground(new Color(255, 0, 0));
		btnInsCL.setBounds(505, 154, 89, 23);
		panel.add(btnInsCL);

		btnStergCL.setForeground(new Color(255, 255, 255));
		btnStergCL.setBackground(new Color(255, 0, 0));
		btnStergCL.setBounds(505, 201, 89, 23);
		panel.add(btnStergCL);
		

		btnUpCL.setForeground(new Color(255, 255, 255));
		btnUpCL.setBackground(new Color(255, 0, 0));
		btnUpCL.setBounds(505, 248, 89, 23);
		panel.add(btnUpCL);

		btnBackCL.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnBackCL.setBackground(new Color(255, 0, 0));
		btnBackCL.setForeground(new Color(255, 255, 255));
		btnBackCL.setBounds(267, 317, 89, 23);
		panel.add(btnBackCL);

		
		txtNume = new JTextField();
		txtNume.setEditable(false);
		txtNume.setBackground(new Color(0, 255, 255));
		txtNume.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtNume.setText("Nume:");
		txtNume.setBounds(53, 117, 67, 24);
		panel.add(txtNume);
		txtNume.setColumns(10);
		
		txtPrenume = new JTextField();
		txtPrenume.setText("Prenume:");
		txtPrenume.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtPrenume.setEditable(false);
		txtPrenume.setColumns(10);
		txtPrenume.setBackground(new Color(0, 255, 255));
		txtPrenume.setBounds(53, 164, 67, 24);
		panel.add(txtPrenume);
		
		txtId = new JTextField();
		txtId.setText("Id:");
		txtId.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtId.setEditable(false);
		txtId.setColumns(10);
		txtId.setBackground(new Color(0, 255, 255));
		txtId.setBounds(53, 76, 67, 24);
		
		panel.add(txtId);
		
		txtTelefon = new JTextField();
		txtTelefon.setText("Telefon:");
		txtTelefon.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtTelefon.setEditable(false);
		txtTelefon.setColumns(10);
		txtTelefon.setBackground(new Color(0, 255, 255));
		txtTelefon.setBounds(53, 246, 67, 24);
		panel.add(txtTelefon);
		
		txtAdresa = new JTextField();
		txtAdresa.setText("Adresa:");
		txtAdresa.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtAdresa.setEditable(false);
		txtAdresa.setColumns(10);
		txtAdresa.setBackground(new Color(0, 255, 255));
		txtAdresa.setBounds(53, 281, 67, 24);
		panel.add(txtAdresa);
		
		textField_idClienti = new JTextField();
		textField_idClienti.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textField_idClienti.setBounds(216, 78, 86, 20);
		panel.add(textField_idClienti);
		
		textField_numeClienti = new JTextField();
		textField_numeClienti.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textField_numeClienti.setBounds(216, 119, 191, 20);
		panel.add(textField_numeClienti);
		
		textField_prenumeClienti = new JTextField();
		textField_prenumeClienti.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textField_prenumeClienti.setColumns(10);
		textField_prenumeClienti.setBounds(216, 166, 191, 20);
		panel.add(textField_prenumeClienti);
		
		textField_telefonClienti = new JTextField();
		textField_telefonClienti.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textField_telefonClienti.setColumns(10);
		textField_telefonClienti.setBounds(216, 248, 191, 20);
		panel.add(textField_telefonClienti);
		
		textField_adresaClienti = new JTextField();
		textField_adresaClienti.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textField_adresaClienti.setColumns(10);
		textField_adresaClienti.setBounds(216, 286, 191, 20);
		panel.add(textField_adresaClienti);
		
		textField_afisare = new JTextField();
		textField_afisare.setEditable(false);
		textField_afisare.setBounds(480, 298, 150, 20);
		panel.add(textField_afisare);
		
		textField_mailClienti = new JTextField();
		textField_mailClienti.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textField_mailClienti.setColumns(10);
		textField_mailClienti.setBounds(216, 204, 191, 20);
		panel.add(textField_mailClienti);
		
		txtMail = new JTextField();
		txtMail.setText("Mail:");
		txtMail.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtMail.setEditable(false);
		txtMail.setColumns(10);
		txtMail.setBackground(Color.CYAN);
		txtMail.setBounds(53, 201, 67, 24);
		panel.add(txtMail);
		
		frameClienti.add(panel);
		frameClienti.setVisible(true);

	}
	
	public void frameProduse()
	{
		frameProduse.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameProduse.setBounds(100, 100, 660, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		frameProduse.setContentPane(contentPane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(new Color(255, 255, 0));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		txtProduse = new JTextField();
		txtProduse.setEditable(false);
		txtProduse.setBackground(new Color(0, 255, 255));
		txtProduse.setForeground(new Color(255, 0, 0));
		txtProduse.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 26));
		txtProduse.setText("Produse");
		txtProduse.setBounds(252, 11, 104, 37);
		panel.add(txtProduse);
		txtProduse.setColumns(10);
		
		btnVizPR.setForeground(new Color(255, 255, 255));
		btnVizPR.setBackground(new Color(255, 0, 0));
		btnVizPR.setBounds(451, 105, 143, 23);
		panel.add(btnVizPR);
		
		btnInsPR.setForeground(new Color(255, 255, 255));
		btnInsPR.setBackground(new Color(255, 0, 0));
		btnInsPR.setBounds(505, 154, 89, 23);
		panel.add(btnInsPR);
		
		btnStergPR.setForeground(new Color(255, 255, 255));
		btnStergPR.setBackground(new Color(255, 0, 0));

		btnStergPR.setBounds(505, 201, 89, 23);
		panel.add(btnStergPR);
		
		btnUpPR.setForeground(new Color(255, 255, 255));
		btnUpPR.setBackground(new Color(255, 0, 0));
		btnUpPR.setBounds(505, 248, 89, 23);
		panel.add(btnUpPR);
		
		btnBackPR.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnBackPR.setBackground(new Color(255, 0, 0));
		btnBackPR.setForeground(new Color(255, 255, 255));
		btnBackPR.setBounds(267, 296, 89, 23);
		panel.add(btnBackPR);
		
		
		txtNumePR = new JTextField();
		txtNumePR.setEditable(false);
		txtNumePR.setBackground(new Color(0, 255, 255));
		txtNumePR.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtNumePR.setText("Nume:");
		txtNumePR.setBounds(53, 138, 67, 24);
		panel.add(txtNumePR);
		txtNumePR.setColumns(10);
		
		txtCantitate = new JTextField();
		txtCantitate.setText("Cantitate");
		txtCantitate.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtCantitate.setEditable(false);
		txtCantitate.setColumns(10);
		txtCantitate.setBackground(new Color(0, 255, 255));
		txtCantitate.setBounds(53, 173, 67, 24);
		panel.add(txtCantitate);
		
		txtIdPR = new JTextField();
		txtIdPR.setText("Id:");
		txtIdPR.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtIdPR.setEditable(false);
		txtIdPR.setColumns(10);
		txtIdPR.setBackground(new Color(0, 255, 255));
		txtIdPR.setBounds(53, 103, 67, 24);
		
		panel.add(txtIdPR);
		

		textField_afisarePR = new JTextField();
		textField_afisarePR.setEditable(false);
		textField_afisarePR.setBounds(480, 298, 150, 20);
		panel.add(textField_afisarePR);
		
		textField_idProduse = new JTextField();
		textField_idProduse.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textField_idProduse.setBounds(216, 106, 86, 20);
		panel.add(textField_idProduse);
		textField_idProduse.setColumns(10);
		
		textField_numeProduse = new JTextField();
		textField_numeProduse.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textField_numeProduse.setColumns(10);
		textField_numeProduse.setBounds(216, 141, 191, 20);
		panel.add(textField_numeProduse);
		
		textField_cantitateProduse = new JTextField();
		textField_cantitateProduse.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textField_cantitateProduse.setColumns(10);
		textField_cantitateProduse.setBounds(216, 176, 191, 20);
		panel.add(textField_cantitateProduse);
		
		frameProduse.add(panel);
		frameProduse.setVisible(true);
	}
	
	public void frameComenzi()
	{
		frameComenzi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameComenzi.setBounds(100, 100, 660, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		frameComenzi.setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(new Color(255, 255, 0));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		txtComenzi = new JTextField();
		txtComenzi.setEditable(false);
		txtComenzi.setBackground(new Color(0, 255, 255));
		txtComenzi.setForeground(new Color(255, 0, 0));
		txtComenzi.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 26));
		txtComenzi.setText("Comenzi");
		txtComenzi.setBounds(267, 11, 101, 37);
		panel.add(txtComenzi);
		
		

		btnVizPR2.setForeground(new Color(255, 255, 255));
		btnVizPR2.setBackground(new Color(255, 0, 0));
		btnVizPR2.setBounds(451, 105, 179, 23);
		panel.add(btnVizPR2);
	
		
		btnVizCO.setForeground(new Color(255, 255, 255));
		btnVizCO.setBackground(new Color(255, 0, 0));
		btnVizCO.setBounds(451, 154, 179, 23);
		panel.add(btnVizCO);
	
		
		btnInsCO.setForeground(new Color(255, 255, 255));
		btnInsCO.setBackground(new Color(255, 0, 0));
		btnInsCO.setBounds(451, 254, 89, 23);
		panel.add(btnInsCO);

		btnAdaugaProduse.setForeground(new Color(255, 255, 255));
		btnAdaugaProduse.setBackground(new Color(255, 0, 0));
		btnAdaugaProduse.setBounds(451, 204, 120, 23);
		panel.add(btnAdaugaProduse);


		btnBackCO.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnBackCO.setBackground(new Color(255, 0, 0));
		btnBackCO.setForeground(new Color(255, 255, 255));
		btnBackCO.setBounds(267, 317, 89, 23);
		panel.add(btnBackCO);
		
		btnChitanta.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnChitanta.setBackground(new Color(255, 0, 0));
		btnChitanta.setForeground(new Color(255, 255, 255));
		btnChitanta.setBounds(53, 317, 160, 23);
		panel.add(btnChitanta);
		
		txtCumparator = new JTextField();
		txtCumparator.setEditable(false);
		txtCumparator.setBackground(new Color(0, 255, 255));
		txtCumparator.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtCumparator.setText("Cumparator:");
		txtCumparator.setBounds(53, 117, 79, 24);
		panel.add(txtCumparator);
		txtCumparator.setColumns(10);
		
		txtProdus = new JTextField();
		txtProdus.setForeground(new Color(0, 0, 0));
		txtProdus.setText("Produs:");
		txtProdus.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtProdus.setEditable(false);
		txtProdus.setColumns(10);
		txtProdus.setBackground(new Color(0, 255, 255));
		txtProdus.setBounds(53, 164, 67, 24);
		panel.add(txtProdus);
		
		txtIdCO = new JTextField();
		txtIdCO.setText("Id client:");
		txtIdCO.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtIdCO.setEditable(false);
		txtIdCO.setColumns(10);
		txtIdCO.setBackground(new Color(0, 255, 255));
		txtIdCO.setBounds(53, 76, 67, 24);
		
		panel.add(txtIdCO);
		
		textField_idComenzi = new JTextField();
		textField_idComenzi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textField_idComenzi.setBounds(216, 78, 86, 20);
		panel.add(textField_idComenzi);
		
		textField_cumparatorComenzi = new JTextField();
		textField_cumparatorComenzi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textField_cumparatorComenzi.setBounds(216, 119, 191, 20);
		panel.add(textField_cumparatorComenzi);
		
		textField_produsComenzi = new JTextField();
		textField_produsComenzi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textField_produsComenzi.setColumns(10);
		textField_produsComenzi.setBounds(216, 166, 191, 20);
		panel.add(textField_produsComenzi);
		
		
		textField_afisareCO = new JTextField();
		textField_afisareCO.setEditable(false);
		textField_afisareCO.setBounds(480, 298, 150, 20);
		panel.add(textField_afisareCO);
		
		
		textField_cantitateComenzi = new JTextField();
		textField_cantitateComenzi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textField_cantitateComenzi.setColumns(10);
		textField_cantitateComenzi.setBounds(216, 204, 191, 20);
		panel.add(textField_cantitateComenzi);
		
		
		txtIdPro = new JTextField();
		txtIdPro.setText("Id produs:");
		txtIdPro.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtIdPro.setEditable(false);
		txtIdPro.setColumns(10);
		txtIdPro.setBackground(Color.CYAN);
		txtIdPro.setBounds(53, 254, 67, 24);
		panel.add(txtIdPro);		
		
		
		textField_idPro = new JTextField();
		textField_idPro.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textField_idPro.setColumns(10);
		textField_idPro.setBounds(216, 254, 91, 20);
		panel.add(textField_idPro);
		
		
		txtCantitateCO = new JTextField();
		txtCantitateCO.setText("Cantitate:");
		txtCantitateCO.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtCantitateCO.setEditable(false);
		txtCantitateCO.setColumns(10);
		txtCantitateCO.setBackground(Color.CYAN);
		txtCantitateCO.setBounds(53, 201, 67, 24);
		panel.add(txtCantitateCO);		
		
		frameComenzi.add(panel);
		frameComenzi.setVisible(true);
	}
	
	
	public void createResultFrame() {
		resultFrame=new JFrame();
		resultFrame.setBackground(new Color(0, 255, 255));
		resultFrame.getContentPane().setBackground(Color.black);
		resultFrame.setResizable(false);
		resultFrame.setBounds(100, 100, 606, 509);
		resultFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		resultFrame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 570, 420);
		resultFrame.getContentPane().add(scrollPane);		
		scrollPane.setViewportView(table);
		
		btnSuplimentar.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSuplimentar.setBackground(new Color(255, 0, 0));
		btnSuplimentar.setForeground(new Color(255, 255, 255));
		btnSuplimentar.setBounds(90, 450, 155, 21);
		btnSuplimentar.setVisible(false);
		
		btnBackR.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnBackR.setBackground(new Color(255, 0, 0));
		btnBackR.setForeground(new Color(255, 255, 255));
		btnBackR.setBounds(451, 450, 85, 21);
		resultFrame.getContentPane().add(btnSuplimentar);
		resultFrame.getContentPane().add(btnBackR);
		resultFrame.getContentPane().add(scrollPane);
		resultFrame.setVisible(true);
		}
	public void addListenerClienti(ActionListener listenerClienti) {
	btnClienti.addActionListener(listenerClienti);
	}
	public void addListenerProduse(ActionListener listenerProduse) {
	btnProduse.addActionListener(listenerProduse);
	}
	public void addListenerComenzi(ActionListener listenerComenzi) {
	btnComenzi.addActionListener(listenerComenzi);
	}
	public void addListenerVizCL(ActionListener listenerVizCL) {
		btnVizCL.addActionListener(listenerVizCL);
		}
	public void addListenerInsCL(ActionListener listenerInsCL) {
		btnInsCL.addActionListener(listenerInsCL);
		}
	public void addListenerStergCL(ActionListener listenerStergCL) {
		btnStergCL.addActionListener(listenerStergCL);
		}
	public void addListenerUpCL(ActionListener listenerUpCL) {
		btnUpCL.addActionListener(listenerUpCL);
		}
	public void addListenerBackCL(ActionListener listenerBackCL) {
		btnBackCL.addActionListener(listenerBackCL);
		}
	public void addListenerVizPR(ActionListener listenerVizPR) {
		btnVizPR.addActionListener(listenerVizPR);
		}
	public void addListenerInsPR(ActionListener listenerInsPR) {
		btnInsPR.addActionListener(listenerInsPR);
		}
	public void addListenerStergPR(ActionListener listenerStergPR) {
		btnStergPR.addActionListener(listenerStergPR);
		}
	public void addListenerUpPR(ActionListener listenerUpPR) {
		btnUpPR.addActionListener(listenerUpPR);
		}
	public void addListenerBackPR(ActionListener listenerBackPR) {
		btnBackPR.addActionListener(listenerBackPR);
		}
	public void addListenerVizCO(ActionListener listenerVizCO) {
		btnVizCO.addActionListener(listenerVizCO);
		}
	public void addListenerInsCO(ActionListener listenerInsCO) {
		btnInsCO.addActionListener(listenerInsCO);
		}
	public void addListenerBackCO(ActionListener listenerBackCO) {
		btnBackCO.addActionListener(listenerBackCO);
		}
	public void addListenerBackR(ActionListener listenerBackR) {
		btnBackR.addActionListener(listenerBackR);
		}
	public void addListenerAdaugareProduse(ActionListener listenerAdaugareProduse) {
		btnAdaugaProduse.addActionListener(listenerAdaugareProduse);
		}
	public void addListenerVizPR2(ActionListener listenerVizPR2) {
		btnVizPR2.addActionListener(listenerVizPR2);
		}

	public void addListenerSuplimentar(ActionListener listenerSuplimentar) {
		btnSuplimentar.addActionListener(listenerSuplimentar);
		}
	
	public void addListenerChitanta(ActionListener listenerChitanta) {
		btnChitanta.addActionListener(listenerChitanta);
		}
	
		
	public JButton getBtnSuplimentar() {
		return btnSuplimentar;
	}
	public JFrame getFrame() {
		return frame;
	}
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	public JFrame getFrameClienti() {
		return frameClienti;
	}
	public void setFrameClienti(JFrame frameClienti) {
		this.frameClienti = frameClienti;
	}
	public JFrame getFrameProduse() {
		return frameProduse;
	}
	public void setFrameProduse(JFrame frameProduse) {
		this.frameProduse = frameProduse;
	}
	public JFrame getFrameComenzi() {
		return frameComenzi;
	}
	public void setFrameComenzi(JFrame frameComenzi) {
		this.frameComenzi = frameComenzi;
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
	
	public String getTextField_idClienti() {
		return textField_idClienti.getText();
	}
	public void setTextField_idClienti(JTextField textField_idClienti) {
		this.textField_idClienti = textField_idClienti;
	}
	public String getTextField_numeClienti() {
		return textField_numeClienti.getText();
	}
	public void setTextField_numeClienti(JTextField textField_numeClienti) {
		this.textField_numeClienti = textField_numeClienti;
	}
	public String getTextField_prenumeClienti() {
		return textField_prenumeClienti.getText();
	}
	public void setTextField_prenumeClienti(JTextField textField_prenumeClienti) {
		this.textField_prenumeClienti = textField_prenumeClienti;
	}
	public String getTextField_mailClienti() {
		return textField_mailClienti.getText();
	}
	public void setTextField_mailClienti(JTextField textField_mailClienti) {
		this.textField_mailClienti = textField_mailClienti;
	}
	public String getTextField_telefonClienti() {
		return textField_telefonClienti.getText();
	}
	public void setTextField_telefonClienti(JTextField textField_telefonClienti) {
		this.textField_telefonClienti = textField_telefonClienti;
	}
	public String getTextField_adresaClienti() {
		return textField_adresaClienti.getText();
	}
	public void setTextField_adresaClienti(JTextField textField_adresaClienti) {
		this.textField_adresaClienti = textField_adresaClienti;
	}
	public void setTextField_afisare(String textField_afisare) {
		this.textField_afisare.setText(textField_afisare);
	}
	public String getTextField_afisarePR() {
		return textField_afisarePR.getText();
	}
	public String getTextField_idProduse() {
		return textField_idProduse.getText();
	}
	public String getTextField_numeProduse() {
		return textField_numeProduse.getText();
	}
	public String getTextField_cantitateProduse() {
		return textField_cantitateProduse.getText();
	}
	public String getTextField_idComenzi() {
		return textField_idComenzi.getText();
	}
	public String getTextField_cumparatorComenzi() {
		return textField_cumparatorComenzi.getText();
	}
	public String getTextField_produsComenzi() {
		return textField_produsComenzi.getText();
	}
	public String getTextField_afisareCO() {
		return textField_afisareCO.getText();
	}
	public String getTextField_cantitateComenzi() {
		return textField_cantitateComenzi.getText();
	}
	public void setTextField_afisarePR(String textField_afisarePR) {
		this.textField_afisarePR.setText(textField_afisarePR);
	}
	public void setTextField_afisareCO(String textField_afisareCO) {
		this.textField_afisareCO.setText(textField_afisareCO);
	}
	public String getTextField_idPro() {
		return textField_idPro.getText();
	}
	public void setTextField_idPro(JTextField textField_idPro) {
		this.textField_idPro = textField_idPro;
	}
	
}
