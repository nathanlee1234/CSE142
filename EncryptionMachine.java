// Nathan Lee << Nathan Lee >>
// 1/15/2022
// CSE 142
// TA: Michelle Jose Morris << Michelle Jose Morris >>
// Take-home Assesment #2
// Takes in a message from the user and outputs an encrypted version of that message.

import java.util.*;

public class EncryptionMachine {
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    public static final int SHIFT = 3;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        introduction();
        encryption(console);
        wordEncryption(console);
    }

    // Prints the introducory message for the encryption machine.
    public static void introduction() {
        System.out.println("Welcome to the CSE142 Encryption Machine!");
        System.out.println("The program lets you encrypt a message");
        System.out.println("with a key so your recipient can decrypt.");
        System.out.println();
        System.out.println("Encrypted messages use a shared keyword to decrypt.");
    }

    // Prompts the user to enter a word.
    // Stores the word as a string name.
    // Encrypts the word and displays what 
    // the input word was encrypted to.
    // Paramater:
    //      Scanner console - the word typed by the user
    public static void encryption(Scanner console) {
        System.out.print("  Enter key: ");
        String word = console.next();
        System.out.print("    \"" + word + "\" has been encrypted to: ");
        encryptGlossery(word);
        System.out.println();
        System.out.println();
    }

    // Takes a word and produces a new word with each letter shifted 
    // the value of the shift constant.
    // Paramater:
    //      String word - the word to be encrypted
    public static void encryptGlossery (String word) {
        for (int i = 0; i <= word.length() - 1 ; i++) {
            int index = ALPHABET.indexOf(word.charAt(i))+ SHIFT;
            System.out.print(ALPHABET.charAt(index % ALPHABET.length()));
        }
    }

    // Prompts the user to enter the number of words
    // to be encrypted in the pre selected message.
    // Stores the number as an integer.
    // Prompts the user for a word and encrypts the entered word.
    // Displays the word entered as well as the encrypted version 
    // of the word.
    // Prints a concluding message.
    public static void wordEncryption(Scanner console) {
        System.out.print("How many words are in your message? ");
        int wordNumber = console.nextInt();
        for (int i = 0; i < wordNumber; i++) {
            System.out.print("  Next word: ");
            String wordi = console.next();
            System.out.print("    \"" + wordi + "\" has been encrypted to: ");
            encryptGlossery(wordi);
            System.out.println();
        }
        System.out.println();
        System.out.println("Message fully encrypted. Happy secret messaging!");
    }
}
