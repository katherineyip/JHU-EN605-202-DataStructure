package src;
import java.io.*;
import java.util.Scanner;
import java.io.File;

/*
 This class encodes or decodes input with a frequency file.
*/
public class HuffmanTree {
    static final int DEFAULT_HEAP_SIZE = 30;
    static Node root;

    HuffmanTree() { // Constructor
        root = null;
    }

    // This method combines two strings and sort each character by ascending order (alphabets closer to A will be toward the front)
    private static String sortString(String s1, String s2) {
        String newString = s1+s2;
        char[] charArray = newString.toCharArray();

        for(int i=0;i<charArray.length;i++){
            for(int j=i+1;j<charArray.length;j++){
                if (charArray[j] < charArray[i]) {
                    char temp = charArray[i];
                    charArray[i]=charArray[j];
                    charArray[j]=temp;
                }
            }
        }
        String newOrderedString = String.valueOf(charArray);
        return newOrderedString;
    }

    // This method builds the huffman tree from a min heap
    public static void buildHuffmanTree(MinHeap heap, HuffmanTree tree) {
        while (heap.lastNodeIndex > 1) {
            Node a = heap.pop();
            Node b = heap.pop();

            int newFrequency = a.frequency + b.frequency;
            String newOrderedString = sortString(a.data, b.data); // Get a new sorted combined string
            //System.out.println("a.data is: " + a.data + ". b.data is: " + b.data + ". newOrderedString is: " + newOrderedString);

            Node newCombinedNode = new Node(newOrderedString, newFrequency);
            heap.insert(newCombinedNode);

            System.out.println("a.data is: " + a.data + ". b.data is: " + b.data);
            System.out.println("a.freq is: " + a.frequency + ". b.freq is: " + b.frequency);
            if (a.isSmallerThan(b)) {
                newCombinedNode.leftChild = a;
                newCombinedNode.rightChild = b;
            } else {
                newCombinedNode.leftChild = b;
                newCombinedNode.rightChild = a;
            }
            System.out.println("newCombinedNode.leftChild " + newCombinedNode.leftChild.data + ". newCombinedNode.rightChild: " + newCombinedNode.rightChild.data);
            //Node currentRoot = tree.root;
            tree.root = newCombinedNode; //TODO: is this the right thing? Does it replace the tree root?
        }
    }

    // Print HuffMan Tree nodes in preorder
    private static void printHuffManTree(Node node) {
        if (node == null) return;
        System.out.println(node.data + ": " + node.frequency);
        printHuffManTree(node.leftChild); // recur on left subtree
        printHuffManTree(node.rightChild); // recur on right subtree
    }

    // This method recursively print the huffman code through the tree traversal.
    public static void generateHuffmanCode(Node root, String s) {
        if (root == null) return;

        // if the left and right child are null, this is a leaf node and print the code path
        if (root.leftChild == null && root.rightChild == null) {
            root.huffmanCode = s;
        }

        generateHuffmanCode(root.leftChild, s + "0"); // Add "0" to the code path if we go to left
        generateHuffmanCode(root.rightChild, s + "1"); // Add"1" to the code path if we go to right
    }

    // This method print the huffman code for all characters
    public static void printHuffmanCode(Node node) {
        // if the left and right child are null, this is a leaf node and print the code path
        if (node.leftChild == null && node.rightChild == null) {
            System.out.println(node.data + ": " + node.huffmanCode);
            return;
        }

        printHuffmanCode(node.leftChild);
        printHuffmanCode(node.rightChild);
    }

    public static String getHuffmanCode(Node node, String s) {
        if (node.data.equals(s)) {
            return node.huffmanCode;
        }

        if (node.leftChild != null && node.leftChild.data.contains(s)) {
            return getHuffmanCode(node.leftChild, s);
        }

        if (node.rightChild != null && node.rightChild.data.contains(s)) {
            return getHuffmanCode(node.rightChild, s);
        }

        return "";
    }

