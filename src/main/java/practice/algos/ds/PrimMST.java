package practice.algos.ds;


import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class PrimMST {

    Graph graph;
    int[] parent;
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

    public PrimMST(InputStream inputStream) {
        this(new GraphUndirected(inputStream, true));
    }

    public PrimMST(GraphUndirected graph) {
        this.graph = graph;
        parent = new int[graph.totalVertices];
        cost = new int[graph.totalVertices];
        marked = new boolean[graph.totalVertices];

        for (int i = 0; i < graph.totalVertices; i++) {
            parent[i] = -1;
            cost[i] = Integer.MAX_VALUE;
            marked[i] = false;
        }
    }

    public Graph getGraph() {
        return graph;
    }

    public List<Edge> mst() {
        List<Edge> edges = new ArrayList<>();

        //picking vertex 0 as starting element. We can pick any element.
        cost[0] = 0;

        for (int i = 0; i < graph.totalVertices - 1; i++) {
            int minVertex = getMinimumVertex();
            marked[minVertex] = true;

            updateAdjVertices(minVertex);
        }

        for (int i = 1; i < graph.totalVertices; i++) {
            edges.add(new Edge(parent[i], i, cost[i]));
        }

        return edges;
    }

    /**
     * Update key value of all adjacent vertices of u. To update the key values,
     * iterate through all adjacent vertices. For every adjacent vertex v, if weight
     * of edge u-v is less than the previous key value of v, update the key value as weight of u-v
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
             .filter(adj -> !marked[adj.getVertex()] && cost[adj.getVertex()] > adj.getWeight())
             .forEach(adj -> {

                 cost[adj.getVertex()] = adj.getWeight();
                 parent[adj.getVertex()] = vertex; //keeping track to construct tree later
             });
    }


    /**
     * To find vertex with minimum weight which is not
     * marked as mst yet. In other words, goal is to find the smallest edge
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
