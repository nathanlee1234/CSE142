// Nathan Lee << Nathan Lee >>
// 3/8/2022
// CSE 142
// TA: Michelle Jose Morris << Michelle Jose Morris >>
// Take-home Assesment #8
// Decides the color, move, and message displayed by the Husky for each round.

import java.util.*;
import java.awt.*;

// A class to represent the characteristics of the Husky critter.
public class Husky extends Critter {
        
    private Random rand;
    private int randomNumber;
    private Color color;

    // Constructs a new Husky.  
    public Husky() {
        rand = new Random();
    }
        
    // Chooses a random number between 0 and 1. Sets the 
    // Color color to GRAY or WHITE based on the random number.
    // Returns Color GRAY or WHITE based on the random number.
    public Color getColor() {
        randomNumber = rand.nextInt(2);
        
        if (randomNumber == 0) {
            color = Color.GRAY;
            return Color.GRAY;

        } else {
            color = Color.WHITE;
            return Color.WHITE;
        }
    }

    // Chooses a move for the Husky based on information in the CritterInfo method.
    // Paramaters:
    //      CritterInfo info - An object containing info on the Husky.
    // Returns INFECT, RIGHT, or LEFT based on what is in front of the Husky.
    public Action getMove(CritterInfo info) {
        info.getFront();

        if (info.getFront() == Neighbor.OTHER) {
             return Action.INFECT;

        } else if (info.getFront() == Neighbor.WALL) {
            return Action.RIGHT;

        } else if (info.getFront() == Neighbor.SAME) {
            return Action.LEFT;

        } else {
            return Action.HOP;
        }
    }

    // Returns "Gray Husky" or "White Husky" 
    // based on the color of the husky.
    public String toString() {
        if (color == Color.GRAY) {
            return "Gray Husky";

        } else {
            return "White Husky";
        }
    }
}
