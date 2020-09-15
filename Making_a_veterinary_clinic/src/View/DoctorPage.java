package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import javafx.util.Pair;

public class DoctorPage {
private JDesktopPane desktopPane = new JDesktopPane();
private JFrame frameDoc=new JFrame();
private JPanel contentPane= new JPanel();
private JButton btnVizualizareStatisticiDoctor = new JButton("Vizualizare statistici");
private JButton btnActualizareFiseMedicaleDoctor = new JButton("Actualizare fi\u0219e medicale animale");
private JButton btnVizualizareFiseMedicaleDoctor = new JButton("Vizualizare fi\u0219e medicale animale");
private JButton btnFiltrareAnimaleDoctor = new JButton("Filtrare animale");
private JButton btnVizualizareConsultaiiDoctor = new JButton("Vizualizare program");
private JButton btnSalvareProgramconsultaii = new JButton("Salvare program");
@SuppressWarnings("rawtypes")
private JComboBox comboBoxCriteriu = new JComboBox();
@SuppressWarnings("rawtypes")
private JComboBox comboBoxStatistici= new JComboBox();
private JTextField textFieldCriteriu = new JTextField();
private JLabel lblNewLabel = new JLabel("");
private JTable table;
private JTable table2;

private JPanel 	panelTabel= new JPanel();
private JPanel panelProgram= new JPanel();
private JPanel panelChart1= new JPanel();
private JPanel panelChart2= new JPanel();
private JPanel panelChart3= new JPanel();


@SuppressWarnings({ "unchecked", "rawtypes" })
public DoctorPage() {
	frameDoc.setBounds(80, 30, 1200, 700);
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	contentPane.setLayout(new BorderLayout(0, 0));
	frameDoc.setContentPane(contentPane);
	
	
	desktopPane.setBackground(SystemColor.text);
	contentPane.add(desktopPane, BorderLayout.CENTER);
	


	btnVizualizareFiseMedicaleDoctor.setForeground(SystemColor.activeCaptionText);
	btnVizualizareFiseMedicaleDoctor.setBackground(SystemColor.textHighlight);
	btnVizualizareFiseMedicaleDoctor.setBounds(23, 193, 230, 23);
	desktopPane.add(btnVizualizareFiseMedicaleDoctor);
	

	btnActualizareFiseMedicaleDoctor.setForeground(SystemColor.activeCaptionText);
	btnActualizareFiseMedicaleDoctor.setBackground(SystemColor.textHighlight);
	btnActualizareFiseMedicaleDoctor.setBounds(23, 227, 230, 23);
	desktopPane.add(btnActualizareFiseMedicaleDoctor);
	
	btnFiltrareAnimaleDoctor.setForeground(SystemColor.activeCaptionText);
	btnFiltrareAnimaleDoctor.setBackground(SystemColor.textHighlight);
	btnFiltrareAnimaleDoctor.setBounds(23, 261, 230, 23);
	desktopPane.add(btnFiltrareAnimaleDoctor);
	

	btnVizualizareStatisticiDoctor.setForeground(SystemColor.activeCaptionText);
	btnVizualizareStatisticiDoctor.setBackground(SystemColor.textHighlight);
	btnVizualizareStatisticiDoctor.setBounds(23, 295, 230, 23);
	desktopPane.add(btnVizualizareStatisticiDoctor);

	
	btnVizualizareConsultaiiDoctor.setForeground(SystemColor.activeCaptionText);
	btnVizualizareConsultaiiDoctor.setBackground(SystemColor.textHighlight);
	btnVizualizareConsultaiiDoctor.setBounds(23, 329, 230, 23);
	desktopPane.add(btnVizualizareConsultaiiDoctor);
	
	
	btnSalvareProgramconsultaii.setForeground(Color.BLACK);
	btnSalvareProgramconsultaii.setBackground(SystemColor.textHighlight);
	btnSalvareProgramconsultaii.setBounds(263, 329, 230, 23);
	desktopPane.add(btnSalvareProgramconsultaii);
	
	
	comboBoxCriteriu.setModel(new DefaultComboBoxModel(new String[] {"diagnostic", "tratament"}));
	comboBoxCriteriu.setBounds(263, 261, 87, 23);
	desktopPane.add(comboBoxCriteriu);
	
	comboBoxStatistici.setModel(new DefaultComboBoxModel(new String[] {"diagnostic", "simptome"}));
	comboBoxStatistici.setBounds(263, 295, 87, 23);
	desktopPane.add(comboBoxStatistici);
	

	lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Stroia Lucian Dorin\\Desktop\\Proiectarea sistemelor\\Tema 1\\images\\docnou.jpg"));
	lblNewLabel.setBounds(-17, 11, 300, 300);
	desktopPane.add(lblNewLabel);
	
	panelTabel.setBounds(500, 23, 664, 331);
	panelTabel.setVisible(false);
	desktopPane.add(panelTabel);
	
	panelProgram.setBounds(4, 362, 249, 280);
	desktopPane.add(panelProgram);
	
	panelChart1.setBounds(260, 362, 450, 280);
	panelChart1.setVisible(false);
	desktopPane.add(panelChart1);
	
	panelChart2.setBounds(712, 362, 450, 280);
	panelChart2.setVisible(false);
	desktopPane.add(panelChart2);
	

	
	textFieldCriteriu.setBounds(360, 262, 130, 23);
	desktopPane.add(textFieldCriteriu);
	textFieldCriteriu.setColumns(10);
	frameDoc.setVisible(true);
	frameDoc.setResizable(false);

}
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
               return true;
               else return false;
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

public JPanel adaugareProgram(String header,ArrayList<String>animale,boolean sePoate) {
	panelProgram.removeAll();
	table2=new JTable();
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
               if(column==3 || column==2 || column==1)
               return true;
               else return false;
            }
        };
    }
    table2.setModel(tableModel);
    table2.setBackground(new Color(169, 204, 227));
    int contor=0;
    maxime[0]=25;
    maxime[1]=25;
    maxime[2]=25;
    maxime[3]=25;
    for (int width : maxime) {
        TableColumn column = table2.getColumnModel().getColumn(contor);
        column.setMinWidth(width);
        column.setMaxWidth(width*10);
        column.setPreferredWidth(width*10);
        contor++;
    }
    JScrollPane scrollPane = new JScrollPane(table2);
    
    panelProgram.setLayout(new BorderLayout());
    panelProgram.add(scrollPane);
    panelProgram.setPreferredSize(new Dimension(500, 200));
    panelProgram.setVisible(true);
    panelProgram.revalidate();
    return panelProgram;
}

