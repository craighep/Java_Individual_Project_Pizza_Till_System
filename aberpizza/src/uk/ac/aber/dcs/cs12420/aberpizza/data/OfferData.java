/*
 * 
 */
package uk.ac.aber.dcs.cs12420.aberpizza.data;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class OfferData.
 * this class checks if any offers are available for the order items selected 
 * so far. It checks every time the order is updated.
 *
 * @author Craig Heptinstall(Crh13)
 */
public class OfferData {
  
    /** The items. */
    ArrayList offers, items;
    private ArrayList<String> newItems = new ArrayList<>();
    /**
     * Check offers when called after each change of the order.
     */
    public void checkOffers() {
        Order ID = new Order();
        items = ID.getItems();
        int size = items.size();
        
        for (int i = 0; i < size; i++){
           String item = items.get(i).toString();
           item = item.substring(2).trim();
           newItems.add(item);
           
        }
        int noI = items.size();
        ID.clearOffers();
        if (newItems.contains("£3.49 Cheese & Tomato")) {
            if (newItems.contains("£1.29 Coke") || newItems.contains("£1.29 Diet Coke")) {
            ID.addOffers("******£-0.99 Cheese And Any Drink* Offer******");
            }}
        if (newItems.contains("£3.99 Garden Party")) {
            if (newItems.contains("£0.99 Water")){
            ID.addOffers("******£-0.99 Vegetarian* Offer******");
            }}
        if (newItems.contains("£3.99 Chicken BBQ") || newItems.contains("£3.99 Double Chicken & Mushroom")) {
            if (newItems.contains("£1.59 BBQ Chicken Wings") || newItems.contains("£1.99 Chicken Dippers") || newItems.contains("£2.09 Southern Style Chicken Wings")) {
            ID.addOffers("******£-1.99 All The Chicken Offer* Offer******");
            
        }
        }

        
       
}
}
