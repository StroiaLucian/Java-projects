package Models;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class PersistentaProgramConsultatii extends Persistenta {
	ArrayList<ProgramConsultatii> lista_program_consultatii;
	public PersistentaProgramConsultatii(String numeFisier)
	{
		this.nume=numeFisier;
		//lista_program_consultatii=new ArrayList<ProgramConsultatii>();
		lista_program_consultatii=this.afisareConsultatii();

	}
	public void creareConsultatii(ProgramConsultatii a) {
		// Serialization  
	        try
	        {    
	            //Saving of object in a file 
	            FileOutputStream file = new FileOutputStream(this.nume); 
	            ObjectOutputStream out = new ObjectOutputStream(file); 
	              
	            // Method for serialization of object
	            if(lista_program_consultatii.size()>0) {
		            int ok=0;

	            for(ProgramConsultatii index:lista_program_consultatii)
	            {
	            	if(index.getDoctor().toString().equals(a.getDoctor().toString()))
	            	{
	            		ok=1;
	            		lista_program_consultatii.get(lista_program_consultatii.indexOf(index)).setProgram(a.getProgram());
	            		break;
	            	}
	            }
	            if(ok==0)
	            lista_program_consultatii.add(a);
	            }else lista_program_consultatii.add(a);
	       
	            out.writeObject(lista_program_consultatii); 
	              
	            out.close(); 
	            file.close(); 
	              
	            System.out.println("Object has been serialized"); 
	  
	        } 
	          
	        catch(IOException ex) 
	        { 
	        	ex.printStackTrace(); 
	        } 
	}
	
	public ArrayList<ProgramConsultatii> afisareConsultatii() {
		try
        {    
            // Reading the object from a file 
            FileInputStream file = new FileInputStream(this.nume); 
            ObjectInputStream in = new ObjectInputStream(file); 
              
            // Method for deserialization of object 
			ArrayList<ProgramConsultatii>aux= (ArrayList<ProgramConsultatii>)in.readObject();
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
}
