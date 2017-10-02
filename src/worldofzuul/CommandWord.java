package worldofzuul;

/**
 * @author Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
public enum CommandWord // A class of the type enum. Enum still unknown. 
{
    GO("go"), QUIT("quit"), HELP("help"), UNKNOWN("?"); // The different commands that can be used in the game. 
    
    private String commandString; // String with the name commandString
    
    CommandWord(String commandString) // Constructor.
    {
        this.commandString = commandString;
    }
    
    public String toString() // Getter method that returns the private String commandString. 
    {
        return commandString;
    }
}
