package uk.ac.aber.dcs.cs12420.aberpizza.panel;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import uk.ac.aber.dcs.cs12420.aberpizza.data.DateAndTime;
import uk.ac.aber.dcs.cs12420.aberpizza.data.Order;
import uk.ac.aber.dcs.cs12420.aberpizza.gui.TillFrame;
import uk.ac.aber.dcs.cs12420.aberpizza.listener.ButtonListener;

/**
 * Contained within {@link uk.ac.aber.dcs.cs12420.aberpizza..frame.TillFrame}.
 * Used to contain all system option and till tool buttons to allow user to interact with the program.
 * 
 * @author Craig Heptinstall (crh13)
 *
 */
public class ButtonPanel extends JPanel implements ActionListener{

	/** The title text. */
	private JLabel titleText = new JLabel("--Till Menu--");
	
	/** The till text. */
	private JLabel tillText = new JLabel("--Till Tools--");
        
        /** The staff text. */
        private JLabel staffText = new JLabel("Staff Member:");
        
        /** The customer text. */
        private JLabel customerText = new JLabel("For Customer:");
        
        /** The date label. */
        private JLabel dateLabel = new JLabel("");
	
	/** The change staff. */
	private JButton addButton, resetButton, saveButton, loadButton, exitButton, undoButton, changeCustomer, changeStaff;
	
	/** The title sep. */
	private JSeparator titleSep = new JSeparator(JSeparator.HORIZONTAL);
	
	/** The menu sep. */
	private JSeparator menuSep = new JSeparator(JSeparator.HORIZONTAL);
	
	/** The draw sep. */
	private JSeparator drawSep = new JSeparator(JSeparator.HORIZONTAL);
	
	/** The top sep. */
	private JSeparator topSep = new JSeparator(JSeparator.HORIZONTAL);
	
	/** The bottom sep. */
	private JSeparator bottomSep = new JSeparator(JSeparator.HORIZONTAL);
	
