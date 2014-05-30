package uk.ac.aber.dcs.cs12420.aberpizza.data;

import java.util.ArrayList;


/**
 * 
 *
 * Stored of type 'Item'
 *
 * @see uk.ac.aber.dcs.cs124.aberpizza.data.item
 *
 * @author Craig Heptinstall (crh13)
 *
 */
public class Order implements Item {

    /** The description. */
    private static String customer, staff, description;
    
    /** The price. */
    private static double tendered, price;
    
    /** The change. */
    private static double change;
    
    /** The item quantity. */
    private int itemQuantity = 1;
    
    /** The total. */
    private static double total;
    
    /** The items. */
    private static ArrayList<String> items = new ArrayList<String>();
    
    /** The saves. */
    private static ArrayList<String> saves = new ArrayList<String>();
    
    /** The offers. */
    private static ArrayList<String> offers = new ArrayList<String>();

    /**
     * Adds the items.
     *
     * @param var the var
     */
    public void addItems(String var) {
        items.add(0, var);
    }

    /**
     * Gets the items.
     *
     * @return the items
     */
    public ArrayList<String> getItems() {
        return items;
    }
    
    /**
     * Sets the items.
     *
     * @param a the new items
     */
    public void setItems (ArrayList<String> a){
        Order.items = a;
    }
    
    /**
     * Adds the saves.
     *
     * @param var the var
     */
    public void addSaves(String var) {
        saves.add(0, var);
    }
    
    /**
     * Sets the saves.
     *
     * @param a the new saves
     */
    public void setSaves (ArrayList<String> a) {
        Order.saves = a;
    }
    
    /**
     * Gets the saves.
     *
     * @return the saves
     */
    public ArrayList<String> getSaves() {
        return saves;
    }
    
    /**
     * Removes the items.
     *
     * @param i the i
     */
    public void removeItems(int i) {
        items.remove(i);
    }

    /**
     * Clear items.
     */
    public void clearItems() {
        items.clear();
    }

    /**
     * Sets the quantity.
     *
     * @param quan the quan
     * @return the int
     */
    public int setQuantity(int quan) {
        this.itemQuantity = quan;
        return itemQuantity;
    }

    /**
     * Gets the quantity.
     *
     * @return the quantity
     */
    public int getQuantity() {

        return itemQuantity;

    }

    /**
     * Sets the customer.
     *
     * @param nameC the new customer
     */
    public void setCustomer(String nameC) {
        Order.customer = nameC;

    }

    /**
     * Gets the customer.
     *
     * @return the customer
     */
    public String getCustomer() {
        return Order.customer;
    }

    /**
     * Sets the staff.
     *
     * @param nameS the new staff
     */
    public void setStaff(String nameS) {
        Order.staff = nameS;
    }

    /**
     * Gets the staff.
     *
     * @return the staff
     */
    public String getStaff() {
        return Order.staff;
    }

    /**
     * Sets the total.
     *
     * @param totalT the new total
     */
    public void setTotal(double totalT) {
        Order.total = totalT;
    }

    /**
     * Gets the total.
     *
     * @return the total
     */
    public double getTotal() {
        return Order.total;
    }
    
    /**
     * Sets the tendered.
     *
     * @param tenderedT the new tendered
     */
    public void setTendered(double tenderedT) {
        Order.tendered = tenderedT;
    }
    
    /**
     * Gets the tendered.
     *
     * @return the tendered
     */
    public double getTendered(){
        return Order.tendered;
    }
    
    /**
     * Sets the change.
     *
     * @param changeT the new change
     */
    public void setChange(double changeT) {
        Order.change = changeT;
    }
    
    /**
     * Gets the change.
     *
     * @return the change
     */
    public double getChange(){
        return Order.change;
    
    }
    
    /**
     * Adds the offers.
     *
     * @param offer the offer
     */
    public void addOffers(String offer){
        offers.add(0, offer);
    }
    
    /**
     * Gets the offers.
     *
     * @return the offers
     */
    public ArrayList<String> getOffers(){
        return offers;
    }
    
    /**
     * Clear offers.
     */
    public void clearOffers(){
        offers.clear();
    }

    /* (non-Javadoc)
     * @see uk.ac.aber.dcs.cs12420.aberpizza.data.Item#getPrice()
     */
    @Override
    public double getPrice() {
        return price;
    }

    /* (non-Javadoc)
     * @see uk.ac.aber.dcs.cs12420.aberpizza.data.Item#setPrice(double)
     */
    @Override
    public void setPrice(double p) {
        Order.price = p;
    }

    /* (non-Javadoc)
     * @see uk.ac.aber.dcs.cs12420.aberpizza.data.Item#getDescription()
     */
    @Override
    public String getDescription() {
        return description;
    }

    /* (non-Javadoc)
     * @see uk.ac.aber.dcs.cs12420.aberpizza.data.Item#setDescription(java.lang.String)
     */
    @Override
    public void setDescription(String a) {
        Order.description = a;
    }
   

    
}