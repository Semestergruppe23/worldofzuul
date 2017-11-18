
package Acquaintance;

 // @author Tim

public interface IHighscoreList {
    
    public String[] getHighscoreList(IHighscoreList list);
    public void addToHighscoreList(int score, String name);
    public boolean checkHighscore(int score);
    
}
