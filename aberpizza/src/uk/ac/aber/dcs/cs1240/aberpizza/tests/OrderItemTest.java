/**
 * 
 */
package uk.ac.aber.dcs.cs1240.aberpizza.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import uk.ac.aber.dcs.cs12420.aberpizza.data.Order;
import uk.ac.aber.dcs.cs12420.aberpizza.data.OrderItem;

/**
 * @author Craig
 * 
 */
public class OrderItemTest {

	private OrderItem OI;

	@Before
	public void setup() {
		OI = new OrderItem();
	}

	/**
	 * Test method for
	 * {@link uk.ac.aber.dcs.cs12420.aberpizza.data.OrderItem#addPizzaType()}.
	 */
	@Test
	public void testAddPizzaType() {
		ArrayList pizza = OI.addPizzaType();
		assertEquals("Cannot get pizza types", pizza, OI.addPizzaType());

	}

	/**
	 * Test method for
	 * {@link uk.ac.aber.dcs.cs12420.aberpizza.data.OrderItem#addDrinkType()}.
	 */
	@Test
	public void testAddDrinkType() {
		ArrayList drink = OI.addDrinkType();
		assertEquals("Cannot get drink types", drink, OI.addDrinkType());
	}

	/**
	 * Test method for
	 * {@link uk.ac.aber.dcs.cs12420.aberpizza.data.OrderItem#addSideType()}.
	 */
	@Test
	public void testAddSideType() {
		ArrayList side = OI.addSideType();
		assertEquals("Cannot get side types", side, OI.addSideType());
	}

}
