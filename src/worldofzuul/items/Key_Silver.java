
package worldofzuul.items;
// @author niemeijeren
 
public class Key_Silver {
    
    private static int volume = 10;
    private String canPickUp = "You can pick this up, "
            + "it's for the Janitor room";
    
    public Key_Silver(){
        this.volume = volume;
        this.canPickUp = canPickUp;
    }
    
    public int getVolume() {
    return this.volume;
    }
    public String canPickUp() {
        return this.canPickUp;
    }
}
