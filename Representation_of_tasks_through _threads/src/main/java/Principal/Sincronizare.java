package Principal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Componente.Client;
import Componente.SimulationManager;
import Interfata.SimulationFrame;
import Interfata.View;

public class Sincronizare {
	private SimulationFrame vedere2;
	private SimulationManager m1;
	private View vedere;
	private int nr_cozi;
	public Sincronizare(View vedere)
	{	this.vedere=vedere;
		vedere.addListenerButon(new listenerStart());
		vedere.addListener1(new listener1());
		vedere.addListener2(new listener2());
		vedere.addListener3(new listener3());
		vedere.addListener4(new listener4());
		vedere.addListener5(new listener5());
		vedere.addListener6(new listener6());
	}
	public class listenerStart implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			vedere2=new SimulationFrame();
			m1=new SimulationManager(nr_cozi,vedere,vedere2);
			 Thread t=new Thread(m1);
			 t.start();
			vedere.getFrame1().dispose();
			
		}	
	}
	public class listener1 implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
		nr_cozi=1;
		}
		
	}
	public class listener2 implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
		nr_cozi=2;
		}
		
	}
	public class listener3 implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
		nr_cozi=3;
		}
		
	}
	public class listener4 implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
		nr_cozi=4;
		}
		
	}
	public class listener5 implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
		nr_cozi=5;
		}
		
	}
	public class listener6 implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
		nr_cozi=6;
		}
		
	}
	

}
