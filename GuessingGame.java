// Nathan Lee << Nathan Lee >>
// 2/8/2022
// CSE 142
// TA: Michelle Jose Morris << Michelle Jose Morris >>
// Take-home Assesment #5
// Prompts the user to guess a number, asks if they want
// to play again and prints games statistics at the end.

import java.util.*;

public class GuessingGame {
    
    // The max number that can be guessed in the guessing game.
    public static final int MAX_VALUE = 100;
    
    public static void main(String[] args) {
        int guesses = 1;
        int totalGames = 1;
        Random rand = new Random();
        Scanner console = new Scanner(System.in);
        haiku();
        int numGuesses = game(console, rand, guesses);
        int bestGuess = numGuesses;
        while (playOrEnd(console) == true) {
            totalGames++;
            guesses = game(console, rand, guesses);
            numGuesses = guesses + numGuesses;
            if (guesses < bestGuess) {
                bestGuess = guesses;
            }
        } 
        results(numGuesses, totalGames, bestGuess);      
    }
    
    // Prints the introductory haiku before the guessing game.
    public static void haiku() {
        System.out.println("This is a fun game");
        System.out.println("You try and guess a number");
        System.out.println("You will be happy");
        System.out.println();
    }

    // Prompts the user to enter a number between 1 and the max value.
    // Uses an if else statement inside a while loop to inform the user
    // whether the value they guess is higher or lower than the chosen value.
    // Repeatedly prompts the user for values until they guess the right number.
    // Parameters: 
    //      Scanner console - the number guess that the user inputs.
    //      Random rand - the random number the program chooses.
    //      int i - the number of guesses taken in the game.
    //      Returns: int i - the number of guesses taken in the game.
    public static int game(Scanner console, Random rand, int guesses) {
        System.out.println("I'm thinking of a number between 1 and " + MAX_VALUE + "...");
        int randomNumber = rand.nextInt(MAX_VALUE) + 1;
        System.out.print("Your guess? ");
        int guess = console.nextInt();
        while (guess != randomNumber) {
            if (guess < randomNumber) {
                System.out.println("It's higher.");
            }
            else {
                System.out.println("It's lower.");
            }
            System.out.print("Your guess? ");
            guess = console.nextInt();
            guesses = guesses + 1;
        }
        if (guesses > 1) {
            System.out.println("You got it right in " + guesses + " guesses!");
        } else {
            System.out.println("You got it right in " + guesses + " guess!");
        }
        return guesses;      
    }

    // Asks the user if they want to play the game again.
    // Prompts the user to input an answer and returns wether
    // the first letter of the answer is a y.
    // Parameter: 
    //      Scanner console - the answer the user inputs.
    // Returns: (answer.toLowerCase().charAt(0) == 'y') - 
    // whether or not the first letter of the answer is true.
    public static boolean playOrEnd(Scanner console) {
        System.out.print("Do you want to play again? ");
        String answer = console.next();
        System.out.println();
        return (answer.toLowerCase().charAt(0) == 'y');
    }

    // Rounds the number of guesses per game to one decimal place.
    // Prints the overall results including the total games played, 
    // total guesses, average guesses per game, and the best game.
    // Parameters:
    //      int numGuesses - the total number of guesses guessed.
    //      int j - the total number of games played.
    //      int bestGuess - the lowest number of guesses guessed in a game.
    public static void results(int numGuesses, int totalGames, int bestGuess) {
        double guessesPerGame = Math.round(10.0 * numGuesses / totalGames) / 10.0;
        System.out.println("Overall results:");
        System.out.println("Total games   = " + totalGames);
        System.out.println("Total guesses = " + numGuesses);
        System.out.println("Guesses/game  = " + guessesPerGame);
        System.out.println("Best game     = " + bestGuess);
    }
}
