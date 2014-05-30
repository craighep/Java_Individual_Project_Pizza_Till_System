/**
 * 
 */
package uk.ac.aber.dcs.cs1240.aberpizza.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import uk.ac.aber.dcs.cs12420.aberpizza.data.Order;

/**
 * @author Craig
 * 
 */
public class OrderTest {

	private Order OD;

	@Before
	public void setup() {
		OD = new Order();
		OD.addItems("Test Item");
		OD.addSaves("Test Item");
		OD.addOffers("Test Offer");
	}

	/**
	 * Test method for
	 * {@link uk.ac.aber.dcs.cs12420.aberpizza.data.Order#addItems(java.lang.String)}
	 * .
	 */
	@Test
	public void testAddItems() {
		OD.addItems("Test Item 2");
		assertEquals("Cannot add Item", "Test Item 2", OD.getItems().get(0));
	}

	/**
	 * Test method for
	 * {@link uk.ac.aber.dcs.cs12420.aberpizza.data.Order#getItems()}.
	 */
	@Test
	public void testGetItems() {
		assertEquals("Cannot get Item", "Test Item", OD.getItems().get(0));
	}

	/**
	 * Test method for
	 * {@link uk.ac.aber.dcs.cs12420.aberpizza.data.Order#setItems(java.util.ArrayList)}
	 * .
	 */
	@Test
	public void testSetItems() {
		ArrayList<String> test = new ArrayList<String>();
		test.add("TEST1");
		test.add("TEST2");
		OD.setItems(test);
		assertEquals("Items cannot be set", test, OD.getItems());
	}

	/**
	 * Test method for
	 * {@link uk.ac.aber.dcs.cs12420.aberpizza.data.Order#addSaves(java.lang.String)}
	 * .
	 */
	@Test
	public void testAddSaves() {
		OD.addSaves("Test Item 2");
		assertEquals("Cannot add Save", "Test Item 2", OD.getSaves().get(0));
	}

	/**
	 * Test method for
	 * {@link uk.ac.aber.dcs.cs12420.aberpizza.data.Order#setSaves(java.util.ArrayList)}
	 * .
	 */
	@Test
	public void testSetSaves() {
		ArrayList<String> test = new ArrayList<String>();
		test.add("TEST1");
		test.add("TEST2");
		OD.setSaves(test);
		assertEquals("Saves cannot be set", test, OD.getSaves());
	}

	/**
	 * Test method for
	 * {@link uk.ac.aber.dcs.cs12420.aberpizza.data.Order#getSaves()}.
	 */
	@Test
	public void testGetSaves() {
		assertEquals("Cannot get Save", "Test Item", OD.getSaves().get(0));
	}

	/**
	 * Test method for
	 * {@link uk.ac.aber.dcs.cs12420.aberpizza.data.Order#removeItems(int)}.
	 */
	@Test
	public void testRemoveItems() {
		OD.addItems("Test");
		OD.removeItems(0);
		assertNotSame("Could not remove", "Test", OD.getItems().get(0));
	}

	/**
	 * Test method for
	 * {@link uk.ac.aber.dcs.cs12420.aberpizza.data.Order#clearItems()}.
	 */
	@Test
	public void testClearItems() {
		OD.clearItems();
		assertEquals("Could not clear Items", 0, OD.getItems().size());
	}

	/**
	 * Test method for
	 * {@link uk.ac.aber.dcs.cs12420.aberpizza.data.Order#setQuantity(int)}.
	 */
	@Test
	public void testSetQuantity() {
		OD.setQuantity(5);
		assertEquals("Items cannot be set", 5, OD.getQuantity());
	}

	/**
	 * Test method for
	 * {@link uk.ac.aber.dcs.cs12420.aberpizza.data.Order#getQuantity()}.
	 */
	@Test
	public void testGetQuantity() {
		assertEquals("Items cannot be retreived", 1, OD.getQuantity());
	}

	/**
	 * Test method for
	 * {@link uk.ac.aber.dcs.cs12420.aberpizza.data.Order#setCustomer(java.lang.String)}
	 * .
	 */
	@Test
	public void testSetCustomer() {
		OD.setCustomer("Tom");
		assertEquals("Customer name cannot be set", "Tom", OD.getCustomer());
	}

	/**
	 * Test method for
	 * {@link uk.ac.aber.dcs.cs12420.aberpizza.data.Order#getCustomer()}.
	 */
	@Test
	public void testGetCustomer() {
		assertEquals("Customer name cannot be retreived", "Tom",
				OD.getCustomer());
	}

