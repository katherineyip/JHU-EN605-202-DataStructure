# Lab 2
* Author: Katherine Yip

## Lab 2 Set up
* Language: Java
* SDK: openjdk-17
* IDE: IntelliJ IDEA Ultimate

### Compile class
To compile the main class for package in the terminal, execute the follow command in the /scr folder:

```bash
javac ./src/PrefixToPostfix.java
```

### Running Lab 1
To run the code in the terminal, execute the follow command in the /scr folder:

```commandline
usage: java lab2/src/PrefixToPostfix.java lab2/resources/input/RequiredInput.txt

arguments:
  lab2/resources/input/RequiredInput.txt     Path from content root
  lab2/resources/input/AdditionalTestInput.txt     Path from content root
```

### Lab 2 Layout
* [lab2/](.): The parent or "root" folder containing all of these files. Can technically have any name.
    * [README.md](README.md):
      The guide you're reading. All software should come with a readme!
    * [src](src):
        * [lab2] (lab2)
            * [`PrefixToPostfix.java`](src/PrefixToPostfix.java)
              This file is the entrypoint to the program when ran as a program. Contains main().
    * [resources]:
        * Contains output file
    * [Test]:
        * Contains test cases