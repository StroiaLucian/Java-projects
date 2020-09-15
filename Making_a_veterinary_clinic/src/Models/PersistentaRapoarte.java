package Models;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class PersistentaRapoarte extends Persistenta{
	ArrayList<Animal> lista_animale= new ArrayList<Animal>();
	ArrayList<Utilizator> lista_doctori= new ArrayList<Utilizator>();
	private String numeFisierCSVAnimale="";
	private String numeFisierXMLAnimale="";
	private String numeFisierJSONDoctori="";
	private String numeFisierCSVDoctori="";
	private String numeFisierXMLDoctori="";
	//rapoarte4.json
	public PersistentaRapoarte(String numeFisier) {
		this.nume=numeFisier;
		this.numeFisierCSVAnimale=numeFisier.substring(0,9)+".csv";
		this.numeFisierXMLAnimale=numeFisier.substring(0,9)+".xml";
		this.numeFisierJSONDoctori=numeFisier.substring(0,9)+"Doctori.json";
		this.numeFisierCSVDoctori=numeFisier.substring(0,9)+"Doctori.csv";
		this.numeFisierXMLDoctori=numeFisier.substring(0,9)+"Doctori.xml";
	}
	@SuppressWarnings("unchecked")
	public void salvareRapoarte(ArrayList<Animal> lista_animale,ArrayList<Utilizator> lista_doctori)
	{
		if(!lista_animale.isEmpty())
		{	
			salvareRapoarteXML(lista_animale,lista_doctori);
			salvareRapoarteCSV(lista_animale,lista_doctori);
			JSONArray jsonArray= new JSONArray(); 
			this.lista_animale=lista_animale;
			for(Animal a:this.lista_animale)
			{
				JSONObject jsonObject= new JSONObject();
				jsonObject.put("Id",a.getIdentificator());
				jsonObject.put("Nume",a.getNume());
				jsonObject.put("Tip",a.getTip());
				jsonObject.put("Varsta",a.getVarsta());
				jsonObject.put("Simptome",a.getSimptome());
				jsonObject.put("Diagnostic",a.getDiagnostic());
				jsonObject.put("Tratament",a.getTratament());
				jsonObject.put("Doctor",a.getDoctor());
				jsonArray.add(jsonObject);

			}
			try {
		         FileWriter file = new FileWriter(this.nume);
		         file.write(jsonArray.toJSONString());
		         file.close();
		      } catch (IOException e) {
		         // TODO Auto-generated catch block
		         e.printStackTrace();
		      }
		      System.out.println("JSON file created with succes! ");
			
		}else if(!lista_doctori.isEmpty())
		{
			
			salvareRapoarteXML(lista_animale,lista_doctori);
			salvareRapoarteCSV(lista_animale,lista_doctori);
			JSONArray jsonArray= new JSONArray(); 
			this.lista_doctori=lista_doctori;
			for(Utilizator a:this.lista_doctori)
			{
				JSONObject jsonObject= new JSONObject();
				jsonObject.put("Id",a.getId()+"");
				jsonObject.put("Nume",a.getNume());
				jsonObject.put("Varsta",a.getVarsta()+"");
				jsonObject.put("CNP",a.getCnp());
				jsonArray.add(jsonObject);

			}
			try {
		         FileWriter file = new FileWriter(numeFisierJSONDoctori);
		         file.write(jsonArray.toJSONString());
		         file.close();
		      } catch (IOException e) {
		         // TODO Auto-generated catch block
		         e.printStackTrace();
		      }
		      System.out.println("JSON file created with succes! ");
		}
	}
	
	public void salvareRapoarteXML(ArrayList<Animal> lista_animale,ArrayList<Utilizator> lista_doctori)
	{
		if(!lista_animale.isEmpty())
		{	
		try {

			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// root elements
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("Animale");
			doc.appendChild(rootElement);
			String[] caracteristici= new String[] {"Nume","Tip","Varsta","Simptome","Diagnostic","Tratament","Doctor"};
			
			// staff elements
			for(Animal a:lista_animale)
			{
				String[] valori_caracteristici= new String[] { a.getNume(), a.getTip(), a.getVarsta()+"",a.getSimptome(),a.getDiagnostic(),a.getTratament(),a.getDoctor()};
				Element staff = doc.createElement("Animal");
				rootElement.appendChild(staff);
				Attr attr = doc.createAttribute("id");
				attr.setValue(a.getIdentificator()+"");
				staff.setAttributeNode(attr);
				for(int i=0;i<7;i++) {
				Element caracteristica = doc.createElement(caracteristici[i]);
				caracteristica.appendChild(doc.createTextNode(valori_caracteristici[i]));
				staff.appendChild(caracteristica);
				}
			}
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(numeFisierXMLAnimale));

			// Output to console for testing
			// StreamResult result = new StreamResult(System.out);

			transformer.transform(source, result);

			System.out.println("XML file created with succes!");

		  } catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		  } catch (TransformerException tfe) {
			tfe.printStackTrace();
		  }
		}else if(!lista_doctori.isEmpty()) {
			try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// root elements
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("Doctori");
			doc.appendChild(rootElement);
			String[] caracteristici= new String[] {"Nume","Varsta","CNP"};
			
			// staff elements
			for(Utilizator a:lista_doctori)
			{
				String[] valori_caracteristici= new String[] {a.getNume(),a.getVarsta()+"",a.getCnp()};
				Element staff = doc.createElement("Doctor");
				rootElement.appendChild(staff);
				Attr attr = doc.createAttribute("id");
				attr.setValue(a.getId()+"");
				staff.setAttributeNode(attr);
				for(int i=0;i<3;i++) {
				Element caracteristica = doc.createElement(caracteristici[i]);
				caracteristica.appendChild(doc.createTextNode(valori_caracteristici[i]));
				staff.appendChild(caracteristica);
				}
			}
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(numeFisierXMLDoctori));

			// Output to console for testing
			// StreamResult result = new StreamResult(System.out);

			transformer.transform(source, result);

			System.out.println("XML file created with succes!");

		}catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		  } catch (TransformerException tfe) {
			tfe.printStackTrace();
		  }
	}
	}
	public String CSV(String[] data) {
	    return Stream.of(data)
	      .collect(Collectors.joining(","));
	}
	
	public void salvareRapoarteCSV(ArrayList<Animal> lista_animale, ArrayList<Utilizator> lista_utilizatori)
	{
		if(!lista_animale.isEmpty())
		{	
		ArrayList<String[]> dataLines = new ArrayList<String[]>();
		for(Animal an:lista_animale)
		{
			dataLines.add(new String[] {an.getIdentificator()+"",an.getNume(),an.getTip(),an.getVarsta()+"",an.getSimptome(),an.getDiagnostic(),an.getTratament(),an.getDoctor()});
		}
		
		File csvOutputFile = new File(numeFisierCSVAnimale);
		try (PrintWriter printer = new PrintWriter(csvOutputFile)) {
	        dataLines.stream()
	          .map(this::CSV)
	          .forEach(printer::println);
	    }catch (IOException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
		System.out.println("CSV file created with succes!");
		}else if(!lista_utilizatori.isEmpty())
		{
			ArrayList<String[]> dataLines = new ArrayList<String[]>();
			for(Utilizator an:lista_utilizatori)
			{
				dataLines.add(new String[] {an.getId()+"",an.getNume(),an.getVarsta()+"",an.getCnp()});
			}
			
			File csvOutputFile = new File(numeFisierCSVDoctori);
			try (PrintWriter printer = new PrintWriter(csvOutputFile)) {
		        dataLines.stream()
		          .map(this::CSV)
		          .forEach(printer::println);
		    }catch (IOException e) {
		         // TODO Auto-generated catch block
		         e.printStackTrace();
		      }
			System.out.println("CSV file created with succes!");
		}
	}
	
}
