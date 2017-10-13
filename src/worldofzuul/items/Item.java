
package worldofzuul.items;
// @author niemeijeren
import java.util.*;
 
public class Item {
    
    private String name;
    private int volume;
    private Map < Item, Integer > objectContent = new HashMap<>();
    private int inventoryIncrease = 40;
    
    
    
    public Item(String name, int volume){
        this.name = name;
        this.volume = volume;
    }
    public void setInventoryIncrease(){
        this.inventoryIncrease = inventoryIncrease;
    }
    public void setObjectContent(){
        this.objectContent = objectContent;
    }
    public int getInventoryIncrease(){
        return this.inventoryIncrease;
    }
    public void insertObject(Item item, Integer volume){
        this.objectContent.put(item, volume);
    }
    
    public String toString() {
        return name;
    }
    
}

    