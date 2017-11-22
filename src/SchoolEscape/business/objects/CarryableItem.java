
package SchoolEscape.business.objects;
// @author niemeijeren

import worldofzuul.objects.*;


public class CarryableItem implements ItemInterface {
    private String name;
    private int volume;
    private boolean canPickUp = true;
    private String itemText;
    
    public CarryableItem(String name, int volume){
        this.name = name;
        this.volume = volume;
    }
    
    @Override
    public String getName() {
        return this.name;
    }
    public int getVolume() {
        return this.volume;
    }
    @Override
    public boolean canPickUp() {
        return this.canPickUp;
    }
    public String getItemText(){
        return this.itemText;
    }
    public void setVolume(int volume){
        this.volume = volume;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setItemText(String itemText){
        this.itemText = itemText;
    }
    
    public String toString() {
        return this.name;
    }
}
