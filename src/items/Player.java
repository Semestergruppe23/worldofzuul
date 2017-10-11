
package worldofzuul.items;
//@author niemeijeren
import java.util.ArrayList;
import worldofzuul.*;

         
public class Player {
    
    String name;
    int inventoryMAX = 20;
    int inventoryUsed = 0;
    
    ArrayList < Object > inventory = new ArrayList<>();
    
    public Player (String name) {
        this.name = name;
        int inventoryUsed = this.inventoryUsed;
        int inventoryMAX = this.inventoryMAX;
      
      
    }    

public void inventoryWithPants(Pants pants){
   
    for (int i = 0; i < inventory.size(); i++){
        if (inventory.get(i) == pants) {
            this.inventoryMAX += pants.getVolumeIncrease();
        }
    }
}
public void setCapacity(int inventoryMAX){
    this.inventoryMAX = inventoryMAX;
}
}