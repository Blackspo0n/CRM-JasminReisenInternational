package crm.JasminReisen.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import crm.JasminReisen.Listener.LoginFrameListener;

public class LoginFrame extends JDialog 
{
	private JPanel contentPane;
	private JPanel buttonPane;

	
	public LoginFrame(JFrame parent) {
		super(parent);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setResizable(false);
		setTitle("Anmeldung");
		setSize(350, 114);
		
        Dimension windowSize = this.getSize();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(screenSize.width/2 - windowSize.width/2, screenSize.height/2 - windowSize.height/2);

		this.setLayout(new BorderLayout());
		
		buttonPane = new  JPanel();
		this.add(buttonPane, BorderLayout.SOUTH);
		
		contentPane =  new JPanel(new GridLayout(2,2,6,3));
		
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.add(contentPane, BorderLayout.CENTER);
				

		JLabel labelUser = new JLabel();
		labelUser.setText("Benutzername:");
		contentPane.add(labelUser);

		JTextField txtUser = new JTextField();
		contentPane.add(txtUser);
		
		JLabel labelPassword = new JLabel();
		labelPassword.setText("Password:");
		contentPane.add(labelPassword);

		JPasswordField txtPassword = new JPasswordField();
		contentPane.add(txtPassword);	
		
		JButton loginButton = new JButton("Einloggen");
		buttonPane.add(loginButton);
		
		//loginButton.addActionListener(new LoginFrameListener(this));
		
		this.setVisible(true);
	}
}
