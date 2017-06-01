package practice.algos.ds;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DAGShortestPath1 {

    private Graph g;

    public DAGShortestPath1(Graph g) {
        this.g = g;
    }

    public static class Graph {

        int vertices;

        List<EdgeNode>[] edgeNodes;

        public Graph(int vertices) {
            this.vertices = vertices;
            edgeNodes = new ArrayList[vertices];
            for ( int i = 0; i < vertices; i++) {
                edgeNodes[i] = new ArrayList<>();
            }
        }

        public List<EdgeNode> getAdjVertices(int vertex) {
            return edgeNodes[vertex];
        }

        public void addEdge(int v1, int v2, int weight) {
            edgeNodes[v1].add(new EdgeNode(v2, weight));
        }
    }

    public static class EdgeNode {
        int vertex;
        int weight;

        public EdgeNode(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    public static class Edge {
        int v1;
        int v2;
        int weight;

        public Edge(int v1, int v2, int weight) {
            this.v1 = v1;
            this.v2 = v2;
            this.weight = weight;
        }
    }


    public Stack<Integer> topSort() {
        Stack<Integer> vertices = new Stack<>();
        boolean[] marked = new boolean[g.vertices];
        int[] parent = new int[g.vertices];
        for (int i =0; i < g.vertices; i++) {
            parent[i] = -1;
        }

        for (int i = 0; i < g.vertices; i++) {
            if (!marked[i]) {
                topSort(i, vertices, marked, parent);
            }
        }

        return vertices;
    }

    private void topSort(int vertex, Stack<Integer> vertices, boolean[] marked, int[] parent) {

        marked[vertex] = true;
        for (EdgeNode edgeNode: g.getAdjVertices(vertex)) {
            if (!marked[edgeNode.vertex]) {
                topSort(edgeNode.vertex, vertices, marked, parent);
                parent[edgeNode.vertex] = vertex;
            }
        }

        vertices.add(vertex);
    }



    public static void main(String[] args) {
        Graph g = new DAGShortestPath1.Graph(6);
        g.addEdge(0, 1, 5);
        g.addEdge(0, 2, 3);
        g.addEdge(1, 3, 6);
        g.addEdge(1, 2, 2);
        g.addEdge(2, 4, 4);
        g.addEdge(2, 5, 2);
        g.addEdge(2, 3, 7);
        g.addEdge(3, 4, -1);
        g.addEdge(4, 5, -2);

        DAGShortestPath1 dsp = new DAGShortestPath1(g);
        Stack<Integer> topSortOrder = dsp.topSort();
        while (!topSortOrder.isEmpty()) {
            System.out.print(topSortOrder.pop() + " ");
        }
        System.out.println("\n");


    }

}
