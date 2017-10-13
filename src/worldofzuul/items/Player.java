
package worldofzuul.items;
//@author niemeijeren
import java.util.*;
import worldofzuul.*;

         
public class Player {
    
    int gameScore= 0;
    String name;
    int inventoryMAX = 20;
    int inventoryUsed = 0;
    
    Map < Item , Integer> inventory = new HashMap<>();
    
    public Player (String name) {
        this.name = name;
        this.inventoryUsed = inventoryUsed;
        this.inventoryMAX = inventoryMAX;
        this.gameScore = gameScore;
        
    }
    
public void setCapacity(int inventoryMAX){
    this.inventoryMAX = inventoryMAX;
}
public String getName(){
    return this.name;
}
}