
package worldofzuul.items;
// @author niemeijeren
 
public class Flashligt {
    
    private static int volume = 10;
    private String canPickUp = "You can pick this up";
    private boolean hasBatteries = false;
            
    public Flashligt() {
        this.canPickUp = canPickUp;
        this.hasBatteries = hasBatteries;
        this.volume = volume;
    }
    public int getVolume() {
        return this.volume;
    }
}
