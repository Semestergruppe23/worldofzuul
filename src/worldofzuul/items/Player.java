
package worldofzuul.items;

//@author niemeijeren
import java.util.*;
import worldofzuul.*;

         
public class Player {
    
    int gameScore= 0;
    String name;
    int inventoryMAX = 20;
    int inventoryUsed = 0;
    private ArrayList<Item> inventory = new ArrayList<>();
    
    
    public Player (String name) {
        this.name = name;
        
    }
    
    public Player() {
        
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

public void grab(Item item) {
    System.out.println("Now you have: " + item.toString());
    this.inventory.add(item); 
    this.inventoryUsed++;
}

public Item drop(int index) {
    for (Item item : this.inventory) {
        if (item.equals(this.inventory.get(index))) {
            this.inventory.remove(item);
            System.out.println("you have removed: " + item.toString());
            return item;
        }
    }
    
    this.inventoryUsed--;
    
    return null;
}

public List getPlayerArraylist () {
    return this.inventory;
}

public void showInventory() {
    for (Item items : inventory) {
        System.out.println(inventory.indexOf(items)+1 + ". " + items.toString());
    }
}


}