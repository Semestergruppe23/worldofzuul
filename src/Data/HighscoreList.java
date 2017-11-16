
package Data;
// @author Tim

import Acquaintance.*;
import java.util.TreeMap;


 
public class HighscoreList implements IHighscoreList {
    private TreeMap <Integer, String> Highscore = new TreeMap<>();

    public HighscoreList(){
        Highscore.put(2583, "Kasper");
        Highscore.put(22345, "sjda");
        Highscore.put(253, "Anja");
        Highscore.put(8653, "Dominator");
        
    }
    
    @Override
    public String getHighscoreList(IHighscoreList list) {
        return this.Highscore.toString();
    }

    @Override
    public void SetHighscoreList(IHighscoreList list, IPlayer player) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean checkHighscore(IHighscoreList list, IPlayer player) {
        boolean newHighscore = false;
        if (player.getGameScore() <= this.Highscore.firstKey()){
            newHighscore = false;
        }else if(player.getGameScore() >= this.Highscore.firstKey()){
            newHighscore = true;
        }
        return newHighscore;
    }
}
