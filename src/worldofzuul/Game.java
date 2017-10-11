package worldofzuul;

/**
 * @author Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
public class Game {

    private Parser parser;
    private Room currentRoom;

    public Game() {
        createRooms();
        parser = new Parser();
    }

    private void createRooms() {
        Room startRoom, MathRoom, HistoryRoom, HallWay_red, HallWay_blue, JanitorRoom, HallWay_green, HallWay_black, toilet, exit; //Declares the rooms of the game

        startRoom = new Room("Where the player starts: "); // Uses the method Room, which declares instances of the Room class, with string arguments for each room
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
    }

    public void play() {
        printWelcome();

        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    private void printWelcome() {
        System.out.println();
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
        } else if (commandWord == CommandWord.INTERACT) {
            System.out.println("Placeholder for interact command.");
        } else if (commandWord == CommandWord.DROP) {
            System.out.println("Placeholder for drop command.");
        } else if (commandWord == CommandWord.INSPECT) {
            System.out.println("Placeholder for inspect command.");
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
            System.out.println(currentRoom.getLongDescription());
        }
    }

    private boolean quit(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        } else {
            return true;
        }
    }
}
