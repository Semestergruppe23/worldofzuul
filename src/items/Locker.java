
package worldofzuul.items;
// @author niemeijeren

import java.util.ArrayList;
         
public class Locker {
    
    private ArrayList < Object > insideLocker = new ArrayList<>();
    private String canPickUp = "You can not pick this up";
    
    public String canPickUp() {
        return this.canPickUp;
    }
}
