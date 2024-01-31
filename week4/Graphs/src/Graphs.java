import edu.princeton.cs.algs4.*;

public class Graphs {
    public static void main(String[] args) {
        In file = new In("graaf100.txt");
        Graph graph = new Graph(file);
        System.out.println(graph.toString());
        System.out.println(graph.V());
        System.out.println(graph.E());
        for (int v = 0; v < graph.V(); v++) {
            for (Integer w : graph.adj(v)) {
                System.out.println(v + " " + w);
            }
        }

        System.out.println("Question 3");
        int source = 0;
        DepthFirstSearch search = new DepthFirstSearch(graph, source);
        if (search.count() != graph.V()) {
            StdOut.println("NOT connected");
        } else {
            StdOut.println("connected");
        }

        boolean[] visited = new boolean[graph.V()];
        for (source = 0; source < graph.V(); source++) {
            if (visited[source]) {
                continue;
            }
            search = new DepthFirstSearch(graph, source);
            for (int v = 0; v < graph.V(); v++) {
                if (search.marked(v) && !visited[v]) {
                    visited[v] = true;
                    System.out.print(v + " ");
                }
            }
            System.out.println();
        }

        EdgeWeightedGraph ewg = new EdgeWeightedGraph(graph.V());
        for (int v = 0; v < graph.V(); v++) {
            for (Integer w : graph.adj(v)) {
                ewg.addEdge(new Edge(v, w, Math.abs(v - w)));
            }
        }
        System.out.println(ewg);

        PrimMST mst = new PrimMST(ewg);
        System.out.println("Weight of MST: " + mst.weight());
        System.out.println("MST edges:");
        for (Edge e : mst.edges()) {
            System.out.println(e);
        }
    }
}
