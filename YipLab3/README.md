# Lab 3
* Author: Katherine Yip
  
## Lab 3 Set up
* Language: Java
* SDK: openjdk-17
* IDE: IntelliJ IDEA Ultimate

### Compile class
To compile the main class for package in the terminal, execute the follow command in the /scr folder:

```bash
javac src/*.java
```

### Running Lab 1
To run the code in the terminal, execute the follow command in the /scr folder:

```commandline
usage: java src/HuffmanTree.java resources/FreqTable_unix.txt Decode resources/Encoded.txt

arguments:
  lab3/resources/FreqTable_unix.txt     Path from content root
  Encode         Choose when encoding the following file
  Decode         Choose when decoding the following file
  lab3/resources/input/Encoded.txt     Path from content root
  lab3/resources/input/ClearText.txt     Path from content root
```

### Lab 3 Layout
* [lab3/](.): The parent or "root" folder containing all of these files. Can technically have any name.
    * [README.md](README.md):
      The guide you're reading. All software should come with a readme!
    * [src](src):
        * [lab3] (lab3)
            * [`HuffmanTree.java`](src/HuffmanTree.java)
              This file is the entrypoint to the program when ran as a program. Contains main().
            * [`MinHeap.java`](src/MinHeap.java)
            * [`Node.java`](src/Node.java)
    * [resources]:
        * Contains output file