
package items;
// @author niemeijeren

public class Picture {
    
    private static int volume = 10;
    private String canPickUp = "You can pick this up";
    private String phonenumber = "3847 2635";
    
    public Picture(){
        this.volume = volume;
        this.canPickUp = canPickUp;
        this.phonenumber = phonenumber;
    }
    
    public int getVolume() {
        return this.volume;
    }
    public String getPhonenumber() {
        return this.phonenumber;
    }
    public String canPickUp() {
        return this.canPickUp;
    }
}
