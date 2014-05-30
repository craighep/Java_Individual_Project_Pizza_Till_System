package uk.ac.aber.dcs.cs12420.aberpizza.panel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import uk.ac.aber.dcs.cs12420.aberpizza.data.OfferData;
import uk.ac.aber.dcs.cs12420.aberpizza.data.Order;
import uk.ac.aber.dcs.cs12420.aberpizza.data.OrderItem;
import uk.ac.aber.dcs.cs12420.aberpizza.gui.PayFrame;
import uk.ac.aber.dcs.cs12420.aberpizza.gui.QuantityFrame;


/**
 * Contained within {@link uk.ac.aber.dcs.cs12420.aberpizza.gui.TillFrame}.
 * Holds the main section of the program, including the ability to add items, 
 * remove, clear the till, and create a new one. It links to all the data 
 * classes, getting and setting data for the items within the order lists.
 * 
 * @author Craig Heptinstall (crh13)
 *
 */
public class TillPanel extends JPanel implements ActionListener {
//private SpringLayout layout;

    /** The selections. */
private JPanel selections = new JPanel();
    
    /** The cash. */
    private JPanel cash = new JPanel();
    
    private Order ID;
    
    /** The label quantity. */
    private JLabel labelQuantity = new JLabel("ITEM QTY:");
    
    /** The total quantity. */
    private JLabel totalQuantity = new JLabel("0");
    
    /** The label total. */
    private JLabel labelTotal = new JLabel("TOTAL TILL:");
    
    /** The total cost. */
    private JLabel totalCost = new JLabel("£0.00");
    
    /** The items. */
    private JList purchase, items;
    
    /** The list items. */
    private DefaultListModel listPurchase, listItems;
    
    /** The scroll items. */
    private JScrollPane scrollPurchase, scrollItems;
    
    /** The pay. */
    private JButton pizzas, drinks, sides, add, remove, quantity, pay;
    
    /** The layout. */
    private GridBagLayout layout;
    
    /** The t. */
    public String itemQuantity, t;
    
    /** The Constant shouldFill. */
    final static boolean shouldFill = true;
    
    /** The Constant shouldWeightX. */
    final static boolean shouldWeightX = true;
    
    /** The Constant RIGHT_TO_LEFT. */
    final static boolean RIGHT_TO_LEFT = false;
    
    /** The start. */
    private int start = 1;
    
    /** The end. */
    private int end = 5;
    
    /** The char v. */
    private int charV = 5;
    
    /** The end x. */
    private int endX = 2;
    
    /** The rolling quantity. */
    private int rollingQuantity;
    
    /** The quantity removing. */
    int quantityRemoving;
    
    /** The rolling cost. */
    public static double rollingCost;
    
    /** The offer. */
    private double current, offerDeduction, offer;
    

    //private VectorOfDrawables vod = new VectorOfDrawables();
    //private CodeExport cEX = new CodeExport();
    //private StatusPanel statusPane;
    //private JFileChooser fc = new JFileChooser();
    //private FileIO file = new FileIO();
    /**
     * initializes and displays the panel and all required components.
     *
     */
    public TillPanel() {

        this.setBackground(Color.gray);
        this.setPreferredSize(new Dimension(800, 600)); //Set size of panel
        this.setLayout(new GridLayout(2, 2));

        initComponents();
    }

    /**
     * Inits the components.
     */
    private void initComponents() {

        OrderItem fd = new OrderItem();


        TitledBorder itemBorder = BorderFactory.createTitledBorder("Item List");
        TitledBorder priceBorder = BorderFactory.createTitledBorder("Rolling Price List");
        quantity = new JButton("Quantity");
        pizzas = new JButton("Pizzas");
        pizzas.addActionListener(this);
        drinks = new JButton("Drinks");
        drinks.addActionListener(this);
        sides = new JButton("Sides");
        sides.addActionListener(this);
        add = new JButton("Add");
        add.addActionListener(this);
        remove = new JButton("Remove Item");
        remove.addActionListener(this);
        pay = new JButton("Pay Now");
        pay.addActionListener(this);
        Font labelfont = new Font("Serif", Font.ITALIC, 20);
        Font font = new Font("Serif", Font.BOLD, 20);
        labelTotal.setFont(labelfont);
        labelQuantity.setFont(labelfont);
        totalQuantity.setFont(font);
        totalCost.setFont(font);
        totalQuantity.setForeground(Color.red);
        totalCost.setForeground(Color.red);
        totalQuantity.setBackground(Color.yellow);
        totalCost.setBackground(Color.yellow);



        quantity.addActionListener(this);
        setUpLists();
        scrollPurchase.setBorder(priceBorder);
        scrollItems.setBorder(itemBorder);
        selections();
        cash();
        this.add(selections);
        this.add(scrollItems);
        this.add(selections);
        this.add(scrollPurchase);
        this.add(cash);
        Cursor handCursor = new Cursor(Cursor.HAND_CURSOR);
        setCursor(handCursor);

    }

