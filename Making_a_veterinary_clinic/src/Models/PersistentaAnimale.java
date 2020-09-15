package Models;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class PersistentaAnimale extends Persistenta {
	ArrayList<Animal> lista_animale;
	public PersistentaAnimale(String numeFisier) {
		this.nume=numeFisier;
		lista_animale=this.afisareAnimale();
		//lista_animale=new ArrayList<Animal>();
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Animal> afisareAnimale() {
		try
        {    
            // Reading the object from a file 
            FileInputStream file = new FileInputStream(this.nume); 
            ObjectInputStream in = new ObjectInputStream(file); 
              
            // Method for deserialization of object 
			ArrayList<Animal>aux= (ArrayList<Animal>)in.readObject();
            in.close(); 
            file.close(); 
              
            System.out.println("Object has been deserialized "); 
           
            return aux;
        } 
          
        catch(IOException ex) 
        { 
	        ex.printStackTrace();
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
            System.out.println("ClassNotFoundException is caught"); 
		}
		return null; 
	}
	
	public void serializare(ArrayList<Animal> lista)
	{
        try
        {    
            //Saving of object in a file 
            FileOutputStream file = new FileOutputStream(this.nume); 
            ObjectOutputStream out = new ObjectOutputStream(file); 
              
            // Method for serialization of object
            for(Animal a:lista_animale)
            {
            	for(int i=0;i<lista.size();i++)
            	if(a.getIdentificator()==lista.get(i).getIdentificator())
            	{
            		lista_animale.set(lista_animale.indexOf(a), lista.get(i));
            	}
            }
            out.writeObject(lista_animale); 
              
            out.close(); 
            file.close(); 
              
            System.out.println("Object has been serialized"); 
  
        } 
          
        catch(IOException ex) 
        { 
        	ex.printStackTrace(); 
        } 
	}
	public void creareAnimale(Animal a) {
		// Serialization  
	        try
	        {    
	            //Saving of object in a file 
	            FileOutputStream file = new FileOutputStream(this.nume); 
	            ObjectOutputStream out = new ObjectOutputStream(file); 
	              
	            // Method for serialization of object
	            lista_animale.add(a);
	            out.writeObject(lista_animale); 
	              
	            out.close(); 
	            file.close(); 
	              
	            System.out.println("Object has been serialized"); 
	  
	        } 
	          
	        catch(IOException ex) 
	        { 
	        	ex.printStackTrace(); 
	        } 
	}

	public void stergereAnimalPersistenta(int id)
	{
		Animal aux=null;
		for(Animal an:lista_animale)
		{
		if(an.getIdentificator()== id)
		{
			aux=an;
			break;
		}
		}
		if(aux!=null)
		{
			lista_animale.remove(aux);
			 try
		        {    
		            //Saving of object in a file 
		            FileOutputStream file = new FileOutputStream(this.nume); 
		            ObjectOutputStream out = new ObjectOutputStream(file); 
		              
		            // Method for serialization of object
		            out.writeObject(lista_animale); 
		              
		            out.close(); 
		            file.close(); 
		              
		            System.out.println("Object has been serialized"); 
		  
		        } 
		          
		        catch(IOException ex) 
		        { 
		        	ex.printStackTrace(); 
		        } 
		}
		else System.out.println("Nu s-a gasit identificatorul!");
	}
	
}
