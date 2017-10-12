
package worldofzuul.items;
import java.util.*;
// @author niemeijeren

         
public class Locker {
    
    private Map < Object ,Integer > insideLocker = new HashMap<>();

    public Locker(){
        this.insideLocker = insideLocker;
    }
    public void putInsideLocker(Object thing, int volume){
        this.insideLocker.put(thing, volume);
    }
    public String getInsideLocker(){
        return insideLocker.toString();
    }
}
