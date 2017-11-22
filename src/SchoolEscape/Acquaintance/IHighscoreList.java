
package SchoolEscape.Acquaintance;

 // @author Tim
import java.util.ArrayList;



public interface IHighscoreList {
    
    public ArrayList getHighscoreList(IHighscoreList list);
    public void addToHighscoreList(int score, String name);
    public boolean checkHighscore(int score);
    
}
