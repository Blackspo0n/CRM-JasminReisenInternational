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
import crm.JasminReisen.Listener.NewsletterMessageListener;

public class NewsletterMessageFrame extends JDialog {

	private JTextArea areaMessage;
	
	public NewsletterMessageFrame() {
		this.setSize(600, 450);
		this.setLayout(new BorderLayout());
		this.setLocationRelativeTo(null);
		this.setTitle("Newsletter versenden");

		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());
		centerPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new GridLayout(1, 3, 30, 10));
		this.add(centerPanel, BorderLayout.CENTER);
		this.add(southPanel, BorderLayout.SOUTH);

		JScrollPane scrollPaneArea = new JScrollPane();
		centerPanel.add(scrollPaneArea, BorderLayout.CENTER);

		areaMessage = new JTextArea();
		areaMessage.setText("Hier kommt unser monatlicher Newsletter.\n"
				+ "Im Anhang finden Sie unsere aktuellen Last-Minute-Schnäppchen!");
		scrollPaneArea.setViewportView(areaMessage);

		JButton abortButton = new JButton("Abbrechen");
		JButton sendButton = new JButton("Versenden");
		//JButton attachmentButton = new JButton("Anhang");
		sendButton.addActionListener(new NewsletterMessageListener(this));
		abortButton.addActionListener(new NewsletterMessageListener(this));
		//attachmentButton.addActionListener(new NewsletterMessageListener(this));

		southPanel.add(abortButton);
		southPanel.add(sendButton);
		//southPanel.add(attachmentButton);

		this.setVisible(true);

	}	

	public JTextArea getAreaMessage() {
		return areaMessage;
	}

	public void setAreaMessage(JTextArea areaMessage) {
		this.areaMessage = areaMessage;
	}
}
