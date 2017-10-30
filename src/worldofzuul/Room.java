package worldofzuul;

import java.util.*;
import worldofzuul.items.*;

/*
Each "Room" represents a location in the game and is connected to other rooms via exits. 
 */
public class Room {

    private String description;
    private HashMap<String, Room> exits; //Stores exits of this room
    private Map< Item, Integer> insideRoom = new HashMap<>();

    /**
     * Constructor
     *
     * @param description
     */
    public Room(String description) {
        this.description = description;
        exits = new HashMap<String, Room>();
        this.insideRoom = insideRoom;

    }

    /* Defines the exit of the particular room
    Direction: Direction of the exit
    Neighbor: The room connected to this one in the given direction
     */

    public void setExit(String direction, Room neighbor) {
        exits.put(direction, neighbor);
    }

    public String getShortDescription() {
        return description;
    }

    /**
     * escribes which room you are in and where the exit is. ex. "You are in a
     * lecture theatre Exits: west"
     *
     * @return String
     */
    public String getLongDescription() {
        return "You are " + description + ".\n" + getExitString();
    }

    /**
     * Return the exits room
     * @return String
     */
    private String getExitString() {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for (String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * 
     * @param direction
     * @return Room
     */
    public Room getExit(String direction) {
        return exits.get(direction);
    }

    /**
     * 
     * @param thing
     * @param volume 
     */
    public void putInsideRoom(Item thing, int volume) {
        this.insideRoom.put(thing, volume);
    }

    /**
     * Prints what inside a room
     */
    public void getInsideRoom() {
        System.out.println("You look around, and find: ");
        for (Item items : insideRoom.keySet()) { 
            System.out.println(items.toString());
        }
        System.out.println("Thats it!");

    }
    
    public Item getItem(String string) {
        for ( Item items : insideRoom.keySet()) {
            if (items.getName().equals(string)){
                System.out.println(items);
                return items;
            } 
            }
              return null;  
        }
    
    
    public void removeFromRoom(Item item) {
        insideRoom.remove(item);
    }
    }


