package crm.JasminReisen.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import crm.JasminReisen.Config;
import crm.JasminReisen.Functions.DbFunctions;
import crm.JasminReisen.Listener.WiederVorlageFrameListener;

public class WiederVorlageFrame extends JFrame {
	private int IdConext = 0;
	private MainFrame mainFrame;
	
	private JPanel northPanel;
	private JLabel header;
	private JLabel beschreibung;
	private JTextArea beschreibungArea;

	private JPanel centerPanel;

	private JPanel centerPanelNorth;

	private JPanel centerPanelSouth;

	private JLabel thema;

	private JTextField txtThema;

	private JTextField txtKunde;

	private JLabel kundeLabel;

	private JLabel aktionsLabel;

	private JTextField txtAktion;

	private JScrollPane scrollPane;

	private JPanel southPanel;

	private JButton btnErledigt;

	private ResultSet tmp;

	private JButton btnCancle;
	
	public WiederVorlageFrame(MainFrame mf, int ID) {
		IdConext = ID;
		mainFrame = mf;
		
		setLayout(new BorderLayout());
		setSize(400, 250);
		setLocationRelativeTo(null);
		setTitle("Wiedervorlage Anzeigen");
		
		centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(0,2,5,5));
		add(centerPanel, BorderLayout.CENTER);
		
		centerPanel.setBorder(new EmptyBorder(0,10,0,10));
		centerPanel.setLayout(new BorderLayout());
		
		centerPanelNorth = new JPanel();
		centerPanelNorth.setLayout(new GridLayout(0,2,0,6));
		centerPanelNorth.setPreferredSize(new Dimension(400,160));
		centerPanel.add(centerPanelNorth, BorderLayout.CENTER);
		
		
		centerPanelSouth = new JPanel();
		centerPanel.add(centerPanelSouth, BorderLayout.SOUTH);
		centerPanelSouth.setPreferredSize(new Dimension(400,60));
		centerPanelSouth.setLayout(new GridLayout(0,2,0,2));
		centerPanelSouth.setBorder(new EmptyBorder(10,0,0,0));
		
		
		
		thema = new JLabel("Thema");
		txtThema = new JTextField();
		
		centerPanelNorth.add(thema);
		centerPanelNorth.add(txtThema);
		

		kundeLabel = new JLabel("Kunde");
		txtKunde = new JTextField();
		
		centerPanelNorth.add(kundeLabel);
		centerPanelNorth.add(txtKunde);
		

		aktionsLabel = new JLabel("Aktion");
		txtAktion = new JTextField();
		
		centerPanelNorth.add(aktionsLabel);
		centerPanelNorth.add(txtAktion);
		
		beschreibung = new JLabel("Beschreibung:");
		beschreibung.setVerticalAlignment(SwingConstants.TOP);
		beschreibung.setPreferredSize(new Dimension(60,60));
		scrollPane = new JScrollPane();
		beschreibungArea = new JTextArea();

		beschreibungArea.setBorder(new LineBorder(Config.getBORDER()));
		scrollPane.setViewportView(beschreibungArea);
		
		centerPanelSouth.add(beschreibung);
		centerPanelSouth.add(beschreibungArea);
		
		
		southPanel = new JPanel();
		btnCancle = new JButton("Abbrechen");
		btnCancle.addActionListener(new WiederVorlageFrameListener(this));
		
		southPanel.add(btnCancle);
		btnErledigt = new JButton("Auf Erledigt setzen");
		btnErledigt.addActionListener(new WiederVorlageFrameListener(this));
		
		southPanel.add(btnErledigt);
		
		add(southPanel, BorderLayout.SOUTH);
		
		northPanel = new JPanel();
		add(northPanel, BorderLayout.NORTH);
		northPanel.setAlignmentX(LEFT_ALIGNMENT);
		northPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		header = new JLabel("Wiedervorlage anzeigen:");
		header.setHorizontalAlignment(SwingConstants.LEFT);
		header.setFont(new Font("Calibri Light", Font.BOLD, 22));
		northPanel.add(header);
		
