
package Acquaintance;

 // @author Tim

public interface IHighscoreList {
    
    public String getHighscoreList(IHighscoreList list);
    public void SetHighscoreList(IHighscoreList list, IPlayer player);
    public boolean checkHighscore(IHighscoreList list, IPlayer player);
    
}
