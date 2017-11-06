
package worldofzuul.objects;
// @author niemeijeren

import java.util.HashMap;
import java.util.Map;


public class NonCarryableItem implements ItemInterface {
    private String name;
    private int volume;
    private boolean canPickUp = true;
    private Map < ItemInterface, Integer > objectContent = new HashMap<>();
    
    public NonCarryableItem(String name, int volume){
        this.name = name;
        this.volume = volume;
    }
    
    @Override
    public String getName() {
    return this.name;
    }

    @Override
    public int getVolume() {
    return this.volume;
    }

    @Override
    public boolean canPickUp() {
        return this.canPickUp;
    }
    public void setVolume(int volume){
        this.volume = volume;
    }
    public void setName(String name){
        this.name = name;
    }
    public void insertObject(ItemInterface item, Integer volume){
        this.objectContent.put(item, volume);
    }
}
