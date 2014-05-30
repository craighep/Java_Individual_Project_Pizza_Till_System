
package uk.ac.aber.dcs.cs12420.aberpizza.FileIO;

import java.awt.HeadlessException;
import java.io.*;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import uk.ac.aber.dcs.cs12420.aberpizza.data.DateAndTime;
import uk.ac.aber.dcs.cs12420.aberpizza.data.Order;
import uk.ac.aber.dcs.cs12420.aberpizza.gui.LoadFrame;
import uk.ac.aber.dcs.cs12420.aberpizza.panel.TillPanel;


/**
 * The Class FileIO.
 * saves and loads the data from till orders to file. Stores item names, prices,
 * total orders, customer and staff names, date and time of orders.
 *
 * @author Craig Heptinstall(Crh13)
 */
public class FileIO {

/** The check. */
public static boolean check = true;

  /**
   * Save till objects.
   */
  public static void saveTillObjects(){

    // Create some data objects for us to save.
      Order ID = new Order();
      
      String date = DateAndTime.getTimeAndDate();
      ID.addSaves(date);
      date = date.replace("/", "_");
      date = date.replace(":", "_");
      String saveOrder = "SaveOrder_"+date.replace(" ", "_") +".sav";
      String saveO = saveOrder;
      

    try{  // Catch errors in I/O if necessary.
      // Open a file to write to, named SavedObjects.sav.
      FileOutputStream saveFile=new FileOutputStream(saveO);
            try (ObjectOutputStream save = new ObjectOutputStream(saveFile)) {
                save.writeObject(ID.getItems());
                save.writeObject(ID.getStaff());
                save.writeObject(ID.getCustomer());
                save.writeObject(ID.getTotal());
                JOptionPane.showMessageDialog(new JFrame(), "Till Saved Succesfully"  , "AberPizza | Save Till", JOptionPane.INFORMATION_MESSAGE);    

            }
    }
    catch(IOException | HeadlessException exc){
    }
  }
  
  /**
   * Load till objects.
   */
  public static void loadTillObjects() {
  Order ID = new Order();
  LoadFrame LF = new LoadFrame();
  TillPanel TP = new TillPanel();
  String date = LF.getLoad();
  date = date.replace("/", "_");
      date = date.replace(":", "_");
      String saveOrder = "SaveOrder_"+date.replace(" ", "_") +".sav";
      String saveO = saveOrder;
		

  
   // Create the data objects for us to restore.
  ArrayList<String> itemsArray = new ArrayList<String>();
  String staff = "";
  String customer = "";
  // Wrap all in a try/catch block to trap I/O errors.
  try{
   // Open file to read from, named SavedObjects.sav.
   FileInputStream saveFile = new FileInputStream(saveO);
            try (ObjectInputStream save = new ObjectInputStream(saveFile)) {
                itemsArray = (ArrayList<String>) save.readObject();
                staff = (String) save.readObject();
                customer = (String) save.readObject();
                double total = (double) save.readObject();
                ID.setItems(itemsArray);
                ID.setStaff(staff);
                ID.setCustomer(customer);
                ID.setTotal(total);
                TP.load();
                
                
            }
   
  }
  catch(IOException | ClassNotFoundException exc){
      
JOptionPane.showMessageDialog(new JFrame(), "Cannot Find Till!"  , "AberPizza | Load Till", JOptionPane.ERROR_MESSAGE); check = false;  
  }
 }
 
 /**
  * Save list of save files.
  */
 public static void saveSaves () {
   Order ID = new Order();
     
     try{  // Catch errors in I/O if necessary.
      // Open a file to write to, named SavedObjects.sav.
      FileOutputStream saveFile=new FileOutputStream("DoNotDelete.sav");
            try (ObjectOutputStream save = new ObjectOutputStream(saveFile)) {
                save.writeObject(ID.getSaves());
              
            }
    }
    catch(Exception exc){
JOptionPane.showMessageDialog(new JFrame(), "Cannot Save Till!"  , "AberPizza | Save Till", JOptionPane.ERROR_MESSAGE);    }
  }
 
  /**
   * Load list of save files.
   */
  public static void loadSaves () {
   Order ID = new Order();
     ArrayList<String> savesArray = new ArrayList<String>();
     try{
   // Open file to read from, named SavedObjects.sav.
   FileInputStream saveFile = new FileInputStream("DoNotDelete.sav"); 
            try (ObjectInputStream save = new ObjectInputStream(saveFile)) {
                savesArray = (ArrayList<String>) save.readObject();
                
                ID.setSaves(savesArray);
                       
                
            }
   
  }
  catch(IOException | ClassNotFoundException exc){
JOptionPane.showMessageDialog(new JFrame(), "Cannot Load Till!"  , "AberPizza | Load Till", JOptionPane.ERROR_MESSAGE); check = false;  }
 }
  
  /**
   * Gets the check that the save list is able to load.
   *
   * @return the check
   */
  public boolean getCheck() {
      
      return check;
  }
  }
 


