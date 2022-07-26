import java.io.*;
import java.util.Scanner;
import java.io.File;

/*
 This class converts a prefix expression to postfix expression using recursion.
*/
public class PrefixToPostfix {

    /*
      This method converts a prefix expression to postfix expression using recursion.
      Input: String
      Output: String (or Error if invalid prefix expression is found)
     */
    public static String prefixToPostfix(String prefixExpression) {
        if (prefixExpression.length() <= 1) {
            return prefixExpression;
        }
        char c = prefixExpression.charAt(0);
        if (isOperator(c)) {
            String operand1 = prefixToPostfix(prefixExpression.substring(1));
            String operand2 = prefixToPostfix(prefixExpression.substring(operand1.length()+1));

            if (operand2 == "" || operand1=="") {
                throw new IllegalArgumentException("> ERROR: Invalid prefix expression. Found missing operand during conversion.");
            }
            return operand1 + operand2 + c;
        } else {
            return c+"";
        }
     }

    // This method determines if a character is an operator.
    private static boolean isOperator(char c) {
        return (c=='+') || c==('-') || c==('*') || c==('/') || c==('$');
    }

    // This method goes through each character in a string to evaluate if the input contains all valid characters
    public static boolean isValidInput(String s) {
        if (s.length() < 3) {
            return false;
        }

        if (s == null) {
            return false;
        }

        Scanner stringScanner = new Scanner(s);
        stringScanner.useDelimiter("");

        while (stringScanner.hasNext()) {
            String nextChar = stringScanner.next();
            if (!isValidCharacter(nextChar)) {  // Check if the character is valid
                return false;
            }
        }
        return true;
    }

    // This method checks if an input is valid
    private static boolean isValidCharacter(String s) {
        return (s.matches("[a-zA-Z\\+\\-*\\-/$]"));
    }

    public static void main(String[] args) {
        long programStartTime = System.nanoTime();

        File file = new File(args[0]);
        try {
            System.out.println("***********************************************************************");
            System.out.println("************************* START OF INPUT FILE *************************");
            System.out.println("***********************************************************************");
            System.out.println("");

            // Read input file
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String currentString = fileScanner.nextLine();
                // Run conversion algorithm
                try {
                    System.out.println("------------------------------------------------------");
                    System.out.println("Prefix Expression: " + currentString);

                    if (isValidInput(currentString)) {
                        String postfixExpression = prefixToPostfix(currentString);
                        if (postfixExpression.length() < currentString.length()) {
                            System.out.println("> ERROR: Invalid prefix expression. Cannot be converted.");
                        } else {
                            System.out.println("> Equivalent postfix Expression: " + postfixExpression);
                        }
                    } else {
                        System.out.println("> ERROR: Invalid character found in prefix expression.");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

            System.out.println("");
            System.out.println("***********************************************************************");
            System.out.println("************************** END OF INPUT FILE **************************");
            System.out.println("***********************************************************************");
            System.out.println("");
            fileScanner.close();

            long programEndTime = System.nanoTime();
            long totalRunTime = programEndTime - programStartTime;
            System.out.println("Total run time of the program is: " + totalRunTime + " nanoseconds.");
        } catch (FileNotFoundException error) {
            error.printStackTrace();
        }
    }
}