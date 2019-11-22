import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * HairSalon
 */
public class HairSalon {

    public final static double TAX_RATE = 6.5;        // 6.5%
    public final static String STORE_NAME = "Hair So Long Salon";
    
    public static String cents2dollarsAndCents(int cents) {
   
      String s = "";
       
      if (cents < 0) {
        s += "-";
        cents *= -1;
      }
      
      int dollars = cents/100;
      cents = cents % 100;
      
      if (dollars > 0)
        s += dollars;
      
      s +=".";
        
      if (cents < 10)
        s += "0";
        
      s += cents;
      return s;
    } 
  
    public static Date string2Date(String date) {
      SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
      return formatter.parse(date);
    }

    public static String date2String(Date date) {
      SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
      return formatter.format(date);
    }
}