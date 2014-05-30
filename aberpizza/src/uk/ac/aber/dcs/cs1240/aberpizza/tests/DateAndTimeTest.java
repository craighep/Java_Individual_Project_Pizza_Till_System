/**
 * 
 */
package uk.ac.aber.dcs.cs1240.aberpizza.tests;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import uk.ac.aber.dcs.cs12420.aberpizza.data.DateAndTime;

/**
 * @author Craig
 * 
 */
public class DateAndTimeTest {

	/**
	 * Test method for
	 * {@link uk.ac.aber.dcs.cs12420.aberpizza.data.DateAndTime#getTimeAndDate()}
	 * .
	 */
	@Test
	public void testGetTimeAndDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String Date = dateFormat.format(date);
		assertEquals("Could not get Date", Date, DateAndTime.getTimeAndDate());
	}

}
