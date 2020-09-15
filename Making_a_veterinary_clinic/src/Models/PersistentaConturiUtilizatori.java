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

public class PersistentaConturiUtilizatori extends Persistenta {
	ArrayList<ContUtilizator> lista_conturi;
	public PersistentaConturiUtilizatori(String numeFisier)
	{
		this.nume=numeFisier;
		//lista_conturi=new ArrayList<ContUtilizator>();
		lista_conturi=this.afisareConturiUtilizatori();

	}
	public void creareConturiUtilizatori(ContUtilizator cont) {
		// Serialization  
        try
        {    
            //Saving of object in a file 
            FileOutputStream file = new FileOutputStream(this.nume); 
            ObjectOutputStream out = new ObjectOutputStream(file); 
              
            // Method for serialization of object
            lista_conturi.add(cont);
            out.writeObject(lista_conturi); 
            out.close(); 
            file.close(); 
              
            System.out.println("Object has been serialized"); 
  
        } 
          
        catch(IOException ex) 
        { 
        	ex.printStackTrace(); 
        } 
	}
	
	public ArrayList<ContUtilizator> afisareConturiUtilizatori()
	{
		try
        {    
            // Reading the object from a file 
            FileInputStream file = new FileInputStream(this.nume); 
            ObjectInputStream in = new ObjectInputStream(file); 
              
            // Method for deserialization of object 
			ArrayList<ContUtilizator>aux= (ArrayList<ContUtilizator>)in.readObject();
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
	
	public ContUtilizator verificareUtilizator(String username, String parola){
		for(ContUtilizator cont: lista_conturi)
			if(cont.getUser().equals(username) && cont.getParola().equals(parola))
			{
				
				return cont;
			}
		return new ContUtilizator("","",null);		
	}
	
	public void serializare(ArrayList<ContUtilizator> lista)
	{
        try
        {    
            //Saving of object in a file 
            FileOutputStream file = new FileOutputStream(this.nume); 
            ObjectOutputStream out = new ObjectOutputStream(file); 
              
            // Method for serialization of object
            for(ContUtilizator a:lista_conturi)
            {
            	for(int i=0;i<lista.size();i++)
            	if(a.getUtilizator().getId()==lista.get(i).getUtilizator().getId())
            	{
            		lista_conturi.set(lista_conturi.indexOf(a), lista.get(i));
            	}
            }
            out.writeObject(lista_conturi); 
              
            out.close(); 
            file.close(); 
              
            System.out.println("Object has been serialized"); 
  
        } 
          
        catch(IOException ex) 
        { 
        	ex.printStackTrace(); 
        } 
	}
	
	public void stergereConturiUtilizatorPersistenta(int id)
	{
		ContUtilizator aux=null;
		for(ContUtilizator an:lista_conturi)
		{
		if(an.getUtilizator().getId()== id)
		{
			aux=an;
			break;
		}
		}
		if(aux!=null)
		{
			lista_conturi.remove(aux);
			 try
		        {    
		            //Saving of object in a file 
		            FileOutputStream file = new FileOutputStream(this.nume); 
		            ObjectOutputStream out = new ObjectOutputStream(file); 
		              
		            // Method for serialization of object
		            out.writeObject(lista_conturi); 
		              
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
