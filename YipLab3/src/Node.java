package src;

/*
 This class creates a Node for storing a string and its corresponding frequency
*/
public class Node {
    String data;
    int frequency;
    Node leftChild;
    Node rightChild;
    String huffmanCode;

    // Class constructor for the HuffmanNode class
    public Node() {
    }

    public Node(String s, int freq) {
        data = s;
        frequency = freq;
        leftChild = null;
        rightChild = null;
        huffmanCode = "";
    }

    // This method compares contents of two nodes with the same frequency. It follows the following tie breaking logic:
    // 1. Compare the frequency values. Lower frequency wins
    // 2. Compare the complexity of the strings. Less complex string (i.e. string with shorter length) win
    // 3. Compare the first letter of the string. Alphabets that are closer to 'A' win
    public boolean isSmallerThan(Node b) {
        if (this.frequency < b.frequency) {
            return true;
        }

        if (b.frequency < this.frequency) {
            return false;
        }

        if (this.data.length() < b.data.length()) {
            return true;
        }

        if (b.data.length() < this.data.length()) {
            return false;
        }

        // If the string length of both nodes are the same
        if (this.data.compareTo(b.data) < 0) {
            return true;
        }
        return false; // a and b cannot be the same
    }
}