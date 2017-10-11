package worldofzuul;

import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;
 
/*
Each "Room" represents a location in the game and is connected to other rooms via exits. 
*/

/**
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
public class Room
{
    
    // test
    private String description;
    private HashMap<String, Room> exits; //Stores exits of this room

    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<String, Room>();
        
        
    }
 /* Defines the exit of the particular room
    Direction: Direction of the exit
    Neighbor: The room connected to this one in the given direction
    */
    
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }
/* Description of the room
    
    */
    public String getShortDescription()
    {
        return description;
    }
 /* Describes which room you are in and where the exit is.
    ex. "You are in a lecture theatre
        Exits: west"
    */
    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString();
    }
 /* Returns a string describing the available exits
        ex. "Exits: west south"
        
        */
	private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }
/* Returns the room that is reached if we go from this room in direction,
        "direction". If there is no room, return null. 

        */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
}

