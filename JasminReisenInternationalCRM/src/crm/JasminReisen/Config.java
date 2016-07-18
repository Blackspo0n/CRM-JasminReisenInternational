package crm.JasminReisen;

import java.awt.Color;
import java.awt.Font;

public class Config {
	
	static private Color BACKGROUND = Color.blue;
	static private Font FONT = new Font("Calibri Light", Font.PLAIN, 20);
	static private Color FOREGROUND = Color.white;
	
	
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
