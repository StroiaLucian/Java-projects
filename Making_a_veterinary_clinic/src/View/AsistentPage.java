package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
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

import org.jdesktop.swingx.JXDatePicker;

public class AsistentPage {
	private JFrame frameAsistent=new JFrame();
	private JPanel contentPane= new JPanel();
	private JButton btnFiltrareAnimaleAsistent = new JButton("Filtrare animale");
	private JButton btnPlanificareConsultatiiAsistent = new JButton("Planificare consulta\u021Bii animale");
	private JButton btnSalvareRapoarteAsistent = new JButton("Salvare rapoarte/liste");
	private JButton btnStergereFiseMedicaleAsistent = new JButton("\u0218tergere fi\u0219e medicale animale");
	private JButton btnEditareFiseMedicaleAsistent = new JButton("Editare fi\u0219e medicale animale");
	private JButton btnVizualizareFiseMedicaleAsistent = new JButton("Vizualizare fi\u0219e medicale animale");
	private JButton btnCreareFiseMedicaleAsistent = new JButton("Creare fi\u0219e medicale animale");
	private JTextField texIntroducereID;
	private JTextField textIntroducereNume;
	private JTextField textIntroducereSpecie;
	private JTextField textIntroducereVarsta;
	private JTextField textIntroducereSimptome;
	private JTextField textIntroducereDiagnostic;
	private JTextField txtId;
	private JTextField txtNume;
	private JTextField txtSpecie;
	private JTextField txtVarsta;
	private JTextField txtSimptome;
	private JTextField txtDiagnostic;
	private JTextField textIntroducereTratament;
	private JTextField textIntroducereDoctor;
	private JTextField txtTratament;
	private JTextField txtDoctor;
	private JTextField textFieldSucces;
	private JTextField textFieldSucces2;
	private JTextField textFieldSucces3;
	private JTable table;
	private JPanel 	panelTabel= new JPanel();
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxFiltrare= new JComboBox();
	private JComboBox comboOra= new JComboBox();
	private JComboBox comboSalvare= new JComboBox();

	private JTextField textFieldCriteriu;
	private JPanel panel1= new JPanel();

