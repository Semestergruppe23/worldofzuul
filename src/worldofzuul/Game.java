package worldofzuul;
import java.util.*;
import worldofzuul.items.*;
/**
 * @author Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
public class Game {
    private Parser parser;
    private Room currentRoom;
    Scanner input = new Scanner(System.in);
    Person person = new Person(); 
    int changeOfRooms = 0; //made so that random questions dont pop up when first beginning the game
    Scanner scanner = new Scanner(System.in); //So that the answers dont interfer with the commands
    long startTime = System.currentTimeMillis(); 
    
    public Game() {
        createRooms();
        parser = new Parser();
        person.putAnswersAndQuestions();
        person.putQuestionsAndAnswers();
        
    }

    private void createRooms() {
        Room startRoom, MathRoom, HistoryRoom, HallWay_red, HallWay_blue, JanitorRoom, HallWay_green, HallWay_black, toilet, exit; //Declares the rooms of the game

        startRoom = new Room("Where the game starts: "); // Uses the method Room, which declares instances of the Room class, with string arguments for each room
        MathRoom = new Room("in the Math room");
        HistoryRoom = new Room("in the history room");
        HallWay_red = new Room("in the red hallway");
        HallWay_blue = new Room("in the blue hallway");
        JanitorRoom = new Room("in the janitor room");
        HallWay_green = new Room("in the green hallway");
        HallWay_black = new Room("in the black hallway");
        toilet = new Room("in the toilet");
        exit = new Room("Congrats, you win");

        // Exits: 
        startRoom.setExit("east", HallWay_red);  //Uses the "sub-method" setExit in the Room class, to set which ways you can leave the rooms

        MathRoom.setExit("south", HallWay_red);

        HistoryRoom.setExit("south", HallWay_blue);

        HallWay_red.setExit("north", MathRoom);
        HallWay_red.setExit("east", HallWay_blue);
        HallWay_red.setExit("south", HallWay_green);
        HallWay_red.setExit("west", startRoom);
        HallWay_blue.setExit("north", HistoryRoom);
        HallWay_blue.setExit("east", JanitorRoom);
        HallWay_blue.setExit("west", HallWay_red);
        HallWay_blue.setExit("south", HallWay_black);
        JanitorRoom.setExit("west", HallWay_blue);
        HallWay_green.setExit("north", HallWay_red);
        HallWay_green.setExit("east", HallWay_black);
        HallWay_green.setExit("south", exit);
        HallWay_black.setExit("north", HallWay_blue);
        HallWay_black.setExit("west", HallWay_green);
        HallWay_black.setExit("east", toilet);

        toilet.setExit("west", HallWay_black);

        currentRoom = startRoom;
        
        //Create objects and put them in rooms:
        Item pants = new Item("pants",0);
            pants.setInventoryIncrease();
        Item batteries = new Item("batteries", 10);
        Item flashlight = new Item("flash light", 10);
        Item mainKey = new Item("Main Key", 10);
        Item silverKey = new Item("Silver Key", 10);
        Item redLocker = new Item("Red Locker", 1000);
            redLocker.setObjectContent();
        Item blueLocker = new Item("Blue Locker", 1000);
            blueLocker.setObjectContent();
        Item greenLocker = new Item("Green Locker", 1000);
            greenLocker.setObjectContent();
        Item blackLocker = new Item("Black Locker", 1000);
            blackLocker.setObjectContent();
        Item randomPerson = new Item("Random Person", 0);

        //insert objects in rooms (Object , volume of object)
        HallWay_black.putInsideRoom(blackLocker, 1000);
        HallWay_green.putInsideRoom(greenLocker, 1000);
        HallWay_blue.putInsideRoom(blueLocker, 1000);
        HallWay_red.putInsideRoom(redLocker, 1000);
        
    }

    public void play() {
        //Creating player at start of game:
        System.out.println("Name your Character: ");
        Player newplayer = new Player(input.next());
        System.out.println("Dear " + newplayer.getName() + "!");
        printWelcome();

        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    private void printWelcome() {
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

   
    private boolean processCommand(Command command) {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        if (commandWord == CommandWord.UNKNOWN) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        if (commandWord == CommandWord.HELP) {
            printHelp();
        } else if (commandWord == CommandWord.GO) {
            goRoom(command);
        } else if (commandWord == CommandWord.QUIT) {
            wantToQuit = quit(command);
        } else if (commandWord == CommandWord.GRAB) {
            System.out.println("Placeholder for grab command.");
        } else if (commandWord == CommandWord.USE) {
            System.out.println("Placeholder for interact command.");
        } else if (commandWord == CommandWord.DROP) {
            System.out.println("Placeholder for drop command.");
        } else if (commandWord == CommandWord.INSPECT) {
            currentRoom.getInsideRoom();    
        } else if (commandWord == CommandWord.INVENTORY) {
            System.out.println("Placeholder for inventory command.");
        }
        
        return wantToQuit;
    }

    private void printHelp() {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    private void goRoom(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        Room nextRoom = currentRoom.getExit(direction);
        
        
        if (nextRoom == null) {
            System.out.println("There is no door!");
        } else {
            currentRoom = nextRoom; //Implement the random person popping up here
            changeOfRooms++; 
            int randomPersonPoppingUp = (int)(Math.random() * 3 + 1);
            
            
            //Prints the description of the room you are now in:
            System.out.println(currentRoom.getLongDescription());
            if(randomPersonPoppingUp == 2){
            //Written so questions does not come immediatly
            if(changeOfRooms > 1){
            //Here comes the questions randomly
            
            //Generate the question 
            String question = person.generateQuestions();
            System.out.println("Questions: " + question);
            //Generates the right corresponding answer
            String answer = person.generateAnswers();
            
            //Obtains the player answer through a different scanner input than the one used to change rooms
            String playerAnswer = scanner.nextLine(); 
            
            //Checks if the answer is correct, case insensitive
            if(answer.toLowerCase().equals(playerAnswer.toLowerCase())){
                    System.out.println("That's right! well done");
                    person.pointsFromAnswers(100);
            }
            else
                    System.out.println("No, that's not right");
            //Prints the room discription again after the answer, so its easier for the user to see
            System.out.println(currentRoom.getLongDescription());
            } 
            }
            
        }
    }

    private boolean quit(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        } else {
            person.pointsFromTime(startTime);
            person.returnPlayerPoints(); 
            return true;
        }
    }
}
