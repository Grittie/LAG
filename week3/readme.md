# Week 3 report
### Lars Arie Grit, IT201
___

## Assignment 3.1 edu.princeton.cs.algs4.BST tree and stack versus heap space
### Assignment steps:
- Problem: how many items can you put in a BST tree when you limit the JVM heap space to 200MB?
Set the heap space VM option by adding it to the IDE run configuration of your project:
- Then run a small program that creates a BST and fills it with lots of items, like Strings or numbers "1", "2".. etc. and print the count until it hits an error. The strange thing is that filling a BST<Integer, Integer> with keys 0,1,2,3 integer numbers will generate a Stackoverflow error while using BST<String, Integer> and filling it with "0", "1", "2" strings (using ""+number or String.valueOf(number)) generates an OutOfMemory error (if you set the Xmx VM option as above).
- Can you tell why a Stackoverflow occurs with Integers and a heap memory overflow when String is used as a key?
Describe the code, results and findings. Why is the max tree height so different in the two cases?
Can you store twice as many items when you double the heap space?

<br>

### Setup process
I have created a file called HeapSpace using the example code that was given, I have made the required edits to test out the theories given in this assignment.

### Running the files
Simply run HeapSpace.java

```bash
javac HeapSpace.java
java HeapSpace
```

### Questions:
#### How many items can you put in a BST tree when you limit the JVM heap space to 200MB?
5.6 million nodes

#### Can you tell why a Stackoverflow occurs with Integers and a heap memory overflow when String is used as a key?
**StackOverflowError with Integer Keys:**
If you uncomment the line //BST<Integer, Integer> mybst = new BST<>(); and use mybst.put(num, num) instead of mybst.put(("test" + num), num), you will encounter a StackOverflowError. This occurs due to the recursive nature of the binary search tree operations, specifically in the recursive methods like put.

Each insertion causes a recursive call to the put method, and with a large number of integers, the recursion depth increases, eventually leading to a stack overflow. The stack is limited in size, and when it's exhausted due to deep recursion, a StackOverflowError is thrown.

**OutOfMemoryError with String Keys:**
With the original code using mybst.put(("test" + num), num), you will encounter an OutOfMemoryError. This error occurs because the program continuously adds new nodes to the binary search tree with string keys, leading to a rapid increase in memory consumption.

Strings, being reference types, have a higher memory overhead compared to primitive types like integers. Additionally, each node in the BST requires memory for the key, value, and internal pointers. As the tree grows, it consumes more and more heap space until the available memory is exhausted, resulting in an OutOfMemoryError.

#### Why is the max tree height so different in the two cases?
The StackOverflowError with Integer keys is mainly caused by the deep recursion in the put method, leading to a deep tree and exceeding the stack limit.

The OutOfMemoryError with String keys is a result of the rapidly increasing memory consumption associated with storing string keys in the binary search tree.

The differences in error types and maximum tree height are primarily due to the nature of the operations involved (recursive insertion) and the memory characteristics of the key types (primitive integers vs. reference-type strings).

#### Can you store twice as many items when you double the heap space?
No, doubling the heap space increases the total memory available, but if you can store exactly twice as many items depends on how efficiently the data structure uses memory and whether other factors, such as garbage collection overhead, come into play.

---

## Assignment 3.2 Hashing
### Assignment steps:
- use the edu.princeton.cs.algs4.SeperateChainingHashST class to count the frequency (number of occurrences) of every word from the given tale2022v2.txt data file on DLO.
- Hint: you can use file.readString until a NoSuchElementException occurs using
SeparateChainingHashST<String, Integer> bookWords = new SeparateChainingHashST<>();   and
In file = new In("tale2022v2.txt");
- What are the most and least frequently used words? Note there are TWO words that have equal maximum frequency so print all max used words. Words are all the strings seperated by spaces and newlines.
- What is the big-O of your solution to counting words with regard to the number of words (N) in the input file?
- Write a method to print the longest word in the file.
- What's the longest word.
- What is the time complexity of this method.
- Explain if it helps to use Hashing or Sorting to find the longest word.
- How much faster or slower is it and how many changes in the code when you change the HashST into BinarySearchST<String, Integer> bookWords ?

### Setup process
I have created a file called Hashing that loops through the txt file prints all those words with their frequency, records the longest word, most and least frequently used words and records the total run time.

### Running the files
Simply run Hashing.java

```bash
javac Hashing.java
java Hashing
```

### Questions:
#### What are the most and least frequently used words? Note there are TWO words that have equal maximum frequency so print all max used words. Words are all the strings seperated by spaces and newlines.
Most frequently used word(s): [vind, the]
Least frequently used word(s): [monks]

#### What is the big-O of your solution to counting words with regard to the number of words (N) in the input file?
SeparateChainingHashST

#### Write a method to print the longest word in the file.
```java
        String longestWord = "";
        for (String word : bookWords.keys()) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
```

#### What's the longest word.
```bash
Longest word: ditiseenheellangwoordomtezoekenmetLAG2022maarwelweerandersdanvorigekeer
```

#### What is the time complexity of this method.
1

#### Explain if it helps to use Hashing or Sorting to find the longest word.
If finding the longest word is a frequent operation and the data set is large, sorting might be more efficient despite the higher initial cost.

If the primary concern is the efficiency of finding the longest word and the data set is not extremely large, hashing may be more suitable due to its constant-time average complexity.

#### How much faster or slower is it and how many changes in the code when you change the HashST into BinarySearchST<String, Integer> bookWords ?
**SeparateChainingHashST<String, Integer> bookWords**
Total runtime: 300 milliseconds

**BinarySearchST<String, Integer> bookWords**
Total runtime: 493 milliseconds
