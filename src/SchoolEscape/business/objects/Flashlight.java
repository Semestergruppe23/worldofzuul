
package SchoolEscape.business.objects;
// @author niemeijeren

import worldofzuul.objects.*;



public class Flashlight extends CarryableItem {
    private Boolean turnedOn = false;
    private Boolean hasBatteries = false;
    
    public Flashlight(String name, int volume) {
        super(name, volume);
    }
    
    public void turnOn() {
        this.turnedOn = true;
    }
    
    public void turnOff() {
        this.turnedOn = false;
    }
    
    public void addBatteries() {
        this.hasBatteries = true;
    }    
}