
package soccertest;

import javax.swing.*;

public class SoccerTest {

    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                //SoccerModel sm = new SoccerModel();
                SoccerView sv = new SoccerView();
                SoccerController sc = new SoccerController(sv);
                
                sc.control();
                
                
            }
        });
        
        
    }
    
}
