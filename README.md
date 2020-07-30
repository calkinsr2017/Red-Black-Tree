## Red-Black Binary Search Tree

In my Advanced Data structures course (CMSC420), we learned extensively about Red-Black trees but never implemented them. In this project, I will design and build a RBbst from scratch. I plan on only using my course notes to create a left-leaning version. Eventually I hope to do research and implement a traditional RBbst. 

My goals for this project are: 
- learn how to design and create a Java project from scratch
- Apply the theory I learned in class into a working model
- improve my overall Java skills

## Project Structure

I decided to use a Java Maven template for this project. The package main.java.com.calkins.rbbst contains the main project files.
- `Tree.java` is the public interface
- `RBbst.java` Contains the code for the Left-Leaning Red-Black binary search tree

My tests are contained under test.java.com.calkins.rbbst, I implemented basic tests to check that the Red-Black specifics of the tree are in working order. I chose not to crowd AppTest.Java with many tests as to highlight just the Red-Black functionality is working. 


## Class Details

I created the interface `Tree.java` to be a starting template for any future tree implementation as well as to take advantage of 
polymorphism. `RBbst.java` implements `Tree.java` and contains numerous other private helper functions. 

