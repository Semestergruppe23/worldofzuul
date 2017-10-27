
package worldofzuul.items;
import java.util.*;
import java.util.HashMap; 

// @author oskar


//Person that can appear in random rooms
public class Person {
    
    int numberOfQuestions = 0;
    public HashMap<String, String> questionsAndAnswers = new HashMap<>();
    public HashMap<String, String> answersAndQuestions = new HashMap<>();
    int questionsAsked = 1;
    int points = 0;
    long endTime; //For determining points for the player
    long timeSpentInSeconds;
    long pointsFromTime;
    
    
    //Key is the questions, USE FOR CHECK FOR RIGHT ANSWERS
    public void putQuestionsAndAnswers(){
        answersAndQuestions.put(question1, answer1);
        answersAndQuestions.put(question2, answer2); 
        answersAndQuestions.put(question3, answer3);
    }
    //Key is the answer, USE TO ASK THE QUESTION  
    public void putAnswersAndQuestions(){
        questionsAndAnswers.put(answer1, question1);
        questionsAndAnswers.put(answer2, question2);
        questionsAndAnswers.put(answer3, question3);
    }
    
    
    public String generateQuestions(){
        //int randomQuestion = (int)(Math.random()*numberOfQuestions + 1);
        switch(questionsAsked){
            case 1: 
                questionsAsked++;
                String firstQuestion = questionsAndAnswers.get(answer1);
                return firstQuestion;
            case 2: 
                questionsAsked++;
                String secondQuestion = questionsAndAnswers.get(answer2);
                return secondQuestion;
            case 3:
                questionsAsked++;
                return questionsAndAnswers.get(answer3);
        }
        return "something went wrong";
    }
    public String generateAnswers(){
        switch(questionsAsked){
            case 2: 
                String firstAnswer = answersAndQuestions.get(question1);
                return firstAnswer;
            case 3: 
                String secondAnswer = answersAndQuestions.get(question2);
                return secondAnswer;
            case 4
                    :
                String thirdAnswer = answersAndQuestions.get(question3);
                return thirdAnswer;
        }
        return "something went wrong";
    }
    
    
    //The questions and answers
    String question1 = "What is the name of the first king of Denmark?"; 
    String answer1 = "Gorm the old";
    String question2 = "What is the surname of the current president of the United States?";
    String answer2 = "Trump";
    String question3 = "Who is the first name of Armadeus Mozart?";
    String answer3 = "Wolfgang";
    
    public void pointsFromAnswers(int number){
        //Increases the number of points after each question answered correctly
        this.points += number;
    }
    public void pointsFromTime(long time){
        this.endTime = System.currentTimeMillis();
        this.timeSpentInSeconds = (endTime - time)/1000;
        this.pointsFromTime = 300 - timeSpentInSeconds;
    }
    public void returnPlayerPoints(){
        System.out.println("Total time spent playing: " + timeSpentInSeconds);
        System.out.println("Total points from correct answers: " + points);
        System.out.println("Total amount of points: " + (pointsFromTime + points));
    }
}
