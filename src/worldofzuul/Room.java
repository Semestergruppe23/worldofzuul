package worldofzuul;

import java.util.*;
import worldofzuul.items.*;

/*
Each "Room" represents a location in the game and is connected to other rooms via exits. 
 */
public class Room {

    private String description;
    private HashMap<String, Room> exits; //Stores exits of this room
    private ArrayList<ItemInterface> insideRoom = new ArrayList<>();

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
    public void putInsideRoom(ItemInterface thing) {
        this.insideRoom.add(thing);
    }

    /**
     * Prints what inside a room
     */
    public void getInsideRoom() {
        System.out.println("You look around, and find: ");
        for (ItemInterface items : insideRoom) { 
            System.out.println( "" + (insideRoom.indexOf(items)+1)+ ". " + items.toString());
        }
        System.out.println("Thats it!");

    }
    

    public ItemInterface pickItemFromRoom(int index) {
        for(ItemInterface items : insideRoom) {
            if (items.equals(insideRoom.get(index))) {
                removeFromRoom(items);
                return items;         
            }
           
        }
        return null;
    }
    
    

    public void removeFromRoom(ItemInterface item) {
        Iterator<ItemInterface> it = insideRoom.iterator();
        
        if (it.hasNext()) {
            if (it.next().equals(item)) {
                it.remove();
            }
        }
    }
    }


