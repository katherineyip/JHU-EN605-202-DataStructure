# Lab 1
* Author: Katherine Yip

## Lab 1 Set up
* Language: Java 
* SDK: openjdk-17
* IDE: IntelliJ IDEA Ultimate

### Compile class
To compile the main class for package in the terminal, execute the follow command in the /scr folder:

```bash
javac ./edu/jhu/lab1/Conversion.java
```

### Running Lab 1
To run the code in the terminal, execute the follow command in the /scr folder:

```commandline
usage: java edu/jhu/lab1/Conversion edu/jhu/lab1/RequiredInput.txt

arguments:
  edu/jhu/lab1/RequiredInput.txt     Path from content root
```

### Lab 1 Layout
* [lab1/](.): The parent or "root" folder containing all of these files. Can technically have any name.
    * [README.md](README.md):
      The guide you're reading. All software should come with a readme!
    * [src](src):
        * [edu.jhu.lab1] (edu/jhu/lab1)
            * [`Conversion.java`](src/edu/jhu/lab1/Conversion.java)
              This file is the entrypoint to the program when ran as a program. Contains main().
            * [`Stack.java`](src/edu/jhu/lab1/Stack.java)
              This file defines a custom Stack class.
    * [resources]:
        * Contains output file
    * [Test]:
        * Contains test cases