
package uk.ac.aber.dcs.cs12420.aberpizza.gui;

/**
 *
 * @author Craig Heptinstall(Crh13)
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.*;
import uk.ac.aber.dcs.cs12420.aberpizza.data.Order;
import uk.ac.aber.dcs.cs12420.aberpizza.FileIO.Reciept;

/**
 * The Class PayFrame.
 * This class opens the pay frame, displaying the amount required, tendered, and
 * remaining, and allows the staff to input the customer amount given.
 * From that, the class will produce the change, and then create a receipt to a
 * chosen location using the JFileChooser.
 */
public class PayFrame  {
    
    /** The Pay frame. */
    JFrame PayFrame = new JFrame("Pay");
    
    /** The pay panel. */
    JPanel pay = new JPanel();
    
    /** The button creation.. */
    private JButton one, two, three, four, five, six, seven, eight, nine, zero, decimalPoint, back, payButton, cancel, twentyNote, tenNote, fiveNote;
    
    /** The textfield creation.. */
    public static JTextField rollingTendered;
    
    /** The label creation */
    private JLabel spacer, total, remaining;
    
    /** The Constant RIGHT_TO_LEFT. */
    final static boolean RIGHT_TO_LEFT = false;
    
    /** The Constant shouldFill. */
    final static boolean shouldFill = true;
    
    /** The Constant shouldWeightX. */
    final static boolean shouldWeightX = true;
    
    /** The amount. */
    private String amount = "0.00";
    
    /** The amount given, total. */
    double amountGiven, amountTotal;
    
    /** The amount remaining. */
    double amountRemaining = 0.00;
	
	/** Create a new receipt. */
	private Reciept cEX = new Reciept();
	
	/** Create a new file chooser. */
	private JFileChooser fc = new JFileChooser();
	//private FileIO file = new FileIO();
    
    /**
	 * Quantity frame.
	 */
	public void quantityFrame() {
        PayFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        PayFrame.setTitle("Pay");
        PayFrame.setLocationRelativeTo(null);
        
        payPanel();

        PayFrame.add(pay);

        PayFrame.pack();
        showIt();

    }

    /**
     * Pay panel.
     */
    public void payPanel() {

        PayFrame.setBackground(Color.gray);
        PayFrame.setPreferredSize(new Dimension(600, 500)); //Set size of panel
        initComponents();
        setLayout();
        
   }

    /**
     * Initializes the components.
     */
    public void initComponents() {
        Order ID = new Order();
            amountTotal = ID.getTotal();
            
           
        one = new JButton("1");
        
        one.addActionListener(new ActionListener() {  
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if ("0.00".equals(amount)) {amount = "";}
            amount = amount + "1";
             setText();
            }});
        
