package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BussinesLogic.ClientiBLL;
import BussinesLogic.ComenziBLL;
import BussinesLogic.InformatiiComenziBLL;
import BussinesLogic.ProduseBLL;
import Model.Clienti;
import Model.Comenzi;
import Model.informatiicomenzi;
import Model.Produse;
import net.proteanit.sql.DbUtils;

public class Controller {
public View my_view;
private ArrayList<Produse> produseAdaugatePerClient=new ArrayList<Produse>();
private Clienti clientPtChitanta;
public Controller(View my_view)
{
	this.my_view=my_view;
	my_view.addListenerClienti(new listenerClienti());
	my_view.addListenerBackCL(new listenerBackCL());
	my_view.addListenerProduse(new listenerProduse());
	my_view.addListenerBackPR(new listenerBackPR());
	my_view.addListenerComenzi(new listenerComenzi());
	my_view.addListenerBackCO(new listenerBackCO());
	my_view.addListenerVizCL(new listenerVizCL());
	my_view.addListenerInsCL(new listenerInsCL());
	my_view.addListenerStergCL(new listenerStergCL());
	my_view.addListenerUpCL(new listenerUpCL());
	my_view.addListenerVizCO(new listenerVizCO());
	my_view.addListenerInsCO(new listenerInsCO());
	my_view.addListenerVizPR(new listenerVizPR());
	my_view.addListenerInsPR(new listenerInsPR());
	my_view.addListenerStergPR(new listenerStergPR());
	my_view.addListenerUpPR(new listenerUpPR());
	my_view.addListenerBackR(new listenerBackR());
	my_view.addListenerAdaugareProduse(new listenerAdaugaProduse());
	my_view.addListenerVizPR2(new listenerVizPR2());
	my_view.addListenerSuplimentar(new listenerSuplimentar());
	my_view.addListenerChitanta(new listenerChitanta());
}

class listenerChitanta implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		try {
				PDDocument document = new PDDocument();
				PDPage pagina = new PDPage();
				document.addPage(pagina);
				PDPageContentStream contentStream = new PDPageContentStream(document, pagina); 
		      contentStream.beginText(); 
		      contentStream.setFont( PDType1Font.TIMES_ROMAN, 18 ); 
		      contentStream.newLineAtOffset(30, 750 ); 
		      String id="Clientul cu id:"+clientPtChitanta.getIdClienti()+"";
		      String nume="Nume:"+clientPtChitanta.getNume()+"";
		      String prenume="Prenume:"+clientPtChitanta.getPrenume()+"";
		      String mail="Mail:"+clientPtChitanta.getMail()+"";
		      String telefon="Telefon:"+clientPtChitanta.getTelefon()+"";
		      String adresa="Adresa:"+clientPtChitanta.getAdresa()+"";
 
