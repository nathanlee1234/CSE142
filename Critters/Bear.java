// Nathan Lee << Nathan Lee >>
// 3/8/2022
// CSE 142
// TA: Michelle Jose Morris << Michelle Jose Morris >>
// Take-home Assesment #8
// Decides the color, move, and message displayed by the Bear for each round.

import java.util.*;
import java.awt.*;

// A class to represent the characteristics of the Bear critter.
public class Bear extends Critter {
    
    private boolean white;
    private int i;

    // Constructs a new Bear.
    // Paramaters:
    //      boolean polar - wether the bear is white or black.
    public Bear(boolean polar) {
        white = polar;
        i = 1;
    }

    // Chooses a color for the Bear based on the boolean polar.
    // Returns the Color BLACK or WHITE based on the boolean polar.
    public Color getColor() {
        if (white == true) {
            return Color.WHITE;

        } else {
            return Color.BLACK;
        }
    }

    // Increases the count of i. Chooses a move for the Bear
    // based on information in the CritterInfo method.
    // Paramaters: 
    //      CritterInfo info - An object containing info on the Bear. 
    // Returns INFECT, HOP, or LEFT based on what is in front of the Bear.
    public Action getMove(CritterInfo info) {
        i++;
    
        info.getFront();

        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;

        } else if (info.getFront() == Neighbor.EMPTY) {
            return Action.HOP;

        } else {
            return Action.LEFT;
        }
    }

    // Returns "\" or "/" based on whether i is divisible by 2.
    public String toString() {
        if (i % 2 == 0) {
            return "\\";

        } else {
            return "/";
        }    
    }
}
