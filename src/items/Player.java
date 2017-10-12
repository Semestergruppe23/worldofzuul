
package items;
//@author niemeijeren
import java.util.*;
import worldofzuul.*;

         
public class Player {
    
    String name;
    int inventoryMAX = 20;
    int inventoryUsed = 0;
    
    Map < String , Object > inventory = new HashMap<>();
    
    public Player (String name) {
        this.name = name;
        this.inventoryUsed = inventoryUsed;
        this.inventoryMAX = inventoryMAX;
        
        
    }
    
public void inventoryWithPants(Pants pants){
   
    if (inventory.containsKey(pants)) {
        setCapacity(inventoryMAX + pants.getVolumeIncrease());
    }
}
public void setCapacity(int inventoryMAX){
    this.inventoryMAX = inventoryMAX;
}
}