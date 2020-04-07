import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.EmptyBorder;
import javax.swing.*;
public class view extends JFrame{
	
	
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JFrame getFrameT() {
		return frameT;
	}

	public void setFrameT(JFrame frameT) {
		this.frameT = frameT;
	}

	public JFrame getFrame2() {
		return frame2;
	}

	public void setFrame2(JFrame frame2) {
		this.frame2 = frame2;
	}

	public JTextField getTxtBiblioteca() {
		return txtBiblioteca;
	}

	public void setTxtBiblioteca(JTextField txtBiblioteca) {
		this.txtBiblioteca = txtBiblioteca;
	}

	public JButton getBtnAccesai() {
		return btnAccesai;
	}

	public void setBtnAccesai(JButton btnAccesai) {
		this.btnAccesai = btnAccesai;
	}

	public JButton getBtnNext() {
		return btnNext;
	}

	public void setBtnNext(JButton btnNext) {
		this.btnNext = btnNext;
	}

	public JComboBox getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}

	public JFrame getResultFrame() {
		return resultFrame;
	}

	public void setResultFrame(JFrame resultFrame) {
		this.resultFrame = resultFrame;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JButton getBack() {
		return back;
	}

	public void setBack(JButton back) {
		this.back = back;
	}
	public JFrame getSubjectFrame()
	{
		return frameS;
	}
	public JButton getButtonOffSubject()
	{
		return ButtonOffSubject;
	}
	public JButton getButtonSubject()
	{
		return ButtonSubject;
	}
	public JButton getButtonRevenire()
	{
		return  ButtonRevenire;
	}
	public JButton getButtonAccesatiInterogarea()
	{
		return btnAccesatiInterogarea;
	}
	
	public JTextField getAccesati()
	{
		return textFieldT;
	}
	
	
	public JButton getBtnTabelulImprumut() {
		return btnTabelulImprumut;
	}

	public void setBtnTabelulImprumut(JButton btnTabelulImprumut) {
		this.btnTabelulImprumut = btnTabelulImprumut;
	}

	public JButton getBtnTabelulCarte() {
		return btnTabelulCarte;
	}

	public void setBtnTabelulCarte(JButton btnTabelulCarte) {
		this.btnTabelulCarte = btnTabelulCarte;
	}

	public JButton getBtnTabelulPersoana() {
		return btnTabelulPersoana;
	}

	public void setBtnTabelulPersoana(JButton btnTabelulPersoana) {
		this.btnTabelulPersoana = btnTabelulPersoana;
	}

	public JButton getBtnTabelulAutor() {
		return btnTabelulAutor;
	}

	public void setBtnTabelulAutor(JButton btnNewButton) {
		this.btnTabelulAutor = btnNewButton;
	}
	

	public JButton getBtnVizualizatiSubiectulPartial() {
		return btnVizualizatiSubiectulPartial;
	}
	

	public JButton getButtonOffSubjectPartial() {
		return ButtonOffSubjectPartial;
	}

	public JFrame getFrameSP() {
		return frameSP;
	}


	private JTextField txtSubiect = new JTextField();
	private JButton ButtonOffSubjectPartial=new JButton("BACK");
	private JFrame frameT;
	private JFrame frame;
	private JFrame frameSP;
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
	private JButton ButtonOffSubject = new JButton("BACK");
	private JButton ButtonRevenire = new JButton("Reveniti la prima pagina");
	private JButton btnVizualizatiSubiectulPartial = new JButton("Vizualizati Subiectul Partial");

	public void addlistener_ButtonOffSubjectPartial(ActionListener a)
	{
		ButtonOffSubjectPartial.addActionListener(a);
	}
	public void addlistener_btnVizualizatiSubiectulPartial(ActionListener a)
	{
		btnVizualizatiSubiectulPartial.addActionListener(a);
	}
	public void addlistener_btnAccesatiInterogarea(ActionListener a)
	{
		btnAccesatiInterogarea.addActionListener(a);
	
	}
	public void addlistener1(ActionListener a)
	{
		btnAccesai.addActionListener(a);
		
	}
	
	public void addlistener_ButonNext(ActionListener a)
	{
		btnNext.addActionListener(a);
		
	}
	public void addlistener_ButonBack(ActionListener a)
	{
		back.addActionListener(a);
		
	}
	public void addlistener_ButonSubiect(ActionListener a)
	{
		ButtonSubject.addActionListener(a);
	}
	public void addlistener_ButtonOffSubject(ActionListener a)
	{
		ButtonOffSubject.addActionListener(a);
	}
	
	public void addlistener_ButonRevenire(ActionListener a)
	{
		ButtonRevenire.addActionListener(a);
		
	}

	public void addlistener_ButonPersoana(ActionListener a)
	{
		btnTabelulPersoana.addActionListener(a);
		
	}

	public void addlistener_ButonCarte(ActionListener a)
	{
		btnTabelulCarte.addActionListener(a);
		
	}

	public void addlistener_ButonImprumut(ActionListener a)
	{
		btnTabelulImprumut.addActionListener(a);
		
	}

	public void addlistener_ButonAutor(ActionListener a)
	{
		btnTabelulAutor.addActionListener(a);
		
	}
	
	public view() 
	{
		frame = new JFrame();
		frame.setBounds(new Rectangle(1920, 1080, 1080, 1920));
		frame.getContentPane().setBackground(new Color(128, 0, 0));


		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		btnAccesai.setBackground(new Color(0, 0, 128));
		btnAccesai.setForeground(new Color(51, 255, 255));
		btnAccesai.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		
		btnAccesai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnAccesai.setBounds(466, 312, 285, 33);
		panel.add(btnAccesai);
		
		ButtonSubject.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		ButtonSubject.setForeground(Color.CYAN);
		ButtonSubject.setBackground(new Color(0, 0, 153));
		ButtonSubject.setBounds(525, 274, 165, 27);
		panel.add(ButtonSubject);
		
		btnVizualizatiSubiectulPartial.setForeground(Color.CYAN);
		btnVizualizatiSubiectulPartial.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btnVizualizatiSubiectulPartial.setBackground(new Color(0, 0, 153));
		btnVizualizatiSubiectulPartial.setBounds(500, 356, 217, 27);
		panel.add(btnVizualizatiSubiectulPartial);
		
		txtRealizatorStroiaLucian.setFont(new Font("Times New Roman", Font.BOLD, 15));
		txtRealizatorStroiaLucian.setText("REALIZATOR: STROIA LUCIAN DORIN");
		txtRealizatorStroiaLucian.setBounds(913, 419, 295, 24);
		txtRealizatorStroiaLucian.setEditable(false);
		panel.add(txtRealizatorStroiaLucian);
		txtRealizatorStroiaLucian.setColumns(10);
		
		txtBiblioteca.setBackground(new Color(0, 0, 128));
		txtBiblioteca.setForeground(Color.CYAN);
		txtBiblioteca.setFont(new Font("Imprint MT Shadow", Font.BOLD, 60));
		txtBiblioteca.setText("BIBLIOTECA");
		txtBiblioteca.setBounds(399, 36, 419, 77);
		txtBiblioteca.setEditable(false);
		panel.add(txtBiblioteca);
		txtBiblioteca.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\lucia\\OneDrive\\Desktop\\UTCN"));
		lblNewLabel_1.setBounds(1008, 456, 200, 157);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\lucia\\OneDrive\\Desktop\\hmm.jpg"));
		lblNewLabel.setBounds(10, 0, 1224,653);
		panel.add(lblNewLabel);
		
		frame.setResizable(false);
		frame.setBounds(70, 0, 1224,653);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	frame.add(panel);
	frame.setVisible(true);

	}
	
	public void createFrame()
	{
		frame2 = new JFrame();
		frame2.getContentPane().setBackground(new Color(128, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		frame2.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		txtInformatii.setEditable(false);
		txtInformatii.setBackground(Color.BLUE);
		txtInformatii.setText("INFORMATII");
		txtInformatii.setFont(new Font("Times New Roman", Font.BOLD, 16));
		txtInformatii.setForeground(Color.CYAN);
		txtInformatii.setBounds(832, 211, 109, 26);
		panel.add(txtInformatii);
		txtInformatii.setColumns(10);
		
		JLabel lblAplicaiaPentruBibliotec = new JLabel("APLICA\u0162IA PENTRU BIBLIOTEC\u0102\r\n");
		lblAplicaiaPentruBibliotec.setForeground(new Color(0, 255, 255));
		lblAplicaiaPentruBibliotec.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblAplicaiaPentruBibliotec.setBounds(289, 11, 440, 31);
		panel.add(lblAplicaiaPentruBibliotec);
		
		JLabel lblMeniulAciunilorPosibile = new JLabel("Meniul ac\u0163iunilor posibile");
		lblMeniulAciunilorPosibile.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblMeniulAciunilorPosibile.setForeground(new Color(0, 255, 255));
		lblMeniulAciunilorPosibile.setBounds(426, 53, 165, 18);
		panel.add(lblMeniulAciunilorPosibile);
		
		comboBox.setBounds(179, 82, 659, 18);
		panel.add(comboBox);
		
		btnTabelulAutor.setBounds(796, 456, 178, 23);
		panel.add(btnTabelulAutor);
		
		btnNext.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnNext.setForeground(Color.BLACK);
		btnNext.setBackground(Color.WHITE);
		btnNext.setBounds(464, 111, 89, 23);
		panel.add(btnNext);

		ButtonRevenire.setBounds(796, 516, 178, 23);
		panel.add(ButtonRevenire);
		
		btnTabelulImprumut.setBounds(796, 395, 178, 23);
		panel.add(btnTabelulImprumut);
		
		btnTabelulCarte.setBounds(796, 338, 178, 23);
		panel.add(btnTabelulCarte);
		
		btnTabelulPersoana.setBounds(796, 289, 178, 23);
		panel.add(btnTabelulPersoana);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\lucia\\OneDrive\\Desktop\\carticica.jpg"));
		lblNewLabel.setBounds(10, 11, 1024,700);
		panel.add(lblNewLabel);
		frame2.setResizable(false);
		frame2.setBounds(70, 0, 1024,700);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame2.add(panel);
		frame2.setVisible(true);

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
	
	back.setBounds(451, 450, 85, 21);
	resultFrame.getContentPane().add(back);
	resultFrame.getContentPane().add(scrollPane);
	resultFrame.setVisible(true);
	
	}
public void SubjectFrame()
{
	frameS = new JFrame();
	frameS.setBounds(new Rectangle(1920, 1080, 1080, 1920));
	frameS.getContentPane().setBackground(new Color(128, 0, 0));


	JPanel panel = new JPanel();
	panel.setBackground(Color.WHITE);
	frameS.getContentPane().add(panel, BorderLayout.CENTER);
	panel.setLayout(null);
	
	JLabel lblNewLabel = new JLabel("");
	lblNewLabel.setForeground(Color.WHITE);
	lblNewLabel.setIcon(new ImageIcon("C:\\Users\\lucia\\OneDrive\\Desktop\\CerintaCF.png"));
	lblNewLabel.setBounds(149, 13, 552, 572);
	panel.add(lblNewLabel);
	
	ButtonOffSubject.setBounds(711, 562, 89, 23);
	panel.add(ButtonOffSubject);
	
	frameS.setResizable(false);
	frameS.setBounds(70, 0, 857,627);
	frameS.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	frameS.add(panel);
	frameS.setVisible(true);
	
}
public void PartialSubjectFrame()
{
	frameSP = new JFrame();
	frameSP.setBounds(new Rectangle(1920, 1080, 1080, 1920));
	frameSP.getContentPane().setBackground(new Color(128, 0, 0));


	JPanel panel = new JPanel();
	panel.setBackground(Color.WHITE);
	frameSP.getContentPane().add(panel, BorderLayout.CENTER);
	panel.setLayout(null);
	
	ButtonOffSubjectPartial.setBounds(705, 437, 89, 23);
	panel.add(ButtonOffSubjectPartial);
	
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
	
	frameSP.setResizable(false);
	frameSP.setBounds(70, 0, 877,562);
	frameSP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


	frameSP.add(panel);
	frameSP.setVisible(true);
}
public void TypeFrame()
{
	frameT = new JFrame();
	frameT.getContentPane().setBackground(new Color(128, 0, 0));
	
	JPanel panel = new JPanel();
	panel.setBackground(Color.BLACK);
	frameT.getContentPane().add(panel, BorderLayout.CENTER);
	panel.setLayout(null);
	frameT.setResizable(false);
	frameT.setBounds(70, 0, 500,500);
	frameT.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frameT.getContentPane().add(panel);
	
	textFieldT.setFont(new Font("Times New Roman", Font.BOLD, 15));
	textFieldT.setForeground(new Color(0, 0, 0));
	textFieldT.setBackground(new Color(204, 204, 153));
	textFieldT.setBounds(120, 120, 253, 27);
	panel.add(textFieldT);
	textFieldT.setColumns(10);
	
	btnAccesatiInterogarea.setFont(new Font("Times New Roman", Font.BOLD, 15));
	btnAccesatiInterogarea.setBounds(150, 176, 194, 27);
	panel.add(btnAccesatiInterogarea);
	
	txtIntroducetiGenul.setEditable(false);
	txtIntroducetiGenul.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
	txtIntroducetiGenul.setText("Introduceti genul:");
	txtIntroducetiGenul.setBounds(120, 59, 140, 26);
	panel.add(txtIntroducetiGenul);
	txtIntroducetiGenul.setColumns(10);
	
	JLabel lblNewLabel = new JLabel("New label");
	lblNewLabel.setIcon(new ImageIcon("C:\\Users\\lucia\\OneDrive\\Desktop\\deschisa.jpg"));
	lblNewLabel.setBounds(-14, -29, 552, 500);
	panel.add(lblNewLabel);
	frameT.add(panel);
	frameT.setVisible(true);

}
	
}
