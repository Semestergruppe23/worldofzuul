package SchoolEscape.business;

import worldofzuul.*;

/** 
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */

public class Command 
{
    private CommandWord commandWord;
    private String secondWord;

    /**
     * The constructor
     * @param commandWord
     * @param secondWord 
     */
    public Command(CommandWord commandWord, String secondWord)
    {
        this.commandWord = commandWord;
        this.secondWord = secondWord;
    }

    /**
     * 
     * @return CommandWord
     */
    public CommandWord getCommandWord()
    {
        return commandWord;
    }

    /**
     * 
     * @return secondWord
     */
    public String getSecondWord()
    {
        return secondWord;
    }

    /**
     * 
     * @return Boolean 
     */
    public boolean isUnknown()
    {
        return (commandWord == CommandWord.UNKNOWN);
    }

    /**
     * 
     * @return Boolean
     */
    public boolean hasSecondWord()
    {
        return (secondWord != null);
    }
}

