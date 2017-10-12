
package worldofzuul.items;
// @author niemeijeren

public class Bottle {
    
    private static int volume = 20;
    private String canPickUp = "You can pick this up";
    
    public int getVolume() {
        return this.volume;
    }
    public String canPickUp() {
        return this.canPickUp;
    }
    
}