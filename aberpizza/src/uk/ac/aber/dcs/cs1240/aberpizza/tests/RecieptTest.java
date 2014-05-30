/**
 * 
 */
package uk.ac.aber.dcs.cs1240.aberpizza.tests;

import java.util.ArrayList;

import javax.swing.JFileChooser;

import org.junit.Test;

import uk.ac.aber.dcs.cs12420.aberpizza.FileIO.Reciept;

/**
 * @author Craig
 * 
 */
public class RecieptTest {
	private Reciept RC;

	/**
	 * Test method for
	 * {@link uk.ac.aber.dcs.cs12420.aberpizza.FileIO.Reciept#printOut(java.lang.String, java.util.ArrayList, java.lang.String, java.lang.String, double, double, double)}
	 * .
	 * @throws Exception 
	 */
	@Test
	public void testPrintOut() throws Exception {
		RC = new Reciept();
		String fileDir = "C:\\Users\\Craig";
		ArrayList<String> items = new ArrayList<String>();
		items.add("Test");
				
		RC.printOut(fileDir, items, "customer","staff", 12.22, 15.00, 2.78);
	}

}
