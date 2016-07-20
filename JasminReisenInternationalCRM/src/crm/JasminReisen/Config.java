package crm.JasminReisen;

import java.awt.Color;
import java.awt.Font;

public class Config {
	
	static private Color BACKGROUND = Color.white;
	static private Font FONT = new Font("Calibri Light", Font.PLAIN, 20);
	static private Font FONT_TEXTFIELD = new Font("Calibri Light", Font.PLAIN, 14);
	static private Font FONT_SUPERSIZE = new Font("Calibri Light", Font.PLAIN, 45);
	static private Color BORDER = Color.LIGHT_GRAY;
	public static Color getBORDER() {
		return BORDER;
	}
	public static void setBORDER(Color bORDER) {
		BORDER = bORDER;
	}
	public static Font getFONT_TEXTFIELD() {
		return FONT_TEXTFIELD;
	}
	public static void setFONT_TEXTFIELD(Font fONT_TEXTFIELD) {
		FONT_TEXTFIELD = fONT_TEXTFIELD;
	}
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
	public static Font getFONT_SUPERSIZE() {
		return FONT_SUPERSIZE;
	}
	public static void setFONT_SUPERSIZE(Font fONT_SUPERSIZE) {
		FONT_SUPERSIZE = fONT_SUPERSIZE;
	}
	
}
