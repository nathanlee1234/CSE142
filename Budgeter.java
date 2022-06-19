// Nathan Lee << Nathan Lee >>
// 1/15/2022
// CSE 142
// TA: Michelle Jose Morris << Michelle Jose Morris >>
// Take-home Assesment #2
// Prompts for all sources of monthly income and monthly or daily expense amounts and
// outputs total monthly income and expenses as well as the total net gain or loss.

import java.util.*;

public class Budgeter {
   
   // The number of days in the month that
   // is used to calculate the daily average.
   public static final int DAYS_IN_MONTH = 31;
   
   public static void main(String[] args) {
      Scanner console = new Scanner(System.in);
      introduction();
      
      double totalIncome = moneyInformation(console, "income");
      double totalExpense = expenses(console);
      
      total(totalIncome, totalExpense);
      netResult(totalIncome, totalExpense);
   }
   
   // Prints the introductory message that explains the program.
   public static void introduction() {
      System.out.println("This program asks for your monthly income and");
      System.out.println("expenses, then tells you your net monthly income.");
      System.out.println();
   }
   
   // Asks the user for the number of categories
   // for a money type and prompts for an answer.
   // Uses a for loop to prompt the user to enter
   // the amount of money for each category
   // and adds up the total amount of money.
   // Returns the total amount of money.
   // Parameters:
   //    Scanner console - takes user input for the number of categories for the money type
   //    String moneyType - the type of money (income or expense) asked about
   public static double moneyInformation(Scanner console, String moneyType ) {
      double totalAmount = 0.0;
      System.out.print("How many categories of " + moneyType + "? ");
      int categories = console.nextInt();
      for (int i = 0; i < categories; i++) {
         System.out.print("    Next " + moneyType + " amount? $");
         totalAmount += console.nextDouble();
      }
      System.out.println();
      return totalAmount;
   }
   
   // Prompts the user to choose to enter monthly or daily expenses.
   // Runs to moneyInformation method to gather information about the user's expenses.
   // Adds the expenses and returns the monthly expense amount.
   // Parameters:
   //    Scanner console - Takes user input for choosing monthly or daily expenses
   public static double expenses(Scanner console) {
      System.out.print("Enter 1) monthly or 2) daily expenses? ");
      int number = console.nextInt();
      double expenseAmount = moneyInformation(console, "expense");
      if (number == 2) {
         expenseAmount *= DAYS_IN_MONTH;
      }
      return expenseAmount;
   }
   
   // Prints the total rounded monthly and daily income and expense of the user.
   // Parameters:
   //    double totalIncome - the total monthly income of the user
   //    double totalExpense - the total monthly expense of the user
   public static void total(double totalIncome, double totalExpense) {
      System.out.println("Total income = $" + round(totalIncome) 
       + " ($" + round(totalIncome / DAYS_IN_MONTH) + "/day)");
      System.out.println("Total expenses = $" + round(totalExpense) 
      + " ($" + round(totalExpense / DAYS_IN_MONTH) + "/day)");
      System.out.println();
   }
   
   // Rounds the provided amount and returns the rounded number.
   // Parameters:
   //    totalAmount - the number to be rounded
   public static double round(double totalAmount) {
      return Math.round(totalAmount * 100.0) / 100.0;
   }
   
   // Takes the difference between the total income and expense to find the net income.
   // Displays the users net income and the category the user falls into.
   // Prints a message based on the user's category.
   // Paramaters:
   //    double totalIncome - the total monthly income of the user.
   //    double totalExpense - the total monthly expense of the user.
   public static void netResult(double totalIncome, double totalExpense) {
      double netIncome = round(totalIncome - totalExpense);
      if (netIncome > 250) {
         System.out.println("You earned $" + netIncome + " more than you spent this month.");
         System.out.println("You're a big saver.");
         System.out.println("You have a very good budget!");
      } else if (netIncome > 0) {
         System.out.println("You earned $" + netIncome + " more than you spent this month.");
         System.out.println("You're a saver.");
         System.out.println("You have a good budget!");
      } else if (netIncome > -250) {
         netIncome = Math.abs(netIncome);
         System.out.println("You spent $" + netIncome + " more than you earned this month.");
         System.out.println("You're a spender.");
         System.out.println("You should optimize your budget!");
      } else {
         netIncome = Math.abs(netIncome);
         System.out.println("You spent $" + netIncome + " more than you earned this month.");
         System.out.println("You're a big spender.");
         System.out.println("You should greatly optimize your budget!");
      }
   }
}
