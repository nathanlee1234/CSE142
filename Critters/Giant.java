// Nathan Lee << Nathan Lee >>
// 3/8/2022
// CSE 142
// TA: Michelle Jose Morris << Michelle Jose Morris >>
// Take-home Assesment #8
// Decides the color, move, and message displayed by the Giant for each round.

import java.util.*;
import java.awt.*;

// A class to represent the characteristics of the Giant critter.
public class Giant extends Critter {
    
    private int count;

    // Constructs a new Giant.
    public Giant() {
        count = 0;
    }

    // Returns the Color GRAY.
    public Color getColor() {
        return Color.GRAY;
    }

    // Increases the count. Chooses a move for the Giant
    // based on information in the CritterInfo method.
    // Paramaters:
    //      CritterInfo info - An object containing info on the Giant.
    // Returns INFECT, HOP, or RIGHT based on what is in front of the Giant.
    public Action getMove(CritterInfo info) {
        count++;
        
        info.getFront();
        
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;

        } else if (info.getFront() == Neighbor.EMPTY) {
            return Action.HOP;

        } else {
            return Action.RIGHT;
        }
    }

    // Returns "fee", "fie", "foe", or "fum" based on the 
    // value of the remainder of the count divided by 24. 
    public String toString() {
        if (count % 24 < 6) { 
            return "fee";

        } else if (count % 24 < 12) {
            return "fie";

        } else if (count % 24 < 18) {
            return "foe";

        } else {
            return "fum";
        } 
    }
}
