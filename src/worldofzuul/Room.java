package worldofzuul;


import java.util.*;
import worldofzuul.items.*;
 
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
    private Map < Item , Integer > insideRoom = new HashMap<>();

    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<String, Room>();
        this.insideRoom = insideRoom;
        
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
    public void putInsideRoom(Item thing,int volume){
        this.insideRoom.put(thing, volume);
    }
    public void getInsideRoom(){
        System.out.println("You look around, and find: ");
        for(Item items : insideRoom.keySet()) {
            System.out.println(items.toString());
        }
        System.out.println("Thats it!");

    }
}

