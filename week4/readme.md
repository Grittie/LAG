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

### Setup process


### Running the files
Simply run Graph.java

```bash
javac Graph.java
java Graph
```

### Questions:

---

## LAGToetsFeb2022
### Assignment steps:
- LAG assignment: fill in you name and Part1-3 parts and check output with output.txt file in this project
- This program generates a random undirected unweighted Graph g and:
- checks if the graph is connected (part 1)
- finds the vertex/node with the highest degree (most edges/neighbours) (part 2)
- finds the longest path between two nodes using the shortest route with BreathFirstPaths (part 3)
- Check example output for various random seeds in the output.txt and output_seed18.txt files and compare results.

### Setup process

### Running the files
Simply run LAGToetsFeb2022.java

```bash
javac LAGToetsFeb2022.java
java LAGToetsFeb2022
```

### Questions: