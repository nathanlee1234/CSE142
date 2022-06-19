// Nathan Lee << Nathan Lee >>
// 3/2/2022
// CSE 142
// TA: Michelle Jose Morris << Michelle Jose Morris >>
// Take-home Assesment #7
// Takes an input file of the names of people with their answers 
// for the Keirsey personality test and outputs the percentage of b 
// values for each personality DIMENSIONS as well as their result.

import java.util.*;
import java.io.*;

public class Personality {
    
    // The number of dimensions in the personality test.
    public static final int DIMENSIONS = 4;

    public static void main(String[] args) throws FileNotFoundException {

        Scanner console = new Scanner(System.in);

        intro();
        Scanner inputFileScan = inputFile(console);
        PrintStream output = outputFile(console);
        
        while (inputFileScan.hasNextLine()) {
            
            String nameLine = inputFileScan.nextLine();
            String answerLine = inputFileScan.nextLine();
            answerLine = answerLine.toLowerCase();

            int[] aAndBCounts = getCounts(answerLine);
            int[] bPercentages = getBPercentages(aAndBCounts);
            String result = getResult(bPercentages);

            output.print(nameLine + ": ");
            output.println(Arrays.toString(bPercentages) + " = " + result);  
        }
    }

    // The introduction to the Keirsey Temperament 
    // Sorter which explains what the program does.
    public static void intro() {
        
        System.out.println("This program processes a file of answers to the");
        System.out.println("Keirsey Temperament Sorter. It converts the");
        System.out.println("various A and B answers for each person into");
        System.out.println("a sequence of B-percentages and then into a");
        System.out.println("four-letter personality type.");
        System.out.println();
    }

    // Prompts the user for an input file name and 
    // converts the contents of the file to a scanner.
    // Paramaters:
    //      Scanner console - the input file name the user inputs.
    // Returns: Scanner inputFile - the scan of the input file.
    public static Scanner inputFile(Scanner console) throws FileNotFoundException {
        
        System.out.print("input file name? ");
        String inputFileName = console.nextLine();
        File file = new File(inputFileName);
        Scanner inputFile = new Scanner(file);
        return inputFile;
    }

    // Prompts the user for an output file name and  
    // converts the output file to a PrintStream to 
    // allow content to be printed to the output.
    // Paramaters:
    //      Scanner console - the output file name the user inputs.
    // Returns: PrintStream output - the PrintStream name for content to be printed to.
    public static PrintStream outputFile(Scanner console) throws FileNotFoundException {
       
        System.out.print("output file name? ");
        String outputFileName = console.nextLine();
        File outputFile = new File(outputFileName);
        PrintStream output = new PrintStream(outputFile);
        return output;
    }

    // Takes in the line of a and b answers for a person
    // and creates an array of length 8 with the first 4
    // Array numbers representing the a counts for each 
    // personality dimension and the last 4 array numbers 
    // representing the b counts for each personality dimension.
    // Paramaters:
    //      String answerLine - the string of a and b answers to the test.
    // Returns: int[] aAndBCounts - the array containing the number  
    // of a and b counts for each dimension of the personality test.
    public static int[] getCounts(String answerLine) {

        int[] aAndBCounts = new int[2 * DIMENSIONS];

        for (int i = 0; i < 70; i++) {
            int index = 0;

            if ((i + 6) % 7 == 0 || (i + 5) % 7 == 0) {
                index = 1;

            } else if ((i + 4) % 7 == 0 || (i + 3) % 7 == 0) {
                index = 2;

            } else if ((i + 2) % 7 == 0 || (i + 1) % 7 == 0) {
                index = 3;
            }

            if (answerLine.charAt(i) == 'a') {
                aAndBCounts[index] = aAndBCounts[index] + 1;

            } else if (answerLine.charAt(i) == 'b') {
                aAndBCounts[index + DIMENSIONS] = aAndBCounts[index + DIMENSIONS] + 1;
            }
        }

        return aAndBCounts;
    }

    // Takes in an array representing the a and b counts 
    // for each dimension of the personality test for a 
    // person and creates an array with the percentage  
    // of b answers foreach dimension of the test.
    // Paramaters: 
    //      int[] aAndBCounts - the array containing 
    //      the a and b counts for each dimension 
    //      of the personality test for a person. 
    // Returns: int[] bPercentages - the array containing
    // the percentage of b values for each dimension.
    public static int[] getBPercentages(int[] aAndBCounts) {
        
        int[] bPercentages = new int[DIMENSIONS];

        for (int i = 0; i < DIMENSIONS; i++) {
            int number = aAndBCounts[i + DIMENSIONS];
            bPercentages[i] = (int) Math.round(100.0 * number / (number + aAndBCounts[i]));
        }

        return bPercentages;
    }

    // Takes in an array representing the percentage  
    // of b values for the dimensions of the 
    // personality test and creates a string  
    // representing the personality result of the test.
    // Paramaters: 
    //      int[] bPercentages - the array containing 
    //      the percentage of b values for each 
    //      dimension in the personlality test
    // Returns: String result - the set of letters
    // representing the result of the personality test.
    public static String getResult(int[] bPercentages) {
        
        String result = "";
        String[] personalities = {"E", "S", "T", "J", "I", "N", "F", "P"};

        for (int i = 0; i < DIMENSIONS; i++) {
            if (bPercentages[i] < 50) {
                result = result + personalities[i];

            } else if (bPercentages[i] > 50) {
                result = result + personalities[i + DIMENSIONS];

            } else {
                result = result + "X";
            }
        }

        return result;
    }
}