    public static void main(String[] args) {
        long programStartTime = System.nanoTime();
        MinHeap minHeap;
        HuffmanTree tree = new HuffmanTree();

        File freqTableFile = new File(args[0]);
        String method = args[1];
        File targetFile = new File(args[2]);
        try {
            System.out.println("***********************************************************************");
            System.out.println("********************** START OF FREQ TABLE FILE ***********************");
            System.out.println("***********************************************************************");
            System.out.println("");

            // Read freqTable input file and builds Min Heap
            minHeap = new MinHeap(DEFAULT_HEAP_SIZE);

            Scanner freqTableFileScanner = new Scanner(freqTableFile);
            while (freqTableFileScanner.hasNextLine()) {
                String currentLine = freqTableFileScanner.nextLine();
                try {
                    //System.out.println("------------------------------------------------------");
                    //System.out.println("Current Line: " + currentLine);
                    Scanner stringScanner = new Scanner(currentLine);
                    stringScanner.useDelimiter(" - ");
                    while (stringScanner.hasNext()) {
                        String alphabet = stringScanner.next();
                        int freq = Integer.parseInt(stringScanner.next());
                        Node newNode = new Node(alphabet, freq);
                        minHeap.insert(newNode);
                    }
                    stringScanner.close();

                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
            minHeap.printHeap();

            System.out.println("");
            System.out.println("***********************************************************************");
            System.out.println("*********************** END OF FREQ TABLE FILE ************************");
            System.out.println("***********************************************************************");
            System.out.println("");
            freqTableFileScanner.close();

            System.out.println("***********************************************************************");
            System.out.println("***************** PRINTING HUFFMAN TREE IN PREORDER: ******************");
            System.out.println("***********************************************************************");
            System.out.println("");
            buildHuffmanTree(minHeap, tree);
            printHuffManTree(root);
            System.out.println("");
            //minHeap.printHeap();

            System.out.println("***********************************************************************");
            System.out.println("************************ PRINTING HUFFMAN CODE: ***********************");
            System.out.println("***********************************************************************");
            System.out.println("");
            generateHuffmanCode(tree.root, "");
            printHuffmanCode(tree.root);
            System.out.println("");
            
            // Encode
            if (method.equals("Encode")) {
                System.out.println("***********************************************************************");
                System.out.println("*********************** START OF ENCODED FILE *************************");
                System.out.println("***********************************************************************");
                System.out.println("");
            }

            // Decode
            if (method.equals("Decode")) {
                System.out.println("***********************************************************************");
                System.out.println("*********************** START OF DECODED FILE *************************");
                System.out.println("***********************************************************************");
                System.out.println("");
            }

            // Read target encoding / decoding file
            Scanner targetFileScanner = new Scanner(targetFile);
            while (targetFileScanner.hasNextLine()) {
                String result = "";
                Node currentNode = tree.root;
                String currentLine = targetFileScanner.nextLine();
                try {
                    System.out.println("------------------------------------------------------");
                    System.out.println("Text from File: " + currentLine);
                    Scanner stringScanner = new Scanner(currentLine);
                    stringScanner.useDelimiter("");

                    // Start decoding
                    if (method.equals("Decode")) {
                        while (stringScanner.hasNext()) {
                            int c = stringScanner.nextInt();
                            if (c==0) {
                                currentNode = currentNode.leftChild;
                            }
                            if (c==1){
                                currentNode = currentNode.rightChild;
                            }
                            if (currentNode.leftChild == null &&  currentNode.rightChild == null) { // reached leaf node
                                result += currentNode.data;
                                currentNode = tree.root;
                            }
                        }
                        System.out.println(">> Decoded result: " + result);
                    }

                    // Start encoding
                    if (method.equals("Encode")) {
                        while (stringScanner.hasNext()) {
                            String s = stringScanner.next().toUpperCase();
                            result += getHuffmanCode(tree.root, s);
                        }
                        System.out.println(">> Encoded result: " + result);
                    }

                    stringScanner.close();

                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }

            }
            targetFileScanner.close();

            long programEndTime = System.nanoTime();
            long totalRunTime = programEndTime - programStartTime;
            System.out.println("Total run time of the program is: " + totalRunTime + " nanoseconds.");
        } catch (FileNotFoundException error) {
            error.printStackTrace();
        }
    }
}
