package crm.JasminReisen.models;

import java.util.Date;

public class Buchung {
	private Integer BuchungsId;
	private Integer ReiseId;
	private Integer KundenId;
	private Date Antrittsdatum;
	
	public Integer getBuchungsId() {
		return BuchungsId;
	}
	public void setBuchungsId(Integer buchungsId) {
		BuchungsId = buchungsId;
	}
	public Integer getReiseId() {
		return ReiseId;
	}
	public void setReiseId(Integer reiseId) {
		ReiseId = reiseId;
	}
	public Integer getKundenId() {
		return KundenId;
	}
	public void setKundenId(Integer kundenId) {
		KundenId = kundenId;
	}
	public Date getAntrittsdatum() {
		return Antrittsdatum;
	}
	public void setAntrittsdatum(Date antrittsdatum) {
		Antrittsdatum = antrittsdatum;
	}
	
	
}
