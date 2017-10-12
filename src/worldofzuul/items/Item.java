
package worldofzuul.items;
// @author niemeijeren
import java.util.*;
 
public class Item {
    
    private String name;
    private int volume;
    private boolean useable;
    private Map < String, Integer > objectContent = null;
    
    
    
    public Item(String name, int volume){
        this.name = name;
        this.volume = volume;
    }
    
    
}

    