/**
 * 
 */
package uk.ac.aber.dcs.cs1240.aberpizza.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import uk.ac.aber.dcs.cs12420.aberpizza.data.OfferData;
import uk.ac.aber.dcs.cs12420.aberpizza.data.Order;

/**
 * @author Craig
 * 
 */
public class OfferDataTest {
	ArrayList test;
	private Order OD;
	private OfferData OF;
	
	@Before
	public void setup(){
		test = new ArrayList();
		OD = new Order();
		OF = new OfferData();
			}
	/**
	 * Test method for
	 * {@link uk.ac.aber.dcs.cs12420.aberpizza.data.OfferData#checkOffers()}.
	 */
	@Test
	public void testCheckOffers() {
		test.add("1 £3.49 Cheese & Tomato");
		test.add("1 £1.29 Coke");
		OD.setItems(test);
		OF.checkOffers();
		assertEquals("Could not calculate Offer","******£-0.99 Cheese And Any Drink* Offer******",OD.getOffers().get(0));
		
	}
	
	@Test 
	public void testCheckNoOffers() {
		OD.clearOffers();
		OD.clearItems();
		OF.checkOffers();
		assertEquals("Could not check offers", 0,  OD.getOffers().size());
	}

}
