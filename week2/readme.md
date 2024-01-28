# Week 2 report
### Lars Arie Grit, IT201
___

## Assignment 2.1 parallel sort research
### Assignment steps:
- Create a test program that generates N random numbers or strings and sorts them serial and parallel and show the elapsed time results in a table to show the differences.
- Estimate the break-even point for N where both methods are equaly fast.
- Depending on your pc/laptop you can use more cores to do parallel sort. How many times faster is parallel sort for 200000000 (2E8) numbers? And 600000000 (6E8) ? Note: maybe change the Heap Size of the JVM memory to 8GB if you can:

- Is oege.ie.hva.nl faster in both normal and parallel sorts than your laptop? Why?
Note: learn to use the (putty) commandline and javac + java commandline tools. You do not need the Algs4.jar for this example - use the standard Java sorting methods.
- How long does this take using python list.sort() to sort 200 million items in a list and is Python faster than Java?

<br>

### Setup process
I have created a file called ParallelSortingResearch which has a main function and a generateRandomIntegers function, in the main function we assign a variable called N a integer value, currently 1000000. This value is given to the generateRandomIntegers which creates a randomly generated array of integers, we make sure to create a copy of this generated array and process them both serially and parallel and record their time which we then later print.

### Running the files
Simply run the file

### Questions:
#### Estimate the break-even point for N where both methods are equaly fast.
During testing I have found out that bewloe N = 1000, serial was faster and above 1000 parallel was faster. 1000 was roughly the break-even point. Considering there can be a bit of randomness with the generated array.

#### Depending on your pc/laptop you can use more cores to do parallel sort. How many times faster is parallel sort for 200000000 (2E8) numbers? And 600000000 (6E8) ?

parallel sort for 200000000 (2E8) = Parallel Sort Elapsed Time: 4606 milliseconds

parallel sort for 600000000 (6E8) = Parallel Sort Elapsed Time: 1077 milliseconds

#### Is oege.ie.hva.nl faster in both normal and parallel sorts than your laptop? Why?

It is slower because it uses less cores.

#### How long does this take using python list.sort() to sort 200 million items in a list and is Python faster than Java?

I have created a pythonSort.py program to calculate the time it takes to sort 200 million items using list.sort(). 

##### Python
Parallel Sort Elapsed Time: 23.78267216682434 seconds 
##### Java
Parallel Sort Elapsed Time: 21683.888912200928 milliseconds