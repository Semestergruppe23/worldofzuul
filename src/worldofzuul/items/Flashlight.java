
package worldofzuul.items;
// @author niemeijeren
 
public class Flashlight {
    
    private static int volume = 10;
    private String canPickUp = "You can pick this up";
    private boolean hasBatteries = false;
            
    public Flashlight() {
        this.canPickUp = canPickUp;
        this.hasBatteries = hasBatteries;
        this.volume = volume;
    }
    public int getVolume() {
        return this.volume;
    }
    public String canPickUp() {
        return this.canPickUp;
    }
}