		      //Informatiile despre client
		      contentStream.showText(id);
		      contentStream.newLineAtOffset(0, -15);
		      contentStream.showText(nume);
		      contentStream.newLineAtOffset(0, -15);
		      contentStream.showText(prenume);
		      contentStream.newLineAtOffset(0, -15);
		      contentStream.showText(mail);
		      contentStream.newLineAtOffset(0, -15);
		      contentStream.showText(telefon);
		      contentStream.newLineAtOffset(0, -15);
		      contentStream.showText(adresa);
		      contentStream.newLineAtOffset(0, -30);
		      //Informatii produse 
		      int i=1;
		      contentStream.showText("Produsele achizitionate de Client:");
		      contentStream.newLineAtOffset(0, -30);
		      for(Produse p:produseAdaugatePerClient)
		      {	
		    	  contentStream.showText("Produsul "+i);
			      contentStream.newLineAtOffset(0, -15);
		    	  contentStream.showText("Nume: "+p.getNume());
			      contentStream.newLineAtOffset(0, -15);
			      contentStream.showText("Cantitate: "+p.getCantitate());
			      contentStream.newLineAtOffset(0, -30);
			      i++;
		      } 
		      contentStream.endText(); 
		      contentStream.close();      
		      document.save("F:/PT2019/pt2019_30227_stroia_lucian_assigment_3/assigment3/Chitanta.pdf");
		      my_view.setTextField_afisareCO("Chitanta generata!");
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}

class listenerComenzi implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		try {
			my_view.frameComenzi();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}

class listenerBackCO implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		try {
			my_view.getFrameComenzi().dispose();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
class listenerBackR implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		try {
			my_view.getResultFrame().dispose();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}


class listenerClienti implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		try {
			my_view.frameClienti();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
class listenerVizPR2 implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		try {
			List<Produse> afisare= new ArrayList<Produse>();
			ProduseBLL aux=new ProduseBLL();
			afisare=aux.findall();
			DefaultTableModel tabelModel =aux.creareTabel(afisare);
			my_view.getTable().setModel(tabelModel);
			my_view.createResultFrame();
			my_view.getResultFrame().setVisible(true);
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}class listenerAdaugaProduse implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		try {
			my_view.setTextField_afisareCO("");
			int id_cautat=Integer.parseInt(my_view.getTextField_idPro());// am luat id-ul produsului pe care dorim sa il comandam.
			ProduseBLL a=new ProduseBLL();
			Produse produs=a.findProduseById(id_cautat);
			Produse produsUpdate=a.findProduseById(id_cautat);
			produs.setCantitate(Integer.parseInt(my_view.getTextField_cantitateComenzi()));
			if(produs.getCantitate()>produsUpdate.getCantitate())
				{my_view.setTextField_afisareCO("Cantitate Insuficienta!");
				}
			else {
			produseAdaugatePerClient.add(produs);// l-am adaugam in arraylistul clientului
			produsUpdate.setCantitate(produsUpdate.getCantitate()-Integer.parseInt(my_view.getTextField_cantitateComenzi()));
			String de=a.update(produsUpdate);//actualizam cantitatea produsului pe care clientulu l-a comandat
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}

class listenerSuplimentar implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		try {
			ClientiBLL a=new ClientiBLL();
			clientPtChitanta=a.findClientiById(Integer.parseInt(my_view.getTextField_idComenzi()));
			my_view.getResultFrame().dispose();
			List<informatiicomenzi> afisare= new ArrayList<informatiicomenzi>();
			InformatiiComenziBLL aux=new InformatiiComenziBLL();
			afisare=aux.findall();
			DefaultTableModel tabelModel =aux.creareTabel(afisare);
			my_view.createResultFrame();
			my_view.getTable().setModel(tabelModel);
			my_view.getTable().setVisible(true);			
			my_view.getResultFrame().setVisible(true);
			my_view.getBtnSuplimentar().setVisible(false);
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
class listenerInsCO implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		try {
			ComenziBLL a=new ComenziBLL();
			Comenzi t=new Comenzi(my_view.getTextField_cumparatorComenzi());
			String d=a.insert(t);
			InformatiiComenziBLL aC=new InformatiiComenziBLL();
			for(Produse p:produseAdaugatePerClient)
				{informatiicomenzi i=new informatiicomenzi(Integer.parseInt(my_view.getTextField_idComenzi()),p.getNume(),p.getCantitate());
				aC.insert(i);
				}
			if(d.equalsIgnoreCase("Inserarea cu succes!"))
			my_view.setTextField_afisareCO("Comanda plasata");
			else 	my_view.setTextField_afisareCO("Comanda a esuat!");
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}

class listenerBackCL implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		try {
			my_view.getFrameClienti().dispose();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
class listenerProduse implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		try {
			my_view.frameProduse();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
class listenerBackPR implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		try {
			my_view.getFrameProduse().dispose();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
class listenerVizCL implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		try {
			List<Clienti> afisare= new ArrayList<Clienti>();
			ClientiBLL aux=new ClientiBLL();
			afisare=aux.findall();
			DefaultTableModel tabelModel =aux.creareTabel(afisare);
			my_view.getTable().setModel(tabelModel);
			my_view.createResultFrame();
			my_view.getResultFrame().setVisible(true);
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
class listenerVizCO implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			try {
				List<Comenzi> afisare= new ArrayList<Comenzi>();
				ComenziBLL aux=new ComenziBLL();
				afisare=aux.findall();
				DefaultTableModel tabelModel =aux.creareTabel(afisare);
				my_view.getTable().setModel(tabelModel);
				my_view.createResultFrame();	
				my_view.getResultFrame().setVisible(true);
				my_view.getBtnSuplimentar().setVisible(true);
			}catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
}
class listenerVizPR implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				try {
					List<Produse> afisare= new ArrayList<Produse>();
					ProduseBLL aux=new ProduseBLL();
					afisare=aux.findall();
					DefaultTableModel tabelModel =aux.creareTabel(afisare);
					my_view.getTable().setModel(tabelModel);
					my_view.createResultFrame();
					my_view.getResultFrame().setVisible(true);
				}catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}

}

class listenerInsCL implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		try {
			ClientiBLL a=new ClientiBLL();
			Clienti t=new Clienti(my_view.getTextField_numeClienti(),my_view.getTextField_prenumeClienti(),my_view.getTextField_mailClienti(),my_view.getTextField_telefonClienti(),my_view.getTextField_adresaClienti());
			String d=a.insert(t);
			my_view.setTextField_afisare(d);
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
class listenerInsPR implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		try {
			ProduseBLL a=new ProduseBLL();
			Produse t=new Produse(my_view.getTextField_numeProduse(),Integer.parseInt(my_view.getTextField_cantitateProduse()));
			String d=a.insert(t);
			my_view.setTextField_afisarePR(d);
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}

class listenerStergPR implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		try {
			ProduseBLL a=new ProduseBLL();
			Produse t=new Produse(Integer.parseInt(my_view.getTextField_idProduse()),my_view.getTextField_numeProduse(),Integer.parseInt(my_view.getTextField_cantitateProduse()));
			String d=a.delete(t);
			my_view.setTextField_afisarePR(d);
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
class listenerStergCL implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		try {
			ClientiBLL a=new ClientiBLL();
			Clienti t=new Clienti(Integer.parseInt(my_view.getTextField_idClienti()),my_view.getTextField_numeClienti(),my_view.getTextField_prenumeClienti(),my_view.getTextField_mailClienti(),my_view.getTextField_telefonClienti(),my_view.getTextField_adresaClienti());
			String d=a.delete(t);
			my_view.setTextField_afisare(d);
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
class listenerUpPR implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		try {
			ProduseBLL a=new ProduseBLL();
			Produse t=new Produse(Integer.parseInt(my_view.getTextField_idProduse()),my_view.getTextField_numeProduse(),Integer.parseInt(my_view.getTextField_cantitateProduse()));
			String d=a.update(t);
			my_view.setTextField_afisarePR(d);
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
class listenerUpCL implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		try {
			ClientiBLL a=new ClientiBLL();
			Clienti t=new Clienti(Integer.parseInt(my_view.getTextField_idClienti()),my_view.getTextField_numeClienti(),my_view.getTextField_prenumeClienti(),my_view.getTextField_mailClienti(),my_view.getTextField_telefonClienti(),my_view.getTextField_adresaClienti());
			String d=a.update(t);
			my_view.setTextField_afisare(d);
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
}
