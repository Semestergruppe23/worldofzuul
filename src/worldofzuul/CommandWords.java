package worldofzuul;

import java.util.HashMap;

/**
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */

public class CommandWords // Class with the name of CommandWords.
{
    private HashMap<String, CommandWord> validCommands; // Hashmap still not learnt. 

    public CommandWords() // Constructor. 
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
     * @return
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
    
    public boolean isCommand(String aString) // Method isCommand that requires a string.
    {
        return validCommands.containsKey(aString);
    }

    public void showAll() // Method showAll.
    {
        for(String command : validCommands.keySet()) {
            System.out.print(command + "  ");
        }
        System.out.println();
    }
}