public void addlistener5(ActionListener a)
{
	btnVizualizareConsultaiiDoctor.addActionListener(a);
}
public void addlistener4(ActionListener a)
{
	btnVizualizareStatisticiDoctor.addActionListener(a);
}
public void addlistener2(ActionListener a)
{
	btnActualizareFiseMedicaleDoctor.addActionListener(a);
}
public void addlistener1(ActionListener a)
{
	btnVizualizareFiseMedicaleDoctor.addActionListener(a);
}
public void addlistener3(ActionListener a)
{
	btnFiltrareAnimaleDoctor.addActionListener(a);
}
public void addlistener6(ActionListener a)
{
	btnSalvareProgramconsultaii.addActionListener(a);
}

public JFrame getFrameDoc() {
	return frameDoc;
}
public void setFrameDoc(JFrame frameDoc) {
	this.frameDoc = frameDoc;
}
public JPanel getPanelTabel() {
	return panelTabel;
}
public void setPanelTabel(JPanel panelTabel) {
	this.panelTabel = panelTabel;
}
public String getComboBoxCriteriu() {
	return comboBoxCriteriu.getSelectedItem()+"";
}
public String getComboBoxStatistici() {
	return comboBoxStatistici.getSelectedItem()+"";
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
public JPanel getPanelProgram() {
	return panelProgram;
}
public void setPanelProgram(JPanel panelProgram) {
	this.panelProgram = panelProgram;
}
public JPanel getPanelChart1() {
	return panelChart1;
}
public void setPanelChart1(JPanel panelChart1) {
	this.panelChart1 = panelChart1;
}
public JPanel getPanelChart2() {
	return panelChart2;
}
public void setPanelChart2(JPanel panelChart2) {
	this.panelChart2 = panelChart2;
}
public JPanel getPanelChart3() {
	return panelChart3;
}
public void setPanelChart3(JPanel panelChart3) {
	this.panelChart3 = panelChart3;
}
public JTable getTable2() {
	return table2;
}
public void setTable2(JTable table2) {
	this.table2 = table2;
}

public void chart1(ChartPanel a)
{
	panelChart1.removeAll();
	panelChart1.setLayout(new BorderLayout());
    panelChart1.add(a);
    panelChart1.setVisible(true);
    panelChart1.revalidate();
}
public void chart2(ChartPanel a)
{
	panelChart2.removeAll();
	panelChart2.setLayout(new BorderLayout());
    panelChart2.add(a);
    panelChart2.setVisible(true);
    panelChart2.revalidate();
}
}