        two = new JButton("2");
      two.addActionListener(new ActionListener() {  
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if ("0.00".equals(amount)) {amount = "";}
             amount = amount + "2";
             setText();
            }});
        three = new JButton("3");
      three.addActionListener(new ActionListener() {  
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if ("0.00".equals(amount)) {amount = "";}
            amount = amount + "3";
             setText();
            }});
        four = new JButton("4");
     four.addActionListener(new ActionListener() {  
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if ("0.00".equals(amount)) {amount = "";}
            amount = amount + "4";
             setText();
            }});
        five = new JButton("5");
  five.addActionListener(new ActionListener() {  
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if ("0.00".equals(amount)) {amount = "";}
            amount = amount + "5";
             setText();
            }});
        six = new JButton("6");
 six.addActionListener(new ActionListener() {  
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if ("0.00".equals(amount)) {amount = "";}
            amount = amount + "6";
             setText();
            }});
        seven = new JButton("7");
   seven.addActionListener(new ActionListener() {  
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if ("0.00".equals(amount)) {amount = "";}
            amount = amount + "7";
             setText();
            }});
        eight = new JButton("8");
    eight.addActionListener(new ActionListener() {  
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if ("0.00".equals(amount)) {amount = "";}
            amount = amount + "8";
             setText();
            }});
        nine = new JButton("9");
    nine.addActionListener(new ActionListener() {  
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if ("0.00".equals(amount)) {amount = "";}
             amount = amount + "9";
             setText();
            }});
        zero = new JButton("0");
   zero.addActionListener(new ActionListener() {  
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if ("0.00".equals(amount)) {amount = "";}
             amount = amount + "0";
             setText();
            }});
        spacer = new JLabel("");
        back = new JButton("Del");
        back.addActionListener(new ActionListener() {  
            @Override
            public void actionPerformed(ActionEvent e)
            {
               
               if (amount.length()== 0){
                   amount = "";
               
               setText();
               }
               else {amount = amount.substring(0, amount.length()-1);
               setText();}
            }});
        payButton = new JButton("CheckOut");
   payButton.addActionListener(new ActionListener() {  
            @Override
            public void actionPerformed(ActionEvent e)
            {
                
                boolean i = isParsableToDouble(amount);
                if (i == true){
                if (amountRemaining <= 0.00) {
                Order I = new Order();
                I.setTotal(amountTotal);
                        I.setTendered(amountGiven);
                        I.setChange(amountRemaining);
                        String amountRemainingText = String.valueOf(amountRemaining).substring(1);
                        JOptionPane.showMessageDialog(null, "Change Required: £" + amountRemainingText,"AberPizza | Transaction Complete", JOptionPane.INFORMATION_MESSAGE);
                printReciept();
                PayFrame.dispose();
                
                }
                if (amountRemaining > 0.00) {
                    {JOptionPane.showMessageDialog(null, "Please Enter Enough Tendered!","AberPizza | Error", JOptionPane.ERROR_MESSAGE);
                }}}              
                else {JOptionPane.showMessageDialog(null, "Please enter a valid amount!","AberPizza | Error", JOptionPane.ERROR_MESSAGE); }              
                
            }});
   decimalPoint = new JButton(".");
        decimalPoint.addActionListener(new ActionListener() {  
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if ("0.00".equals(amount)) {amount = "";}
               amount = amount + ".";
               setText();
            }});
        twentyNote = new JButton("£20");
        twentyNote.addActionListener(new ActionListener() {  
            @Override
            public void actionPerformed(ActionEvent e)
            {
            amount = "20.00";
            setText();
            }});
        tenNote = new JButton("£10");
        tenNote.addActionListener(new ActionListener() {  
            @Override
            public void actionPerformed(ActionEvent e)
            {
            amount = "10.00";
            setText();
            }});
        fiveNote = new JButton("£5");
        fiveNote.addActionListener(new ActionListener() {  
            @Override
            public void actionPerformed(ActionEvent e)
            {
            amount = "5.00";
            setText();
            }});
   
            
        rollingTendered = new JTextField(3);
        total = new JLabel("Amount:" + amountTotal);
        remaining = new JLabel("Remaining:");
        setText();
        
        cancel = new JButton("Cancel");
        cancel.addActionListener(new ActionListener() {  
            @Override
            public void actionPerformed(ActionEvent e)
            {
             PayFrame.dispose();
            }
        });
        
        Font font = new Font("Serif", Font.BOLD, 20);
        total.setFont(font);
        remaining.setFont(font);
        rollingTendered.setHorizontalAlignment(JTextField.CENTER);
        rollingTendered.setFont(font);
        rollingTendered.setForeground(Color.red);
        remaining.setBorder(BorderFactory.createLineBorder(Color.black));
        total.setBorder(BorderFactory.createLineBorder(Color.black));
        calculateRemaining();
}
    
    /**
     * Checks if is parsable to double.
     *
     * @param i the i
     * @return true, if is parsable to double
     */
    public boolean isParsableToDouble(String i)
 {
 try
 {
 Double.parseDouble(i);
 return true;
 }
 catch(NumberFormatException nfe)
 {
 return false;
 }
 }
    
    /**
     * Sets the text.
     */
    public void setText (){
        rollingTendered.setText("£" + amount);
        boolean i = isParsableToDouble(amount);
        if (i == true){
        calculateRemaining();
    }}
    
    /**
     * Calculate remaining.
     */
    public void calculateRemaining() {
        DecimalFormat twoDForm = new DecimalFormat("#.##");
        amountTotal =Double.valueOf(twoDForm.format(amountTotal));
        amountGiven =Double.valueOf(twoDForm.format(amountGiven));
          
        
        amountGiven = Double.parseDouble(amount);
        amountRemaining = amountTotal - amountGiven;
        amountRemaining = Double.valueOf(twoDForm.format(amountRemaining));        
       
        remaining.setText("Remaining: "+ amountRemaining);
    }

/**
 * Sets the layout.
 */
