package crm.JasminReisen.models;

import java.util.Date;

public class HistoryReise {
	
	Date reiseBeginn;
	Date reiseEnde;
	String reiseName;
	String zielOrt;
	String hotel;
	double preis;
	
	public HistoryReise() {
		
	}

	public Date getReiseBeginn() {
		return reiseBeginn;
	}

	public void setReiseBeginn(Date reiseBeginn) {
		this.reiseBeginn = reiseBeginn;
	}

	public Date getReiseEnde() {
		return reiseEnde;
	}

	public void setReiseEnde(Date reiseEnde) {
		this.reiseEnde = reiseEnde;
	}

	public String getReiseName() {
		return reiseName;
	}

	public void setReiseName(String reiseName) {
		this.reiseName = reiseName;
	}

	public String getZielOrt() {
		return zielOrt;
	}

	public void setZielOrt(String zielOrt) {
		this.zielOrt = zielOrt;
	}

	public String getHotel() {
		return hotel;
	}

	public void setHotel(String hotel) {
		this.hotel = hotel;
	}

	public double getPreis() {
		return preis;
	}

	public void setPreis(double preis) {
		this.preis = preis;
	}
	
}
