package crm.JasminReisen.models;

import java.util.Date;

public class Reise {
	private int ReiseID;
	private String Name;
	private String Beschreibung;
	private Date ReiseBeginn;
	private Date ReiseEnde;
	private int VerfuegbarePlaetze;
	private int TransportmittelID;
	private int KlimaID;
	private int ThemaID;
	private int RegionID;
	private int HotelID;
	private double Preis;
	private String ZielOrt;
	private int Gruppengroesse;
	private int Kontingent;
	private Date VerfuegbarAb;
	
	public Reise () {

	}
	
	
	public Reise(int reiseID, String name, String beschreibung,
			Date reiseBeginn, Date reiseEnde, int verfuegbarePlaetze,
			int transportmittelID, int klimaID, int themaID,
			int regionID, int hotelID, double preis, String zielOrt,
			int gruppengroesse, int kontingent, Date verfuegbarAb) {
		ReiseID = reiseID;
		Name = name;
		Beschreibung = beschreibung;
		ReiseBeginn = reiseBeginn;
		ReiseEnde = reiseEnde;
		VerfuegbarePlaetze = verfuegbarePlaetze;
		TransportmittelID = transportmittelID;
		KlimaID = klimaID;
		ThemaID = themaID;
		RegionID = regionID;
		HotelID = hotelID;
		Preis = preis;
		ZielOrt = zielOrt;
		Gruppengroesse = gruppengroesse;
		Kontingent = kontingent;
		VerfuegbarAb = verfuegbarAb;
	}

	public String getZielOrt() {
		return ZielOrt;
	}


	public void setZielOrt(String zielOrt) {
		ZielOrt = zielOrt;
	}


	public int getGruppengroesse() {
		return Gruppengroesse;
	}


	public void setGruppengroesse(int gruppengroesse) {
		Gruppengroesse = gruppengroesse;
	}

	public int getKontingent() {
		return Kontingent;
	}


	public void setKontingent(int kontingent) {
		Kontingent = kontingent;
	}


	public Date getVerfuegbarAb() {
		return VerfuegbarAb;
	}


	public void setVerfuegbarAb(Date verfuegbarAb) {
		VerfuegbarAb = verfuegbarAb;
	}


	public int getReiseID() {
		return ReiseID;
	}

	public void setReiseID(int reiseID) {
		ReiseID = reiseID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Date getReiseBeginn() {
		return ReiseBeginn;
	}

	public void setReiseBeginn(Date reiseBeginn) {
		ReiseBeginn = reiseBeginn;
	}

	public Date getReiseEnde() {
		return ReiseEnde;
	}

	public void setReiseEnde(Date reiseEnde) {
		ReiseEnde = reiseEnde;
	}

	public int getVerfuegbarePlaetze() {
		return VerfuegbarePlaetze;
	}

	public void setVerfuegbarePlaetze(int verfuegbarePlaetze) {
		VerfuegbarePlaetze = verfuegbarePlaetze;
	}

	public int getTransportmittelID() {
		return TransportmittelID;
	}

	public void setTransportmittelID(int transportmittelID) {
		TransportmittelID = transportmittelID;
	}

	public int getKlimaID() {
		return KlimaID;
	}

	public void setKlimaID(int klimaID) {
		KlimaID = klimaID;
	}

	public int getThemaID() {
		return ThemaID;
	}

	public void setThemaID(int themaID) {
		ThemaID = themaID;
	}

	public int getRegionID() {
		return RegionID;
	}

	public void setRegionID(int regionID) {
		RegionID = regionID;
	}

	public int getHotelID() {
		return HotelID;
	}

	public void setHotelID(int hotelID) {
		HotelID = hotelID;
	}

	public double getPreis() {
		return Preis;
	}

	public void setPreis(double preis) {
		Preis = preis;
	}

	public String getBeschreibung() {
		return Beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		Beschreibung = beschreibung;
	}
	
}