public void setLayout() {
        if (RIGHT_TO_LEFT) {
            pay.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }
        pay.setLayout(new GridBagLayout());
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
        c.gridx = 2;
        c.gridy = 1;
        c.gridwidth = 2;
        pay.add(total, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 55; 
        c.gridx = 1;
        c.gridy = 3;
        c.gridwidth = 4;
        pay.add(rollingTendered, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 55; 
        c.gridx = 1;
        c.gridy = 4;
        c.gridwidth = 4;
        pay.add(remaining, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 55; 
        c.gridx = 1;
        c.gridy = 6;
        c.gridwidth = 2;
        pay.add(cancel, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 55; 
        c.gridx = 3;
        c.gridy = 6;
        c.gridwidth = 2;
        pay.add(payButton, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 55; 
        c.gridx = 5;
        c.gridy = 1;
        c.gridwidth = 1;
        pay.add(one, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 55;
        c.weightx = 0.5;
        c.gridx = 6;
        c.gridy = 1;
        c.gridwidth = 1;
        pay.add(two, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 55;
        c.weightx = 0.5;
        c.gridx = 7;
        c.gridy = 1;
        c.gridwidth = 1;
        pay.add(three, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 55;      //make this component tall
        c.weightx = 0.5;
        c.gridx = 5;
        c.gridy = 2;
        c.gridwidth = 1;
        pay.add(four, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 55;      //make this component tall
        c.weightx = 0.5;
        c.gridwidth = 1;
        c.gridx = 6;
        c.gridy = 2;
        pay.add(five, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 55;      //make this component tall
        c.weightx = 0.5;
        c.gridwidth = 1;
        c.gridx = 7;
        c.gridy = 2;
        pay.add(six, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 55;      //make this component tall
        c.weightx = 0.5;
        c.gridwidth = 1;
        c.gridx = 5;
        c.gridy = 3;
        pay.add(seven, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 55;      //make this component tall
        c.weightx = 0.0;
        c.gridwidth = 1;
        c.gridx = 6;
        c.gridy = 3;
        pay.add(eight, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 55;      //make this component tall
        c.weightx = 0.5;
        c.gridwidth = 1;
        c.gridx = 7;
        c.gridy = 3;
        pay.add(nine, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 55;      //make this component tall
        c.weightx = 0.5;
        c.gridwidth = 1;
        c.gridx = 6;
        c.gridy = 4;
        pay.add(zero, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 55;      //make this component tall
        c.weightx = 0.5;
        c.gridwidth = 1;
        c.gridx = 5;
        c.gridy = 4;
        pay.add(decimalPoint, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 55;      //make this component tall
        c.weightx = 0.5;
        c.gridwidth = 1;
        c.gridx = 7;
        c.gridy = 4;
        pay.add(back, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 55;      //make this component tall
        c.weightx = 0.5;
        c.gridwidth = 3;
        c.gridx = 5;
        c.gridy = 5;
        pay.add(spacer, c);
                      
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 55;      //make this component tall
        c.weightx = 0.5;
        c.gridwidth = 1;
        c.gridx = 5;
        c.gridy = 6;
        pay.add(twentyNote, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 55;      //make this component tall
        c.weightx = 0.5;
        c.gridwidth = 1;
        c.gridx = 6;
        c.gridy = 6;
        pay.add(tenNote, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 55;      //make this component tall
        c.weightx = 0.5;
        c.gridwidth = 1;
        c.gridx = 7;
        c.gridy = 6;
        pay.add(fiveNote, c);       
    }
    
   
    /**
     * Show it.
     */
    public void showIt() {
        //Display frame on screen
        PayFrame.setVisible(true);
    }
    
    /**
     * Gets the amount.
     *
     * @return the amount
     */
    public String getAmount(){
        return amount;
        
        }
    
    /**
     * Prints the receipt.
     */
    public void printReciept() {
        Order ID = new Order();
        String customerName = ID.getCustomer();
        String staffName = ID.getStaff();
        double totalt = ID.getTotal();
        double tenderedt = ID.getTendered();
        double changet = ID.getChange();
	//Display save dialog (Directories only)
			fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int returnVal = fc.showSaveDialog(null);
                        

			//Check if user has approved save
			if (returnVal == JFileChooser.APPROVE_OPTION) {

				
						ArrayList<String> items = ID.getItems();
						

						try {

							//Set selected file path
							String fileDir = fc.getSelectedFile().getAbsolutePath();

							cEX.printOut(fileDir, items, customerName, staffName, totalt, tenderedt, changet);
							

							//Display message box confirming export
							JOptionPane.showMessageDialog(new JFrame(), "Reciept Created Successfully", "UMLator | Code Export", JOptionPane.INFORMATION_MESSAGE);

						} catch (ArrayIndexOutOfBoundsException aI) {

							JOptionPane.showMessageDialog(new JFrame(), "Reciept Exported Failed - " + aI, "UMLator | Code Export", JOptionPane.ERROR_MESSAGE);
							

						} catch (NullPointerException nP) {

							JOptionPane.showMessageDialog(new JFrame(), "Reciept Exported Failed - " + nP, "UMLator | Code Export", JOptionPane.ERROR_MESSAGE);
							

						} catch (Exception e) {

							JOptionPane.showMessageDialog(new JFrame(), "Reciept Exported Failed - " + e, "UMLator | Code Export", JOptionPane.ERROR_MESSAGE);
							

						
					}

				}
			}
   
		}
	
    

