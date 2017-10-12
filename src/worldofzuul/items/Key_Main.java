
package worldofzuul.items;
// @author niemeijeren
 
public class Key_Main {
    
    private static int volume = 10;
    private String canPickUp = "You can pick this up, "
            + "it's for the main entrance";
    
    public int getVolume() {
        return this.volume;
    }
    public String canPickUp() {
        return this.canPickUp;
    }
}
