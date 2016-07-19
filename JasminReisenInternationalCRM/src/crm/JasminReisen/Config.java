package crm.JasminReisen;

import java.awt.Color;
import java.awt.Font;

public class Config {
	
	static private Color BACKGROUND = Color.white;
	static private Font FONT = new Font("Calibri Light", Font.PLAIN, 20);
	static private Font HEADLINE = new Font("Calibri Light", Font.BOLD, 22);
	public static Font getHEADLINE() {
		return HEADLINE;
	}
	public static void setHEADLINE(Font hEADLINE) {
		HEADLINE = hEADLINE;
	}
	static private Color FOREGROUND = Color.black;
	
	
	public static Color getBACKGROUND() {
		return BACKGROUND;
	}
	public static void setBACKGROUND(Color bACKGROUND) {
		BACKGROUND = bACKGROUND;
	}
	public static Font getFONT() {
		return FONT;
	}
	public static void setFONT(Font fONT) {
		FONT = fONT;
	}
	public static Color getFOREGROUND() {
		return FOREGROUND;
	}
	public static void setFOREGROUND(Color fOREGROUND) {
		FOREGROUND = fOREGROUND;
	}
	
}
