package Models;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class PersistentaUtilizatori extends Persistenta {
	ArrayList<Utilizator> lista_utilizatori;
	public PersistentaUtilizatori(String numeFisier)
	{
		this.nume=numeFisier;
		//lista_utilizatori=new ArrayList<Utilizator>();
		lista_utilizatori=this.afisareUtilizatori();
	}
	public void creareUtilizatori(Utilizator a) {

		// Serialization  
	        try
	        {    
	            //Saving of object in a file 
	            FileOutputStream file = new FileOutputStream(this.nume); 
	            ObjectOutputStream out = new ObjectOutputStream(file); 
	              
	            // Method for serialization of object
	            lista_utilizatori.add(a);
	            out.writeObject(lista_utilizatori); 
	              
	            out.close(); 
	            file.close(); 
	              
	            System.out.println("Object has been serialized"); 
	  
	        } 
	          
	        catch(IOException ex) 
	        { 
	        	ex.printStackTrace(); 
	        } 
	}
	public ArrayList<Utilizator> afisareUtilizatori()
	{
		try
        {    
            // Reading the object from a file 
            FileInputStream file = new FileInputStream(this.nume); 
            ObjectInputStream in = new ObjectInputStream(file); 
              
            // Method for deserialization of object 
			ArrayList<Utilizator>aux= (ArrayList<Utilizator>)in.readObject();
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
	public void serializare(ArrayList<Utilizator> lista)
	{
        try
        {    
            //Saving of object in a file 
            FileOutputStream file = new FileOutputStream(this.nume); 
            ObjectOutputStream out = new ObjectOutputStream(file); 
              
            // Method for serialization of object
            for(Utilizator a:lista_utilizatori)
            {
            	for(int i=0;i<lista.size();i++)
            	if(a.getId()==lista.get(i).getId())
            	{
            		lista_utilizatori.set(lista_utilizatori.indexOf(a), lista.get(i));
            	}
            }
            out.writeObject(lista_utilizatori); 
              
            out.close(); 
            file.close(); 
              
            System.out.println("Object has been serialized"); 
  
        } 
          
        catch(IOException ex) 
        { 
        	ex.printStackTrace(); 
        } 
	}
	public void stergereUtilizatorPersistenta(int id)
	{
		Utilizator aux=null;
		for(Utilizator an:lista_utilizatori)
		{
		if(an.getId()== id)
		{
			aux=an;
			break;
		}
		}
		if(aux!=null)
		{
			lista_utilizatori.remove(aux);
			 try
		        {    
		            //Saving of object in a file 
		            FileOutputStream file = new FileOutputStream(this.nume); 
		            ObjectOutputStream out = new ObjectOutputStream(file); 
		              
		            // Method for serialization of object
		            out.writeObject(lista_utilizatori);               
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
