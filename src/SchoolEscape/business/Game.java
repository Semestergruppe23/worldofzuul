package SchoolEscape.business;
import worldofzuul.*;
import SchoolEscape.Acquaintance.IHighscoreList;
import worldofzuul.objects.Person;
import worldofzuul.objects.CarryableItem;
import worldofzuul.objects.NonCarryableItem;
import worldofzuul.objects.Key;
import worldofzuul.objects.Pants;
import java.util.*;
/**
 * @author Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
public class Game {
    private Parser parser;
    private Room currentRoom;
    Scanner input = new Scanner(System.in);
    Person person = new Person(); //The hallucination that pops up and asks questions
    EndOfGame pointsAndEnd = new EndOfGame(); //Awards the player poits, take away time, and end the game under certain conditions
    int changeOfRooms = 0; //made so that random questions dont pop up when first beginning the game
    Scanner scanner = new Scanner(System.in); //So that the answers dont interfer with the commands
    long startTime = System.currentTimeMillis(); //Made so the game time is initialized when the player starts the game
    int questionsAsked = 1;//So that questions are only answered as long as there is more in the array
    private Player newplayer = new Player();
    IHighscoreList HighscoreList;
    private ArrayList gameHighscore;
    
    
    
    public Game() {
        createRooms();
        parser = new Parser();
        person.putQuestionsAndAnswers(); //Fills the hashmap in the Person class with questions and answers
    }
    
    
    
    private void createRooms() {
        Room startRoom, MathRoom, HistoryRoom, HallWay_red, HallWay_blue, JanitorRoom, HallWay_green, HallWay_black, toilet, exit; //Declares the rooms of the game

        startRoom = new Room("Where the game starts: ", false); // Uses the method Room, which declares instances of the Room class, with string arguments for each room
        MathRoom = new Room("in the Math room", false);
        HistoryRoom = new Room("in the history room", false);
        HallWay_red = new Room("in the red hallway", false);
        HallWay_blue = new Room("in the blue hallway", false);
        JanitorRoom = new Room("in the janitor room", true);
        HallWay_green = new Room("in the green hallway", false);
        HallWay_black = new Room("in the black hallway", false);
        toilet = new Room("in the toilet", false);
        exit = new Room("Congrats, you win", true);

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
        
        JanitorRoom.setRoomLockedMessage("The room is dark. you need a flashlight with batteries");
        exit.setRoomLockedMessage("The room is locked. You need to find a key");
        MathRoom.setRoomLockedMessage("The room is locked. You need to find a key.");
        
        currentRoom = startRoom;
        
        //Create objects and put them in rooms:
        Pants pants = new Pants("pants",0);
        CarryableItem batteries = new CarryableItem("batteries", 10);
        CarryableItem flashlight = new CarryableItem("flash light", 10);
        Key mainKey = new Key("Main Key", 10);
        Key silverKey = new Key("Silver Key", 10);
        NonCarryableItem redLocker = new NonCarryableItem("RedLocker", 1000);
        NonCarryableItem blueLocker = new NonCarryableItem("Blue Locker", 1000);
        NonCarryableItem greenLocker = new NonCarryableItem("Green Locker", 1000);
        NonCarryableItem blackLocker = new NonCarryableItem("Black Locker", 1000);
        NonCarryableItem randomPerson = new NonCarryableItem("Random Person", 0);

        //insert objects in rooms (Object , volume of object)
        HallWay_black.putInsideRoom(blackLocker);
        HallWay_green.putInsideRoom(greenLocker);
        HallWay_blue.putInsideRoom(blueLocker);
        HallWay_red.putInsideRoom(redLocker);
        
    }

    public void play() {
        //Creating player at start of game:
        System.out.println("Name your Character: ");
        newplayer.setName(input.nextLine());
        //Create highscorelist from database
        setGameHighscore(HighscoreList.getHighscoreList(HighscoreList));
        //Choice to see highscore
        System.out.println("See highscore list press 1, 0 to continue");
        switch (input.nextInt()){
            case 1:
                for (int i = 0; i < gameHighscore.size()-1; i++)
                    System.out.println(gameHighscore.get(i));
            default :
                break;
        }
        System.out.println("Dear " + newplayer.getName() + "!");
        printWelcome();
        

        
        boolean finished = false;
        while (!finished) {
            
            Command command = parser.getCommand();
            finished = processCommand(command);
            
        //Checks if the time has run out, print the remaing time if not, else the game is ended
            finished = pointsAndEnd.checkTime(startTime);
            
        //If the player reaches the exit, finished = true, and the points is printet with the returnPlayerPoints() method
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
            if (command.getSecondWord().matches("\\d+")) { // Checks if secondWord contains digits only. \d means a digit and + means one or more times.
          newplayer.grab((CarryableItem) currentRoom.pickItemFromRoom(Integer.parseInt(command.getSecondWord())-1)); 
            }
            System.out.println("Please enter a digit.");
        } else if (commandWord == CommandWord.USE) {
            System.out.println("using");
        } else if (commandWord == CommandWord.DROP) {
            if (command.getSecondWord().matches("\\d+")) { // Checks if secondWord contains digits only. \d means a digit and + means one or more times.
           currentRoom.putInsideRoom(newplayer.drop(Integer.parseInt(command.getSecondWord())-1));
            }
            System.out.println("Please enter a digit.");
        } else if (commandWord == CommandWord.INSPECT) {
            currentRoom.getInsideRoom();    
        } else if (commandWord == CommandWord.INVENTORY) {
            newplayer.showInventory();
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
        //Checks if the room is locked and displays the locked message if true
        if(nextRoom.getRoomLocked() == true){
            nextRoom.getRoomLockedMessage();
        }
        else{
            
        
        if (nextRoom == null) {
            System.out.println("There is no door!");
        } else {
            currentRoom = nextRoom;
            changeOfRooms++; 
            System.out.println(currentRoom.getLongDescription());
            
            //1/3 chance of the hallucination to pop up and ask a question everytime the player switches rooms
            person.randomPopUp(changeOfRooms, person, scanner, pointsAndEnd, currentRoom, newplayer);
        }  
        }
        
    }
    //Making the highscorelist from data-layer into its own list
    public void setGameHighscore(ArrayList list){
            this.gameHighscore = list;
        }
    //Inject method for connecting data-layer and business layer
    public void injectHighscoreList(IHighscoreList list){
        this.HighscoreList = list;
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
