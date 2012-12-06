

/*
 * TabComponentDemo.java requires one additional file:
 *   ButtonTabComponent.java
 */



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

/*
 * Creating and using TabComponentsDemo example  
 */ 
public class TabComponentsDemo extends JFrame {    

    private final int tabNumber = 5;
    private final JTabbedPane pane = new JTabbedPane();
    private JMenuItem tabComponentsItem;
    private JMenuItem scrollLayoutItem;
    
    public static void main(String[] args) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                //Turn off metal's use of bold fonts
	        UIManager.put("swing.boldMetal", Boolean.FALSE);
                new TabComponentsDemo("TabComponentsDemo").runTest();
            }
        });
    }
    
    public TabComponentsDemo(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initMenu();        
        add(pane);        
    }
    
    public void runTest() {
        pane.removeAll();
        for (int i = 0; i < tabNumber; i++) {
            String title = "Tab " + i;
            pane.add(title, new JLabel(title));
            initTabComponent(i);
        }
        tabComponentsItem.setSelected(true);
        pane.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);
        scrollLayoutItem.setSelected(false);
        setSize(new Dimension(400, 200));
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    
    private void initTabComponent(int i) {
        pane.setTabComponentAt(i,
                 new ButtonTabComponent(pane));
    }    

    //Setting menu
    
    private void initMenu() {
    	JMenuBar menuBar = new JMenuBar();
//        //create Options menu
    	tabComponentsItem = new JCheckBoxMenuItem("Use TabComponents", true);
    	scrollLayoutItem = new JCheckBoxMenuItem("Set ScrollLayout");
    	
    	
    	setJMenuBar(menuBar);
    }
}