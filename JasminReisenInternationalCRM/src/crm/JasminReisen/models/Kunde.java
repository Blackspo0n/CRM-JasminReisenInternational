package crm.JasminReisen.models;

import java.util.Date;

public class Kunde {
	private int Kundennummer;
	private String Name;
	private String Vorname;
	private String Strasse;
	private String PLZ;
	private String Ort;
	private String Land;
	private String Telefon;
	private String EMail;
	private Date GebDat;
	
	public Kunde() {
		Name = "";
		Vorname = "";
		Strasse = "";
		PLZ = "";
		Ort = "";
		Land = "";
		Telefon = "";
		EMail = "";
		GebDat = null;
		Kundennummer = 0;
	}
	
	public Kunde(int kundennummer, String name, String vorname, String strasse,
			String pLZ, String ort, String land, String telefon, String eMail,
			Date gebDat) {
		this();
		Kundennummer = kundennummer;
		Name = name;
		Vorname = vorname;
		Strasse = strasse;
		PLZ = pLZ;
		Ort = ort;
		Land = land;
		Telefon = telefon;
		EMail = eMail;
		GebDat = gebDat;
	}
	
	public String toString() {
		return this.getName() + ", " + this.getVorname();
	}
	
	public int getKundennummer() {
		return Kundennummer;
	}
	public void setKundennummer(int kundennummer) {
		Kundennummer = kundennummer;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getVorname() {
		return Vorname;
	}
	public void setVorname(String vorname) {
		Vorname = vorname;
	}
	public String getStrasse() {
		return Strasse;
	}
	public void setStrasse(String strasse) {
		Strasse = strasse;
	}
	public String getPLZ() {
		return PLZ;
	}
	public void setPLZ(String pLZ) {
		PLZ = pLZ;
	}
	public String getOrt() {
		return Ort;
	}
	public void setOrt(String ort) {
		Ort = ort;
	}
	public String getLand() {
		return Land;
	}
	public void setLand(String land) {
		Land = land;
	}
	public String getTelefon() {
		return Telefon;
	}
	public void setTelefon(String telefon) {
		Telefon = telefon;
	}
	public String getEMail() {
		return EMail;
	}
	public void setEMail(String eMail) {
		EMail = eMail;
	}
	public Date getGebDat() {
		return GebDat;
	}
	public void setGebDat(Date gebDat) {
		GebDat = gebDat;
	}
	
	
}
