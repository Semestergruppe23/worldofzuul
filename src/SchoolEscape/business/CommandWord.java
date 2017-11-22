package SchoolEscape.business;

import worldofzuul.*;

/**
 * @author Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
public enum CommandWord // A class of the type enum. 
{
    GO("go"), QUIT("quit"), HELP("help"), UNKNOWN("?"), GRAB("grab"), USE("use"), DROP("drop"), INSPECT("inspect"), INVENTORY("inventory") ; // The different commands that can be used in the game. 


    private String commandString; 
    
    /**
     * 
     * @param commandString 
     */
    
    CommandWord(String commandString) 
    {
        this.commandString = commandString;
    }
    
    /**
     * 
     * @return Overriding toString
     */
    public String toString() 
    {
        return commandString;
    }
}
