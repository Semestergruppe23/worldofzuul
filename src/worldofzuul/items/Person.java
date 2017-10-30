
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
    
    /**
     * returns the Array containing the questions length
     * @return the length of the array containing the questions
     */
    public int getArrayLength(){
        return questions.length; 
    }
    
    /**
     * Fills the hashMap with the questions and answers
     */
    public void putQuestionsAndAnswers(){
        answersAndQuestions.put(question1, answer1);
        answersAndQuestions.put(question2, answer2); 
        answersAndQuestions.put(question3, answer3);
    }
    
    /**
     * If the number of questios asked is less than the length of the array, 
     * return a questions at array(how many questions asked)
     * @return returns the String at the specified index of the array
     */
    public String generateQuestions(){
        numberInArray++; 
        if(numberInArray < questions.length){
            
            return questions[numberInArray]; 
        } else
            return "something went wrong";
        }
}
