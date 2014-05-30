package uk.ac.aber.dcs.cs12420.aberpizza.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import uk.ac.aber.dcs.cs12420.aberpizza.gui.QuantityFrame;
import uk.ac.aber.dcs.cs12420.aberpizza.panel.ButtonPanel;
import uk.ac.aber.dcs.cs12420.aberpizza.panel.TillPanel;

/**
 * Listener for {@link uk.ac.aber.dcs.cs12420.aberpizza.panel.ButtonPanel} to allow program
 * control buttons to perform functions when clicked.
 * 
 * @author Craig Heptinstall (crh13)
 *
 */
public class KeypadListener implements ActionListener {
	
	/** The canvas pane. */
	private TillPanel canvasPane;
	
	/** The button pane. */
	private ButtonPanel buttonPane;
        
        /** The quantity frame. */
        private QuantityFrame quantityFrame;
	
	/**
	 * initializes links to panels to allow functions to be performed.
	 *
	 * @param cp the cp
	 * @param bp - {@link uk.ac.aber.dcs.cs12420.aberpizza.panel.ButtonPanel} link to allow listening to
	 * take place on control buttons
	 * @param qf the qf
	 */
          public KeypadListener(TillPanel cp, ButtonPanel bp, QuantityFrame qf) {
		this.canvasPane = cp;
		this.buttonPane = bp;
                this.quantityFrame = qf;
		
              //  QuantityFrame qp;
	}
	
	/**
	 * Listens for user input to allow interactive components to be used.
	 *
	 * @param evt the evt
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent evt) {
		String actionCommand = evt.getActionCommand();
		
		
                    
                    if (actionCommand.equals("quantity")) {
            //If left mouse button is being clicked
            //Display AddClassDialog window with link to CanvasPanel and mouse position coordinates
           
                    new QuantityFrame().quantityFrame();
			
		
		
	}


}}