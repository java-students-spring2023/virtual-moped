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

    private String orientation = "south"; 
    private boolean forward = true; 
    private int gas = 100; 
    private int streetLoc = 10;
    private int aveLoc = 5; 


    /**
     * Sets the orientation of the moped to a particular cardinal direction.
     * @param orientation A string representing which cardinal direction at which to set the orientation of the moped.  E.g. "north", "south", "east", or "west".
     */
    public void setOrientation(String orientation) {
        if (orientation.equalsIgnoreCase("north")) {
            this.orientation = "north";
        } else if (orientation.equalsIgnoreCase("south")) {
            this.orientation = "south";
        } else if (orientation.equalsIgnoreCase("east")) {
            this.orientation = "east";
        } else if (orientation.equalsIgnoreCase("west")) {
            this.orientation = "west";
        }   
    }

    /**
     * Returns the current orientation of the moped, as a lowercase String.
     * E.g. "north", "south", "east", or "west".
     * @return The current orientation of the moped, as a lowercase String.
     */
    public String getOrientation() {
        return this.orientation; 
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
        String capitalizedOri = this.orientation.substring(0, 1).toUpperCase() + this.orientation.substring(1);

        int street = getLocation()[0];
        int ave = getLocation()[1];
        
        String streetSuf = "";
        String aveSuf = "";
        String ad = "";

        switch (street % 100) {
            case 11: 
            case 12: 
            case 13:
                streetSuf = "th";
                break;
            default:
                switch (street % 10) {
                    case 1: 
                        streetSuf = "st";
                        break;
                    case 2:
                        streetSuf = "nd";
                        break;
                    case 3:
                        streetSuf = "rd";
                        break;
                    default:
                        streetSuf = "th";
                }
        }

        switch (ave) {
            case 1:
                aveSuf = "st";
                break;
            case 2:
                aveSuf = "nd";
                break;
            case 3:
                aveSuf = "rd";
                break;
            default:
                aveSuf = "th";
        }

        if (street == 12 && ave == 4) {
            ad = " Did you know The Strand has 18 Miles of new, used and rare books, and has been in business since 1927?";
        }
        if (street == 79 && ave == 8) {
            ad = " Did you know that the American Museum of Natural History was founded in 1869 and is renowned for its exibitions and scientific collections?";
        }
        if (street == 74 && ave == 1) {
            ad = " Did you know that Memorial Sloan Kettering was one of the first cancer centers to receive the Comprehensive Cancer Center designation from NCI in 1971?";
        }
        if (street == 56 && ave == 3) {
            ad = " Did you know that Tina's Cuban Cuisine uses the most natural ingredients that are always freshly prepared?";
        }
        if (street == 15 && ave == 8) {
            ad = " We have reached Xi'an Famous Foods.  Enjoy your noodles.";
        }

        
        String message = String.format("Now at %d%s St. and %d%s Ave, facing %s. %s", street, streetSuf, ave, aveSuf, capitalizedOri, ad); 

        System.out.println(message);
    }

    /**
     * Handles the command, `go left`.
     * Moves the moped one block to the left, and causes the moped to face the appropriate new cardinal direction.
     * Consumes gas with each block moved, and doesn't move or turn unless there is sufficient gas, as according to the instructions.
     * If attempting to drive off the map, the moped will turn but not move a block.  Turns-only consume no gas.
     * This method must not print anything.
     */
    public void goLeft() {
        int[] location = getLocation();
        int street = location[0];
        int ave = location[1];
        
        if (this.gas > 0) {
            if (this.orientation.equals("north")) {
                if (this.forward) {
                    this.orientation = "west";
                    if (ave != 10) {
                        ++this.aveLoc;
                        this.gas = this.gas - 5;
                    }
                } else {
                    this.orientation = "east";
                    if (ave != 10) {
                        ++this.aveLoc;
                        this.gas = this.gas - 5;
                    }
                }
                
            } else if (this.orientation.equals("south")) {
                if (this.forward) {
                    this.orientation = "east";
                    if (ave != 1) {
                        --this.aveLoc;
                        this.gas = this.gas - 5;
                    }
                } else {
                    this.orientation = "west";
                    if (ave != 1) {
                        --this.aveLoc;
                        this.gas = this.gas - 5;
                    }
                }

            } else if (this.orientation.equals("east")) {
                if (this.forward) {
                    this.orientation = "north";
                    if (street != 200) {
                        ++this.streetLoc;
                        this.gas = this.gas - 5;
                    }
                } else {
                    this.orientation = "south";
                    if (street != 200) {
                        ++this.streetLoc;
                        this.gas = this.gas - 5;
                    }
                }
            } else if (this.orientation.equals("west")) {
                if (this.forward) {
                    this.orientation = "south";
                    if (street != 1) {
                        --this.streetLoc;
                        this.gas = this.gas - 5;
                    }
                } else {
                    this.orientation = "north";
                    if (street != 1) {
                        --this.streetLoc;
                        this.gas = this.gas - 5;
                    }
                }
            }
        } else if (this.gas == 0) {
            System.out.println("We have run out of gas. Bye bye!"); 
            System.exit(0);
        }
    }

    /**
     * Handles the command, `go right`.
     * Moves the moped one block to the right, and causes the moped to face the appropriate new cardinal direction.
     * Consumes gas with each block moved, and doesn't move or turn unless there is sufficient gas, as according to the instructions.
     * If attempting to drive off the map, the moped will turn but not move a block.  Turns-only consume no gas.
     * This method must not print anything.
     */
    public void goRight() {
        int[] location = getLocation();
        int street = location[0];
        int ave = location[1];
        
        if (this.gas > 0) {
            if (this.orientation.equals("north")) {
                if (this.forward) {
                    this.orientation = "east";
                    if (ave != 1) {
                        --this.aveLoc;
                        this.gas = this.gas - 5;
                    }
                } else {
                    this.orientation = "west";
                    if (ave != 1) {
                        --this.aveLoc;
                        this.gas = this.gas - 5;
                    }
                }
                
            } else if (this.orientation.equals("south")) {
                if (this.forward) {
                    this.orientation = "west";
                    if (ave != 10) {
                        ++this.aveLoc;
                        this.gas = this.gas - 5;
                    }
                } else {
                    this.orientation = "east";
                    if (ave != 10) {
                        ++this.aveLoc;
                        this.gas = this.gas - 5;
                    }
                }

            } else if (this.orientation.equals("east")) {
                if (this.forward) {
                    this.orientation = "south";
                    if (street != 1) {
                        --this.streetLoc;
                        this.gas = this.gas - 5;
                    }
                } else {
                    this.orientation = "north";
                    if (street != 1) {
                        --this.streetLoc;
                        this.gas = this.gas - 5;
                    }
                }
            } else if (this.orientation.equals("west")) {
                if (this.forward) {
                    this.orientation = "north";
                    if (street != 200) {
                        ++this.streetLoc;
                        this.gas = this.gas - 5;
                    }
                } else {
                    this.orientation = "south";
                    if (street != 200) {
                        ++this.streetLoc;
                        this.gas = this.gas - 5;
                    }
                }
            }
        } else if (this.gas == 0) {
            System.out.println("We have run out of gas. Bye bye!"); 
            System.exit(0);
        }
    }
    

    /**
     * Handles the command,`straight on`.
     * Moves the moped one block straight ahead.
     * Consumes gas with each block moved, and doesn't move unless there is sufficient gas, as according to the instructions.
     * This method must not print anything.
     */
    public void goStraight() {
        int[] location = getLocation();
        int street = location[0];
        int ave = location[1];
        this.forward = true;

        if (this.gas > 0 ) {
            switch (this.orientation) {
                case "north":
                    if (street != 200) {
                        ++this.streetLoc;
                        this.gas = this.gas - 5;
                    }
                    break;
                case "south":
                    if (street != 1) {
                        --this.streetLoc;
                        this.gas = this.gas - 5;
                    }
                    break;
                case "east":
                    if (ave != 1) {
                        --this.aveLoc;
                        this.gas = this.gas - 5;
                    }
                    break;
                case "west":
                    if (ave != 10) {
                        ++this.aveLoc;
                        this.gas = this.gas - 5;
                    }
                    break;
            }
        } else if (this.gas == 0) {
            System.out.println("We have run out of gas. Bye bye!"); 
            System.exit(0);
        }
    }

    /**
     * Handles the command,`back up`.
     * Moves the moped one block backwards, but does not change the cardinal direction the moped is facing.
     * Consumes gas with each block moved, and doesn't move unless there is sufficient gas, as according to the instructions.
     * This method must not print anything.
     */
    public void goBackwards() {
        int[] location = getLocation();
        int street = location[0];
        int ave = location[1];
        this.forward = false;

        if (this.gas > 0 ) {
            switch (this.orientation) {
                case "north":
                    if (street != 1) {
                        --this.streetLoc;
                        this.gas = this.gas - 5;
                    }
                    break;
                case "south":
                    if (street != 200) {
                        ++this.streetLoc;
                        this.gas = this.gas - 5;
                    }
                    break;
                case "east":
                    if (ave != 10) {
                        ++this.aveLoc;
                        this.gas = this.gas - 5;
                    }
                    break;
                case "west":
                    if (ave != 1) {
                        --this.aveLoc;
                        this.gas = this.gas - 5;
                    }
                    break;
            }
        } else if (this.gas == 0) {
            System.out.println("We have run out of gas. Bye bye!"); 
            System.exit(0);
        }
    }
    

    /**
     * Handles the command,`how we doin'?`.
     * This method must not print anything.
     * @return The current gas level, as an integer from 0 to 100.
     */
    public int getGasLevel() {
        return this.gas; 
    }

    /**
     * Prints the current gas level, by default exactly following the format:
     *      The gas tank is currently 85% full.
     *
     * If the moped is out of gas, this method should print exactly following format:
     *      We have run out of gas.  Bye bye!
     */
    public void printGasLevel() {
        double percent = ((double) this.gas / 100.0);
        int percentInt = (int) Math.round(percent * 100);
        if (this.gas == 0) {
            System.out.println("We have run out of gas.  Bye bye!"); 
        } else{
            System.out.println(String.format("The gas tank is currently %d%% full.", percentInt));
        }
    }

    /**
     * Handles the command, `fill it up`.
     * This method must not print anything.
     * Fills the gas level to the maximum.
     */
    public void fillGas() {
        this.gas = 100; 
    }

    /**
     * Handles the command, `park`.
     * This causes the program to quit.  
     * You can use System.exit(0); to cause a program to quit with status code 0, which indicates a normal graceful exit. 
     * (In case you were wondering, status code 1 represents quitting as a result of an error of some kind).
     */
    public void park() {
        System.out.println("We have parked.");
        System.exit(0);

    }

    /**
     * Handles the command, `go to Xi'an Famous Foods`
     * Causes the moped to self-drive, block-by-block, to 8th Ave. and 15th St.
     * Consumes gas with each block, and doesn't move unless there is sufficient gas, as according to the instructions.
     */
    public void goToXianFamousFoods() {
        int[] location = getLocation();
        int street = location[0];
        int ave = location[1];
        int streetDist = street - 15;
        int aveDist = ave - 8; 

        while (this.aveLoc != 8) {
            if (aveDist > 0) {
                this.orientation = "east";
                for (;aveDist > 0; aveDist--) {
                    goStraight();
                    printLocation();
                }
            } else if (aveDist < 0) {
                this.orientation = "west";
                for (;aveDist < 0; aveDist++) {
                    goStraight();
                    printLocation();
                }
            }
        }
        while (this.streetLoc != 15) {
            if (streetDist > 0) {
                this.orientation = "south";
                for (;streetDist > 0; streetDist--) {
                    goStraight();
                    printLocation();
                }
            } else if (streetDist < 0) {
                this.orientation = "north";
                for (;streetDist < 0; streetDist++) {
                    goStraight();
                    printLocation();
                }
            }
        }
    }

    /**
     * Generates a string, containing a list of all the user commands that the program understands.
     * @return String containing commands that the user can type to control the moped.
     */
    public String getHelp() {
        String message = " - 'go left' : move one block to the left\n - 'go right' : move one block to the right\n - 'straight on' : move one block forward\n - 'back up' : start reversing and move one block backwards\n - 'how we doin'?' : check how much gas is remaining\n - 'fill it up' : fill up the gas tank\n - 'park' : park the moped on the sidewalk and quit\n - 'go to Xi'an Famous Foods' : go to Xi'an Famous Foods no matter where you are\n - 'help' : view a list of all commands and what they do";

        return message;         
    }

    /**
     * Sets the current location of the moped.
     * @param location an int array containing the new location at which to place the moped, in the order {street, avenue}.
     */
    public void setLocation(int[] location) {
        this.streetLoc = location[0];
        this.aveLoc = location[1];
    }

    /**
     * Gets the current location of the moped.
     * @return The current location of the moped, as an int array in the order {street, avenue}.
     */
    public int[] getLocation() {
        int[] location = {this.streetLoc, this.aveLoc}; 
        return location;
    }

}
