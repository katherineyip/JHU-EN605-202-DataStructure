package edu.jhu.lab1;

import org.junit.jupiter.api.Test;

import static edu.jhu.lab1.Conversion.prefixToPostfix;
import static org.junit.jupiter.api.Assertions.*;

class ConversionTest {

    @Test
    void testCase1() throws Exception {
        Conversion conversionTest = new Conversion();
        String prefix = "*AB";
        Stack stack = conversionTest.stringToStack(prefix);
        String postfixConversion = conversionTest.prefixToPostfix(stack);
        assertEquals(postfixConversion, "AB*");
    }

    @Test
    void testCase2() throws Exception {
        Conversion conversionTest = new Conversion();
        String prefix = "++A*BCD";
        Stack stack = conversionTest.stringToStack(prefix);
        String postfixConversion = conversionTest.prefixToPostfix(stack);
        assertEquals(postfixConversion, "ABC*+D+");
    }

    @Test
    void testCase3() throws Exception {
        Conversion conversionTest = new Conversion();
        String prefix = "$A+BC";
        Stack stack = conversionTest.stringToStack(prefix);
        String postfixConversion = conversionTest.prefixToPostfix(stack);
        assertEquals(postfixConversion, "ABC+$");
    }

    @Test
    void testCase4() throws Exception {
        Conversion conversionTest = new Conversion();
        String prefix = "+-+$+ABCDE$FG";
        Stack stack = conversionTest.stringToStack(prefix);
        String postfixConversion = conversionTest.prefixToPostfix(stack);
        assertEquals(postfixConversion, "AB+C$D+E-FG$+");
    }

    @Test
    void testCase5() throws Exception {
        Conversion conversionTest = new Conversion();
        String prefix = "*-A/BC-/ADE";
        Stack stack = conversionTest.stringToStack(prefix);
        String postfixConversion = conversionTest.prefixToPostfix(stack);
        assertEquals(postfixConversion, "ABC/-AD/E-*");
    }

    @Test
    // Prefix expression: + * A B * C D
    void testCase6() throws Exception {
        Conversion conversionTest = new Conversion();
        Stack stack = new Stack();
        stack.push("+");
        stack.push("*");
        stack.push("A");
        stack.push("B");
        stack.push("*");
        stack.push("C");
        stack.push("D");
        String postfixConversion = conversionTest.prefixToPostfix(stack);
        assertEquals(postfixConversion, "AB*CD*+");
    }

    @Test
    void testCase7() throws Exception {
        Conversion conversionTest = new Conversion();
        String s = " ";
        boolean result = conversionTest.isValidCharacter(s);
        System.out.println(result);
        assertEquals(false, result);
    }

    @Test
    void testCase8() throws Exception {
        Conversion conversionTest = new Conversion();
        String s = "A";
        boolean result = conversionTest.isValidCharacter(s);
        System.out.println(result);
        assertEquals(true, result);
    }

    @Test
    void testCase9() throws Exception {
        Conversion conversionTest = new Conversion();
        String s = "/";
        boolean result = conversionTest.isValidCharacter(s);
        System.out.println(result);
        assertEquals(true, result);
    }

    @Test
    void testCase10() throws Exception {
        Conversion conversionTest = new Conversion();
        String s = "+";
        boolean result = conversionTest.isValidCharacter(s);
        System.out.println(result);
        assertEquals(true, result);
    }

    @Test
    void testCase11() throws Exception {
        Conversion conversionTest = new Conversion();
        String s = "-";
        boolean result = conversionTest.isValidCharacter(s);
        System.out.println(result);
        assertEquals(true, result);
    }

    @Test
    void testCase12() throws Exception {
        Conversion conversionTest = new Conversion();
        String s = "*";
        boolean result = conversionTest.isValidCharacter(s);
        System.out.println(result);
        assertEquals(true, result);
    }

    @Test
    void testCase13() throws Exception {
        Conversion conversionTest = new Conversion();
        String s = "^";
        boolean result = conversionTest.isValidCharacter(s);
        System.out.println(result);
        assertEquals(false, result);
    }
}