    /**
     * Cash.
     */
    public void cash() {
        TitledBorder cashBorder = BorderFactory.createTitledBorder("Cash Register");
        cash.setBorder(cashBorder);
        layout = new GridBagLayout();
        setCashLayout();
    }

    /**
     * Selections.
     */
    public void selections() {
        TitledBorder selectionsBorder = BorderFactory.createTitledBorder("Item Options");
        selections.setBorder(selectionsBorder);
        layout = new GridBagLayout();
        setSelectionsLayout();

    }

    /**
     * Sets the up lists.
     */
    public void setUpLists() {
        listPurchase = new DefaultListModel();
        listItems = new DefaultListModel();
        purchase = new JList(listPurchase);
        items = new JList(listItems);

        scrollPurchase = new JScrollPane(purchase);
        scrollItems = new JScrollPane(items);
    }

    /**
     * Sets the cash layout.
     */
    public void setCashLayout() {
        if (RIGHT_TO_LEFT) {
            cash.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }
        cash.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        if (shouldFill) {
            //natural height, maximum width
            c.fill = GridBagConstraints.HORIZONTAL;
        }
        if (shouldWeightX) {
            c.weightx = 0.5;
        }
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 55;
        c.gridx = 1;
        c.gridy = 2;
        cash.add(labelQuantity, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 55;
        c.weightx = 0.5;
        c.gridx = 2;
        c.gridy = 2;
        cash.add(labelTotal, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 55;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 3;
        cash.add(totalQuantity, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 55;
        c.weightx = 0.5;
        c.gridx = 2;
        c.gridy = 3;
        cash.add(totalCost, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 55;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 4;
        cash.add(remove, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 55;
        c.weightx = 0.5;
        c.gridx = 2;
        c.gridy = 4;
        cash.add(pay, c);
    }

    /**
     * Sets the selections layout.
     */
    public void setSelectionsLayout() {
        if (RIGHT_TO_LEFT) {
            selections.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }
        selections.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        if (shouldFill) {
            //natural height, maximum width
            c.fill = GridBagConstraints.HORIZONTAL;
        }

        if (shouldWeightX) {
            c.weightx = 0.5;
        }
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 55;
        c.gridx = 0;
        c.gridy = 1;
        selections.add(pizzas, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 55;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 1;
        selections.add(drinks, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 55;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 2;
        selections.add(sides, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 55;      //make this component tall
        c.weightx = 0.0;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 3;
        selections.add(add, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 55;      //make this component tall
        c.weightx = 0.0;
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 2;
        selections.add(quantity, c);


    }


    /*
     * c.fill = GridBagConstraints.HORIZONTAL; c.ipady = 40; //make this
     * component tall c.weightx = 0.0; c.gridwidth = 3; c.gridx = 0; c.gridy =
     * 4; selections.add(remove, c);}
     */
    /**
     * Retrieves data for all diagram objects contained within itself and sends
     * to {@link uk.ac.aber.dcs.cs124.clg11.fileIO.CodeExport} for exporting to
     * Java code.
     */
    public void exitProgram() {

        //Display question dialog
        int exit = JOptionPane.YES_OPTION;
        exit = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "UMLator | Exit", JOptionPane.YES_NO_OPTION);

        //If user selects "yes"
        if (exit == JOptionPane.YES_OPTION) {

            //Terminate the program
            System.exit(0);
        }
    }

    /**
     * Updates mouse coordinates displayed to user within  {@link uk.ac.aber.dcs.cs124.clg11.panel.StatusPanel}
     *
     */
    public void about() {
        //Display the 'About' dialog
        JOptionPane.showMessageDialog(null, "Created by: Craig Heptinstall (crh13) - March/ April/ May 2012", "AberPizza Till | About", JOptionPane.INFORMATION_MESSAGE);
    }
    public void offerInformation() {
        JOptionPane.showMessageDialog(null, "<html>OfferList:<br> 'Cheese and Tomato pizza and a coke', £0.99 off. <br> 'Any chicken pizza with any chicken side', £1.99 off <br> 'Garden Salad pizza and water', £0.99 off.");
    }

    /**
     * Purchase list.
     */
    public void purchaseList() {

        Order I = new Order();
        OfferData OD = new OfferData();
        I.clearItems();
        int offerNo = I.getOffers().size();

        int purchaseNo = listPurchase.size();
        for (int i = 0; i < purchaseNo-offerNo; i++) {
            I.addItems(listPurchase.get(i).toString());
        }
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setGroupingUsed(false);     // don't group by threes 
        nf.setMaximumFractionDigits(2);
        nf.setMinimumFractionDigits(2);
        if (listPurchase.isEmpty()) {
            I.clearOffers();
            offerDeduction = 0;
            rollingCost = rollingCost - offerDeduction;}
            rollingCost = rollingCost + (2*offerDeduction);
        
            totalCost.setText("£" + nf.format(rollingCost));
        I.clearOffers();
        OD.checkOffers();
        ArrayList offers = I.getOffers();

        listPurchase.clear();
        offerNo = offers.size();
        for (int i = 0; i < offerNo; i++) {
            listPurchase.add(0, offers.get(i).toString());
            offer = Double.parseDouble(offers.get(i).toString().substring(9, 12));
            offerDeduction = offerDeduction + offer;
            

        }
        rollingCost = rollingCost - offerDeduction;
            totalCost.setText("£" + nf.format(rollingCost));
        purchaseNo = I.getItems().size();
        for (int i = 0; i < purchaseNo; i++) {


            listPurchase.add(0, I.getItems().get(i).toString());



        }
        I.setTotal(rollingCost);
       purchaseNo = listPurchase.size();
        for (int i = 0; i < purchaseNo-offerNo; i++) {
            I.addItems(listPurchase.get(i).toString());
        }
    }

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent evt) {

        String actionCommand = evt.getActionCommand();

        OrderItem fd = new OrderItem();

        switch (actionCommand) {
            case "Quantity":
                new QuantityFrame().quantityFrame();
                break;
            case "Remove Item":
                remove();
                break;
            case "Pay Now":
                pay();
                break;
            case "Pizzas":
                ArrayList<String> x = fd.addPizzaType();
                listItems.clear();
                for (int i = 0; i < x.size(); i++) {
                    String s = (String) x.get(i);
                    listItems.add(0, s);
                }
                ;
                break;
            case "Sides":
                x = fd.addSideType();
                listItems.clear();
                for (int i = 0; i < x.size(); i++) {
                    String s = (String) x.get(i);
                    listItems.add(0, s);
                }
                ;
                break;
            case "Drinks":
                x = fd.addDrinkType();
                listItems.clear();
                for (int i = 0; i < x.size(); i++) {
                    String s = (String) x.get(i);
                    listItems.add(0, s);
                }
                ;
                break;
            case "Add":
                if (items.getSelectedValue() == null) {
                    JOptionPane.showMessageDialog(null, "Please select an item", "AberPizza | Error", JOptionPane.ERROR_MESSAGE);
                } else {

                    addItem();

                }
        }
    }

    /**
     * Adds the item.
     */
    public void addItem() {
        Order ID = new Order();

        boolean q = isQuantityGettable();
        //Create new data model
        if (q == true) {
            QuantityFrame qr = new QuantityFrame();
            t = qr.getQuantity();
            QuantityFrame.rollingQuantity.setText("1");
        } else {
            t = "1";
        }



        int quan = Integer.parseInt(t);



        String itemT = items.getSelectedValue().toString().substring(7);
        String itemT2 = items.getSelectedValue().toString().substring(6);
        for (int i = 0; i < listPurchase.size(); i++) {
            String s = listPurchase.get(i).toString();
            s = s.substring(10);
            String testQuantity = (listPurchase.get(i).toString().substring(1, 2));
            endX = 2;
            if (testQuantity.equals(" ")) {
                endX = 1;
            }

            if (s.equals(itemT) || s.equals(itemT2)) {


                int currentQuantity = Integer.parseInt(listPurchase.get(i).toString().substring(0, endX));
                quan = quan + currentQuantity;

                listPurchase.removeElementAt(i);
            }
        }


        listPurchase.add(0, quan + "  " + items.getSelectedValue().toString());


        rollingQuantity = Integer.parseInt(totalQuantity.getText());
        rollingQuantity = Integer.parseInt(t) + rollingQuantity;
        totalQuantity.setText((new Integer(rollingQuantity)).toString());
        ID.setQuantity(new Integer(rollingQuantity));



        char price[] = new char[4];
        char currentPrice[] = new char[5];

        items.getSelectedValue().toString().getChars(1, 5, price, 0);
        totalCost.getText().getChars(start, end, currentPrice, 0);
        String cost = String.valueOf(price);
        String currentC = String.valueOf(currentPrice).trim();


        rollingCost = Double.parseDouble(cost);
        current = Double.parseDouble(currentC);
        rollingCost = (rollingCost * Integer.parseInt(t)) + current;
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setGroupingUsed(false);     // don't group by threes 
        nf.setMaximumFractionDigits(2);
        nf.setMinimumFractionDigits(2);

        if (rollingCost > 9.99) {
            end = 6;
        }



        totalCost.setText("£" + nf.format(rollingCost));

        ID.setTotal(rollingCost);

        purchaseList();




    }


    /**
     * Load.
     */
    public void load() {
        ID = new Order();
        rollingCost = ID.getTotal();
        totalCost.setText("");
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setGroupingUsed(false);     // don't group by threes 
        nf.setMaximumFractionDigits(2);
        nf.setMinimumFractionDigits(2);
        totalCost.setText("£" + nf.format(rollingCost));

        
        ArrayList loadedItems = ID.getItems();
        listPurchase.clear();
        purchase.clearSelection();
        clear();
        for (int i = 0; i < loadedItems.size(); i++) {
            listPurchase.add(0, loadedItems.get(i).toString());
            this.listPurchase.add(0, loadedItems.get(i).toString());
        }
    }

    /**
     * Clears the till of ordered items.
     */
    public void clear() {
        listPurchase.clear();
        Order ID = new Order();
        ID.clearItems();
        ID.setQuantity(0);
        totalQuantity.setText("0");
        rollingCost = 0.00;
        totalCost.setText("£0.00");
        end = 5;
    }
    /**
     * Removes the selected item.
     */
    public void remove() {

        boolean q = isRemoveable();
        //Create new data model
        if (q == true) {

            int starti = 4;
            int endi = 8;
            int i = purchase.getSelectedIndex();
            quantityRemoving = Integer.parseInt(listPurchase.get(i).toString().substring(0, endX).trim());
            totalQuantity.setText((new Integer(rollingQuantity - quantityRemoving)).toString());
            if (quantityRemoving > 9) {
                starti = 6;
                endi = 10;
            }
            char price[] = new char[4];
            purchase.getSelectedValue().toString().getChars(starti, endi, price, 0);
            String cost = String.valueOf(price);
            double thisCost = Double.parseDouble(cost);
            NumberFormat nf = NumberFormat.getNumberInstance();
            nf.setGroupingUsed(false);     // don't group by threes 
            nf.setMaximumFractionDigits(2);
            nf.setMinimumFractionDigits(2);
            rollingCost = rollingCost - (thisCost * quantityRemoving);

            totalCost.setText("£" + nf.format(rollingCost));

            listPurchase.remove(purchase.getSelectedIndex());
            if (rollingCost > 9.99) {
                end = 6;
            } else {
                end = 5;
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "There is no item selected!", "AberPizza | Error", JOptionPane.ERROR_MESSAGE);
        }purchaseList();
    }

    /**
     * Pay.
     */
    public void pay() {
        if (listPurchase.isEmpty()) {
            JOptionPane.showMessageDialog(null, "There are no items in the order!", "AberPizza | Error", JOptionPane.ERROR_MESSAGE);
        } else {
            new PayFrame().quantityFrame();
        }
    }

    /**
     * Checks if is quantity gettable.
     *
     * @return true, if is quantity gettable
     */
    public boolean isQuantityGettable() {
        try {
            QuantityFrame qr = new QuantityFrame();
            String test = qr.getQuantity();
            return true;
        } catch (NullPointerException npe) {
            return false;
        }
    }

    /**
     * Checks if is removeable.
     *
     * @return true, if is removeable
     */
    public boolean isRemoveable() {
        try {
            int i = purchase.getSelectedIndex();
            quantityRemoving = Integer.parseInt(listPurchase.get(i).toString().substring(0, endX).trim());
            return true;
        } catch (ArrayIndexOutOfBoundsException ind) {
            return false;
        }
    }
}