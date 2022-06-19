// Nathan Lee << Nathan Lee >>
// 2/23/2022
// CSE 142
// TA: Michelle Jose Morris << Michelle Jose Morris >>
// Take-home Assesment #6
// Plays the Mad Libs game in which a user is prompted the enter different types
// of words after which the program then outputs a story using the inputted words.

import java.io.*;
import java.util.*;

public class MadLibs {
   public static void main(String[] args) throws FileNotFoundException {
      
      Scanner console = new Scanner(System.in);
      
      introduction();
      String decision = choice(console);

      while (!decision.equals("Q")) {
         if (decision.equals("C")) {
            create(console);
         } else if (decision.equals("V")) {
            view(console);
         }
         decision = choice(console);
      }
      
      System.out.println();
   }
   
   // Prints the introductory message for the Mad Libs game.
   public static void introduction() {
      
      System.out.println("Welcome to the game of Mad Libs.");
      System.out.println("I will ask you to provide various words");
      System.out.println("and phrases to fill in a story.");
      System.out.println("The result will be written to an output file.");
      System.out.println();
   }
   
   // Prompts the user to enter c,v, or q to create or view a madlib or 
   // quit the program. Returns the resulting letter written by the user.
   // Paramaters:
   //      Scanner console - the letter indicator written by the user.
   // Returns decision - the choice chosen by the user.
   public static String choice(Scanner console) throws FileNotFoundException {
      
      System.out.print("(C)reate mad-lib, (V)iew mad-lib, (Q)uit? ");
      String decision = console.nextLine().toUpperCase();

      return decision;
   }
   
   
   // Prompts the user to enter an input file name.
   // Searches for an input file with the given name.
   // Continually prompts for an input file name input
   // file name if input file name is not found.
   // Prompts the user for an output file name.
   // Scans the input text and prompts the user to enter
   // the type of word in between each pair of "<" and ">".
   // Sends the input text with the typed word in place of
   // each text starting and ending with "<" and ">" to the
   // output file and states the Mad Lib has been created.
   // Paramaters:
   //      Scanner console - the file name or Mad Libs word entered by the user.
   //      char decision - the answer given by the user to display their chosen pathway.
   public static void create(Scanner console) throws FileNotFoundException {
      
      File file = inputFile(console);
      Scanner inputFile = new Scanner(file);
      
      System.out.print("Output file name: ");
      String outputFileName = console.nextLine();
      File outputFile = new File(outputFileName);
      PrintStream output = new PrintStream(outputFile);
      
      System.out.println();
      
      while (inputFile.hasNextLine()) {
         String line = inputFile.nextLine();
         Scanner lineScan = new Scanner(line);
         
         while (lineScan.hasNext()) {
            String word = lineScan.next();
            
            if (word.startsWith("<") && word.endsWith(">")) {
               String aOrAn;
               
               word = word.substring(1, word.length() - 1) + ":";
               word = word.replace('-', ' ');
               char firstLetter = Character.toLowerCase(word.charAt(0));
               
               if (firstLetter == 'a' || firstLetter == 'e' || firstLetter == 'i'
               || firstLetter == 'o' || firstLetter == 'u') {
                  aOrAn = "an ";
                  
               } else {
                  aOrAn = "a ";
               }
               
               System.out.print("Please type " + aOrAn + word + " ");
               word = console.nextLine();
               
               output.print(word + " ");
               
            } else {
               output.print(word + " ");
            }
            
         }
         output.println();
      }
      
      System.out.println("Your mad-lib has been created!");
      System.out.println();
   }
   
   // Prompts the user to enter an input file name.
   // Searches for an input file with the given name.
   // Continually prompts for an input file name input
   // file name if input file name is not found.
   // Prints the contents of the file.
   // Paramaters:
   //      Scanner console - the input file name entered by the user.
   public static void view(Scanner console) throws FileNotFoundException {
      
      File file = inputFile(console);
      
      System.out.println();
      
      Scanner output = new Scanner(file);
      
      while (output.hasNextLine()) {
         String line = output.nextLine();
         System.out.println(line);
      }
      
      System.out.println();
   }
   
   // Prompts the user for an input file name and creates a file
   // with that name. States the file does not exist and prompts the
   // user for another file name if the file entered does not exist.
   // Paramaters:
   //      Scanner console - the input file name entered by the user.
   // Returns file - the input file created.
   public static File inputFile(Scanner console) throws FileNotFoundException{
      
      System.out.print("Input file name: ");
      String inputFileName = console.nextLine();
      File file = new File(inputFileName);
      
      while(!file.exists()) {
         System.out.print("File not found. Try again: ");
         inputFileName = console.nextLine();
         file = new File(inputFileName);
      }
      
      return file;
   }
}
