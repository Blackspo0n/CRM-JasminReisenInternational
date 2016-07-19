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
	private JLabel labelUser;
	private JLabel labelPassword;
	private JTextField txtUser;
	private JPasswordField txtPassword;
	private JButton loginButton;
	private JFrame mainFrame;
	
	public static void main(String[] args) {
		LoginFrame lf = new LoginFrame(new JFrame());
	}
	
	public LoginFrame(JFrame parent) {
		super(parent);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setTitle("Anmeldung");
		setSize(350, 114);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		
		mainFrame = parent;
		
		buttonPane = new  JPanel();
		contentPane = new JPanel(new GridLayout(2,2,6,3));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		add(contentPane, BorderLayout.CENTER);
		add(buttonPane, BorderLayout.SOUTH);
				

		labelUser = new JLabel();
		labelUser.setText("Benutzername:");
		contentPane.add(labelUser);

		txtUser = new JTextField();
		contentPane.add(txtUser);
		
		labelPassword = new JLabel();
		labelPassword.setText("Password:");
		contentPane.add(labelPassword);

		txtPassword = new JPasswordField();
		contentPane.add(txtPassword);	
		
		loginButton = new JButton("Einloggen");
		buttonPane.add(loginButton);
		
		loginButton.addActionListener(new LoginFrameListener(this));
		
		setVisible(true);
	}

	public JFrame getMainFrame() {
		return mainFrame;
	}

	public void setMainFrame(JFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public void setContentPane(JPanel contentPane) {
		this.contentPane = contentPane;
	}

	public JPanel getButtonPane() {
		return buttonPane;
	}

	public void setButtonPane(JPanel buttonPane) {
		this.buttonPane = buttonPane;
	}

	public JLabel getLabelUser() {
		return labelUser;
	}

	public void setLabelUser(JLabel labelUser) {
		this.labelUser = labelUser;
	}

	public JLabel getLabelPassword() {
		return labelPassword;
	}

	public void setLabelPassword(JLabel labelPassword) {
		this.labelPassword = labelPassword;
	}

	public JTextField getTxtUser() {
		return txtUser;
	}

	public void setTxtUser(JTextField txtUser) {
		this.txtUser = txtUser;
	}

	public JPasswordField getTxtPassword() {
		return txtPassword;
	}

	public void setTxtPassword(JPasswordField txtPassword) {
		this.txtPassword = txtPassword;
	}

	public JButton getLoginButton() {
		return loginButton;
	}

	public void setLoginButton(JButton loginButton) {
		this.loginButton = loginButton;
	}
	
}
