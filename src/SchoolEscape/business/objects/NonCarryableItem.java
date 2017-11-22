
package SchoolEscape.business.objects;
// @author niemeijeren

import worldofzuul.objects.*;
import java.util.HashMap;
import java.util.Map;


public class NonCarryableItem implements ItemInterface {
    private String name;
    private boolean canPickUp = false;
    private Map < ItemInterface, Integer > objectContent = new HashMap<>();
    
    public NonCarryableItem(String name, int volume){
        this.name = name;
    }
    
    @Override
    public String getName() {
    return this.name;
    }
    @Override
    public boolean canPickUp() {
        return this.canPickUp;
    }
    public void setName(String name){
        this.name = name;
    }
    public void insertObject(ItemInterface item, Integer volume){
        this.objectContent.put(item, volume);
    }
    
    public String toString() {
        return this.name;
    }
}
