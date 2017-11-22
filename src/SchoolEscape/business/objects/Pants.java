
package SchoolEscape.business.objects;
// @author niemeijeren

import worldofzuul.objects.*;



public class Pants extends CarryableItem {
private int inventoryIncrease = 40;

    public Pants(String name, int volume) {
        super(name, volume);
    }
    
    public int getInventoryIncrease(){
        return this.inventoryIncrease;
    }
    
}
