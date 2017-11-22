
package SchoolEscape.business.objects;
import worldofzuul.objects.*;
import java.util.*;
import java.util.HashMap; 
import worldofzuul.Room; 
import worldofzuul.EndOfGame;
import worldofzuul.Player;
import worldofzuul.Game;

// @author oskar


//Person that can appear in random rooms
public class Person {
    
    int numberOfQuestions = 0, questionsAsked = 1, points = 0;
    public HashMap<String, String> answersAndQuestions = new HashMap<>();
    long endTime, timeSpentInSeconds, pointsFromTime;
    int numberInArray = 0;
    final String NAME = "Tom";
    String actionIndicator = "----------------------------";
    //Made so that questions that appear in these rooms only appears once
    boolean historyAsked = false, toiletAsked = false, introAsked = false; 
    
    //The questions and answers
    String question1 = "Do you even remember where you are?;\n" +
                        "Question: What's the name of this school?"; 
    String answer1 = "University of Southern Denmark";
    
    String question2 = "Shouldn't you be at school?;\n" +
                        "Question: What day of the weekend is it currently?";
    String answer2 = "Saturday";
    
    String question3 = "You look wasted\n" + 
                        "Question: What happened yesterday?";
    String answer3 = "A party";
    
    String question4 = "You look lost;\n" +
                        "Question: What are you looking for?";
    String answer4 = "A key";
    
    String question5 = "Did you drink way too many shots of vodka or what?;\n" +
                        "Question: What alcoholic beverage did you drink last night?";
    String answer5 = "Beer";
    
    String question6 = "Do you even pay attention to what I'm saying?;\n" +
                        "Question: What's my name?";
    String answer6 = this.NAME;
    
    String question7 = "Why are you still here, why don't you just walk out?;\n" +
                        "Question: Why are you trapped in here?";
    String answer7 = "the doors are locked";
    
    String question8 = "Dialogue: I saw you in your underwear earlier today;\n" +
                        "Question: Why did you take off your clothes?";
    String answer8 = "It was hot inside";
    
    String question9 = "Haha, I still remember seeing you on the hallway wearing almost nothing;\n" +
                        "Question: What did you wear when you woke up?"; 
    String answer9 = "underwear";
    
    String question10 = "Your parents must be missing you, haven't they called you?\n" +
                        "Question: Who called your phone earlier?";
    String answer10 = "Mom";
    
    String question11 = "It's almost midnight, how late did you wake up?;\n" +
                        "Question: At what time did you wake up?";
    String answer11 = "15:49";
    
    
    String[] questions = {"NotUsed", question1, question2, question3, question4,
                            question5, question6, question7, question8, question9,
                            question10, question11}; 
    
    
    /**
     * Fills the hashMap with the questions and answers
     * Used to check if the players answer is the same as the specified answer
     */
    public void putQuestionsAndAnswers(){
        answersAndQuestions.put(question1, answer1);
        answersAndQuestions.put(question2, answer2); 
        answersAndQuestions.put(question3, answer3);
        answersAndQuestions.put(question4, answer4);
        answersAndQuestions.put(question5, answer5);
        answersAndQuestions.put(question6, answer6);
        answersAndQuestions.put(question7, answer7);
        answersAndQuestions.put(question8, answer8);
        answersAndQuestions.put(question9, answer9);
        answersAndQuestions.put(question10, answer10);
        answersAndQuestions.put(question11, answer11);
    }
    
    /**
     * If the number of questios asked is less than the length of the array, 
     * return a questions at array(how many questions asked)
     * @return the String at the specified index of the array containing the questions
     */
    public String generateQuestions(){
        numberInArray++; 
        if(numberInArray < questions.length){
            
            return questions[numberInArray]; 
        } else
            return "something went wrong";
        }
    
    /**
     * Prints the intro for the bad guy of the game, the hallucination
     */
    public void getIntro(){
        System.out.println(this.actionIndicator + "\nHi there!\n"
                + "My name is " + this.NAME + "\n" + 
                "I think im your hallucination! Wild night eh?..." + "\n" +
                "Anyways, i just wanted to tell you, that i will be popping by to ask you a few questions!" +
                "\nIf you answer correctly, i will let you be and be om my way.." +
                "\nIf you answer incorrectly however... well... you won't like it!\n" + 
                "Here, let's try an easy one to start off with: \n"); 
    }
    
