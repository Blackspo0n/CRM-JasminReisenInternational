package crm.JasminReisen.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class LoginFrame extends JDialog {
	private JPanel contentPane;

	public static void main(String[] args) {
		LoginFrame lf = new LoginFrame(new JFrame());
	}
	
	public LoginFrame(JFrame parent) {
		super(parent);
		
		setResizable(false);
		setTitle("Anmeldung");
		setSize(450, 274);
		
        Dimension windowSize = this.getSize();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(screenSize.width/2 - windowSize.width/2, screenSize.height/2 - windowSize.height/2);

		
		contentPane = (JPanel)this.getContentPane();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 6, 3));

		JLabel labelUser = new JLabel();
		labelUser.setText("Benutzername:");
		contentPane.add(labelUser);

		JLabel labelPassword = new JLabel();
		labelPassword.setText("Password:");
		contentPane.add(labelPassword);

		JTextField txtUser = new JTextField();
		contentPane.add(txtUser);

		JPasswordField txtPassword = new JPasswordField();
		contentPane.add(txtPassword);
		
		this.setVisible(true);
	}
}
