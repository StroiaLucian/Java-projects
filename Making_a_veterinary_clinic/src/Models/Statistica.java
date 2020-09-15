package Models;

import java.util.ArrayList;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import javafx.util.Pair;

public class Statistica {

	private ArrayList<Animal> animale= new ArrayList<Animal>();
	private String dupaCe= "";
	public void AdaugareAnimale(Animal animal)
    {
		animale.add(animal);
    }
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public  ArrayList<Pair<Integer, String>> calculareStatistici(String dupaCe)
	{
		ArrayList<Pair<Integer, String>> ceReturnez = new ArrayList<>();
		int[] numar= new int[animale.size()];
		String[] detaliu= new String[animale.size()];
		for(int k=0;k<animale.size();k++)
			numar[k]=0;
		for(int i=0;i<animale.size();i++)
		{
			for(int j=0;j<animale.size();j++)
			{	if(dupaCe.equalsIgnoreCase("diagnostic")) {
				if(animale.get(i).getDiagnostic().equalsIgnoreCase(animale.get(j).getDiagnostic())){
					
					numar[i]++;
					detaliu[i]=animale.get(i).getDiagnostic();
				}
			}else if(dupaCe.equalsIgnoreCase("simptome"))
			{
				if(animale.get(i).getSimptome().equalsIgnoreCase(animale.get(j).getSimptome())){
					
					numar[i]++;
					detaliu[i]=animale.get(i).getSimptome();
				}
			}
			}
		}		
		for(int i=0;i<animale.size();i++)
			for(int j=0;j<animale.size();j++)
			{
				if(numar[i]==numar[j] && detaliu[i].equalsIgnoreCase(detaliu[j]))
				{	
					if(!ceReturnez.contains(new Pair(numar[i],detaliu[i])))
					ceReturnez.add(new Pair(numar[i],detaliu[i]));
				}
			}
		
		return ceReturnez;	
	}
	
	@SuppressWarnings("rawtypes")
	private PieDataset createDataset(ArrayList<Pair<Integer, String>> ceAfisez) {
	    DefaultPieDataset dataset = new DefaultPieDataset( );
	    for(Pair a:ceAfisez)
	  	  dataset.setValue(a.getValue()+"",(Number)a.getKey());
	    return dataset;         
	 }
	@SuppressWarnings({ "unused", "rawtypes" })
	private CategoryDataset  createDataset2(ArrayList<Pair<Integer, String>> ceAfisez) {
		DefaultCategoryDataset dataset= new DefaultCategoryDataset();
		for(Pair a:ceAfisez)
		  	  dataset.setValue((Number)a.getKey(),a.getValue()+"",a.getValue()+"");
		    return dataset; 
	}
	 
	 private JFreeChart createChart( String name,PieDataset dataset ) {
	    JFreeChart chart = ChartFactory.createPieChart(      
	       name, 
	       dataset,        
	       true,              
	       true, 
	       false);
	    return chart;
	 }
	 public ChartPanel createDemoPanel() {
		 ArrayList<Pair<Integer, String>> ceAfisez = calculareStatistici(dupaCe);
		 JFreeChart chart = createChart(dupaCe,createDataset(ceAfisez) ); 
	    ChartPanel chartPanel = new ChartPanel((JFreeChart) null);
		chartPanel.removeAll();
	    chartPanel.setChart(chart);
		chartPanel.setBounds(260, 362, 450, 280);
		return chartPanel; 
	 }
	 
	 public ChartPanel createDemoPanel2( ) {
		    ArrayList<Pair<Integer, String>> ceAfisez=calculareStatistici(dupaCe);
		    CategoryDataset dataset =  createDataset2(ceAfisez);
		    
		    //Create chart
		    JFreeChart chart=ChartFactory.createBarChart(
		    		dupaCe, //Chart Title
		        "tipuri de "+dupaCe, // Category axis
		        "Numar de "+ dupaCe, // Value axis
		        dataset,
		        PlotOrientation.VERTICAL,
		        true,true,false
		       );
		    ChartPanel chartPanel2 = new ChartPanel((JFreeChart) null);
			chartPanel2.removeAll();
		    chartPanel2.setChart(chart);
			chartPanel2.setBounds(712, 362, 450, 280);
		    return chartPanel2;
	 }

	public String getDupaCe() {
		return dupaCe;
	}

	public void setDupaCe(String dupaCe2) {
		// TODO Auto-generated method stub
		this.dupaCe = dupaCe2;

	}
	 
}
