package dataAcces;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import bussinesLogic.MenuItem;

public class RestaurantSerializator implements Serializable {

	public void serialization(ArrayList<MenuItem> sir)
	{
		try {
			FileOutputStream out1 = new FileOutputStream("informatii.ser");
			ObjectOutputStream out2= new ObjectOutputStream(out1);
	         out2.writeObject(sir);
	         out2.close();
	         out1.close();
		}
		catch (IOException i) {
	         i.printStackTrace();
	      }
		
	}
	public ArrayList<MenuItem> deserialization()
	{
		try
		{
			FileInputStream in1 = new FileInputStream("informatii.ser");
			ObjectInputStream in2 = new ObjectInputStream(in1);
			ArrayList<MenuItem> deserializationArray = (ArrayList<MenuItem>) in2.readObject();
	         in2.close();
	         in1.close();
	         return deserializationArray;
		}
		catch (IOException i) {
	         i.printStackTrace();
	         return null;
	      } catch (ClassNotFoundException c) {
	         c.printStackTrace();
	         return null;
	      }
     
	}
}
