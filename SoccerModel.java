
package soccertest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

public class SoccerModel {
    
    List<LatLonData> data;
    
    public SoccerModel(List<LatLonData> data) {
        this.data = data;
    }
    
    public static void createData(File f) {
        
        List<LatLonData> point = new ArrayList<>();
        LatLonData tempObj;
        
        try {                        
            //***To be replaced with "selectedFile" - now reading too early
            BufferedReader br = new BufferedReader(new FileReader(f));
                        
            String fileRead = br.readLine();

            while(fileRead != null) {

                // split file by commas
                String[] token = fileRead.split(",");

                double tempLat = Double.parseDouble(token[0]);
                double tempLon = Double.parseDouble(token[1]); 
                double tempSpeed = Double.parseDouble(token[2]);                 

                tempObj = new LatLonData(tempLat,tempLon,tempSpeed);
                point.add(tempObj);

                
                fileRead = br.readLine();
                }
                // close file
                br.close();
            }
            catch (FileNotFoundException fnfe) {
                System.out.println("File not found");
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
            // put points in text area on main frame
            SoccerView.printGPSToPanel(point);
        
    }
    
    
    
    
}
