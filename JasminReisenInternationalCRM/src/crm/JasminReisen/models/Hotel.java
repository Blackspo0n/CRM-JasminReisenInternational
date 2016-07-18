package crm.JasminReisen.models;

public class Hotel {
	private Integer HotelId;
	private Integer Sterne;

	private String Strasse;
	private String PLZ;
	private String Ort;
	private String Land;
	
	private Integer Zimmetyp;

	public Integer getHotelId() {
		return HotelId;
	}

	public void setHotelId(Integer hotelId) {
		HotelId = hotelId;
	}

	public Integer getSterne() {
		return Sterne;
	}

	public void setSterne(Integer sterne) {
		Sterne = sterne;
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

	public Integer getZimmetyp() {
		return Zimmetyp;
	}

	public void setZimmetyp(Integer zimmetyp) {
		Zimmetyp = zimmetyp;
	}
}