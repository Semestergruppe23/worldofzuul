
package worldofzuul.items;
//@author niemeijeren

public class NPC_person {
    
    private String name;
    private String story;
    private boolean giveItem = false;
    private boolean helped = false;
    
    public NPC_person(String name) {  
    
    }
    
    public void setStory(String story){
        this.story = story;
    }
    public void setHelped(boolean helped){
        this.helped = helped;
    }
    public void setGiveItem(boolean giveItem){
        this.giveItem = giveItem;
    }
    public boolean getHelped(){
        return this.helped;
    }
    public boolean getGiveItem(){
        return this.giveItem;
    }
    public String getName(){
        return this.name;
    }
    public String getStory(){
        return this.story;
    }
}