    /**
     * 
     * @param player used to get the players name, that the player enters at the beginning of the game
     * @param currentRoom used to get the current room the player is in
     * @param changeOfRooms shows how many times the player has changed rooms
     * @param scanner gets the players answers to the questions
     * @param pointsAndEnd used to award points for correct answers, and detracts time for incorrect ones
     * @return true if the 1 of the methods if statements are true, false if not
     */
    public void specialQuestions(Player player, Room currentRoom, int changeOfRooms, Scanner scanner, EndOfGame pointsAndEnd){
        
        
        String sQuestion1 = "You look very hungover!;\n" + "Question: Do you even remember your own name?"; 
        String sAnswer1 = player.getName();
        
        String sQuestion2 = "You're way too drunk, did you lose your mind?;\n" + "Question: Which room are you currently in?";
        String sAnswer2 = "Toilet";
        
        String sQuestion3 = "Do you even remember anything?;\n" + "Question: Which room were you previously in?";
        String sAnswer3 = "blue hallway";
        
        String toiletDescription = "in the toilet";
        String historyRoomDescription = "in the history room";
        
        if(changeOfRooms == 1 && introAsked == false){
            this.getIntro();
            System.out.println(sQuestion1);
            String playerAnswer = scanner.nextLine().toLowerCase();
            if(playerAnswer.equals(sAnswer1.toLowerCase())){
                this.correctAnswer(pointsAndEnd, currentRoom);
                introAsked = true;
            }
            else{
                this.wrongAnswer(pointsAndEnd, currentRoom);
                introAsked = true;
            }
        }
        else if(currentRoom.getShortDescription().equals(toiletDescription) && this.toiletAsked == false){
            System.out.println(sQuestion2);
            String playerAnswer = scanner.nextLine().toLowerCase();
            if(playerAnswer.equals(sAnswer2.toLowerCase())){
                this.correctAnswer(pointsAndEnd, currentRoom);
                this.toiletAsked = true;
            }
            else{
                this.wrongAnswer(pointsAndEnd, currentRoom);
                this.toiletAsked = true;
            }
        }
        else if(currentRoom.getShortDescription().equals(historyRoomDescription) && this.historyAsked == false){
            System.out.println(sQuestion3); 
            String playerAnswer = scanner.nextLine().toLowerCase();
            if(playerAnswer.equals(sAnswer3.toLowerCase())){
                this.correctAnswer(pointsAndEnd, currentRoom);
                this.historyAsked = true;
            }
            else{
                this.wrongAnswer(pointsAndEnd, currentRoom);
                this.historyAsked = true;
            }
        }
 
    }
    
    /**
     * awards 100 points to the player for a correct answer, and prints that the answer was right
     * @param pointsAndEnd, used to award the player points for correct answers
     * @param currentRoom , used to prints out the LongDescription of the room the player is in
     */
    public void correctAnswer(EndOfGame pointsAndEnd, Room currentRoom){
        pointsAndEnd.pointsFromAnswers(100);
        System.out.println("That's right! well done");
        System.out.println(this.actionIndicator + "\n");
        System.out.println(currentRoom.getLongDescription());
    }
    
    /**
     * Used to take away time when the player answers a question wrong
     * @param pointsAndEnd, used to take away 30 seconds from the game time
     * @param currentRoom , used to print the rooms longDescription
     */
    public void wrongAnswer(EndOfGame pointsAndEnd, Room currentRoom){
        System.out.println("No, that's not right");
        pointsAndEnd.retractTime(30);
        System.out.println(this.actionIndicator + "\n");
        System.out.println(currentRoom.getLongDescription());
    }
    
    /**
     * @return the length of the array containing the questions
     */
    public int getArrayLength(){
        return questions.length; 
    }
       
    /**
     * Person randomly pops up here, asking questions, which gives extra points
     * there are however certain situations where it is not random, which is implemented in the randomPopUp method:
     * this includes, when the player is in the bathroom, the historyRoom, and the beginning of the game
     * @param changeOfRooms used so that random questions does not pop up immediatly
     * @param person used to generate questions and the correct answers
     * @param scanner used to obtain the players answers to questions
     * @param pointsAndEnd used to take away time for wrong answers, and give points for right ones
     * @param currentRoom used to prints the description of the room the player is in, after the NPC goes away
     * @param player used to obtain the players name for the specialQuestions Method, in the person class
     */
    public void randomPopUp(int changeOfRooms, Person person, Scanner scanner, EndOfGame pointsAndEnd, Room currentRoom, Player player){
        //if(this.specialQuestions(player, currentRoom, changeOfRooms, scanner, pointsAndEnd) == true){
        if(this.checkForSpecialQuestion(changeOfRooms, currentRoom) == true){
            System.out.print("Hallucination>> ");
            this.specialQuestions(player, currentRoom, changeOfRooms, scanner, pointsAndEnd);
            
        } else if((int)(Math.random() * (4 - 1) + 1) == 2 && changeOfRooms > 1 && questionsAsked < person.getArrayLength()){
                    String question = person.generateQuestions();
                    System.out.println("\n" + this.actionIndicator);
                    System.out.println("Hallucination>> " + question + "\nYour answer: ");
                    String playerAnswer = scanner.nextLine().toLowerCase(); 
                    String realAnswer = person.answersAndQuestions.get(question).toLowerCase();
                    questionsAsked++; 
                    if(playerAnswer.equals(realAnswer))
                    {
                        this.correctAnswer(pointsAndEnd, currentRoom);
                    }
                    else
                    {
                        this.wrongAnswer(pointsAndEnd, currentRoom);
                    }
        }
    }
    
    /**
     * Checks if the player is in the toilet, historyRoom, or has just begun the game, and askes special questions
     * @param changeOfRooms used to check how many times the player has changed rooms
     * @param currentRoom used to ask questions concerning the room the player is currently in
     * @return 
     */
    public boolean checkForSpecialQuestion(int changeOfRooms, Room currentRoom){
	String toiletDescription = "in the toilet";
        String historyRoomDescription = "in the history room";
        // Få description fra dem: toilet.getShortDescription();
        
        
	if(changeOfRooms == 1 && this.introAsked == false){
		return true;
	}
	if(currentRoom.getShortDescription().equals(toiletDescription) && this.toiletAsked == false){
		return true;
	}
	if(currentRoom.getShortDescription().equals(historyRoomDescription) && this.historyAsked == false){
		return true;
	}
        
	else
		return false;
}
}
