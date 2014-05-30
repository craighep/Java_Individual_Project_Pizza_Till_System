
package uk.ac.aber.dcs.cs12420.aberpizza.data;

import java.util.ArrayList;

/**
 * The Class OrderItem.
 * Stores the names and prices of items used in the gui list of available items.
 * can be added to here easily, and changed where required. Uses an array of 
 * strings for each type of item
 *
 * @author Craig Heptinstall(Crh13)
 */
public class OrderItem {

    /** The drink. */
    private static ArrayList<String> drink = new ArrayList<String>();
    
    /** The side. */
    private static ArrayList<String> side = new ArrayList<String>();
    
    /** The pizza. */
    private static ArrayList<String> pizza = new ArrayList<String>();

    /**
     * Adds the pizza type.
     *
     * @return the array list
     */
    public ArrayList<String> addPizzaType() {
        pizza.clear();

        pizza.add(0, "£3.99 Mediterranean Sausage");
        pizza.add(0, "£3.79 Double Spicy Beef");
        pizza.add(0, "£3.99 Chicken BBQ");
        pizza.add(0, "£4.99 The Works");
        pizza.add(0, "£3.69 Grande Italia");
        pizza.add(0, "£3.99 Garden Party");
        pizza.add(0, "£4.29 Double Pepperoni");
        pizza.add(0, "£4.59 All the Meats");
        pizza.add(0, "£3.99 The Mexican");
        pizza.add(0, "£2.99 Hawaiian Special");
        pizza.add(0, "£3.59 Hot Pepper Passion");
        pizza.add(0, "£4.19 Pepperoni Plus");
        pizza.add(0, "£3.99 Double Chicken & Mushroom");
        pizza.add(0, "£3.49 Cheese & Tomato");

        return pizza;

    }

    /**
     * Adds the drink type.
     *
     * @return the array list
     */
    public ArrayList<String> addDrinkType() {
        drink.clear();
        
        drink.add(0, "£1.29 Coke");
        drink.add(0, "£1.29 Diet Coke");
        drink.add(0, "£1.29 Coke Zero");
        drink.add(0, "£1.19 Fanta");
        drink.add(0, "£1.19 Sprite");
        drink.add(0, "£1.25 Schweppes Lemonade");
        drink.add(0, "£0.99 Water");
        return drink;
    }

    /**
     * Adds the side type.
     *
     * @return the array list
     */
    public ArrayList<String> addSideType() {
        side.clear();
        
        side.add(0, "£2.19 Hot Buffalo Wings");
        side.add(0, "£1.59 BBQ Chicken Wings");
        side.add(0, "£1.99 Chicken Dippers");
        side.add(0, "£2.09 Southern Style Chicken Wings");
        side.add(0, "£3.99 Variety Combo - Cheesy Jalapeno Bites");
        side.add(0, "£3.99 Variety Combo - Potato Wedges");
        side.add(0, "£2.09 Cheesy Jalapeno Bites");
        side.add(0, "£1.19 Garlic Cheesesticks");
        side.add(0, "£1.99 Garlic Pizza Bread");
        side.add(0, "£1.59 Potato Wedges");
        side.add(0, "£0.20 Dips");

        return side;
    }
}
