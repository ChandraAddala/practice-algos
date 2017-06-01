package practice.algos.ds;

import java.util.*;

public class DAGShortestPath {

    private static class EdgeNode {
        private int vertex;
        private int weight;

        public EdgeNode(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        public int getVertex() {
            return vertex;
        }

        public int getWeight() {
            return weight;
        }
    }

    public static class DAG {

        private int numberOfVertices;

        private List<EdgeNode>[] vertices;

        public DAG(int numberOfVertices) {
            this.numberOfVertices = numberOfVertices;

            vertices = new ArrayList[numberOfVertices];
            for (int i =0; i < numberOfVertices; i++) {
                vertices[i] = new ArrayList<>();
            }
        }

        public void addEdge(int from, int to, int weight) {
            this.vertices[from].add(new EdgeNode(to, weight)); //Since this is directed graph, we add only from -> to;
        }

        public List<EdgeNode> getAdjacentVertices(int vertex) {
            return vertices[vertex];
        }

        public Stack<Integer> topologicalSort() {
            Stack<Integer> output = new Stack<>();
            boolean[] marked = new boolean[this.numberOfVertices];

            for (int i = 0; i < numberOfVertices; i++) {
                if (!marked[i]) {
                    dfs(i, marked, output);
                }
            }

            System.out.println(Arrays.toString(output.toArray()));
            return output;
        }

        private void dfs(int vertex, boolean[] marked, Stack<Integer> output) {

            marked[vertex] = true;
            for (EdgeNode edgeNode: this.getAdjacentVertices(vertex)) {
                if (!marked[edgeNode.getVertex()]) {
                    dfs(edgeNode.getVertex(), marked, output);
                }
            }

            output.add(vertex);
        }
    }

    private DAG graph;

    public DAGShortestPath(DAG graph) {
        this.graph = graph;
    }

    /**
     * Calculate single source shortest distances in O(E + VLogV) time using Dijkstra’s algorithm.
     * But we can calculate single source shortest distances in O(V+E) time for DAGs.
     *
     * This method returns the shortest distance from single source to all other vertices.
     *
     * http://www.geeksforgeeks.org/shortest-path-for-directed-acyclic-graphs/
     *
     * @param source
     * @return
     */
    public int[] shortestPathUsingTopSort(int source) {
        int dist[] = new int[this.graph.numberOfVertices];
        for (int i = 0; i < this.graph.numberOfVertices; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[source] = 0;

        Stack<Integer> stack = this.graph.topologicalSort();

        //Move forward in the topological order till the source.
        while (!stack.isEmpty()) {
            if (stack.peek() == source) break;
            stack.pop();
        }

        while (!stack.isEmpty()) {
            int vertex = stack.pop();

            for (EdgeNode edgeNode: this.graph.getAdjacentVertices(vertex)) {
                int newWeight = dist[vertex] + edgeNode.getWeight();

                if (dist[edgeNode.getVertex()] > newWeight) {
                    dist[edgeNode.getVertex()] = newWeight;
                }
            }
        }

        return dist;
    }



}