	/**
	 * Test method for
	 * {@link uk.ac.aber.dcs.cs12420.aberpizza.data.Order#setStaff(java.lang.String)}
	 * .
	 */
	@Test
	public void testSetStaff() {
		OD.setStaff("Colin");
		assertEquals("Staff name cannot be set", "Colin", OD.getStaff());
	}

	/**
	 * Test method for
	 * {@link uk.ac.aber.dcs.cs12420.aberpizza.data.Order#getStaff()}.
	 */
	@Test
	public void testGetStaff() {
		assertEquals("Staff name cannot be retreived", "Colin", OD.getStaff());
	}

	/**
	 * Test method for
	 * {@link uk.ac.aber.dcs.cs12420.aberpizza.data.Order#setTotal(double)}.
	 */
	@Test
	public void testSetTotal() {
		OD.setTotal(0.50);
		assertEquals("Double Total cannot be set", 0.50, OD.getTotal(), 0);
	}

	/**
	 * Test method for
	 * {@link uk.ac.aber.dcs.cs12420.aberpizza.data.Order#getTotal()}.
	 */
	@Test
	public void testGetTotal() {
		assertEquals("Double Total cannot be retreieved", 0.50, OD.getTotal(), 0);
	}

	/**
	 * Test method for
	 * {@link uk.ac.aber.dcs.cs12420.aberpizza.data.Order#setTendered(double)}.
	 */
	@Test
	public void testSetTendered() {
		OD.setTendered(1.99);
		assertEquals("Double Tendered cannot be set", 1.99, OD.getTendered(), 0);
	}

	/**
	 * Test method for
	 * {@link uk.ac.aber.dcs.cs12420.aberpizza.data.Order#getTendered()}.
	 */
	@Test
	public void testGetTendered() {
		assertEquals("Double Tendered cannot be retreieved", 1.99, OD.getTendered(), 0);	}

	/**
	 * Test method for
	 * {@link uk.ac.aber.dcs.cs12420.aberpizza.data.Order#setChange(double)}.
	 */
	@Test
	public void testSetChange() {
		OD.setChange(1.49);
		assertEquals("Double Change cannot be set", 1.49, OD.getChange(), 0);
	}

	/**
	 * Test method for
	 * {@link uk.ac.aber.dcs.cs12420.aberpizza.data.Order#getChange()}.
	 */
	@Test
	public void testGetChange() {
		assertEquals("Double Change cannot be retreieved", 1.49, OD.getChange(), 0);	}

	/**
	 * Test method for
	 * {@link uk.ac.aber.dcs.cs12420.aberpizza.data.Order#addOffers(java.lang.String)}
	 * .
	 */
	@Test
	public void testAddOffers() {
		OD.addOffers("Test Offer 2");
		assertEquals("Cannot add Offer", "Test Offer 2", OD.getOffers().get(0));
	}

	/**
	 * Test method for
	 * {@link uk.ac.aber.dcs.cs12420.aberpizza.data.Order#getOffers()}.
	 */
	@Test
	public void testGetOffers() {
		assertEquals("Cannot get Offer", "Test Offer", OD.getOffers().get(0));
	}

	/**
	 * Test method for
	 * {@link uk.ac.aber.dcs.cs12420.aberpizza.data.Order#clearOffers()}.
	 */
	@Test
	public void testClearOffers() {
		OD.clearOffers();
		assertEquals("Could not clear Offers", 0, OD.getOffers().size());
	}

	/**
	 * Test method for
	 * {@link uk.ac.aber.dcs.cs12420.aberpizza.data.Order#setPrice(double)}.
	 */
	@Test
	public void testSetPrice() {
		OD.setPrice(3.99);
		assertEquals("Double Price cannot be set", 3.99, OD.getPrice(), 0);
	}

	/**
	 * Test method for
	 * {@link uk.ac.aber.dcs.cs12420.aberpizza.data.Order#getPrice()}.
	 */
	@Test
	public void testGetPrice() {
		assertEquals("Double Price cannot be retreieved", 3.99, OD.getPrice(), 0);	}

	/**
	 * Test method for
	 * {@link uk.ac.aber.dcs.cs12420.aberpizza.data.Order#getDescription()}.
	 */
	@Test
	public void testGetDescription() {
		OD.setDescription("Cheese & Tomatoe Pizza");
		assertEquals("Description cannot be set", "Cheese & Tomatoe Pizza",
				OD.getDescription());
	}

	/**
	 * Test method for
	 * {@link uk.ac.aber.dcs.cs12420.aberpizza.data.Order#setDescription(java.lang.String)}
	 * .
	 */
	@Test
	public void testSetDescription() {
		assertEquals("Description cannot be retreived",
				"Cheese & Tomatoe Pizza", OD.getDescription());
	}

}
