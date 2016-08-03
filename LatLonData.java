/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class LatLonData {
    
    private double lonXY;
    private double latXY;
    private double speedMPH;
    
    public LatLonData(double lonXY, double latXY, double speedMPH) {
        
        this.lonXY = lonXY;
        this.latXY = latXY;
        this.speedMPH = speedMPH;
        
    }
    
    public double getLat() {
        return latXY;
    }
    
    public double getLon() {
        return lonXY;
    }
    
    public double getSpeed() {
        return speedMPH;
    }
    
    // setters
    public void setLat(double latXY) {
        this.latXY = latXY;
    }
    
    public void setLon(double lonXY) {
        this.lonXY = lonXY;
    }
    
    public void setSpeed(double speedMPH) {
        this.speedMPH = speedMPH;
    }
    
    public String toString() {
        
        return "  lon: " + lonXY + "  lat: " + latXY + "  speed: " + speedMPH;
    }   
}