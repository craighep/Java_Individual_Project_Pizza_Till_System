
package uk.ac.aber.dcs.cs12420.aberpizza.gui;

/**
 *
 * @author Craig Heptinstall(Crh13)
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import uk.ac.aber.dcs.cs12420.aberpizza.FileIO.FileIO;
import uk.ac.aber.dcs.cs12420.aberpizza.data.Order;

/**
 * The Class LoadFrame.
 * This class opens a frame displaying a list of possible loads, then allows the
 * user to select one, getting this and sending it to the @FileIO class.
 * 
 */
public class LoadFrame  {
    
    /** The Load frame. */
    JFrame LoadFrame = new JFrame("Load");
    
    /** The load p. */
    JPanel loadP = new JPanel();
    
    /** The cancel. */
    private JButton load, cancel;
    
    /** The rolling tendered. */
    public static JTextField rollingTendered;
    
    /** The remaining. */
    private JLabel spacer, total, remaining;
    
    /** The Constant RIGHT_TO_LEFT. */
    final static boolean RIGHT_TO_LEFT = false;
    
    /** The Constant shouldFill. */
    final static boolean shouldFill = true;
    
    /** The Constant shouldWeightX. */
    final static boolean shouldWeightX = true;
    
    /** The loadables. */
    private static JList loadables;
    
    /** The list. */
    private static DefaultListModel list;
    
    /** The scroll list. */
    private JScrollPane scrollList;
    
    /** The to load. */
    private String toLoad = "";

    
    /**
     * Quantity frame.
     */
    public void quantityFrame() {
        LoadFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        LoadFrame.setTitle("Load Selector");
        LoadFrame.setLocationRelativeTo(null);
        
        loadPanel();

        LoadFrame.add(loadP);

        LoadFrame.pack();
        showIt();

    }

    /**
     * Load panel.
     */
    public void loadPanel() {

        LoadFrame.setBackground(Color.gray);
        LoadFrame.setPreferredSize(new Dimension(300, 170)); //Set size of panel
        initComponents();
        setLayout();
        
   }

    /**
     * initializes the components.
     */
    public void initComponents() {
        list = new DefaultListModel();
        loadables = new JList(list);
        scrollList = new JScrollPane(loadables);
        
        Order ID = new Order();
      
        for (int i = 0; i < ID.getSaves().size(); i++) {
            list.add(0, ID.getSaves().get(i));
        }
        

        load = new JButton("Load");
        load.addActionListener(new ActionListener() {  
            @Override
            public void actionPerformed(ActionEvent e)
            {
                getLoad();
                FileIO.loadTillObjects();
                LoadFrame.dispose();
            }});
               
        cancel = new JButton("Cancel");
        cancel.addActionListener(new ActionListener() {  
            @Override
            public void actionPerformed(ActionEvent e)
            {
             LoadFrame.dispose();
            }
        });
        
       
        
        
}
    
/**
 * Sets the layout.
 */
public void setLayout() {
        if (RIGHT_TO_LEFT) {
            loadP.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }
        loadP.setLayout(new GridBagLayout());
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
        c.gridy = 1;
        c.gridwidth = 2;
        loadP.add(scrollList, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 55; 
        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth = 1;
        loadP.add(load, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 55; 
        c.gridx = 2;
        c.gridy = 2;
        c.gridwidth = 1;
        loadP.add(cancel, c);
               
    }
    
    /**
     * Gets the loaded file
     *
     * @return the load file
     */
    public String getLoad(){
        
        return loadables.getSelectedValue().toString();
    }
       
    /**
     * Show it.
     */
    public void showIt() {
        //Display frame on screen
        LoadFrame.setVisible(true);
    }
   
		}
	
    

