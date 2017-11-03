
package worldofzuul.items;
// @author niemeijeren
import java.util.*;
import worldofzuul.*;
 
public class Item {
    
    private String name;
    private int volume;
    private Map < Item, Integer > objectContent = new HashMap<>();
    private int inventoryIncrease;
    
    
    
    public Item(String name, int volume){
        this.name = name;
        this.volume = volume;
    }
    public void setInventoryIncrease(int inventoryIncrease){
        this.inventoryIncrease = inventoryIncrease;
    }
    public int getInventoryIncrease(){
        return this.inventoryIncrease;
    }
    public void insertObject(Item item, Integer volume){
        this.objectContent.put(item, volume);
    }
    
    public String getName() {
        return this.name;
    }
    
    public String toString() {
        return name;
    }
    public int getVolume() {
        return this.volume;
    }
    
}

    