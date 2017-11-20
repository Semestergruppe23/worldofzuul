
package Data;
// @author Tim

import Acquaintance.*;
import java.util.ArrayList;



// Create highscore list implementing interface
public class HighscoreList implements IHighscoreList 
{
    private ArrayList<String> Highscore = new ArrayList<>();
    private int highscoreLength = Highscore.size();
    private int lowestScore = Highscore.size() -1;
        
//Create object
    public HighscoreList()
    {

        Highscore.add("2583 , Kasper");
        Highscore.add("22345 , sjda");
        Highscore.add("253 , Anja");
        Highscore.add("8653 , Dominator");
        
    }
    
    //Override getter-method
    @Override
    public ArrayList getHighscoreList(IHighscoreList list) 
    {
        return this.Highscore;
    }

    //Add highscore, depending on amount of scores on the list
    @Override
    public void addToHighscoreList(int score, String name) 
    {
        
        if (highscoreLength <=9 ){
            Highscore.add(score + ", " + name);
        } else {
        Highscore.remove(9);
        Highscore.add(9,(score + ", " + name));
        }
    }

    //Checking if highscore deserves a spot on list, returning boolean
    @Override
    public boolean checkHighscore(int score) 
    {

        boolean newHighscore = false;
        
        
        if (highscoreLength <= 9)
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
