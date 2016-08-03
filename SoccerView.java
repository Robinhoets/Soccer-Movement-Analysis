

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

public class SoccerView {
    
    private static JFrame frame;

    private JMenuBar menuBar;
    private JMenu menu, menu2, menu3;
    private JMenuItem menuItemUpload, menuItemExit, menuItemVersion;
    
    private JFrame versionFrame;
    private JTextArea versionTextArea;
    
    private static JPanel mainPanel;
    private static JPanel picPanel;
    private static JPanel textPanel;
    private static JTextArea textPanelTextArea;
    private static JScrollPane scrollPane;
    
    public SoccerView() {
        
        frame = new JFrame();
        frame.getContentPane().setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750, 600);
        frame.setVisible(true);
        
        // Create main menus
        menu = new JMenu("File");
        menu2 = new JMenu("Edit");
        menu3 = new JMenu("Help");
        
        // create bar to put main menus on
        menuBar = new JMenuBar();
        
        // add main menus
        menuBar.add(menu);
        menuBar.add(menu2);
        menuBar.add(menu3);
        
        frame.setJMenuBar(menuBar);
        
        // create drop down labels for FILE
        menuItemUpload = new JMenuItem("Upload");
        menuItemExit = new JMenuItem("Exit");
        
        // create drop down label for EDIT
        //------------------
        
        // create drop down labels for help
        menuItemVersion = new JMenuItem("Version");
        
        // add dropdowns for FILE
        menu.add(menuItemUpload);
        menu.add(menuItemExit);
        
        // add dropdowns for EDIT
        //--------------------
        
        // add dropdowns for HELP
        menu3.add(menuItemVersion);
        
        /*
        
            Create panes within frame
        
        */
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        
        picPanel = new JPanel();
        textPanel = new JPanel();
        
        mainPanel.add(picPanel);
        mainPanel.add(textPanel);
        
        frame.getContentPane().add(mainPanel);
        
    }
    
    
    public JMenuItem getMenuItemUpload() {
        return menuItemUpload;
    }
    
    public JMenuItem getMenuItemExit() {
        return menuItemExit;
    }
    
    public JMenuItem getMenuItemVersion() {
        return menuItemVersion;
    }
    
    
    public void createVersionPane() {
        
        versionFrame = new JFrame("Version");
        versionFrame.getContentPane().setLayout(new FlowLayout());
        versionFrame.setSize(100, 100);
        
        versionTextArea = new JTextArea(20,20);
        versionTextArea.setEditable(false);
        versionTextArea.append("Version 1.0");
        
        versionFrame.add(versionTextArea);
        
        versionFrame.pack();
        versionFrame.setLocationRelativeTo(null);
        versionFrame.setVisible(true);
    }
    
    public static void printGPSToPanel(List<LatLonData> p) {
        
        textPanelTextArea = new JTextArea(8,30);
        textPanelTextArea.setEditable(false);
        /*
        for(LatLonData l: p) {
                textPanelTextArea.append(l.toString() + "\n");
            }
        */
        for(int z=0; z<p.size(); z++) {
            textPanelTextArea.append(p.get(z).toString());
            textPanelTextArea.append("\n");
        }
        scrollPane = new JScrollPane(textPanelTextArea);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        textPanel.add(scrollPane);
        frame.pack();
    }
    
    public static void setPicture() {
        
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("/home/robinho/Desktop/soccer-field3.jpg"));
        } 
        catch (IOException ex) {
                
        }        
        
        final ColorPanel cPanel = new ColorPanel(img);
        picPanel.add(cPanel);
        
        
        
        
        
        
        //JLabel pic = new JLabel(new ImageIcon(img));        
        //picPanel.add(pic);
        frame.pack();
    }
}
