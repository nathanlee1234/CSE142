// Nathan Lee << Nathan Lee >>
// 3/8/2022
// CSE 142
// TA: Michelle Jose Morris << Michelle Jose Morris >>
// Take-home Assesment #8
// Decides the color, move, and message displayed by the Lion for each round.

import java.util.*;
import java.awt.*;

// A class to represent the characteristics of the Lion critter.
public class Lion extends Critter {
    
    private Random rand;
    private int randomNumber;
    private int count;

    // Constructs a new Lion.
    public Lion() {
        count = 0;
        rand = new Random();
        randomNumber = rand.nextInt(3);
    }

    // Chooses a color for the Lion based on a random number generator.
    // Returns the Color RED, GREEN, or BLUE based on the random number.
    public Color getColor() {
            if (randomNumber == 0) {
                return Color.RED;

            } else if (randomNumber == 1) {
                return Color.GREEN;

            } else {
                return Color.BLUE;
            }
    }

    // Increases the count and resets the count and chooses a new
    // random number if the count equals 3. Chooses a move for
    // the lion based on information in the CritterInfo method.
    // Paramaters:
    //      CritterInfo info - An object containing info on the Lion.
    // Returns INFECT, LEFT, or RIGHT based on what is in front of the Lion.
    public Action getMove(CritterInfo info) {
        count++;
        
        if (count == 3) {
            randomNumber = rand.nextInt(3);
            count = 0;
        }

        info.getFront();
        info.getRight();

        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;

        } else if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL) {
            return Action.LEFT;

        } else if (info.getFront() == Neighbor.SAME) {
            return Action.RIGHT;

        } else {
            return Action.HOP;
        }
    }

    // Returns "L".
    public String toString() {
        return "L";
    }
}
