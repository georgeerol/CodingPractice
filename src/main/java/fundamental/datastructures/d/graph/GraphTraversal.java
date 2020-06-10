package fundamental.datastructures.d.graph;

import fundamental.datastructures.c.stackandqueues.Stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by George Fouche on 1/16/20.
 */
public class GraphTraversal {


    /**
     * The First In First out(FIFO) structure of the queue ensure that the graph is travesed one level at a time
     *
     * @param g      - graph
     * @param source - the starting point
     * @retur - traverse # as string
     */
    private static String bfsTraversal(Graph g, int source) {
        String result = "";

        /** Mark all the vertices as not visited(By default set as false) */
        boolean visited[] = new boolean[g.vertices];

        /** Create a queue for  Breath First Search */
        Queue<Integer> queue = new LinkedList<>();

        /** Mark the current node as visited and enqueue it*/
        visited[source] = true;
        queue.add(source);

        while (!queue.isEmpty()) {
            /** Dequeue a vertex from queue and print it */
            source = queue.poll();
            result += String.valueOf(source);


            /**
             * Get all adjacent vertices of the dequeued vertex source
             * if an adjacent has not been visited, then mark it visited and enqueue it
             */
            for (Integer n : g.adjacencyList[source]) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
        return result;
    }


    /**
     * The same approach as BFS solution. However, instead of a queue, we use a stack since it follows the
     * Last In First out (LIFO) approach.
     * @param g
     * @param source
     * @return
     */
    private static String dfsTraversal(Graph g, int source) {
        String result = "";

        /** Mark all the vertices as not visited(By default set as false) */
        boolean visited[] = new boolean[g.vertices];

        /** Create a Stack for Breath First Search */
        Stack stack = new Stack(g.vertices);

        /** Mark the current vertex as visited and stack it*/
        visited[source] = true;
        stack.push(source);

        while (!stack.isEmpty()) {
            /** Pop a vertex from stack and print it */
            source = stack.pop();
            result += String.valueOf(source);


            /**
             * Get all adjacent vertices of the pop vertex source
             * if an adjacent has not been visited, then mark it visited and push it to the stack
             */
            for (Integer n : g.adjacencyList[source]) {
                if (!visited[n]) {
                    visited[n] = true;
                    stack.push(n);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);


        System.out.println(bfsTraversal(g, 0));
        System.out.println(dfsTraversal(g, 0));

    }


}
