package crm.JasminReisen.models;

import java.util.Date;

public class Reise {
	private Integer ReiseID;
	private String Name;
	private Date ReiseBeginn;
	private Date ReiseEnde;
	private Integer VerfuegbarePlaetze;
	private Integer TransportmittelId;
	private String Klima;
	private String Thema;
	private String Region;
	private Integer HotelId;
	private double Preis;
	private String Beschreibung;
	
	public Integer getReiseID() {
		return ReiseID;
	}
	public void setReiseID(Integer reiseID) {
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
	public Integer getVerfuegbarePlaetze() {
		return VerfuegbarePlaetze;
	}
	public void setVerfuegbarePlaetze(Integer verfuegbarePlaetze) {
		VerfuegbarePlaetze = verfuegbarePlaetze;
	}
	public Integer getTransportmittelId() {
		return TransportmittelId;
	}
	public void setTransportmittelId(Integer transportmittelId) {
		TransportmittelId = transportmittelId;
	}
	public String getKlima() {
		return Klima;
	}
	public void setKlima(String klima) {
		Klima = klima;
	}
	public String getThema() {
		return Thema;
	}
	public void setThema(String thema) {
		Thema = thema;
	}
	public String getRegion() {
		return Region;
	}
	public void setRegion(String region) {
		Region = region;
	}
	public Integer getHotelId() {
		return HotelId;
	}
	public void setHotelId(Integer hotelId) {
		HotelId = hotelId;
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
