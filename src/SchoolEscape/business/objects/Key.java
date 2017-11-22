
package SchoolEscape.business.objects;
// @author niemeijeren

import worldofzuul.objects.*;



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
