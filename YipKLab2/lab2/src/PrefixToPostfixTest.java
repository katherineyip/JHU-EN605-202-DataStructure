import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrefixToPostfixTest {

    @Test
    void testCase1() {
        PrefixToPostfix prefixToPostfixTest = new PrefixToPostfix();
        String prefix = "*AB";
        String postfixConversion = prefixToPostfixTest.prefixToPostfix(prefix);
        assertEquals(postfixConversion, "AB*");
    }

    @Test
    void testCase2() throws Exception {
        PrefixToPostfix prefixToPostfixTest = new PrefixToPostfix();
        String prefix = "++A*BCD";
        String postfixConversion = prefixToPostfixTest.prefixToPostfix(prefix);
        assertEquals(postfixConversion, "ABC*+D+");
    }

    @Test
    void testCase3() throws Exception {
        PrefixToPostfix prefixToPostfixTest = new PrefixToPostfix();
        String prefix = "$A+BC";
        String postfixConversion = prefixToPostfixTest.prefixToPostfix(prefix);
        assertEquals(postfixConversion, "ABC+$");
    }

    @Test
    void testCase4() throws Exception {
        PrefixToPostfix prefixToPostfixTest = new PrefixToPostfix();
        String prefix = "+-+$+ABCDE$FG";
        String postfixConversion = prefixToPostfixTest.prefixToPostfix(prefix);
        assertEquals(postfixConversion, "AB+C$D+E-FG$+");
    }

    @Test
    void testCase5() throws Exception {
        PrefixToPostfix prefixToPostfixTest = new PrefixToPostfix();
        String prefix = "*-A/BC-/ADE";
        String postfixConversion = prefixToPostfixTest.prefixToPostfix(prefix);
        assertEquals(postfixConversion, "ABC/-AD/E-*");
    }

    @Test
    void testCase7() throws Exception {
        PrefixToPostfix prefixToPostfixTest = new PrefixToPostfix();
        String s = " ";
        boolean result = prefixToPostfixTest.isValidInput(s);
        System.out.println(result);
        assertEquals(false, result);
    }

    @Test
    void testCase8() throws Exception {
        PrefixToPostfix prefixToPostfixTest = new PrefixToPostfix();
        String s = "AB+";
        String postfixConversion = prefixToPostfixTest.prefixToPostfix(s);
        System.out.println(postfixConversion);
    }
}