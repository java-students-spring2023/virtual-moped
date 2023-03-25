package edu.nyu.cs;

import java.util.Arrays;

/**
 * A virtual moped, roaming the streets of New York.
 * The signatures of a few methods are given and must be completed and used as indicated.
 * Create as many additional properties or methods as you want, as long as the given methods behave as indicated in the instructions.
 * Follow good object-oriented design, especially the principles of abstraction (i.e. the black box metaphor) and encapsulation (i.e. methods and properties belonging to specific objects), as we have learned them.
 * The rest is up to you.
 */
public class Moped {

    /**
     * Sets the orientation of the moped to a particular cardinal direction.
     * @param orientation A string representing which cardinal direction at which to set the orientation of the moped.  E.g. "north", "south", "east", or "west".
     */
    public void setOrientation(String orientation) {

    }

    /**
     * Returns the current orientation of the moped, as a lowercase String.
     * E.g. "north", "south", "east", or "west".
     * @return The current orientation of the moped, as a lowercase String.
     */
    public String getOrientation() {
        return ""; // placeholder only... delete this!        
    }

    /**
     * Prints the current location, by default exactly following the format:
     *      Now at 12th St. and 5th Ave, facing South.
     *
     * If the current location is associated with location-based advertising, this method should print exactly following format:
     *      Now at 12th St. and 4th Ave, facing West.  Did you know The Strand has 18 Miles of new, used and rare books, and has been in business since 1927?
     * 
     * Note that the suffixes for the numbers must be correct: i.e. the "st" in "1st", "nd" in "2nd", "rd" in "3rd", "th" in "4th", etc, must be correct.
     */
    public void printLocation() {

    }

    /**
     * Handles the command, `go left`.
     * Moves the moped one block to the left, and causes the moped to face the appropriate new cardinal direction.
     * Consumes gas with each block moved, and doesn't move or turn unless there is sufficient gas, as according to the instructions.
     * If attempting to drive off the map, the moped will turn but not move a block.  Turns-only consume no gas.
     * This method must not print anything.
     */
    public void goLeft() {

    }

    /**
     * Handles the command, `go right`.
     * Moves the moped one block to the right, and causes the moped to face the appropriate new cardinal direction.
     * Consumes gas with each block moved, and doesn't move or turn unless there is sufficient gas, as according to the instructions.
     * If attempting to drive off the map, the moped will turn but not move a block.  Turns-only consume no gas.
     * This method must not print anything.
     */
    public void goRight() {

    }

    /**
     * Handles the command,`straight on`.
     * Moves the moped one block straight ahead.
     * Consumes gas with each block moved, and doesn't move unless there is sufficient gas, as according to the instructions.
     * This method must not print anything.
     */
    public void goStraight() {

    }

    /**
     * Handles the command,`back up`.
     * Moves the moped one block backwards, but does not change the cardinal direction the moped is facing.
     * Consumes gas with each block moved, and doesn't move unless there is sufficient gas, as according to the instructions.
     * This method must not print anything.
     */
    public void goBackwards() {

    }

    /**
     * Handles the command,`how we doin'?`.
     * This method must not print anything.
     * @return The current gas level, as an integer from 0 to 100.
     */
    public int getGasLevel() {
        return 0; // placeholder only... delete this!
    }

    /**
     * Prints the current gas level, by default exactly following the format:
     *      The gas tank is currently 85% full.
     *
     * If the moped is out of gas, this method should print exactly following format:
     *      We have run out of gas.  Bye bye!
     */
    public void printGasLevel() {

    }

    /**
     * Handles the command, `fill it up`.
     * This method must not print anything.
     * Fills the gas level to the maximum.
     */
    public void fillGas() {

    }

    /**
     * Handles the command, `park`.
     * This causes the program to quit.  
     * You can use System.exit(0); to cause a program to quit with status code 0, which indicates a normal graceful exit. 
     * (In case you were wondering, status code 1 represents quitting as a result of an error of some kind).
     */
    public void park() {

    }

    /**
     * Handles the command, `go to Xi'an Famous Foods`
     * Causes the moped to self-drive, block-by-block, to 8th Ave. and 15th St.
     * Consumes gas with each block, and doesn't move unless there is sufficient gas, as according to the instructions.
     */
    public void goToXianFamousFoods() {

    }

    /**
     * Generates a string, containing a list of all the user commands that the program understands.
     * @return String containing commands that the user can type to control the moped.
     */
    public String getHelp() {
        return ""; // placeholder only... delete this!        
    }

    /**
     * Sets the current location of the moped.
     * @param location an int array containing the new location at which to place the moped, in the order {street, avenue}.
     */
    public void setLocation(int[] location) {

    }

    /**
     * Gets the current location of the moped.
     * @return The current location of the moped, as an int array in the order {street, avenue}.
     */
    public int[] getLocation() {
        // the following two lines are placeholder... delete them and return this moped's correct coordinates.
        int[] location = {3, 4}; // an example array at 3rd st and 4th Ave.... placeholder only... delete this!
        return location;
    }

}
