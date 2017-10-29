
package worldofzuul.items;
import java.util.*;
import java.util.HashMap; 

// @author oskar


//Person that can appear in random rooms
public class Person {
    
    int numberOfQuestions = 0, questionsAsked = 1, points = 0;
    public HashMap<String, String> answersAndQuestions = new HashMap<>();
    long endTime, timeSpentInSeconds, pointsFromTime;
    int numberInArray = 0;
    //The questions and answers
    String question1 = "What is the name of the first king of Denmark?"; 
    String answer1 = "Gorm the old";
    String question2 = "What is the surname of the current president of the United States?";
    String answer2 = "Trump";
    String question3 = "What is the first name of Armadeus Mozart?";
    String answer3 = "Wolfgang";
    
    String[] questions = {"NotUsed", question1, question2, question3}; 
    
    
    public int getArrayLength(){
        return questions.length; 
    }
    
    public void putQuestionsAndAnswers(){
        answersAndQuestions.put(question1, answer1);
        answersAndQuestions.put(question2, answer2); 
        answersAndQuestions.put(question3, answer3);
    }
    
    
    public String generateQuestions(){
        numberInArray++; 
        if(numberInArray < questions.length){
            
            return questions[numberInArray]; 
        } else
            return "something went wrong";
        }
<<<<<<< HEAD
    
    
=======
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
    
   
>>>>>>> 177a4326eeb248cd11a1a9f7ac6f0c25585debaf
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
        System.out.println("Total time spent playing: " + this.timeSpentInSeconds);
        System.out.println("Points from time used: " + this.pointsFromTime);
        System.out.println("Total points from correct answers: " + this.points);
        System.out.println("Total amount of points: " + (pointsFromTime + points));
    }
}
