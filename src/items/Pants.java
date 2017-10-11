
package worldofzuul.items;
// @author niemeijeren
import worldofzuul.items.*;

public class Pants {
    
    private static int volumeIncrease = 40;
    private String canPickUp = "You can pick this up";
    
    
    public Pants() {
        this.canPickUp = canPickUp;
        this.volumeIncrease = volumeIncrease;
    }  

    public String getVolume() {
        return "Increases volume to 60";
    }
    public int getVolumeIncrease(){
        return volumeIncrease;
    }
}
