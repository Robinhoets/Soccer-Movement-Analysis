
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;
import javax.swing.JFileChooser;

public class SoccerController {
    
    private SoccerModel model;
    private SoccerView view;
    
    private ActionListener aLUpload;
    private ActionListener aLExit;
    private ActionListener aLVersion;
    
    private JFileChooser fc;
    private File selectedFile;
    
    
    
    
    public SoccerController(SoccerView view) {
        
        //  this.model = model;
        this.view = view;
    }
    
    // adds the action listeners for our menu items
    public void control() {
        
        aLUpload = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                updateSoccerData();
                SoccerView.setPicture();
            }
        };
        view.getMenuItemUpload().addActionListener(aLUpload);
        
        aLExit = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        };
        view.getMenuItemExit().addActionListener(aLExit);
                
        aLVersion = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                view.createVersionPane();
            }
        };
        view.getMenuItemVersion().addActionListener(aLVersion);
    }
    
    private void updateSoccerData() {
        
        fc = new JFileChooser();
        fc.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fc.showOpenDialog(null); 
        
        if (result == JFileChooser.APPROVE_OPTION) {
            selectedFile = fc.getSelectedFile();
            SoccerModel.createData(selectedFile);  
        } 
    }
    
    
    
}
