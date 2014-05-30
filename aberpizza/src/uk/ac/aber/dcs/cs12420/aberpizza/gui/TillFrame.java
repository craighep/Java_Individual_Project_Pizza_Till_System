package uk.ac.aber.dcs.cs12420.aberpizza.gui;

/**
 *
 * @author Craig Heptinstall(Crh13)
 */
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import javax.swing.*;
import uk.ac.aber.dcs.cs12420.aberpizza.listener.MenuListener;
import uk.ac.aber.dcs.cs12420.aberpizza.panel.ButtonPanel;
import uk.ac.aber.dcs.cs12420.aberpizza.panel.TillPanel;

/**
 * The Class TillFrame. Holds the TillPanel, and also holds the menu bar, button
 * panel and listener for the menu items.
 *
 */
public class TillFrame extends JFrame {

    /**
     * The button panel.
     */
    private ButtonPanel btPanel;
    //private StatusPanel stPanel;
    /**
     * The till panel.
     */
    private TillPanel cvPanel;
    //private MouseInterListener mIL;
    //private MousePositionListener mPL;
    /**
     * The menu bar.
     */
    private JMenuBar mb = new JMenuBar();
    /**
     * The file menu.
     */
    private JMenu fileMenu = new JMenu("File");
    /**
     * The edit menu.
     */
    private JMenu editMenu = new JMenu("Admin");
    /**
     * The help menu.
     */
    private JMenu helpMenu = new JMenu("Help");
    /**
     * The new till.
     */
    private JMenuItem newTill = new JMenuItem("New Till");
    /**
     * The save till.
     */
    private JMenuItem saveTill = new JMenuItem("Save Till");
    /**
     * The load till.
     */
    private JMenuItem loadTill = new JMenuItem("Load Till");
    /**
     * The exit prog.
     */
    private JMenuItem exitProg = new JMenuItem("Exit");
    /**
     * The undo action.
     */
    private JMenuItem undoAction = new JMenuItem("Undo");
    /**
     * The about.
     */
    private JMenuItem about = new JMenuItem("About");
    
    private JMenuItem offers = new JMenuItem("Offer Info");
    /**
     * Instantiates a new till frame.
     */
    public TillFrame() {
        MenuListener mL = new MenuListener();
        //Locate and set frame icon
        
    



        //Initialise and set up frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("AberPizza- Till System");
        this.setResizable(false);

        //Set frame menu bar
        this.setJMenuBar(mb);

        //Create new CanvasPanel
        cvPanel = new TillPanel();

        //Create new ButtonPanel


        //Set panel positions and add to frame
        addButtonPanel();
        add(cvPanel, BorderLayout.WEST);



        //Fit frame to ensure all panels/components are visible
        pack();


        //Create and initialise keystroke shortcut commands for menu bar
        KeyStroke keyNewTill = KeyStroke.getKeyStroke(KeyEvent.VK_N, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask());
        KeyStroke keyLoadTill = KeyStroke.getKeyStroke(KeyEvent.VK_L, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask());
        KeyStroke keySaveTill = KeyStroke.getKeyStroke(KeyEvent.VK_S, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask());
        KeyStroke keyQuit = KeyStroke.getKeyStroke(KeyEvent.VK_Q, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask());

        //Add menus, and menu items to menu bar
        mb.add(fileMenu);
        editMenu.add(newTill);

        //Add action listener to menu item to allow interactivity
        newTill.addActionListener(mL);

        //Add relevant keyboard shortcut accelerator to menu item
        newTill.setAccelerator(keyNewTill);


        fileMenu.add(loadTill);
        loadTill.addActionListener(mL);
        loadTill.setAccelerator(keyLoadTill);
        fileMenu.add(saveTill);
        saveTill.addActionListener(mL);
        saveTill.setAccelerator(keySaveTill);

        fileMenu.add(exitProg);
        exitProg.addActionListener(mL);
        exitProg.setAccelerator(keyQuit);

        mb.add(editMenu);



        mb.add(helpMenu);
        helpMenu.add(about);
        about.addActionListener(mL);
        helpMenu.add(offers);
        offers.addActionListener(mL);

        //Determine centre of user's screen and position frame
        Toolkit k = Toolkit.getDefaultToolkit();
        Dimension d = k.getScreenSize();
        this.setLocation(d.width / 2 - this.getWidth() / 2, d.height / 2 - this.getHeight() / 2);

    }

    /**
     * Show it.
     */
    public void showIt() {
        //Display frame on screen
        this.setVisible(true);
    }
public void pullThePlug() {
        this.dispose();
}
    /**
     * Adds the button panel.
     */
    private void addButtonPanel() {
        btPanel = new ButtonPanel(cvPanel);
        btPanel.setPreferredSize(new Dimension(155, this.getHeight()));
        add(btPanel, BorderLayout.EAST);
    }
}
