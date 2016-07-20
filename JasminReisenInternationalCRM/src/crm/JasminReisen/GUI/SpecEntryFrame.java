package crm.JasminReisen.GUI;

import java.awt.*;

import javax.swing.*;

import crm.JasminReisen.Config;
import crm.JasminReisen.Listener.SpecEntryFrameListener;


public class SpecEntryFrame extends JFrame
{
	private JComboBox box;
	private JTextField entry;
	private JButton send;
	private JButton reset;
	private JPanel boxpanel;
	private JPanel entrypanel;
	private JPanel buttonpanel;
	
	public static void main (String [] args)
	{
		new SpecEntryFrame();
	}
	
	public SpecEntryFrame()
		{
			
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setResizable(false);
			//this.setUndecorated(true);
			this.setSize(270,150);
			setLocationRelativeTo(null);
			setTitle("Neue Spec anlegen");
			this.setBackground(Config.getBACKGROUND());
			this.setLayout(new BorderLayout());
			boxpanel = new JPanel();
			boxpanel.setBackground(Config.getBACKGROUND());
			entrypanel = new JPanel(new BorderLayout());
			entrypanel.setBackground(Config.getBACKGROUND());
			buttonpanel = new JPanel(new GridLayout(2,1,2,2));
			buttonpanel.setBackground(Config.getBACKGROUND());
			
			String [] list = {"--- Bitte auswählen ---",
					"Neue Region anlegen",
					"Neues Klima anlegen",
					"Neues Thema anlegen",
					"Neues Transportmittel anlegen"};
			
			this.entry = new JTextField();
			this.reset = new JButton("Eingaben zurücksetzen");
			this.send = new JButton ("Spezifikation anlegen");
			this.box = new JComboBox(list);
			this.send.addActionListener(new SpecEntryFrameListener(this));
			this.reset.addActionListener(new SpecEntryFrameListener(this));
			
			boxpanel.add(box);
			entrypanel.add(entry, BorderLayout.CENTER);
			buttonpanel.add(reset);
			buttonpanel.add(send);
			this.add(boxpanel, BorderLayout.NORTH);
			this.add(entrypanel, BorderLayout.CENTER);
			this.add(buttonpanel, BorderLayout.SOUTH);
			
			
			this.setVisible(true);
		}

	public JComboBox getBox() {
		return box;
	}

	public JTextField getEntry() {
		return entry;
	}

	public JButton getSend() {
		return send;
	}

	public JButton getReset() {
		return reset;
	}

	public JPanel getBoxpanel() {
		return boxpanel;
	}

	public JPanel getEntrypanel() {
		return entrypanel;
	}

	public JPanel getButtonpanel() {
		return buttonpanel;
	}

	public void setBox(JComboBox box) {
		this.box = box;
	}

	public void setEntry(JTextField entry) {
		this.entry = entry;
	}

	public void setSend(JButton send) {
		this.send = send;
	}

	public void setReset(JButton reset) {
		this.reset = reset;
	}

	public void setBoxpanel(JPanel boxpanel) {
		this.boxpanel = boxpanel;
	}

	public void setEntrypanel(JPanel entrypanel) {
		this.entrypanel = entrypanel;
	}

	public void setButtonpanel(JPanel buttonpanel) {
		this.buttonpanel = buttonpanel;
	}
}
