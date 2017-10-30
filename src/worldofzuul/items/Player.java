
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
    System.out.println(item);
    this.inventory.add(item);
    
    this.inventoryUsed++;
   
}

}