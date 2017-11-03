
package worldofzuul.items;
// @author niemeijeren
public class CarryableItem implements ItemInterface {
    private String name;
    private int volume;
    private boolean canPickUp = true;
    
    public CarryableItem(String name, int volume){
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
}