		tmp = null;
		if(ID == 0 || (tmp = DbFunctions.getWiederVorlage(ID)) == null) {
			this.dispose();
			JOptionPane.showMessageDialog(null, "Wiedervorlage existiert nicht");
			return;
		}
		
		try {
			txtThema.setText(tmp.getString("WiedervorlageThema").substring(7, tmp.getString("WiedervorlageThema").indexOf("Beschreibung:")));
			txtKunde.setText(tmp.getString("Vorname") + " " + tmp.getString("Name"));
			txtAktion.setText(tmp.getString("AktionsName"));
			beschreibungArea.setText(
					tmp.getString("WiedervorlageThema").substring(tmp.getString("WiedervorlageThema").lastIndexOf("Beschreibung:")+13)
			);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		setVisible(true);
	}

	public int getIdConext() {
		return IdConext;
	}

	public void setIdConext(int idConext) {
		IdConext = idConext;
	}

	public JPanel getNorthPanel() {
		return northPanel;
	}

	public void setNorthPanel(JPanel northPanel) {
		this.northPanel = northPanel;
	}

	public JLabel getHeader() {
		return header;
	}

	public void setHeader(JLabel header) {
		this.header = header;
	}

	public JLabel getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(JLabel beschreibung) {
		this.beschreibung = beschreibung;
	}

	public JTextArea getBeschreibungArea() {
		return beschreibungArea;
	}

	public void setBeschreibungArea(JTextArea beschreibungArea) {
		this.beschreibungArea = beschreibungArea;
	}

	public JPanel getCenterPanel() {
		return centerPanel;
	}

	public void setCenterPanel(JPanel centerPanel) {
		this.centerPanel = centerPanel;
	}

	public JPanel getCenterPanelNorth() {
		return centerPanelNorth;
	}

	public void setCenterPanelNorth(JPanel centerPanelNorth) {
		this.centerPanelNorth = centerPanelNorth;
	}

	public JPanel getCenterPanelSouth() {
		return centerPanelSouth;
	}

	public void setCenterPanelSouth(JPanel centerPanelSouth) {
		this.centerPanelSouth = centerPanelSouth;
	}

	public JLabel getThema() {
		return thema;
	}

	public void setThema(JLabel thema) {
		this.thema = thema;
	}

	public JTextField getTxtThema() {
		return txtThema;
	}

	public void setTxtThema(JTextField txtThema) {
		this.txtThema = txtThema;
	}

	public JTextField getTxtKunde() {
		return txtKunde;
	}

	public void setTxtKunde(JTextField txtKunde) {
		this.txtKunde = txtKunde;
	}

	public JLabel getKundeLabel() {
		return kundeLabel;
	}

	public void setKundeLabel(JLabel kundeLabel) {
		this.kundeLabel = kundeLabel;
	}

	public JLabel getAktionsLabel() {
		return aktionsLabel;
	}

	public void setAktionsLabel(JLabel aktionsLabel) {
		this.aktionsLabel = aktionsLabel;
	}

	public JTextField getTxtAktion() {
		return txtAktion;
	}

	public void setTxtAktion(JTextField txtAktion) {
		this.txtAktion = txtAktion;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public JPanel getSouthPanel() {
		return southPanel;
	}

	public void setSouthPanel(JPanel southPanel) {
		this.southPanel = southPanel;
	}

	public JButton getBtnErledigt() {
		return btnErledigt;
	}

	public void setBtnErledigt(JButton btnErledigt) {
		this.btnErledigt = btnErledigt;
	}

	public ResultSet getTmp() {
		return tmp;
	}

	public void setTmp(ResultSet tmp) {
		this.tmp = tmp;
	}

	public MainFrame getMainFrame() {
		return mainFrame;
	}

	public void setMainFrame(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	public JButton getBtnCancle() {
		return btnCancle;
	}

	public void setBtnCancle(JButton btnCancle) {
		this.btnCancle = btnCancle;
	}
}