	/** The name sep. */
	private JSeparator nameSep = new JSeparator(JSeparator.HORIZONTAL);
	/**
	 * initializes and displays the panel and all required components.
	 * @param cP - Link to {@link uk.ac.aber.dcs.cs124.clg11.panel.CanvasPanel}
	 */
	public ButtonPanel(TillPanel cP) {

		//Initialises action listener for button components on panel
		ButtonListener buttonList = new ButtonListener(this, cP);
		Cursor handCursor = new Cursor(Cursor.HAND_CURSOR);
                setCursor(handCursor);
		//Set new layout for  panel
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
                
                DateAndTime DT = new DateAndTime();
                Order ID = new Order();
                
                dateLabel.setText("     " +DT.getTimeAndDate().substring(0, 10));
                staffText.setText("Satff Member: " + ID.getStaff());
                customerText.setText("For Customer: " + ID.getCustomer());
     		Font font = new Font("Serif", Font.BOLD, 18);
                dateLabel.setFont(font);
		//Add visual components to panel
                this.add(nameSep);
                this.add(staffText);
                this.add(customerText);
		this.add(titleText);
		this.add(tillText);
		this.add(titleSep);
		this.add(menuSep);
		this.add(drawSep);
		this.add(topSep);
		this.add(bottomSep);
                this.add(dateLabel);
		

		//Set EAST border of panel 
		this.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, Color.black));

		
		//Initialise and add interactive components (buttons) to panel
		
		//Create new button
		addButton = new JButton("New Till");
		
		//Add button to panel
		this.add(addButton);
		
		//Set action listener to button to allow interaction
		addButton.addActionListener(buttonList);


		resetButton = new JButton("Reset Till");
		this.add(resetButton);
		resetButton.addActionListener(buttonList);
                
                changeCustomer = new JButton("Change Customer");
                this.add(changeCustomer);
                changeCustomer.addActionListener(this);
                
                changeStaff = new JButton("Change Staff");
		this.add(changeStaff);
		changeStaff.addActionListener(this);

		saveButton = new JButton("Save Till");
		this.add(saveButton);
		saveButton.addActionListener(buttonList);

		loadButton = new JButton("Load Till");
		this.add(loadButton);
		loadButton.addActionListener(buttonList);

		exitButton = new JButton("Exit Program");
		this.add(exitButton);
		exitButton.addActionListener(buttonList);

		
		//Set up the 'SpringLayout' layout manager to organise all components on the Dialo
                layout.putConstraint(SpringLayout.NORTH,nameSep,10,SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST,nameSep,5,SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, nameSep,-5,SpringLayout.EAST, this);
                
                layout.putConstraint(SpringLayout.NORTH,staffText,20,SpringLayout.NORTH, nameSep);
		layout.putConstraint(SpringLayout.WEST,staffText,5,SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, staffText,-5,SpringLayout.EAST, this);
                
                layout.putConstraint(SpringLayout.NORTH,customerText,30,SpringLayout.NORTH, staffText);
		layout.putConstraint(SpringLayout.WEST,customerText,5,SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, customerText,-5,SpringLayout.EAST, this);
                
		layout.putConstraint(SpringLayout.NORTH,topSep, 30,SpringLayout.NORTH,customerText) ;
		layout.putConstraint(SpringLayout.WEST,topSep,5,SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, topSep,-5,SpringLayout.EAST, this);

		layout.putConstraint(SpringLayout.NORTH,titleText,10,SpringLayout.NORTH, topSep);
		layout.putConstraint(SpringLayout.WEST,titleText,30,SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, titleText,-30,SpringLayout.EAST, this);

		layout.putConstraint(SpringLayout.NORTH,titleSep,30,SpringLayout.NORTH, titleText);
		layout.putConstraint(SpringLayout.WEST,titleSep,5,SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, titleSep,-5,SpringLayout.EAST, this);
                
                layout.putConstraint(SpringLayout.NORTH,changeCustomer,15,SpringLayout.NORTH, titleSep);
		layout.putConstraint(SpringLayout.WEST, changeCustomer,12,SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, changeCustomer,-12,SpringLayout.EAST, this);
                
                layout.putConstraint(SpringLayout.NORTH,changeStaff,35,SpringLayout.NORTH, changeCustomer);
		layout.putConstraint(SpringLayout.WEST, changeStaff,12,SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, changeStaff,-12,SpringLayout.EAST, this);
                
                layout.putConstraint(SpringLayout.NORTH,saveButton,35,SpringLayout.NORTH, changeStaff);
		layout.putConstraint(SpringLayout.WEST, saveButton,12,SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, saveButton,-12,SpringLayout.EAST, this);

		layout.putConstraint(SpringLayout.NORTH,loadButton,35,SpringLayout.NORTH, saveButton);
		layout.putConstraint(SpringLayout.WEST,loadButton,12,SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, loadButton,-12,SpringLayout.EAST, this);
                
                layout.putConstraint(SpringLayout.NORTH,exitButton,35,SpringLayout.NORTH, loadButton);
		layout.putConstraint(SpringLayout.WEST, exitButton,12,SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, exitButton,-12,SpringLayout.EAST, this);
                
		layout.putConstraint(SpringLayout.NORTH,menuSep,35,SpringLayout.NORTH, exitButton);
		layout.putConstraint(SpringLayout.WEST,menuSep,5,SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, menuSep,-5,SpringLayout.EAST, this);
		
		layout.putConstraint(SpringLayout.NORTH,tillText,15,SpringLayout.NORTH, menuSep);
		layout.putConstraint(SpringLayout.WEST,tillText,25,SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, tillText,-10,SpringLayout.EAST, this);
		
		layout.putConstraint(SpringLayout.NORTH,drawSep,30,SpringLayout.NORTH, tillText);
		layout.putConstraint(SpringLayout.WEST,drawSep,5,SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, drawSep,-5,SpringLayout.EAST, this);
		
		layout.putConstraint(SpringLayout.NORTH,addButton,15,SpringLayout.NORTH, drawSep);
		layout.putConstraint(SpringLayout.WEST, addButton,12,SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, addButton,-12,SpringLayout.EAST, this);

		layout.putConstraint(SpringLayout.NORTH,resetButton,30,SpringLayout.NORTH, addButton);
		layout.putConstraint(SpringLayout.WEST, resetButton,12,SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, resetButton,-12,SpringLayout.EAST, this);
		
		layout.putConstraint(SpringLayout.NORTH,bottomSep,30,SpringLayout.NORTH, resetButton);
		layout.putConstraint(SpringLayout.WEST,bottomSep,5,SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, bottomSep,-5,SpringLayout.EAST, this);
		
                layout.putConstraint(SpringLayout.NORTH,dateLabel,55,SpringLayout.NORTH, bottomSep);
		layout.putConstraint(SpringLayout.WEST,dateLabel,5,SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, dateLabel,-5,SpringLayout.EAST, this);
                
        }
    
    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent evt) {

        String actionCommand = evt.getActionCommand();

        switch (actionCommand) {
            case "Change Customer":
                Order ID = new Order();
                ID.setCustomer("");
                while ("".equals(ID.getCustomer())){
                String customer = JOptionPane.showInputDialog(null,
                "Change Customer",
                "Enter Your New Customer Name",
                JOptionPane.QUESTION_MESSAGE);
                ID.setCustomer(customer);}
                customerText.setText("For Customer: " + ID.getCustomer());
                break;
	}
       switch (actionCommand) {
            case "Change Staff":
                Order ID = new Order();
                ID.setStaff("");
                while ("".equals(ID.getStaff())){
                String staff = JOptionPane.showInputDialog(null,
                "Change Staff",
                "Enter Your New Staff Name",
                JOptionPane.QUESTION_MESSAGE);
                ID.setStaff(staff);}
                staffText.setText("Satff Member: " + ID.getStaff());
                break;
	}
        switch (actionCommand) {
            case "New Till":
                TillFrame TF = new TillFrame();
                //TF.close();
                break;
        }
        }
           
           /**
            * Sets the customer.
            */
           public void setCustomer() {
               Order ID = new Order();
       customerText.setText("For Customer: " + ID.getCustomer());
   }
}
