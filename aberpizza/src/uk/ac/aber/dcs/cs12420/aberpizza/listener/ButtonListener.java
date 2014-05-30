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
 * Listener for {@link uk.ac.aber.dcs.cs12420.aberpizza.panel.ButtonPanel} to allow program
 * control buttons to perform functions when clicked.
 * 
 * @author Craig Heptinstall (crh13)
 *
 */
public class ButtonListener implements ActionListener {
	
	/** The canvas pane. */
	private TillPanel tillpane;
        
        private TillFrame tillframe;
	
	/** The button pane. */
	private ButtonPanel buttonPane;
        
        /** The load pane. */
        private LoadFrame loadPane;
        
        /** The file. */
        private FileIO file;
        
        private SplashScreen1 SS;
	
	/**
	 * initializes links to panels to allow functions to be performed.
	 *
	 * @param bp - {@link uk.ac.aber.dcs.cs12420.aberpizza.panel.ButtonPanel} link to allow listening to
	 * take place on control buttons
	 * @param tP - {@link uk.ac.aber.dcs.cs12420.aberpizza.panel.TillPanel} 
	 */
	public ButtonListener(ButtonPanel bp, TillPanel tP) {
		tillpane=  tP;
		buttonPane = bp;
	}
	
	/**
	 * Listens for user input to allow interactive components to be used.
	 *
	 * @param evt the evt
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
    @Override
	public void actionPerformed(ActionEvent evt) {
		String actionCommand = evt.getActionCommand();
        switch (actionCommand) {
            
            case "Exit Program":
                //Close the program
                tillpane.exitProgram();
                break;
            case "Reset Till":
                tillpane.clear();
                break;
            case "Save Till":
                FileIO.saveTillObjects();
                FileIO.saveSaves();
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
            case"New Till":
                SS.start();
                break;
              }
        }
}
