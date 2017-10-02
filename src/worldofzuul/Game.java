package worldofzuul;

/**
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
public class Game 
{
    private Parser parser;  //Creates an instance of the Parser class, and assigns it to the variable "parser"
    private Room currentRoom;  // Creates an instance of the Room class, and assigns it to the variable "currentRoom"
        
    public Game() //No-args constructor of the Game Class
    {
        createRooms();  //Kører createRooms klassen, som laver rummene i starten af spillet
        parser = new Parser();  //Creates an instant of the parser class (continued from above for unknown reasons)
								//, to continuelly run in the play method untill the game ends
    }

    private void createRooms()  //Is used in the game class, and creates the rooms of the game at start, with instances of the Room class
    {
        Room outside, theatre, pub, lab, office, HUT; //Declares the rooms of the game, SLET HUT
      
        outside = new Room("outside the main entrance of the university"); // Uses the method Room, which declares instances of the Room class, with string arguments for each room
        theatre = new Room("in a lecture theatre");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");
        HUT = new Room("In the HUT \n Exits: go east"); // SLET
        
        outside.setExit("east", theatre);  //Uses the "sub-method" setExit in the Room class, to set which ways you can leave the rooms
        outside.setExit("south", lab);
        outside.setExit("west", pub);

        theatre.setExit("west", outside);
        theatre.setExit("east", HUT); // SLET
        HUT.setExit("east", theatre); 

        pub.setExit("east", outside);

        lab.setExit("north", outside);
        lab.setExit("east", office);

        office.setExit("west", lab);

        currentRoom = outside;  // Sets the initial room to "outside" which is changed in the goRoom method below
    }

    public void play() //Method to start the game
    {            
        printWelcome();  //Prints the welcome method, using the printWelcome method below

        boolean finished = false;  // Remains false until changed in the quit method below
        while (! finished) {		//While the game is not finished, continuelly get commands from the parser.getCommand() Method
            Command command = parser.getCommand();
            finished = processCommand(command);		//Changes to "true" when the parser receives the word "QUIT"
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    private void printWelcome()  //Prints the welcome + the CommandWord.HELP (HASHMAP THING),
	{			//which is "help", and the getLongDescription method for the current room, from the Room class
    
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    private boolean processCommand(Command command)   //Processes a command object from the Command class
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();     //Creates a object from the getCommandWord() method in the Commandword class

        if(commandWord == CommandWord.UNKNOWN) {                //HASHMAP_THING, if the command != Go, quit, etc. sout "I dont know what... " 
            System.out.println("I don't know what you mean...");
            return false;
        }

        if (commandWord == CommandWord.HELP) {                  //If the commandWord is "help" call the printHelp() method below
            printHelp();
        }
        else if (commandWord == CommandWord.GO) {               //If the command is "go" call the goRoom method below
            goRoom(command);
        }
        else if (commandWord == CommandWord.QUIT) {             //If the command word is "quit" call the quit method below, with the argument "quit"
            wantToQuit = quit(command);
        }
        return wantToQuit;
    }

    private void printHelp()                                    //Prints a little text and calls the showCommands() method from the parser class
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    private void goRoom(Command command)       //The method to go to another room                 
    {
        if(!command.hasSecondWord()) {          //If the command does not have a second word, "Go where?" is asked
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        Room nextRoom = currentRoom.getExit(direction);         //Makes the nextRoom from the Room class be the exit from the current room

        if (nextRoom == null) {
            System.out.println("There is no door!");            //Is nextRoom doesent have the wanted exit, print "There is no door"
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());   //Changes the currentRoom to the requested nextRoom, and prints the rooms description
        }
    }

    private boolean quit(Command command)       //Method to quit the game
    {
        if(command.hasSecondWord()) {           //If there is a word after "quit", returns false and asks "Quit what?"
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;                        //Returns true if the command.equals("quit") and quits the game 
        }
    }
}
