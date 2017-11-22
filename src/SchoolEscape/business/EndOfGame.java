/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SchoolEscape.business;

import worldofzuul.*;

/**
 *
 * @author Oskar
 */
public class EndOfGame {
    
    int points = 0;
    long endTime, timeSpentInSeconds, pointsFromTime;
    int exit = 1;
    long gameTime = 600; 
    
    public EndOfGame(){ 
    }
    
    /**
     * Increases the number of points after each question answered correctly
     * @param number: The amount of points given to the player at one time
     */
    public void pointsFromAnswers(int number){
        this.points += number;
    }
    
    /**
     * Calculates the points the player gets from the amount of time used
     * @param time: System.currentTimeMillis at the start of the application
     */
    public void pointsFromTime(long time){
        this.endTime = System.currentTimeMillis();
        this.timeSpentInSeconds = (endTime - time)/1000;
        this.pointsFromTime = 300 - timeSpentInSeconds;
    }
    
    /**
     * Prints out the remaining time everytime it is checked, untill the time runs out
     * Prints that the time is up, if the occured time is less than the specified game time
     * @param time, is System.currentTimeMillis(); started at the beginning of the game
     * @return false if there is still time left, true, if time has run out
     */
    public boolean checkTime(long time){
        long timeWhenChecked = System.currentTimeMillis();
        
        long timeOccuredInSeconds = (timeWhenChecked - time)/1000;
        
        if(timeOccuredInSeconds < gameTime)
        {
            System.out.println("Time left: " + 
                    (gameTime - timeOccuredInSeconds) + "...");
            return false;
        }
        else
        {
            System.out.println("Time ran out!");
            this.returnPlayerPoints();
            return true;
        }
    }
    
    /**
     * Prints the points earned by the player
     * Shows; how long the player spent in seconds, how many points that earned,
     * the player, how many points from correct answers, and the 2 combined as
     * total points
     */
    public void returnPlayerPoints(){
        System.out.println("Total time spent playing: " + this.timeSpentInSeconds);
        System.out.println("Points from time used: " + this.pointsFromTime);
        System.out.println("Total points from correct answers: " + this.points);
        System.out.println("Total amount of points: " + (pointsFromTime + points));
    }
    
    /**
     * prints out how much time is lost, and detracts the specified time, from the alloted game time
     * @param time is the amount of time lost from the time alloted at the beginning
     */
    public void retractTime(long time){
        this.gameTime -= time; 
        System.out.println("You are " + time + " seconds closer to alchohol poisoning!");
    }
    
    
}
