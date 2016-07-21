package crm.JasminReisen.GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import crm.JasminReisen.Config;
import crm.JasminReisen.Listener.EmailMessageListener;
import crm.JasminReisen.models.Kunde;

public class EmailMessageFrame extends JDialog {

	String mail;
	
	private JTextField nameField;
	private JTextField subjectField;
	private JTextArea areaMessage;
	private JComboBox <String> salutation;

	public EmailMessageFrame(Kunde kunde) {
		this.setSize(600, 450);
		this.setLayout(new BorderLayout());
		this.setLocationRelativeTo(null);
		this.setTitle("E-Mail versenden");

		mail = kunde.getEMail();
		
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new GridLayout(2, 2, 30, 10));
		northPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		this.add(northPanel, BorderLayout.NORTH);
		String[] salutationArray = { "Sehr geehrte Frau", "Sehr geehrter Herr" };
		salutation = new JComboBox<String>(salutationArray);
		JLabel subjectLabel = new JLabel("Betreff:");
		subjectField = new JTextField();
		northPanel.add(salutation);
		nameField = new JTextField(kunde.getName());
		nameField.setFont(Config.getFONT());
		northPanel.add(nameField);
		northPanel.add(subjectLabel);
		northPanel.add(subjectField);	

		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());
		centerPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new GridLayout(1, 2, 30, 10));
		this.add(centerPanel, BorderLayout.CENTER);
		this.add(southPanel, BorderLayout.SOUTH);

		JScrollPane scrollPaneArea = new JScrollPane();
		centerPanel.add(scrollPaneArea, BorderLayout.CENTER);

		areaMessage = new JTextArea();
		
		scrollPaneArea.setViewportView(areaMessage);

		JButton abortButton = new JButton("Abbrechen");
		JButton sendButton = new JButton("Versenden");
		sendButton.addActionListener(new EmailMessageListener(this));
		abortButton.addActionListener(new EmailMessageListener(this));

		southPanel.add(abortButton);
		southPanel.add(sendButton);

		this.setVisible(true);

	}

	public JTextField getNameField() {
		return nameField;
	}

	public void setNameField(JTextField nameField) {
		this.nameField = nameField;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public JTextArea getAreaMessage() {
		return areaMessage;
	}

	public void setAreaMessage(JTextArea areaMessage) {
		this.areaMessage = areaMessage;
	}

	public JComboBox <String> getSalutation() {
		return salutation;
	}

	public void setSalutation(JComboBox <String> salutation) {
		this.salutation = salutation;
	}

	public JTextField getSubjectField() {
		return subjectField;
	}

	public void setSubjectField(JTextField subjectField) {
		this.subjectField = subjectField;
	}

	public String getSubject() {
		return subjectField.getText();
	}

	public void setSubject(String subject) {
		this.subjectField.setText(subject);
	}	
}
