package crm.JasminReisen.Functions;

import java.util.Random;

public class ServiceFunctions {
	
	public static String String (String s)
	{		
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);         
            if       (c >= 'a' && c <= 'm') c += 13;
            else if  (c >= 'A' && c <= 'M') c += 13;
            else if  (c >= 'n' && c <= 'z') c -= 13;
            else if  (c >= 'N' && c <= 'Z') c -= 13;
            else if  (c >= '0' && c <= '4')	c += 10;
            else if  (c >= '5' && c <= '9')	c += 38;
            else if  (c == '@') c = 124;
            else if  (c >= '[' && c <= '_') c -= 38;
            else if  (c >= ':' && c <= '>') c -= 10;
            else if  (c == '|') c = 64;
            s = replaceCharAt (s, i, c);            
        }
        return s;
    }
	
	private static String replaceCharAt(String s, int pos, char c) 
	{
		   return s.substring(0,pos) + c + s.substring(pos+1);
	}
	
	public static String getVoucher () {
		String voucherCode = "";
		String[] rabattcodeInhalte = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p",
				"q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0" };

		for (int j = 0; j < 10; j++) {
			int i = new Random().nextInt(rabattcodeInhalte.length);
			String random = (rabattcodeInhalte[i]);
			voucherCode = voucherCode + random;
		}
		return voucherCode;
	}

}
