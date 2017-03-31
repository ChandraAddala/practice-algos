package practice.algos.ds;

import java.util.Stack;

public class TopologicalSort {


    GraphDirected g;
    private boolean[] marked;

    public TopologicalSort(GraphDirected g) {
        this.g = g;
        this.marked = new boolean[g.totalVertices];
        for ( int i =0; i < g.totalVertices; i++) {
            marked[i] = false;
        }
    }

    public Stack<Integer> tsort() {

        Stack<Integer> output = new Stack<Integer>();
        for (int i = 0; i < g.totalVertices; i++) {
            if (!marked[i]) {
                if (!dfs(i, output)) {
                    throw new IllegalArgumentException("Invalid graph. Not a DAG. Contains cycle.");
                }
            }
        }

        return output;
    }

    private boolean dfs(int vertex, Stack<Integer> output) {
//        System.out.print(vertex + " ");
        marked[vertex] = true;

        for (int adj: g.getAdjacentVertices(vertex)) {

            if (!marked[adj]) {
                if (!dfs(adj, output)) {
                    return false;
                }
            } else if (!output.contains(adj)) { //checking for cycle; topological sort is not possible if there is a cycle
                // if vertex is marked but it is not completed, its a back edge to form a cycle.
                System.out.println("Cycle detected at: " + adj);
                return false;
            }
        }

        output.add(vertex); //vertex completed processing; topological sort is just reverse post order
        return true;
    }


}
