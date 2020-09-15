package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class MainPage {
private JPanel contentPane= new JPanel();
private JPasswordField Password=new JPasswordField();
private JFrame frame=new JFrame();
private JTextField Username = new JTextField();
private JDesktopPane desktopPane = new JDesktopPane();
private JTextPane User = new JTextPane();
private JTextPane Pass = new JTextPane();
private JLabel Image = new JLabel("");
private JButton btnLogIn = new JButton("Log in");
public MainPage()
{
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setBounds(300, 100, 820, 420);
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	contentPane.setLayout(new BorderLayout(0, 0));
	frame.setContentPane(contentPane);
	
	desktopPane.setBackground(new Color(255, 255, 0));
	contentPane.add(desktopPane, BorderLayout.CENTER);
	
	
	Username.setBounds(572, 70, 165, 20);
	desktopPane.add(Username);
	Username.setForeground(Color.BLACK);
	Username.setBackground(new Color(255, 255, 102));
	Username.setColumns(10);

	Password.setEchoChar('*');
	Password.setForeground(Color.BLACK);
	Password.setColumns(10);
	Password.setBackground(new Color(255, 255, 102));
	Password.setBounds(572, 107, 165, 20);
	desktopPane.add(Password);
	
	
	User.setEditable(false);
	User.setText("Username");
	User.setBounds(497, 67, 65, 23);
	desktopPane.add(User);
	

	Pass.setEditable(false);
	Pass.setText("Password");
	Pass.setBounds(497, 104, 65, 23);
	desktopPane.add(Pass);
	
	btnLogIn.setBackground(Color.GREEN);
	btnLogIn.setBounds(616, 138, 89, 23);
	desktopPane.add(btnLogIn);
	
	
	Image.setIcon(new ImageIcon("C:\\Users\\Stroia Lucian Dorin\\Desktop\\Proiectarea sistemelor\\Tema 1\\images\\Fundal.png"));
	Image.setBounds(0, 0, 794, 371);
	desktopPane.add(Image);
	frame.setVisible(true);
	frame.setResizable(false);

}

public void addlistener1(ActionListener a)
{
	btnLogIn.addActionListener(a);
}

public JPanel getContentPane() {
	return contentPane;
}
public void setContentPane(JPanel contentPane) {
	this.contentPane = contentPane;
}
public String getUsername() {
	return Username.getText();
}
public void setUsername(String string) {
	Username.setText(string); 
	Username.setForeground(Color.red);
}
public String getPassword() {
	return String.valueOf(Password.getPassword());
}
public void setPassword(JPasswordField password) {
	Password = password;
}
public JFrame getFrame() {
	return frame;
}
public void setFrame(JFrame frame) {
	this.frame = frame;
}





}
