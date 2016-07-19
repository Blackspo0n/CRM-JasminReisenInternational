package crm.JasminReisen.GUI;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import crm.JasminReisen.Config;
import crm.JasminReisen.Listener.MainFrameListener;
import crm.JasminReisen.models.User;
import crm.JasminReisen.Listener.LoginFrameListener;

public class LoginFrame extends JDialog 
{
	private JPanel gridpane;
	private JPanel buttonPane;
	private JLabel labelUser;
	private JLabel labelPassword;
	private JTextField txtUser;
	private JPasswordField txtPassword;
	private JButton loginButton;
	private MainFrame mainFrame;
	private JButton resetButton;
	
	public LoginFrame(MainFrame parent) {
		super(parent);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setTitle("Anmeldung");
		setModal(true);
		this.setLayout(new BorderLayout());
		
		mainFrame = parent;
		buttonPane = new  JPanel();
		gridpane = new JPanel(new GridLayout(2,2,6,3));
		gridpane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		add(gridpane, BorderLayout.CENTER);
		add(buttonPane, BorderLayout.SOUTH);
				
		labelUser = new JLabel();
		labelUser.setText("Benutzername:");
		gridpane.add(labelUser);

		txtUser = new JTextField();
		gridpane.add(txtUser);
		
		labelPassword = new JLabel();
		labelPassword.setText("Password:");
		gridpane.add(labelPassword);

		txtPassword = new JPasswordField();
		gridpane.add(txtPassword);	
		
		resetButton = new JButton("Zurücksetzen");
		buttonPane.add(resetButton);
	
		loginButton = new JButton("Einloggen");
		buttonPane.add(loginButton);
		
		loginButton.addActionListener(new LoginFrameListener(this));
		resetButton.addActionListener(new LoginFrameListener(this));
		
		setSize(350, 114);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public MainFrame getMainFrame() {
		return mainFrame;
	}

	public void setMainFrame(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
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
