package crm.JasminReisen.GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import crm.JasminReisen.Config;
import crm.JasminReisen.Functions.ServiceFunctions;
import crm.JasminReisen.Listener.BirthdayMessageListener;

public class BirthdayMessageFrame extends JDialog {

	String rabattCode;
	String mail;
	int kundenNummer;
	int alter;
	private JTextField nameField;
	private JTextArea areaMessage;
	private JComboBox salutation;

	public BirthdayMessageFrame(int customerID, String kundenName, String kundenMail, int age) {
		this.setSize(600, 450);
		this.setLayout(new BorderLayout());
		this.setLocationRelativeTo(null);
		this.setTitle("Geburtstagsgrüße erstellen");

		mail = kundenMail;
		rabattCode = ServiceFunctions.getVoucher();
		kundenNummer = customerID;
		alter = age;

		JPanel northPanel = new JPanel();
		northPanel.setLayout(new GridLayout(1, 2, 30, 10));
		northPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		this.add(northPanel, BorderLayout.NORTH);
		String[] salutationArray = { "Sehr geehrte Frau", "Sehr geehrter Herr" };
		salutation = new JComboBox(salutationArray);
		northPanel.add(salutation);

		nameField = new JTextField(kundenName);
		nameField.setFont(Config.getFONT());
		northPanel.add(nameField);

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
		areaMessage.setText("Sie feiern heute Ihren " + alter + ". Geburtstag – kaum zu glauben! \n\n"
				+ "Sie können mit Stolz auf Ihr erfolgreiches Wirken zurückblicken. \n"
				+ "Jahre, die geprägt waren von Mut, Beharrlichkeit und einer beneidenswerten \n"
				+ "Schaffenskraft, die wir an Ihnen so sehr bewundern.\n\nHeute an Ihrem Feiertag "
				+ "möchten auch wir uns in die Reihe der Gratulanten stellen:\nNehmen Sie unsere "
				+ "herzlichen Glückwünsche entgegen. Bleiben Sie bei guter Gesundheit und möge "
				+ "Ihnen jene Vitalität erhalten bleiben, die Sie auszeichnet.\n"
				+ "Gerne möchten wir Ihnen eine kleine Freude machen, nutzen Sie innerhalb der nächsten "
				+ "drei Monate den Rabattacode\n\n" + rabattCode + "\n\nund profitieren Sie von einem Rabatt"
				+ " über 5% auf Ihre nächste gebuchte Reise.\n\nIn diesem Sinne "
				+ "bleiben wir mit den besten Wünschen und Grüßen Ihre\n\n\n Jasmin\n Inhaberin von Jasmin Reisen International");
		scrollPaneArea.setViewportView(areaMessage);

		JButton abortButton = new JButton("Abbrechen");
		JButton sendButton = new JButton("Versenden");
		sendButton.addActionListener(new BirthdayMessageListener(this));
		abortButton.addActionListener(new BirthdayMessageListener(this));

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

	public String getRabattCode() {
		return rabattCode;
	}

	public void setRabattCode(String rabattCode) {
		this.rabattCode = rabattCode;
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

	public int getKundenNummer() {
		return kundenNummer;
	}

	public void setKundenNummer(int kundenNummer) {
		this.kundenNummer = kundenNummer;
	}

	public int getAlter() {
		return alter;
	}

	public void setAlter(int alter) {
		this.alter = alter;
	}

	public JComboBox getSalutation() {
		return salutation;
	}

	public void setSalutation(JComboBox salutation) {
		this.salutation = salutation;
	}
}
