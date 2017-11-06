
package worldofzuul;

//@author niemeijeren
import worldofzuul.objects.ItemInterface;
import worldofzuul.objects.CarryableItem;
import java.util.*;
import worldofzuul.*;

         
public class Player {
    
    int gameScore= 0;
    String name;
    int inventoryMAX = 20;
    int inventoryUsed = 0;
    private ArrayList<CarryableItem> inventory = new ArrayList<>();
    
    
    public Player (String name) {
        this.name = name;
        
    }
    
public void setCapacity(int inventoryMAX){
    this.inventoryMAX = inventoryMAX;
}
public String getName(){
    return this.name;
}

public void setName(String string) {
    this.name = string;
}

public void grab(CarryableItem item) {
    System.out.println("Now you have: " + item.toString());
    this.inventory.add(item); 
    this.inventoryUsed = inventoryUsed + item.getVolume();
}

public CarryableItem drop(int index) {
    for (CarryableItem item : this.inventory) {
        if (item.equals(this.inventory.get(index))) {
            this.inventory.remove(item);
            System.out.println("you have removed: " + item.toString());
            return item;
        }
        this.inventoryUsed = inventoryUsed - item.getVolume();
    }
        
    return null;
}

public List getPlayerArraylist () {
    return this.inventory;
}

public void showInventory() {
    for (ItemInterface items : inventory) {
        System.out.println(inventory.indexOf(items)+1 + ". " + items.toString());
    }
}


}