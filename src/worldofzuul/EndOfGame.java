/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldofzuul;

/**
 *
 * @author Oskar
 */
public class EndOfGame {
    
    int points = 0;
    long endTime, timeSpentInSeconds, pointsFromTime;
    int exit = 1;
    
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
}
