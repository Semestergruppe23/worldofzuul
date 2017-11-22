
package SchoolEscape.business.objects;
//@author niemeijeren

import worldofzuul.objects.*;


public class NPC_person {
    
    private String name;
    private String story;
    private boolean giveItem = false;
    private String itemWanted;
    private int bonustime = 120;
    
    public NPC_person(String name) {  
        
    }
    
    public void setStory(String story){
        this.story = story;
    }
    public void setGiveItem(boolean giveItem){
        this.giveItem = giveItem;
    }
    public void setItemWanted(String itemname){
        this.itemWanted = itemWanted;
    }
    public boolean getGiveItem(){
        return this.giveItem;
    }
    public String getItemWanted(){
        return this.itemWanted;
    }
    public String getName(){
        return this.name;
    }
    public String getStory(){
        return this.story;
    }
    public int getBonustime(){
        return this.bonustime;
    }
}

