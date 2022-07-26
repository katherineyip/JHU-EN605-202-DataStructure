package src;

/*
 This class heapifies an array to a Min Heap structure, and allows for insertion and removal.
*/
public class MinHeap {
    Node[] heap;
    int lastNodeIndex;

    // Class constructor for the MinHeap class
    public MinHeap(int size) {
        heap = new Node[size];
        heap[0] = new Node();
        lastNodeIndex = 0;
    }

    public void printHeap() {
        System.out.println("---------Printing Heap----------");
        for (int i = 1; i <= lastNodeIndex; i++) {
            System.out.println(heap[i].data + ": " + heap[i].frequency);
        }
        System.out.println("------Finish Printing Heap------");
    }

    // This method inserts a new node to heap and heapifies it to maintain a valid minHeap
    public void insert(Node newNode) {
        if (lastNodeIndex <= heap.length) {
            lastNodeIndex++;
            //System.out.println("last Node: " + lastNodeIndex);
            heap[lastNodeIndex] = newNode;
        } else {
            System.out.println("Array is full");
            //TODO: Resize heap
        }
        heapifyUp(lastNodeIndex);
        //System.out.println("Successfully inserted a new node and heapified up");
        //printHeap();
    }

    // This method removes the node with the lowest frequency and heapifies it to maintain a valid minHeap
    public Node pop() {
        Node rootNode;

        if (lastNodeIndex <= 0) {
            rootNode = null;
            System.out.println("No items available to pop");
        } else {
            rootNode = heap[1];
            heap[1] = heap[lastNodeIndex]; // replace last node with root
            heap[lastNodeIndex] = null;
            lastNodeIndex--;
            heapifyDown(1);
        }
        return rootNode;
    }

    // This method heapifies down a subtree rooted with node i in the min heap
    private void heapifyDown(int i) {
        int leftIndex = 2 * i;
        int rightIndex = 2 * i + 1;

        // TODO: If both left and right are smaller than current index -- need to pick the smallest one

        // Only swap if the child has a strictly smaller value
        if (leftIndex <= lastNodeIndex && heap[leftIndex].isSmallerThan(heap[i])) {
            Node temp = heap[i];
            heap[i] = heap[leftIndex]; // swap i and left
            heap[leftIndex] = temp;
            heapifyDown(leftIndex);
        }

        if (rightIndex <= lastNodeIndex && heap[rightIndex].isSmallerThan(heap[i])) {
            Node temp = heap[i];
            heap[i] = heap[rightIndex]; // swap i and right
            heap[rightIndex] = temp;
            heapifyDown(rightIndex);
        }
    }

    // This method heapifies up a subtree rooted with node i in in the min heap
    private void heapifyUp(int i) {
        int parentIndex = i/2;

        if (i > 1 && heap[i].isSmallerThan(heap[parentIndex])) {
            Node temp = heap[i];
            heap[i] = heap[parentIndex]; // swap i and left
            heap[parentIndex] = temp;
            heapifyUp(parentIndex);
        }
    }
}