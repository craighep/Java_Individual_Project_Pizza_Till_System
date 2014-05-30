package uk.ac.aber.dcs.cs1240.aberpizza.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ DateAndTimeTest.class, FileIOTest.class, OfferDataTest.class,
		OrderItemTest.class, OrderTest.class, RecieptTest.class })
public class TestSuite {

}
