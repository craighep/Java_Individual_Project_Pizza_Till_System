package uk.ac.aber.dcs.cs12420.aberpizza.panel;
/**
 *
 * @author Craig Heptinstall(Crh13)
 */
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.*;
import uk.ac.aber.dcs.cs12420.aberpizza.data.Order;
import uk.ac.aber.dcs.cs12420.aberpizza.gui.TillFrame;
        
/**
 * The Class SplashScreen1.
 */
public class SplashScreen1 extends JWindow
{

/** The progress bar. */
private static JProgressBar progressBar = new JProgressBar();

/** The execute. */
private static SplashScreen1 execute;

/** The count. */
private static int count;   

/** The timer1. */
private static Timer timer1;

/** The customer. */
public String staff, customer;

private TillFrame tillFrame;


/**
 * Splash screen.
 */
public void SplashScreen()
{                   
    Container container = getContentPane();
    container.setLayout(null);    

    JPanel panel = new JPanel();
    panel.setBorder(new javax.swing.border.EtchedBorder());
    panel.setBackground(new Color(255,255,255));
    panel.setBounds(10,10,348,150);
    panel.setLayout(null);
    container.add(panel);       

    JLabel label = new JLabel("Aber Pizza-   Till System");
   
    label.setFont(new Font("Verdana",Font.BOLD,14));
    label.setForeground(Color.red);
    label.setBounds(85,25,280,30);
    panel.add(label);
    
    progressBar.setMaximum(40);
    progressBar.setBounds(55, 180, 250, 15);        
    container.add(progressBar);         
    loadProgressBar();                  
    setSize(370,215);
    setLocationRelativeTo(null);
    setVisible(true);
}

/**
 * Load progress bar.
 */
public void loadProgressBar()
{
    ActionListener al = new ActionListener()
    {
            @Override
        public void actionPerformed(java.awt.event.ActionEvent evt)
        {
            count++;
            progressBar.setValue(count);
            if (count == 40){
                timer1.stop();
                setVisible(false);
                Cursor handCursor = new Cursor(Cursor.HAND_CURSOR);
                setCursor(handCursor); 
                start();
                
               
                
                
               
                
                
                
		

                            //load the rest of my application

            }               
        }};         
    timer1 = new Timer(40, al);
    timer1.start();
}
public void start(){
    askStaff();
                Order ID = new Order();
                while ("".equals(ID.getStaff())) {
                    askStaff();
                }
                askCustomer();
                while ("".equals(ID.getCustomer())) {
                    askCustomer();
                }
                tillFrame = new TillFrame();
		tillFrame.showIt();
}
public TillFrame getTillFrame(){
    return tillFrame;
}

/**
 * Ask customer.
 */
public void askCustomer() {
    Order ID = new Order();
                
                customer = JOptionPane.showInputDialog(null,
                "Customer Name?",
                "Enter Customer Name:",
                JOptionPane.QUESTION_MESSAGE);
                ID.setCustomer(customer);
}

/**
 * Ask staff.
 */
public void askStaff(){
        Order ID = new Order();

    staff = JOptionPane.showInputDialog(null,
                "What Is Your Name?",
                "Enter Your Staff Name",
                JOptionPane.QUESTION_MESSAGE);
                ID.setStaff(staff);}

}