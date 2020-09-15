package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JDesktopPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Test extends JFrame {
	private JDesktopPane desktopPane = new JDesktopPane();
	private JButton btnFiltrareAnimaleAsistent = new JButton("Filtrare animale");
	private JButton btnPlanificareConsultatiiAsistent = new JButton("Planificare consulta\u021Bii animale");
	private JButton btnSalvareRapoarteAsistent = new JButton("Salvare rapoarte/liste");
	private JButton btnStergereFiseMedicaleAsistent = new JButton("\u0218tergere fi\u0219e medicale animale");
	private JButton btnEditareFiseMedicaleAsistent = new JButton("Editare fi\u0219e medicale animale");
	private JButton btnVizualizareFiseMedicaleAsistent = new JButton("Vizualizare fi\u0219e medicale animale");
	private JButton btnCreareFiseMedicaleAsistent = new JButton("Creare fi\u0219e medicale animale");
	private JTextField texIntroducereID;
	private JTextField textIntroducereNume;
	private JTextField textIntroducereSpecie;
	private JTextField textIntroducereVarsta;
	private JTextField textIntroducereSimptome;
	private JTextField textIntroducereDiagnostic;
	private JTextField txtId;
	private JTextField txtNume;
	private JTextField txtSpecie;
	private JTextField txtVarsta;
	private JTextField txtSimptome;
	private JTextField txtDiagnostic;
	private JTextField textIntroducereTratament;
	private JTextField textIntroducereDoctor;
	private JTextField txtTratament;
	private JTextField txtDoctor;
	private JTextField textFieldSucces;
	private JTextField textFieldCriteriu;
	private JPanel contentPane= new JPanel();
	private JButton btnProgramConsultaiiDoctor = new JButton("Program consulta\u021Bii");
	private JButton btnVizualizareStatisticiDoctor = new JButton("Vizualizare statistici");
	private JButton btnActualizareFiseMedicaleDoctor = new JButton("Actualizare fi\u0219e medicale animale");
	private JButton btnVizualizareFiseMedicaleDoctor = new JButton("Vizualizare fi\u0219e medicale animale");
	private JButton btnFiltrareAnimaleDoctor = new JButton("Filtrare animale");
	private JButton btnVizualizareConsultaiiDoctor = new JButton("Vizualizare program");
	private JButton btnSalvareProgramconsultaii = new JButton("Salvare program");
	private JComboBox comboBoxCriteriu = new JComboBox();
	private JComboBox comboBoxStatistici= new JComboBox();
	private JLabel lblNewLabel = new JLabel("");
	private JTable table;
	private JPanel 	panelTabel= new JPanel();
	private final JPanel panelChar1 = new JPanel();
	private final JPanel panelChar2 = new JPanel();
	private JFrame frameAdministrator=new JFrame();
	private JButton btnInregistrareDoctor = new JButton("Inregistrare doctor/asistent");
	private JButton btnStergereDoctor = new JButton("\u0218tergere informatii doctor/asistent");
	private JButton btnEditareDoctor = new JButton("Editare informatii doctor/asistent");
	private JButton btnVizualizareDoctor = new JButton("Vizualizare informatii doctor/asistent");
	private JTextField texIntroducereNume;
	private JTextField textIntroducereCNP;
	private JTextField textIntroducereProfesie;
	private JTextField textIntroducereUsername;
	private JTextField textIntroducereParola;
	private JTextField txtVrst;
	private JTextField txtCnp;
	private JTextField txtProfesie;
	private JTextField txtUsername;
	private JTextField txtParola;
	private JTextField textIntroducereId;
	private JTextField textSuccesInregistrare;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test frame = new Test();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Test() {
		frameAdministrator.setBounds(0, 100, 1200, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		frameAdministrator.setContentPane(contentPane);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(SystemColor.text);
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		texIntroducereNume = new JTextField();
		texIntroducereNume.setBackground(new Color(173, 255, 47));
		texIntroducereNume.setBounds(100, 332, 178, 20);
		desktopPane.add(texIntroducereNume);
		texIntroducereNume.setColumns(10);
		
		textIntroducereVarsta = new JTextField();
		textIntroducereVarsta.setBackground(new Color(173, 255, 47));
		textIntroducereVarsta.setColumns(10);
		textIntroducereVarsta.setBounds(100, 173, 178, 20);
		desktopPane.add(textIntroducereVarsta);
		
		textIntroducereCNP = new JTextField();
		textIntroducereCNP.setBackground(new Color(173, 255, 47));
		textIntroducereCNP.setColumns(10);
		textIntroducereCNP.setBounds(100, 204, 178, 20);
		desktopPane.add(textIntroducereCNP);
		
		textIntroducereProfesie = new JTextField();
		textIntroducereProfesie.setBackground(new Color(173, 255, 47));
		textIntroducereProfesie.setColumns(10);
		textIntroducereProfesie.setBounds(100, 235, 178, 20);
		desktopPane.add(textIntroducereProfesie);
		
		textIntroducereUsername = new JTextField();
		textIntroducereUsername.setBackground(new Color(173, 255, 47));
		textIntroducereUsername.setColumns(10);
		textIntroducereUsername.setBounds(100, 266, 178, 20);
		desktopPane.add(textIntroducereUsername);
		
		textIntroducereParola = new JTextField();
		textIntroducereParola.setBackground(new Color(173, 255, 47));
		textIntroducereParola.setColumns(10);
		textIntroducereParola.setBounds(100, 301, 178, 20);
		desktopPane.add(textIntroducereParola);
		
		textIntroducereId = new JTextField();
		textIntroducereId.setBackground(new Color(173, 255, 47));
		textIntroducereId.setColumns(10);
		textIntroducereId.setBounds(100, 142, 178, 20);
		desktopPane.add(textIntroducereId);
		
		
		
		txtNume = new JTextField();
		txtNume.setBackground(new Color(50, 205, 50));
		txtNume.setEditable(false);
		txtNume.setHorizontalAlignment(SwingConstants.RIGHT);
		txtNume.setText("Nume:");
		txtNume.setColumns(10);
		txtNume.setBounds(33, 332, 67, 20);
		desktopPane.add(txtNume);
		
		txtVrst = new JTextField();
		txtVrst.setBackground(new Color(50, 205, 50));
		txtVrst.setEditable(false);
		txtVrst.setHorizontalAlignment(SwingConstants.RIGHT);
		txtVrst.setText("V\u00E2rst\u0103:");
		txtVrst.setColumns(10);
		txtVrst.setBounds(33, 173, 67, 20);
		desktopPane.add(txtVrst);
		
		txtCnp = new JTextField();
		txtCnp.setBackground(new Color(50, 205, 50));
		txtCnp.setEditable(false);
		txtCnp.setHorizontalAlignment(SwingConstants.RIGHT);
		txtCnp.setText("CNP:");
		txtCnp.setColumns(10);
		txtCnp.setBounds(33, 204, 67, 20);
		desktopPane.add(txtCnp);
		
		txtProfesie = new JTextField();
		txtProfesie.setBackground(new Color(50, 205, 50));
		txtProfesie.setEditable(false);
		txtProfesie.setHorizontalAlignment(SwingConstants.RIGHT);
		txtProfesie.setText("Profesie:");
		txtProfesie.setColumns(10);
		txtProfesie.setBounds(33, 235, 67, 20);
		desktopPane.add(txtProfesie);
		
		txtUsername = new JTextField();
		txtUsername.setBackground(new Color(50, 205, 50));
		txtUsername.setEditable(false);
		txtUsername.setHorizontalAlignment(SwingConstants.RIGHT);
		txtUsername.setText("Username:");
		txtUsername.setColumns(10);
		txtUsername.setBounds(33, 266, 67, 20);
		desktopPane.add(txtUsername);
		
		txtParola = new JTextField();
		txtParola.setBackground(new Color(50, 205, 50));
		txtParola.setEditable(false);
		txtParola.setHorizontalAlignment(SwingConstants.RIGHT);
		txtParola.setText("Parola");
		txtParola.setColumns(10);
		txtParola.setBounds(33, 301, 67, 20);
		desktopPane.add(txtParola);
		
		txtId = new JTextField();
		txtId.setBackground(new Color(50, 205, 50));
		txtId.setEditable(false);
		txtId.setHorizontalAlignment(SwingConstants.RIGHT);
		txtId.setText("Id");
		txtId.setColumns(10);
		txtId.setBounds(33, 142, 67, 20);
		desktopPane.add(txtId);
		
		
		
		
		
		btnStergereDoctor.setForeground(Color.BLACK);
		btnStergereDoctor.setBackground(new Color(255, 255, 102));
		btnStergereDoctor.setBounds(33, 519, 245, 23);
		desktopPane.add(btnStergereDoctor);
		
		
		btnEditareDoctor.setForeground(Color.BLACK);
		btnEditareDoctor.setBackground(new Color(255, 255, 102));
		btnEditareDoctor.setBounds(33, 481, 245, 23);
		desktopPane.add(btnEditareDoctor);
		

		btnVizualizareDoctor.setForeground(Color.BLACK);
		btnVizualizareDoctor.setBackground(new Color(255, 255, 102));
		btnVizualizareDoctor.setBounds(33, 413, 245, 23);
		desktopPane.add(btnVizualizareDoctor);
		

		btnInregistrareDoctor.setForeground(Color.BLACK);
		btnInregistrareDoctor.setBackground(new Color(255, 255, 102));
		btnInregistrareDoctor.setBounds(33, 447, 245, 23);
		desktopPane.add(btnInregistrareDoctor);
		
		JPanel panel = new JPanel();
		panel.setBounds(460, 25, 664, 331);
		desktopPane.add(panel);
		
		textSuccesInregistrare = new JTextField();
		textSuccesInregistrare.setBounds(288, 448, 86, 20);
		desktopPane.add(textSuccesInregistrare);
		textSuccesInregistrare.setColumns(10);
		
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Stroia Lucian Dorin\\Desktop\\Proiectarea sistemelor\\Tema 1\\images\\admin.png"));
		lblNewLabel_1.setBounds(460, 333, 243, 344);
		desktopPane.add(lblNewLabel_1);
		

		
	}
}
