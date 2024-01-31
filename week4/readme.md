# Week 4 report
### Lars Arie Grit, IT201
___

## Test exam 2: graphs
### Assignment steps:
- Maak een java project met code als antwoord op onderstaande vragen. De klassen die je nodig
hebt zijn onder andere: Graph, Bag, Edge, Stack, EdgeWeightedGraph en andere uit de standaard
codebibliotheek van het boek (algs4.jar gebruiken). Wijzig deze standaardklassen niet.
Lever de java file(s) die je zelf gemaakt hebt in via gitlab. Gebruik duidelijke comments in je
code als toelichting. Alles kan in een bestand van 80 regels worden gedaan maar je mag extra
klassen en methoden aanmaken.
- Tip: vooral de voorbeeldcode in de main methoden van de algs4.jar klassen zijn handig als bron.
- Er is een ongebonden graaf met 100 knopen gegeven in file “graaf100.txt” op Dlo of Moodle. Maak
een Graph object aan die dit inleest met de methoden (constructors) die Graph hiervoor beschikbaar
heeft. Ook de edu.princeton.cs.algs4.In klasse kun je hiervoor gebruiken.
- Druk de graaf af. Er is al een toString methode.
- Maak een nieuwe methode om de graaf af te drukken in hetzelfde formaat als waarmee het ingelezen werd, dus de output van deze methode moet weer in te lezen zijn door dit programma.
- Gebruik de DepthFirstSearch(g, s) klasse constructor om te bepalen of de graaf inderdaad unconnected is en druk van elke deelgraaf alleen de knopen (vertex nummers) af.
Doe dit door s van 0 tot N (100) te laten lopen en marked(v) te gebruiken maar druk dezelfde knoop niet meerdere keren af.
- Maak een lege EdgeWeightedGraph en vul deze met knopen en kanten uit de eerste graaf waarbij de afstand tussen twee knopen het absolute verschil tussen de knoopnummers is (dus van vertex 2 naar 10 is de afstand 8). Druk deze graaf af op de manier zoals bij punt 2.
- Gebruik de PrimMST class om het gewicht en de MST van deze graaf af te drukken. Check je antwoord:
Vraag 6 Prim MST 3379 (forest) of 1858 (eerste deelgraaf vanaf 0). Zie ook de gegeven output file op DLO.
- Lever de oplossing in als een enkel java broncode bestand op gitlab.
<br>

### Explanation

This program reads a graph from a file, performs various graph-related operations such as checking connectivity, finding connected components, and computing the Minimum Spanning Tree. The code is organized into sections, each addressing a specific aspect of graph processing.

**Reading and Displaying the Graph:**
- The program reads a graph from a file named "graaf100.txt" using the `In` class from Princeton's `algs4` library.
- It then creates a `Graph` object (presumably representing an undirected graph) using the data from the file.
- Prints the graph using `toString()`.
- Outputs the number of vertices (`V()`) and edges (`E()`) in the graph.
- Displays the adjacency lists for each vertex.

**Graph Connectivity Check (Question 3):**
- The program performs a depth-first search (`DepthFirstSearch`) on the graph starting from vertex 0.
- Checks if all vertices are reachable from the source vertex. If not, it prints "NOT connected"; otherwise, it prints "connected".

**Connected Components:**
- The program identifies connected components in the graph.
- It initializes a boolean array `visited` to keep track of visited vertices.
- For each unvisited vertex, it performs a depth-first search and prints the vertices belonging to the same connected component.

**Creating an EdgeWeightedGraph and Finding Minimum Spanning Tree (MST):**
- It creates an `EdgeWeightedGraph` (`ewg`) by adding edges with weights based on the absolute difference between vertex indices in the original graph.
- Prints the `EdgeWeightedGraph`.
- Computes the Minimum Spanning Tree (MST) using Prim's algorithm (`PrimMST`).
- Outputs the weight of the MST and displays the edges in the MST.

---

## LAGToetsFeb2022
### Assignment steps:
- LAG assignment: fill in you name and Part1-3 parts and check output with output.txt file in this project
- This program generates a random undirected unweighted Graph g and:
- checks if the graph is connected (part 1)
- finds the vertex/node with the highest degree (most edges/neighbours) (part 2)
- finds the longest path between two nodes using the shortest route with BreathFirstPaths (part 3)
- Check example output for various random seeds in the output.txt and output_seed18.txt files and compare results.

### Questions:
This program generates a random graph, checks its connectivity, finds the node with the highest degree, and determines the longest path between two nodes using graph algorithms. The student is expected to fill in specific information and compare the output with predefined examples.

**Graph Generation:**
- The `generateGraph` method creates a random undirected graph with a fixed seed for randomness. It uses the `GraphGenerator.simple` method from the `edu.princeton.cs.algs4` library to generate a graph with a specified number of vertices (`nrVertices`) and edges (`nrEdges`).

**Main Functionality:**
- The `main` method is the main entry point of the program.
- It initializes a random graph using the `generateGraph` method with a fixed seed (in this case, seed `16`).
- It checks and prints whether the generated graph is connected or not (part 1 of the assignment) using a `DepthFirstSearch` algorithm.
- It identifies and prints the node with the highest degree (number of neighbors) in the graph (part 2 of the assignment).
- It finds and prints the longest path between two nodes using the Breadth-First Search (BFS) algorithm (`BreadthFirstPaths`) to find the shortest routes between all pairs of nodes and then selects the longest one (part 3 of the assignment).

**Output:**
- The program prints the results of the connectivity check, the node with the highest degree, and the longest path between two nodes.
- The output is intended to be compared with example outputs stored in `output.txt` and `output_seed18.txt` files for different random seeds.

**Additional Notes:**
- The program includes some placeholder information for the student's name, student number, and class/group.
- The seed value `16` is provided, and the comments suggest changing it to compare different outputs.
- The program uses the `StdOut` class from the `edu.princeton.cs.algs4` library for standard output.