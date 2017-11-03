
package worldofzuul.items;
// @author niemeijeren

public class Key extends CarryableItem {
    private int opensDoor;
    
    public Key(String name, int volume) {
        super(name, volume);
    }
    
    public void setOpensDoor(int doorNumber){
        this.opensDoor = doorNumber;
    }
    public int getOpensDoor(){
        return this.opensDoor;
    }
}
