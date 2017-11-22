package SchoolEscape.business;

import worldofzuul.*;
import java.util.HashMap;

/**
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */

public class CommandWords // Class with the name of CommandWords.
{
    private HashMap<String, CommandWord> validCommands; 

    /**
     * No arg constructor
     */
    public CommandWords() 
    {
        validCommands = new HashMap<String, CommandWord>(); // Hashmap.
        for(CommandWord command : CommandWord.values()) {
            if(command != CommandWord.UNKNOWN) { // If the command does NOT equal CommandWord.UNKNOWN
                validCommands.put(command.toString(), command); // 
            }
        }
    }



    /**
     *
     * @param commandWord
     * @return Commandword
     */
    public CommandWord getCommandWord(String commandWord) // Method getCommandWord that requires a String input.
    {
        CommandWord command = validCommands.get(commandWord); // New object named command.
        if(command != null) { // If command is not empty or null.
            return command; // Returns the command if it's not empty or null.
        }
        else {
            return CommandWord.UNKNOWN; // If the command is null then it should be seen as unknown.
        }
    }
    
    /**
     * 
     * @param aString
     * @return Boolean
     */
    public boolean isCommand(String aString) // Method isCommand that requires a string.
    {
        return validCommands.containsKey(aString);
    }

    /**
     * Method to show all valid commands
     */
    public void showAll() // Method showAll.
    {
        for(String command : validCommands.keySet()) {
            System.out.print(command + "  ");
        }
        System.out.println();
    }
}
