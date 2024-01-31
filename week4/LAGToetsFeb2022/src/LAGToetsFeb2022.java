import edu.princeton.cs.algs4.*;

/**
 * practicumtoets LAG februari 2022.
 * Fill in the Parts and check output example file output.txt
 * Export project to zip and upload zipfile to Testvision (File-Export-to-zip).
 */

public class LAGToetsFeb2022 {

    public static void main(String[] args) {
        new LAGToetsFeb2022().main();
    }

    /**
     * LAG assignment: fill in you name and Part1-3 parts and check output with output.txt file in this project
     * This program generates a random undirected unweighted Graph g and:
     * - checks if the graph is connected (part 1)
     * - finds the vertex/node with the highest degree (most edges/neighbours) (part 2)
     * - finds the longest path between two nodes using the shortest route with BreathFirstPaths (part 3)
     *
     * Check example output for various random seeds in the output.txt and output_seed18.txt files and compare results.
     * Good luck!
     */
    void main() {
        final long seed = 16;  // change if you want to compare other outputs (seed 17 is a non-connected graph)
        Graph g = generateGraph(seed);
        System.out.println("\nLAG practicumtoets. Naam: Lars Grit STUDENT_NUMMER Klas/Groep: IT201");
        // part 1: check connectivity
        System.out.println("\nPart 1: test connected graph seed = " + seed);
        boolean connected = false;

        DepthFirstSearch dfs = new DepthFirstSearch(g,0);
        connected = dfs.count() == g.V();
        if (connected) StdOut.println("connected");
        else {
            StdOut.println("Graph NOT connected");
            return;
        }

        // part 2: find nodes with highest degree. Print every line if higher node is found, see output.txt file
        System.out.println("\nPart 2: find node with highest number of neighbours.");
        int maxdegree = 0;
        int maxdegreeNode = -1;

        for (int i = 0; i < g.V(); i++) {
            int degree = g.degree(i);
            if (degree > maxdegree) {
                maxdegree = degree;
                maxdegreeNode = i;
                System.out.printf("node %d has degree %d\n", maxdegreeNode, maxdegree);
            }
        }
        System.out.printf("Answer part 2: node number %d has degree %d\n", maxdegreeNode, maxdegree);

        // Part 3: find longest of all shortest path between two nodes in graph g
        System.out.println("\nPart 3: find shortest routes from all vertices to others and print longest one.");
        // use the algs4.BreadthFirstPaths class to find distTo and pathTo from all nodes to all other nodes.
        // use loops to find the path with longest length using BreadthFirstPaths distTo method.
        int maxDist = 0;
        for (int node = 0 ; node < g.V(); node++){
            BreadthFirstPaths bf = new BreadthFirstPaths(g,node);
            for (int n2 = 0; n2 < g.V(); n2++){
                if (bf.distTo(n2) > maxDist) {
                    maxDist = bf.distTo(n2);
                    System.out.printf("Distance from %d to %d is %d\n", node, n2, maxDist);
                    System.out.println(bf.pathTo(n2));
                }
            }
        }

    } // end main

    /**
     * Generate a random graph given a fixed seed for the StdRandom generator. Don't change.
     *
     * @param seed the seed for Random
     * @return a simple Graph with bidirectional edges
     */
    Graph generateGraph(long seed) {
        StdRandom.setSeed(seed); // fix random nums
        // create random bidirected simple Graph
        final int nrVertices = 100;
        final int nrEdges = 200;
        Graph g = GraphGenerator.simple(nrVertices, nrEdges);
        return g;
    }

}