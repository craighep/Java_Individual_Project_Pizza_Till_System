package uk.ac.aber.dcs.cs12420.aberpizza.FileIO;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import uk.ac.aber.dcs.cs12420.aberpizza.data.DateAndTime;
import uk.ac.aber.dcs.cs12420.aberpizza.data.OfferData;
import uk.ac.aber.dcs.cs12420.aberpizza.data.Order;


/**
 * The Class Receipt.
 * Exports receipt data to file using data retrieved from all {@link uk.ac.aber.dcs.cs12420.aberpizza.data.Order} & 
 * 
 * 
 * @author Craig Heptinstall (crh13)
 *
 */

public class Reciept {

	
        /** The space. */
        private String directEnd, space;

	/**
	 * 
	 *
	 * @param filePath - File path for .java files selected by user using dialog
	 * @param items the items
	 * @param customer the customer
	 * @param staff the staff
	 * @param total the total
	 * @param tendered the tendered
	 * @param change the change
	 * @throws Exception - IO/FileNotFound exceptions that are thrown and dealt with by {@link uk.ac.aber.dcs.cs124.clg11.panel.CanvasPanel}
	 */
	public void printOut(String filePath, ArrayList<String>items, String customer, String staff, double total, double tendered, double change) throws Exception{
                DateAndTime DT = new DateAndTime();
                String date = DT.getTimeAndDate();
                Order OD = new Order();
                String dateTitle = date.replace("/", "_");
                dateTitle = dateTitle.replace(":", "_"); 
                dateTitle = dateTitle.replace(" ", "_"); 
		//Determine OS so that correct directory symbol can be used
		String os = System.getProperty("os.name").toLowerCase();
		
		if (os.indexOf("win") >= 0) {
			directEnd = "\\";
		} else {
			directEnd = "/";
		}
		
		//Create and initialise new PrintWriter with selected filepath
		PrintWriter out = new PrintWriter(new FileWriter(filePath + directEnd + "Reciept- " +dateTitle+ ".txt"));
		
		//Write out class Java code with current class name
		out.write("  ****************************** ABER PIZZA ******************************* "  + "\r\n");
		out.write("\r\n"); //Perform carriage return
                out.write("  Thank You For Using Aber Pizza, Your Reciept Is As Follows:"  + "\r\n");
                out.write("  _________________________________________________________________________"  + "\r\n");
                out.write(" | Quantity |      Cost    |                 Item Description              |"  + "\r\n");
                out.write(" |-------------------------------------------------------------------------|"  + "\r\n");
		//Loop through all variables in class
		for (int i = 0; i < items.size()/2; i++) {
			String s = items.get(i);
                        String quantities = s.substring(0,2).trim();
                        String costs = s.substring(3,9).trim();
                        String itemName = s.substring(9).trim();
                int quan = Integer.parseInt(quantities);
                if (quan > 9) { space = "";}
                if (quan < 10){ space = " ";}
                out.write(" |   " + quantities.trim());
                out.write("           " + space +costs.trim());
                out.write("             " +itemName.trim());
                out.write("  "+"\r\n"); //Perform carriage return
                }
                out.write(" |------------------------------------------------------------------------- "  + "\r\n");
                for (int i = 0; i < OD.getOffers().size(); i++) {
			String s = OD.getOffers().get(i);
                out.write(" |    " + s +"\r\n");
                }
                out.write(" |------------------------------------------------------------------------- "  + "\r\n");
                out.write(" | TOTAL SPEND (VAT 20%): £"+total  + "\r\n");
                out.write(" | TENDERED             : £"+tendered  + "\r\n");
                out.write(" |__________________________________________________________________________" + "\r\n");
                out.write(" | CHANGE GIVEN:        : £"+change  + "\r\n");
                out.write(" |__________________________________________________________________________"  + "\r\n");
                out.write(" |"+"\r\n");
                out.write(" |  For Customer     : "+ customer  + "\r\n");
                out.write(" |   You Was Served By: "+staff  + "\r\n");
                out.write(" |"+"\r\n");
                out.write(" |   Date printed     : "+date  + "\r\n");
                out.write(" |"+"\r\n");
                out.write(" |    Aber Pizza, Main Road 1, Aberystwyth, Cerdigion, Wales, SY23 3LH"  + "\r\n");
                out.write(" |                       THANK YOU PLEASE COME AGAIN!                       "  + "\r\n");
                out.write("  **************************************************************************");
		
		//Close PrintWriter
		out.close();
                
                
	}
}


