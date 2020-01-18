package fundamental.datastructures.graph;

import java.util.LinkedList;

/**
 * Created by George Fouche on 1/14/20.
 */
public class Graph {

    int vertices; // Total number or vertices in graph

    /**
     * To store an array of Linked List. Each index of the array represents a vertex of the graph
     * and the linked list represents the adjacent vertices.
     * */
    LinkedList<Integer> adjacencyList[];

    @SuppressWarnings("unchecked")
    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }

    }

    /**
     * @param source      - vertex number
     * @param destination - destination vertex number
     */
    public void addEdge(int source, int destination) {
        this.adjacencyList[source].addLast(destination);

        //for undirected graph uncomment the line below
        //this.adjacencyList[destination].addLast(source);
    }

    static void printGraph(Graph graph) {
        for (int v = 0; v < graph.vertices; v++) {
            System.out.println("Adjacency list of vertex " + v);
            System.out.print("[" + v + "]");
            for (Integer data : graph.adjacencyList[v]) {
                System.out.print("->" + data);
            }
            System.out.print("->null");
            System.out.println("\n");
        }
    }


    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1); // create an edge from 0 to 1
        g.addEdge(0, 2); // create an edge from 0 to 2
        g.addEdge(1, 3); // create an edge from 1 to 3
        g.addEdge(2, 3); // create an edge from 2 to 3
        // g.addEdge(3, 0);
        printGraph(g);
    }


}