	private JXDatePicker picker = new JXDatePicker();
	@SuppressWarnings({ "unchecked", "rawtypes", "deprecation" })
	public AsistentPage() {
		frameAsistent.setBounds(80, 30, 1200, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		frameAsistent.setContentPane(contentPane);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(SystemColor.text);
		contentPane.add(desktopPane, BorderLayout.CENTER);
		texIntroducereID = new JTextField();
		texIntroducereID.setBackground(new Color(255, 218, 185));
		texIntroducereID.setBounds(111, 23, 156, 20);
		desktopPane.add(texIntroducereID);
		texIntroducereID.setColumns(10);
		
		textIntroducereNume = new JTextField();
		textIntroducereNume.setBackground(new Color(255, 218, 185));
		textIntroducereNume.setColumns(10);
		textIntroducereNume.setBounds(111, 54, 156, 20);
		desktopPane.add(textIntroducereNume);
		
		textIntroducereSpecie = new JTextField();
		textIntroducereSpecie.setBackground(new Color(255, 218, 185));
		textIntroducereSpecie.setColumns(10);
		textIntroducereSpecie.setBounds(111, 85, 156, 20);
		desktopPane.add(textIntroducereSpecie);
		
		textIntroducereVarsta = new JTextField();
		textIntroducereVarsta.setBackground(new Color(255, 218, 185));
		textIntroducereVarsta.setColumns(10);
		textIntroducereVarsta.setBounds(111, 116, 156, 20);
		desktopPane.add(textIntroducereVarsta);

		textIntroducereDoctor = new JTextField();
		textIntroducereDoctor.setColumns(10);
		textIntroducereDoctor.setBackground(new Color(255, 218, 185));
		textIntroducereDoctor.setBounds(111, 147, 156, 20);
		desktopPane.add(textIntroducereDoctor);
		
		
		textIntroducereSimptome = new JTextField();
		textIntroducereSimptome.setBackground(new Color(255, 218, 185));
		textIntroducereSimptome.setColumns(10);
		textIntroducereSimptome.setBounds(111, 178, 156, 20);
		
		textIntroducereDiagnostic = new JTextField();
		textIntroducereDiagnostic.setBackground(new Color(255, 218, 185));
		textIntroducereDiagnostic.setColumns(10);
		textIntroducereDiagnostic.setBounds(111, 209, 156, 20);
		
		
		textIntroducereTratament = new JTextField();
		textIntroducereTratament.setColumns(10);
		textIntroducereTratament.setBackground(new Color(255, 218, 185));
		textIntroducereTratament.setBounds(111, 240, 156, 20);
		
		
		txtSimptome = new JTextField();
		txtSimptome.setBackground(new Color(255, 192, 203));
		txtSimptome.setEditable(false);
		txtSimptome.setHorizontalAlignment(SwingConstants.RIGHT);
		txtSimptome.setText("Simptome:");
		txtSimptome.setColumns(10);
		txtSimptome.setBounds(37, 178, 75, 20);
	
		
		txtDiagnostic = new JTextField();
		txtDiagnostic.setBackground(new Color(255, 192, 203));
		txtDiagnostic.setEditable(false);
		txtDiagnostic.setHorizontalAlignment(SwingConstants.RIGHT);
		txtDiagnostic.setText("Diagnostic:");
		txtDiagnostic.setColumns(10);
		txtDiagnostic.setBounds(37, 209, 75, 20);

		
		txtTratament = new JTextField();
		txtTratament.setText("Tratament:");
		txtTratament.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTratament.setEditable(false);
		txtTratament.setColumns(10);
		txtTratament.setBackground(new Color(255, 192, 203));
		txtTratament.setBounds(37, 240, 75, 20);

		
		desktopPane.add(textIntroducereSimptome);
		desktopPane.add(textIntroducereDiagnostic);
		desktopPane.add(textIntroducereTratament);
		desktopPane.add(txtSimptome);
		desktopPane.add(txtDiagnostic);
		desktopPane.add(txtTratament);
		
		txtId = new JTextField();
		txtId.setBackground(new Color(255, 192, 203));
		txtId.setEditable(false);
		txtId.setHorizontalAlignment(SwingConstants.RIGHT);
		txtId.setText("Id:");
		txtId.setColumns(10);
		txtId.setBounds(37, 23, 75, 20);
		desktopPane.add(txtId);
		
		txtNume = new JTextField();
		txtNume.setBackground(new Color(255, 192, 203));
		txtNume.setEditable(false);
		txtNume.setHorizontalAlignment(SwingConstants.RIGHT);
		txtNume.setText("Nume:");
		txtNume.setColumns(10);
		txtNume.setBounds(37, 54, 75, 20);
		desktopPane.add(txtNume);
		
		txtSpecie = new JTextField();
		txtSpecie.setBackground(new Color(255, 192, 203));
		txtSpecie.setEditable(false);
		txtSpecie.setHorizontalAlignment(SwingConstants.RIGHT);
		txtSpecie.setText("Specie:");
		txtSpecie.setColumns(10);
		txtSpecie.setBounds(37, 85, 75, 20);
		desktopPane.add(txtSpecie);
		
		txtVarsta = new JTextField();
		txtVarsta.setBackground(new Color(255, 192, 203));
		txtVarsta.setEditable(false);
		txtVarsta.setHorizontalAlignment(SwingConstants.RIGHT);
		txtVarsta.setText("Varsta:");
		txtVarsta.setColumns(10);
		txtVarsta.setBounds(37, 116, 75, 20);
		desktopPane.add(txtVarsta);
		
		txtDoctor = new JTextField();
		txtDoctor.setText("Doctor:");
		txtDoctor.setHorizontalAlignment(SwingConstants.RIGHT);
		txtDoctor.setEditable(false);
		txtDoctor.setColumns(10);
		txtDoctor.setBackground(new Color(255, 192, 203));
		txtDoctor.setBounds(37, 147, 75, 20);
		desktopPane.add(txtDoctor);

		btnFiltrareAnimaleAsistent.setForeground(SystemColor.activeCaptionText);
		btnFiltrareAnimaleAsistent.setBackground(new Color(255, 218, 185));
		btnFiltrareAnimaleAsistent.setBounds(37, 480, 230, 23);
		desktopPane.add(btnFiltrareAnimaleAsistent);
		
		btnPlanificareConsultatiiAsistent.setForeground(SystemColor.activeCaptionText);
		btnPlanificareConsultatiiAsistent.setBackground(new Color(255, 218, 185));
		btnPlanificareConsultatiiAsistent.setBounds(37, 446, 230, 23);
		desktopPane.add(btnPlanificareConsultatiiAsistent);
		


		btnSalvareRapoarteAsistent.setForeground(SystemColor.activeCaptionText);
		btnSalvareRapoarteAsistent.setBackground(new Color(255, 218, 185));
		btnSalvareRapoarteAsistent.setBounds(37, 514, 230, 23);
		desktopPane.add(btnSalvareRapoarteAsistent);
		
		comboSalvare.setModel(new DefaultComboBoxModel(new String[] {"Animale","Doctori"}));
		comboSalvare.setBounds(277, 514, 86, 23);
		desktopPane.add(comboSalvare);
		
		textFieldSucces3 = new JTextField();
		textFieldSucces3.setEditable(false);
		textFieldSucces3.setBounds(373, 514, 96, 23);;
		desktopPane.add(textFieldSucces3);
		//(373, 480, 96, 22);
		
		btnStergereFiseMedicaleAsistent.setForeground(Color.BLACK);
		btnStergereFiseMedicaleAsistent.setBackground(new Color(255, 218, 185));
		btnStergereFiseMedicaleAsistent.setBounds(37, 413, 230, 23);
		desktopPane.add(btnStergereFiseMedicaleAsistent);
		

		btnEditareFiseMedicaleAsistent.setForeground(Color.BLACK);
		btnEditareFiseMedicaleAsistent.setBackground(new Color(255, 218, 185));
		btnEditareFiseMedicaleAsistent.setBounds(37, 379, 230, 23);
		desktopPane.add(btnEditareFiseMedicaleAsistent);
		

		btnVizualizareFiseMedicaleAsistent.setForeground(Color.BLACK);
		btnVizualizareFiseMedicaleAsistent.setBackground(new Color(255, 218, 185));
		btnVizualizareFiseMedicaleAsistent.setBounds(37, 345, 230, 23);
		desktopPane.add(btnVizualizareFiseMedicaleAsistent);
		

		
		btnCreareFiseMedicaleAsistent.setForeground(Color.BLACK);
		btnCreareFiseMedicaleAsistent.setBackground(new Color(255, 218, 185));
		btnCreareFiseMedicaleAsistent.setBounds(37, 311, 230, 23);
		desktopPane.add(btnCreareFiseMedicaleAsistent);
		
		panelTabel.setBounds(500, 23, 664, 331);
		panelTabel.setVisible(false);
		desktopPane.add(panelTabel);
		
		textFieldSucces = new JTextField();
		textFieldSucces.setEditable(false);
		textFieldSucces.setBounds(277, 312, 180, 20);
		desktopPane.add(textFieldSucces);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Stroia Lucian Dorin\\Desktop\\Proiectarea sistemelor\\Tema 1\\images\\doc2.jpg"));
		lblNewLabel.setBounds(292, -23, 300, 300);
		desktopPane.add(lblNewLabel);
		
		comboBoxFiltrare.setModel(new DefaultComboBoxModel(new String[] {"tip", "diagnostic", "doctor"}));
		comboBoxFiltrare.setBounds(277, 480, 86, 22);
		desktopPane.add(comboBoxFiltrare);
		
		textFieldCriteriu = new JTextField();
		textFieldCriteriu.setBounds(373, 480, 96, 22);
		desktopPane.add(textFieldCriteriu);
		textFieldCriteriu.setColumns(10);
		
		picker.setBounds(277, 446, 110, 22);
        picker.setDate(Calendar.getInstance().getTime());
        picker.setFormats(new SimpleDateFormat("dd.MM.yyyy"));
        desktopPane.add(picker);
        comboOra.setModel(new DefaultComboBoxModel(new String[] {"08-10", "10-12", "12-14","14-16","16-18","18-20"}));
        comboOra.setBounds(400, 446, 68, 22);
		desktopPane.add(comboOra);
		textFieldSucces2= new JTextField();
		textFieldSucces2.setBounds(475, 446, 86, 22);
		textFieldSucces2.setEditable(false);
		desktopPane.add(textFieldSucces2);

		frameAsistent.setVisible(true);
		frameAsistent.setResizable(false);
	}
	@SuppressWarnings("serial")
	public JPanel adaugareTabel(String header,ArrayList<String>animale,boolean sePoate) {
	    //headers for the table
		panelTabel.removeAll();
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
	    int maxime[]=new int[helperString.length];
	    for(int o=0;o<helperString.length;o++)
	    		maxime[o]=1;
	    for(String s:animale)
	    {    
	    if(s!="\n")
	    {
	    String rand[]= s.split(",");
	    for(int j=0;j<helperString.length;j++)
	    {	
	    	data[i][j]=rand[j].substring(rand[j].lastIndexOf("=")+1);
	    	if(rand[j].substring(rand[j].lastIndexOf("=")+1).length()>=maxime[j])
	    		{
	    		maxime[j]=rand[j].substring(rand[j].lastIndexOf("=")+1).length();
	    		}
	    		
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
	               if(column==4 || column==5 || column== 6)
	               return false;
	               else return true;
	            }
	        };
	    }
	    table.setModel(tableModel);
	    table.setBackground(new Color(169, 204, 227));
	    int contor=0;
	    maxime[0]=3;
	    for (int width : maxime) {
	    	if(width<2 )
	    	width=10;
	        TableColumn column = table.getColumnModel().getColumn(contor);
	        column.setMinWidth(width);
	        column.setMaxWidth(width*10);
	        column.setPreferredWidth(width*10);
	        contor++;
	        
	    }
	    JScrollPane scrollPane = new JScrollPane(table);
	    panelTabel.setLayout(new BorderLayout());
	    panelTabel.add(scrollPane);
	    panelTabel.setPreferredSize(new Dimension(500, 200));
	    panelTabel.setVisible(true);
	    panelTabel.revalidate();
	    return panelTabel;
	}
	public void addlistener5(ActionListener a)
	{
		btnFiltrareAnimaleAsistent.addActionListener(a);
	}
	public void addlistener6(ActionListener a)
	{
		btnPlanificareConsultatiiAsistent.addActionListener(a);
	}
	public void addlistener7(ActionListener a)
	{
		btnSalvareRapoarteAsistent.addActionListener(a);
	}
	public void addlistener4(ActionListener a)
	{
		btnStergereFiseMedicaleAsistent.addActionListener(a);
	}
	public void addlistener3(ActionListener a)
	{
		btnEditareFiseMedicaleAsistent.addActionListener(a);
	}
	public void addlistener2(ActionListener a)
	{
		btnVizualizareFiseMedicaleAsistent.addActionListener(a);
	}
	public void addlistener1(ActionListener a)
	{
		btnCreareFiseMedicaleAsistent.addActionListener(a);
	}
	public JFrame getFrameAsistent() {
		return frameAsistent;
	}
	public void setFrameAsistent(JFrame frameAsistent) {
		this.frameAsistent = frameAsistent;
	}
	public void setTexIntroducereID(String texIntroducereID) {
		this.texIntroducereID.setText(texIntroducereID);
	}

	public void setTextIntroducereNume(String textIntroducereNume) {
		this.textIntroducereNume.setText(textIntroducereNume);
	}

	public void setTextIntroducereSpecie(String textIntroducereSpecie) {
		this.textIntroducereSpecie.setText(textIntroducereSpecie);
	}

	public void setTextIntroducereVarsta(String textIntroducereVarsta) {
		this.textIntroducereVarsta.setText(textIntroducereVarsta);
	}

	public void setTextIntroducereSimptome(String textIntroducereSimptome) {
		this.textIntroducereSimptome.setText(textIntroducereSimptome);
	}

	public void setTextIntroducereDiagnostic(String textIntroducereDiagnostic) {
		this.textIntroducereDiagnostic.setText(textIntroducereDiagnostic);
	}

	public void setTextIntroducereTratament(String textIntroducereTratament) {
		this.textIntroducereTratament.setText(textIntroducereTratament);
	}

	public void setTextIntroducereDoctor(String textIntroducereDoctor) {
		this.textIntroducereDoctor.setText(textIntroducereDoctor);
	}

	public String getTexIntroducereID() {
		return texIntroducereID.getText();
	}

	public String getTextIntroducereNume() {
		return textIntroducereNume.getText();
	}

	public String getTextIntroducereSpecie() {
		return textIntroducereSpecie.getText();
	}

	public String getTextIntroducereVarsta() {
		return textIntroducereVarsta.getText();
	}

	public String getTextIntroducereSimptome() {
		return textIntroducereSimptome.getText();
	}

	public String getTextIntroducereDiagnostic() {
		return textIntroducereDiagnostic.getText();
	}

	public String getTextIntroducereTratament() {
		return textIntroducereTratament.getText();
	}

	public String getTextIntroducereDoctor() {
		return textIntroducereDoctor.getText();
	}
	public String getTextFieldSucces() {
		return textFieldSucces.getText();
	}
	public void setTextFieldSucces(String textFieldSucces) {
		this.textFieldSucces.setText(textFieldSucces);

		if(textFieldSucces.equalsIgnoreCase("SUCCES!"))
		this.textFieldSucces.setForeground(Color.GREEN);
		else if(textFieldSucces.equalsIgnoreCase("EROARE!")) this.textFieldSucces.setForeground(Color.RED);

	}
	public JPanel getPanelTabel() {
		return panelTabel;
	}
	public void setPanelTabel(JPanel panelTabel) {
		this.panelTabel = panelTabel;
	}
	public String getComboBoxCriteriu() {
		return comboBoxFiltrare.getSelectedItem()+"";
	}

	public String getTextFieldCriteriu() {
		return textFieldCriteriu.getText();
	}
	public void setTextFieldCriteriu(String textFieldCriteriu) {
		this.textFieldCriteriu.setText(textFieldCriteriu);
	}
	public JTable getTable() {
		return table;
	}
	public void setTable(JTable table) {
		this.table = table;
	}
	public JXDatePicker getPicker() {
		return picker;
	}
	public void setPicker(JXDatePicker picker) {
		this.picker = picker;
	}
	public JComboBox getComboOra() {
		return comboOra;
	}
	public void setComboOra(JComboBox comboOra) {
		this.comboOra = comboOra;
	}
	public JComboBox getComboSalvare() {
		return comboSalvare;
	}

	
	public String getTextFieldSucces2() {
		return textFieldSucces2.getText();
	}
	public void setTextFieldSucces2(String textFieldSucces2) {
		this.textFieldSucces2.setText(textFieldSucces2);
		if(textFieldSucces2.equalsIgnoreCase("SUCCES!"))
			this.textFieldSucces2.setForeground(Color.GREEN);
			else if(textFieldSucces2.equalsIgnoreCase("EROARE!")) this.textFieldSucces2.setForeground(Color.RED);
	}
	
	public String getTextFieldSucces3() {
		return textFieldSucces3.getText();
	}
	public void setTextFieldSucces3(String textFieldSucces3) {
		this.textFieldSucces3.setText(textFieldSucces3);
		if(textFieldSucces3.equalsIgnoreCase("SUCCES!"))
			this.textFieldSucces3.setForeground(Color.GREEN);
			else if(textFieldSucces3.equalsIgnoreCase("EROARE!")) this.textFieldSucces3.setForeground(Color.RED);
	}
	
	
	
}
