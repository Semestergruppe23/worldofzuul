/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldofzuul;

import SchoolEscape.Acquaintance.IHighscoreList;
import SchoolEscape.Data.HighscoreList;

/**
 *
 * @author Hansi
 */
public class main {
    public static void main(String[] args) {
        IHighscoreList HighscoreList = new HighscoreList();
        Game game = new Game();
        game.injectHighscoreList(HighscoreList);
        game.play();
    }
    
}