
package uk.ac.aber.dcs.cs12420.aberpizza.data;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
 
 

/**
 * The Class DateAndTime.
 * This class gets the date and time at the current moment, and produces this
 * as a string in the format e.g "2012/05/01 11:02:01".
 * 
 * @author Craig Heptinstall(Crh13)
 */
public class DateAndTime {
  
  /**
   * Gets the time and date.
   *
   * @return the time and date
   */
  public static String getTimeAndDate() {
 
	   DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	   //get current date time with Date()
	   Date date = new Date();
	   
           String Date = dateFormat.format(date);
       return Date;
  }
}