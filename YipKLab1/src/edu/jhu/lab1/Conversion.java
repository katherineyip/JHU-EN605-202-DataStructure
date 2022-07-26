package edu.jhu.lab1;
import java.io.*;
import java.util.Scanner;
import java.io.File;

public class Conversion {
    /*
     This method converts a prefix expression to post expression utilizing a custom stack.
     */
    public static String prefixToPostfix(Stack reverseInputStack) throws Stack.EmptyStackException {
        Stack stack = new Stack();

        while (!reverseInputStack.isEmpty()) {
            String currentChar = reverseInputStack.pop();
            if (isOperator(currentChar)) {
                String operand1 = stack.pop();
                String operand2 = stack.pop();
                String newExpression = operand1 + operand2 + currentChar;
                stack.push(newExpression);
            } else {
                stack.push(currentChar);
            }
        }

        String postfixExpression = stack.pop();
        return postfixExpression;
    }

    /*
     This method determines if a string is an operator.
     */
    public static boolean isOperator(String s) {
        return (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("$"));
    }

    public static boolean isValidCharacter(String s) {
        return (s.matches("[a-zA-Z\\+\\-*\\-/$]"));
    }

    /*
     This method puts each character in a string, from front to back, into a stack
     */
    public static Stack stringToStack(String s) {
        Stack reverseInputStack = new Stack();
        Scanner stringScanner = new Scanner(s);
        stringScanner.useDelimiter("");
        while (stringScanner.hasNext()) {
            String nextChar = stringScanner.next();
            if (!isValidCharacter(nextChar)) {  // Check if the character is valid
                throw new IllegalArgumentException();
            }
            reverseInputStack.push(nextChar);
        }

        return reverseInputStack;
    }

    public static void main(String[] args) {
        long programStartTime = System.nanoTime();

        File file = new File(args[0]);
        try {
            System.out.println("***********************************************************************");
            System.out.println("************************* START OF INPUT FILE *************************");
            System.out.println("***********************************************************************");
            System.out.println("");

            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String currentString = fileScanner.nextLine();
                System.out.println("------------------------------------------------------");
                System.out.println("Prefix Expression: " + currentString);

                try {
                    Stack reverseInputStack = stringToStack(currentString);
                    try {
                        String postfixExpression = prefixToPostfix(reverseInputStack);
                        System.out.println("> Equivalent postfix Expression: " + postfixExpression);
                    } catch (Stack.EmptyStackException error) {
                        System.out.println("> ERROR: Invalid Prefix Expression");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("> ERROR: Invalid character found in prefix expression.");
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