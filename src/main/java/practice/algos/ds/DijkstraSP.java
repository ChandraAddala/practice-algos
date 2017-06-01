package practice.algos.ds;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class DijkstraSP {


    private Graph graph;
    private Edge[] edges;
    int[] cost;
    boolean[] marked; //marked to true if picked as min vertex.

    public static class Edge {
        private int v1;
        private int v2;
        private int weight;

        public int getV1() {
            return v1;
        }

        public int getV2() {
            return v2;
        }

        public int getWeight() {
            return weight;
        }

        public Edge(int v1, int v2, int weight) {
            this.v1 = v1;
            this.v2 = v2;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return v1 + "-" + v2 + " : " + weight;
        }
    }

    public DijkstraSP(InputStream inputStream, int source) {
        this(new GraphUndirected(inputStream, true), source);
    }

    public DijkstraSP(GraphUndirected graph, int source) {
        this.graph = graph;
        edges = new Edge[graph.totalVertices];
        cost = new int[graph.totalVertices];
        marked = new boolean[graph.totalVertices];

        for (int i = 0; i < graph.totalVertices; i++) {
            cost[i] = Integer.MAX_VALUE;
            marked[i] = false;
        }

        singleSourceSP(source);
    }

    public DijkstraSP(GraphDirected graph, int source) {
        this.graph = graph;
        edges = new Edge[graph.totalVertices];
        cost = new int[graph.totalVertices];
        marked = new boolean[graph.totalVertices];

        for (int i = 0; i < graph.totalVertices; i++) {
            cost[i] = Integer.MAX_VALUE;
            marked[i] = false;
        }

        singleSourceSP(source);

        System.out.println(Arrays.toString(cost));
        Arrays.stream(edges).forEach(System.out::println);
    }

    public Graph getGraph() {
        return graph;
    }


    public int distTo(int vertex) {
        return cost[vertex];
    }

    public List<Edge> pathTo(int dest) {
        List<Edge> result = new ArrayList<>();

        Edge e = edges[dest];
        while (e != null) {
            result.add(e);
            e = edges[e.getV1()];
        }

        return result;
    }

    /**
     * Computes a shortest-paths tree from the source vertex {@code s} to every other
     * vertex in the graph
     *
     * Time complexity is (V + E log V) (provided we use the right data structure)
     *
     *
     * @param source
     */
    private void singleSourceSP(int source) {

        //picking vertex 0 as starting element. We can pick any element.
        cost[source] = 0;

        for (int i = 0; i < graph.totalVertices - 1; i++) {
            int minVertex = getMinimumVertex();
            marked[minVertex] = true;

            updateAdjVertices(minVertex);
        }
    }

    /**
     * Update key value of all adjacent vertices of u. To update the key values,
     * iterate through all adjacent vertices. For every adjacent vertex v, if (weight
     * of edge u-v + cost of u) is less than the previous key value of v, update the key value
     *
     * if we use binary help, we can leverage its decrease method and contains method here.
     *
     * @param vertex
     */
    private void updateAdjVertices(int vertex) {
        //Update the cost only if existing cost is higher than the new cost
        //keeping track to construct tree later
        graph.getEdges(vertex)
             .stream()
             .filter(edgeNode -> !marked[edgeNode.getVertex()] && cost[edgeNode.getVertex()] > cost[vertex] + edgeNode.getWeight())
             .forEach(edgeNode -> {

                 cost[edgeNode.getVertex()] = cost[vertex] + edgeNode.getWeight(); //We maintain the cost from source to this vertex.
                 edges[edgeNode.getVertex()] = new Edge(vertex, edgeNode.getVertex(), edgeNode.getWeight()); //keeping track to edges of shortest path
             });
    }


    /**
     * To find vertex with minimum weight which is not
     * marked yet. In other words, goal is to find the smallest edge
     * that connects to an unvisited node.
     *
     * (Since only the weights of vertices adjacent to the marked vertices
     * are updated in cost({@link PrimMST#updateAdjVertices(int)}, this will
     * only pick vertex which is adjacent to already marked vertex.)
     *
     * This can be be optimized to use binary heap to get O(log(n))
     * performance. Its more optimized if we remove the min from the heap.
     *
     * Binary help supports
     *
     * extractMin   - O(log(n))
     * add          - O(log(n))
     * contains     - O(1)
     * decrease     - O(log(n)) (if we reduce the value, elements gets rearranged)
     *
     * Java's priority queue implementation runs contains in O(n) and also
     * does not support decrease.
     *
     * @return
     */
    private int getMinimumVertex() {

        int minValue = Integer.MAX_VALUE;
        int minVertex = -1;

        //Pick a vertex u which is not marked and has minimum key value.
        for (int i = 0; i < graph.totalVertices; i++) {
            if (!marked[i]) {
                if (cost[i] < minValue) {
                    minVertex = i;
                    minValue = cost[i];
                }
            }
        }

        return minVertex;
    }

}
