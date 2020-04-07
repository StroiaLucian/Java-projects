import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Rectangle;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class Frame {	private JFrame frameT;
private JFrame frame;
private JFrame frame2;
private JTextField txtBiblioteca = new JTextField();
private JTextField textFieldT= new JTextField();

private JButton btnAccesatiInterogarea = new JButton("Accesati interogarea");
private JTextField txtIntroducetiGenul = new JTextField();


private JButton btnTabelulImprumut = new JButton("Tabelul Imprumut");
private JButton btnTabelulCarte = new JButton("Tabelul Carte");
private JButton btnTabelulPersoana = new JButton("Tabelul Persoana");
private JButton btnTabelulAutor = new JButton("Tabelul Autor");
private JTextField txtInformatii = new JTextField();

private JButton btnAccesai = new JButton("Accesa\u0163i Aplica\u0163ia pentru Bibliotec\u0103");
private JButton btnNext = new JButton("NEXT");
private JComboBox comboBox = new JComboBox(new String[] {
		"Sa se gaseasca titlul, genul si nr_pagini pentru cartile cu numar de pagini par ordonat dupa numar pagini si gen."
		,"Sa se gaseasca id_carte, id_imp si numar zile intarziere pentru imprumuturile cu restituire intarziata."
		,"Sa se gaseasca perechi de carti gen BELETRISTICA scrise de acelasi autor"
		,"Sa se gaseasca numele si numarul de telefon pentru persoanele care au carti nerestituite."
		,"Sa se gaseasca numele autorului cartii cu titlul India ."
		,"Sa se gaseasca id-ul cartilor cu mai multi autori."
		,"Sa se gaseasca titlul cartilor cele mai imprumutate."
		,"Sa se gaseasca numarul de pagini mediu pentru fiecare gen."});
private JFrame resultFrame;
private JScrollPane scrollPane;
private JTable table=new JTable();
private JButton back=new JButton("BACK");
private JTextField txtRealizatorStroiaLucian = new JTextField();
private JButton ButtonSubject = new JButton("Vizualizati Cerinta");
private JFrame frameS ;
private JButton ButtonOffSubjectpPartial = new JButton("BACK");
private JButton ButtonRevenire = new JButton("Reveniti la prima pagina");
private JTextField txtSubiect;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame window = new Frame();
					window.frameS.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frameS = new JFrame();
		frameS.setBounds(new Rectangle(1920, 1080, 1080, 1920));
		frameS.getContentPane().setBackground(new Color(128, 0, 0));


		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		frameS.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		ButtonOffSubjectpPartial.setBounds(705, 437, 89, 23);
		panel.add(ButtonOffSubjectpPartial);
		
		txtSubiect = new JTextField();
		txtSubiect.setEditable(false);
		txtSubiect.setFont(new Font("Viner Hand ITC", Font.PLAIN, 15));
		txtSubiect.setText("SUBIECT");
		txtSubiect.setBounds(398, 11, 74, 25);
		panel.add(txtSubiect);
		txtSubiect.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\lucia\\OneDrive\\Desktop\\UTCN"));
		lblNewLabel.setBounds(651, -17, 205, 200);
		panel.add(lblNewLabel);
		
		JTextPane txtpnSeDau = new JTextPane();
		txtpnSeDau.setFont(new Font("Times New Roman", Font.ITALIC, 11));
		txtpnSeDau.setText("12.01. Se dau rela\u0163iile:\r\nPersoan\u0103 (id_pers, nume, telefon)\r\nCarte (id_carte, titlu, nr_pagini, nr_exemplare, gen)\r\n\u00CEmprumut (id_carte, id_imp, datai, datar, nr_zile)\r\nAutor (id_carte, id_aut)\r\nPentru eviden\u021Ba unei biblioteci se folose\u0219te schema de mai sus. \r\nO carte poate avea mai mul\u021Bi autori. Coloanele id_imp \u0219i id_aut iau valori din domeniul id_pers.\r\n La efectuarea unui \u00EEmprumut coloana datar (data restituirii) ia valoarea NULL, iar coloana nr_zile reprezint\u0103 termenul de restituire. \r\nLa restituire se va completa datar.\r\n Se presupune c\u0103 o persoan\u0103 \u00EEmprumut\u0103 o anumit\u0103 carte o singur\u0103 dat\u0103 \u00EEntr-o zi (datai este data \u00EEmprumutului).\r\nS\u0103 se scrie urm\u0103toarele instruc\u0163iuni:\r\na) creare tabel\u0103 pentru rela\u0163ia Persoan\u0103;\r\nb) creare tabel\u0103 pentru rela\u0163ia Carte;\r\nc) creare tabel\u0103 pentru rela\u0163ia \u00CEmprumut;\r\nd) creare tabel\u0103 pentru rela\u0163ia Autor;\r\ne) s\u0103 se declare cheile primare \u015Fi str\u0103ine;\r\nf) modificare defini\u0163ie tabel\u0103 Carte pentru a ad\u0103uga atributul rezumat.\r\n\r\n12.02. S\u0103 se exprime urm\u0103toarele constr\u00E2ngeri (la nivel atribut sau tupl\u0103):\r\na) Coloana nr_exemplare trebuie s\u0103 ia valoare mai mare ca 1.\r\nb) Dac\u0103 gen este \u2018BELETRISTICA\u2019, atunci num\u0103rul de pagini este peste 30.\r\n\r\n12.03. S\u0103 se exprime \u00EEn SQL urm\u0103toarele interog\u0103ri:\r\na) S\u0103 se g\u0103seasc\u0103 titlul, genul \u0219i nr_pagini pentru c\u0103r\u021Bile cu num\u0103r de pagini par, ordonat dup\u0103 num\u0103r pagini \u0219i gen.\r\nb) S\u0103 se g\u0103seasc\u0103 id_carte, id_imp \u0219i num\u0103r zile \u00EEnt\u00E2rziere pentru \u00EEmprumuturile cu restituire \u00EEnt\u00E2rziat\u0103 (numai cele restituite) \u00EEn ordinea descresc\u0103toare a num\u0103rului de zile \u00EEnt\u00E2rziere.\r\n\r\n12.04. S\u0103 se exprime \u00EEn SQL urm\u0103toarele interog\u0103ri folosind operatorul JOIN:\r\na) S\u0103 se g\u0103seasc\u0103 perechi de c\u0103r\u021Bi gen \u2018BELETRISTICA\u2019 (titlu1, titlu2) scrise de acela\u0219i autor. O pereche este unic\u0103 \u00EEn rezultat.\r\nb) S\u0103 se g\u0103seasc\u0103 numele \u0219i num\u0103rul de telefon pentru persoanele care au c\u0103r\u021Bi nerestituite.\r\n\r\n12.05. S\u0103 se exprime \u00EEn SQL f\u0103r\u0103 func\u021Bii de agregare urm\u0103toarele interog\u0103ri\r\nfolosind cel pu\u0163in o interogare imbricat\u0103 \u015Fi operatori de genul EXISTS, IN, ALL,\r\nANY:\r\na) S\u0103 se g\u0103seasc\u0103 numele autorului c\u0103r\u021Bii cu titlul \u2019India\u2019.\r\nb) S\u0103 se g\u0103seasc\u0103 id-ul c\u0103r\u021Bilor cu mai mul\u021Bi autori.\r\n\r\n12.06. S\u0103 se exprime \u00EEn SQL urm\u0103toarele interog\u0103ri folosind func\u0163ii de agregare:\r\na) S\u0103 se g\u0103seasc\u0103 titlul c\u0103r\u021Bilor cele mai \u00EEmprumutate.\r\nb) S\u0103 se g\u0103seasc\u0103 num\u0103rul de pagini mediu pentru fiecare gen.\r\n");
		txtpnSeDau.setBounds(10, 11, 846, 526);
		panel.add(txtpnSeDau);
		
		frameS.setResizable(false);
		frameS.setBounds(70, 0, 877,562);
		frameS.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		}
}
