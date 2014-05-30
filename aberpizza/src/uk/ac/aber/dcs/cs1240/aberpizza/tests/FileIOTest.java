/**
 * 
 */
package uk.ac.aber.dcs.cs1240.aberpizza.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import uk.ac.aber.dcs.cs12420.aberpizza.FileIO.FileIO;
import uk.ac.aber.dcs.cs12420.aberpizza.data.Order;

/**
 * @author Craig
 * 
 */
public class FileIOTest {
	private Order OD;
	private FileIO FIO;
	/**
	 * Test method for
	 * {@link uk.ac.aber.dcs.cs12420.aberpizza.FileIO.FileIO#saveTillObjects()}.
	 */
	@Test
	public void testSaveAndLoadTillObjects() {
		OD = new Order();
		OD.addItems("Test");
		OD.setStaff("Staff");
		OD.setCustomer("Customer");
		OD.setTotal(13.99);
		FIO = new FileIO();
		FIO.saveTillObjects();
		FIO.saveSaves();
		FIO.loadSaves();
		
		
		
	}

	/**
	 * Test method for
	 * {@link uk.ac.aber.dcs.cs12420.aberpizza.FileIO.FileIO#getCheck()}.
	 */
	@Test
	public void testGetCheck() {
		FIO = new FileIO();
		boolean test = FIO.getCheck();
		assertEquals("Cannot get check", true, test);
	}

}
