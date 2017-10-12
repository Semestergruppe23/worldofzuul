
package worldofzuul.items;
import java.util.*;

// @author niemeijeren


//Person that can appear in random rooms
public class Person {
    
    private Map <Integer, String> questions = new HashMap<>();
    private ArrayList <String> personQuestions = new ArrayList<>();
    
    //Constuctor for person
    public Person(){
        this.questions = questions;
    }
    
    //Method for transfering questions from Arraylist into Hashmap
    public void getQuestions(){
        for (int i = 0; i < personQuestions.size()-1; i++){
            this.questions.put(i, this.personQuestions.get(i));
                    }
    }

    //Write several questions below as strings for the "personQuestions" list
    
}
