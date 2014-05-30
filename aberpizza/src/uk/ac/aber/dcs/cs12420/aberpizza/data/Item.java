
package uk.ac.aber.dcs.cs12420.aberpizza.data;


/**
 * The Interface Item.
 * This interface outlines a few methods used in the data class for the order
 * data.
 *
 * @author Craig Heptinstall(Crh13)
 */
public interface Item {
    
    /**
     * Gets the price.
     *
     * @return the price
     */
    public double getPrice();
    
    /**
     * Sets the price.
     *
     * @param p the new price
     */
    public void setPrice(double p);
    
    /**
     * Gets the description.
     *
     * @return the description
     */
    public String getDescription();
    
    /**
     * Sets the description.
     *
     * @param a the new description
     */
    public void setDescription(String a);
}
