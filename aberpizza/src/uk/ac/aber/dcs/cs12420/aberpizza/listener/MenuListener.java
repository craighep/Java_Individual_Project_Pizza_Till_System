package uk.ac.aber.dcs.cs12420.aberpizza.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import uk.ac.aber.dcs.cs12420.aberpizza.FileIO.FileIO;
import uk.ac.aber.dcs.cs12420.aberpizza.gui.LoadFrame;
import uk.ac.aber.dcs.cs12420.aberpizza.gui.TillFrame;
import uk.ac.aber.dcs.cs12420.aberpizza.panel.ButtonPanel;
import uk.ac.aber.dcs.cs12420.aberpizza.panel.SplashScreen1;
import uk.ac.aber.dcs.cs12420.aberpizza.panel.TillPanel;


/**
 * Listener for menu bar in {@link uk.ac.aber.dcs.cs12420.aberpizza.frame.TillFrame} to functions
 * to be performed when menu items are clicked.
 * 
 * @author Craig Heptinstall (crh13)
 *
 */

public class MenuListener implements ActionListener{
	
        	/**
	         * Initialises links to panels to allow functions to be performed.
	         *
	         */

	public MenuListener() {
		
	}
        
	/** The TillPanel. */
	TillPanel TP = new TillPanel();
        
        
        
        /** The ButtonPanel. */
        ButtonPanel BP = new ButtonPanel(TP);
        
        SplashScreen1 SS = new SplashScreen1();
	
	/**
	 * Listens for user input to allow interactive components to be used.
	 *
	 * @param e the e
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
    @Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
        switch (actionCommand) {
            case "About":
                 TP.about();
                break;
            case "Exit":
                TP.exitProgram();
                break;
                              
            case "Load Till":                
                FileIO.loadSaves();
                    FileIO FI = new FileIO();
                    boolean check = FI.getCheck();
                    if (check = true){
                    new LoadFrame().quantityFrame();
                    }
                    else {}
                break; 
            case "Save Till":
                FileIO.saveTillObjects();
                    FileIO.saveSaves();
                break;  
            case "Clear Till":
                TP.clear();
                break;
            case "Offer Info":
                TP.offerInformation();
                break;
            case "New Till":
                TillFrame tf = SS.getTillFrame();
                tf.pullThePlug();
                SS.start();
                break;
        }
			
                
		
	}

}
