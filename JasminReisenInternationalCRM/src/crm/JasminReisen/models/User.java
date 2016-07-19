package crm.JasminReisen.models;

public class User {
	private Integer BenutzerId;
	private String BenutzerName;
	private String Passwort;
	
	public User(Integer benutzerId, String benutzerName, String passwort) {
		BenutzerId = benutzerId;
		BenutzerName = benutzerName;
		Passwort = passwort;
	}

	public Integer getBenutzerId() {
		return BenutzerId;
	}

	public void setBenutzerId(Integer benutzerId) {
		BenutzerId = benutzerId;
	}

	public String getBenutzerName() {
		return BenutzerName;
	}

	public void setBenutzerName(String benutzerName) {
		BenutzerName = benutzerName;
	}

	public String getPasswort() {
		return Passwort;
	}

	public void setPasswort(String passwort) {
		Passwort = passwort;
	}
}
