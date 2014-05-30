
package uk.ac.aber.dcs.cs12420.aberpizza.gui;

/**
 *
 * @author Craig Heptinstall(Crh13)
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import uk.ac.aber.dcs.cs12420.aberpizza.data.Order;


/**
 * The Class QuantityFrame.
 * Creates a frame displaying a keypad where the customer can input the amount 
 * of a certain item required, and then click 'ok' to send this to the @Order 
 * class.
 */
public class QuantityFrame  {
    
    /** The Quantity frame. */
    JFrame QuantityFrame = new JFrame("Quantity");
    
    /** The quantity. */
    JPanel quantity = new JPanel();
    
    /** The cancel. */
    private JButton one, two, three, four, five, six, seven, eight, nine, zero, back, ok, cancel;
    
    /** The rolling quantity. */
    public static JTextField rollingQuantity;
    
    /** The spacer. */
    private JLabel spacer;
    
    /**
     * Quantity frame.
     */
    public void quantityFrame() {
        QuantityFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        QuantityFrame.setTitle("Quantity");
        QuantityFrame.setLocationRelativeTo(null);
        quantityPanel();

        QuantityFrame.add(quantity);

        QuantityFrame.pack();
        showIt();

    }

    /**
     * Quantity panel.
     */
    public void quantityPanel() {

        QuantityFrame.setBackground(Color.gray);
        QuantityFrame.setPreferredSize(new Dimension(300, 300)); //Set size of panel
        initComponents();
        setLayout();




    }

    /**
     * Initialises the components.
     */
    public void initComponents() {
           
        one = new JButton("1");
        
        one.addActionListener(new ActionListener() {  
            @Override
            public void actionPerformed(ActionEvent e)
            {
               String quan = rollingQuantity.getText();
            rollingQuantity.setText(quan+"1");
            }});
        
        two = new JButton("2");
      two.addActionListener(new ActionListener() {  
            @Override
            public void actionPerformed(ActionEvent e)
            {
               String quan = rollingQuantity.getText();
            rollingQuantity.setText(quan+"2");
            }});
        three = new JButton("3");
      three.addActionListener(new ActionListener() {  
            @Override
            public void actionPerformed(ActionEvent e)
            {
               String quan = rollingQuantity.getText();
            rollingQuantity.setText(quan+"3");
            }});
        four = new JButton("4");
     four.addActionListener(new ActionListener() {  
            @Override
            public void actionPerformed(ActionEvent e)
            {
               String quan = rollingQuantity.getText();
            rollingQuantity.setText(quan+"4");
            }});
        five = new JButton("5");
  five.addActionListener(new ActionListener() {  
            @Override
            public void actionPerformed(ActionEvent e)
            {
               String quan = rollingQuantity.getText();
            rollingQuantity.setText(quan+"5");
            }});
        six = new JButton("6");
 six.addActionListener(new ActionListener() {  
            @Override
            public void actionPerformed(ActionEvent e)
            {
               String quan = rollingQuantity.getText();
            rollingQuantity.setText(quan+"6");
            }});
        seven = new JButton("7");
   seven.addActionListener(new ActionListener() {  
            @Override
            public void actionPerformed(ActionEvent e)
            {
               String quan = rollingQuantity.getText();
            rollingQuantity.setText(quan+"7");
            }});
        eight = new JButton("8");
    eight.addActionListener(new ActionListener() {  
            @Override
            public void actionPerformed(ActionEvent e)
            {
               String quan = rollingQuantity.getText();
            rollingQuantity.setText(quan+"8");
            }});
        nine = new JButton("9");
    nine.addActionListener(new ActionListener() {  
            @Override
            public void actionPerformed(ActionEvent e)
            {
               String quan = rollingQuantity.getText();
            rollingQuantity.setText(quan+"9");
            }});
        zero = new JButton("0");
   zero.addActionListener(new ActionListener() {  
            @Override
            public void actionPerformed(ActionEvent e)
            {
               String quan = rollingQuantity.getText();
            rollingQuantity.setText(quan+"0");
            }});
        spacer = new JLabel("");
        back = new JButton("Del");
        back.addActionListener(new ActionListener() {  
            @Override
            public void actionPerformed(ActionEvent e)
            {
               String quan = rollingQuantity.getText();
               if (quan.length()== 0){
                   quan = "";
               }
               else{
               quan = quan.substring(0, quan.length()-1);
               rollingQuantity.setText(quan);}
            }});
        ok = new JButton("OK");
   ok.addActionListener(new ActionListener() {  
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String q = rollingQuantity.getText();
                boolean i = isParsableToInt(q);
                if (i == true){
                Order I = new Order();
                I.setQuantity(Integer.parseInt(q));
                QuantityFrame.dispose();}
                else {JOptionPane.showMessageDialog(null, "Please enter a valid quantity!","AberPizza | Error", JOptionPane.ERROR_MESSAGE); }              
                
            }});
   
            
        rollingQuantity = new JTextField(3);
        
        cancel = new JButton("Cancel");
        cancel.addActionListener(new ActionListener() {  
            @Override
            public void actionPerformed(ActionEvent e)
            {
               Order I = new Order();
                I.setQuantity(1);
                rollingQuantity.setText("1");
             QuantityFrame.dispose();
            }
        });
}
    
    /**
     * Checks if is parsable to int.
     *
     * @param i the i
     * @return true, if is parsable to int
     */
    public boolean isParsableToInt(String i)
 {
 try
 {
 Integer.parseInt(i);
 return true;
 }
 catch(NumberFormatException nfe)
 {
 return false;
 }
 }

    /**
     * Sets the layout.
     */
    public void setLayout() {
        quantity.setLayout(new GridLayout(5, 3));
        quantity.add(one);
        quantity.add(two);
        quantity.add(three);
        quantity.add(four);
        quantity.add(five);
        quantity.add(six);
        quantity.add(seven);
        quantity.add(eight);
        quantity.add(nine);
        quantity.add(spacer);
        quantity.add(zero);
        quantity.add(ok);
        quantity.add(rollingQuantity);
        quantity.add(back);
        quantity.add(cancel);

    } 
    
    /**
     * Show it.
     */
    public void showIt() {
        //Display frame on screen
        QuantityFrame.setVisible(true);
    }
    
    /**
     * Gets the quantity.
     *
     * @return the quantity
     */
    public String getQuantity(){
        return rollingQuantity.getText();
        
        }
    
}
