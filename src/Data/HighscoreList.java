
package Data;
// @author Tim

import Acquaintance.*;
import java.util.Collection;
import java.util.TreeMap;



public class HighscoreList implements IHighscoreList 
{
    private String[] Highscore;
    

    public HighscoreList()
    {

        Highscore[0] = "2583 , Kasper";
        Highscore[1] = "22345 , sjda";
        Highscore[2] = "253 , Anja";
        Highscore[3] = "8653 , Dominator";
        
    }
    
    @Override
    public String[] getHighscoreList(IHighscoreList list) 
    {
        return this.Highscore;
    }

    @Override
    public void addToHighscoreList(int score, String name) 
    {
        Highscore[10] = (score + ", " + name);
    }

    @Override
    public boolean checkHighscore(int score) 
    {
        boolean newHighscore = false;
        int highscorePosition = Highscore.length;
        int lowestScore = Highscore.length -1;
        
        if (highscorePosition <= 9)
        {
            return true;
        } else {
                if (score < lowestScore  ){
                newHighscore = false;
            }else if(score > lowestScore){
                newHighscore = true;
                }
        return newHighscore;
        }
    }
}
