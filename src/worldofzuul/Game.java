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
    EndOfGame pointsAndEnd = new EndOfGame();
    int changeOfRooms = 0; //made so that random questions dont pop up when first beginning the game
    Scanner scanner = new Scanner(System.in); //So that the answers dont interfer with the commands
    long startTime = System.currentTimeMillis(); 
    int questionsAsked = 1;//So that questions are only answered as long as there is more in the array
    private Player newplayer = new Player();
    
    
    public Game() {
        createRooms();
        parser = new Parser();
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
        Item redLocker = new Item("RedLocker", 1000);
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
        newplayer.setName(input.nextLine());
        System.out.println("Dear " + newplayer.getName() + "!");
        printWelcome();

        
        boolean finished = false;
        while (!finished) {
            
            Command command = parser.getCommand();
            finished = processCommand(command);
            if(currentRoom.getShortDescription().equals("Congrats, you win")){
                pointsAndEnd.pointsFromTime(startTime);
                pointsAndEnd.returnPlayerPoints(); 
                finished = true; 
            }
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
             newplayer.grab(currentRoom.getItem(command.getSecondWord()));
             currentRoom.removeFromRoom(currentRoom.getItem(command.getSecondWord()));
        } else if (commandWord == CommandWord.USE) {
            System.out.println("using");
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
            currentRoom = nextRoom;
            changeOfRooms++; 
            System.out.println(currentRoom.getLongDescription());
            
            /*
            Person randomly pops up here, asking questions, which gives extra points
            questionsAked < getArrayLength, so questions is only asked while there is more in the array
            Math.random (1-3) is used so there is a 1/3 chance of this happening
            changeOfRooms > 1 is written so it does not happen immediatly
            Generate the question, get the players answer, and generate string with the "real answer"
            Check if the answer is correct, and give points to player if so
            if the room is the "Exit", imediatly print out score and end the game
            */
            
                if((int)(Math.random() * 3 + 1) == 2 && changeOfRooms > 1 && questionsAsked < person.getArrayLength()){
                    String question = person.generateQuestions();
                    System.out.println("Questions: " + question + "\n Your answer: ");
                    String playerAnswer = scanner.nextLine().toLowerCase(); 
                    String realAnswer = person.answersAndQuestions.get(question).toLowerCase();
                    questionsAsked++; 
                    if(playerAnswer.equals(realAnswer)){
                        System.out.println("That's right! well done");
                        pointsAndEnd.pointsFromAnswers(100);
                    }
                    else{
                        System.out.println("No, that's not right");
                    }

            //Prints the room discription again after the answer, so its easier for the user to see
            System.out.println(currentRoom.getLongDescription());
            }
        }  
    }

    private boolean quit(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        } else {
            pointsAndEnd.pointsFromTime(startTime);
            pointsAndEnd.returnPlayerPoints(); 
            return true;
        }
    } 
}
