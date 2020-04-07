package dataAcces;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import bussinesLogic.MenuItem;

public class FileWriterClass {
	public FileWriterClass()
	{
		
	}
	public void chitanta(ArrayList<MenuItem>listOfProductsPerOrder, int price)
	{
		File file = new File("Bill.txt");
		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter(file);
			for(MenuItem m:listOfProductsPerOrder)
			{
			fileWriter.write("Id:"+m.getId()+System.getProperty( "line.separator" ));
			fileWriter.write("Nume:"+m.getName()+System.getProperty( "line.separator" ));
			fileWriter.write("Pret:"+m.getPrice()+System.getProperty( "line.separator" ));
			fileWriter.write(System.getProperty( "line.separator" ));
			}
			fileWriter.write("Total:"+price);
		
			fileWriter.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
