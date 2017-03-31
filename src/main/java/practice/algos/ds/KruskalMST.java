package practice.algos.ds;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.io.InputStream;
import java.util.*;

public class KruskalMST {

    Graph graph;

    private UnionFind unionFind;
    private Queue<Edge> pq;

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
        public boolean equals(Object o) {
            if (this == o) return true;

            if (o == null || getClass() != o.getClass()) return false;

            Edge edge = (Edge) o;

            return new EqualsBuilder()
                    .append(v1, edge.v1)
                    .append(v2, edge.v2)
                    .append(weight, edge.weight)
                    .isEquals();
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder(17, 37)
                    .append(v1)
                    .append(v2)
                    .append(weight)
                    .toHashCode();
        }

        @Override
        public String toString() {
            return v1 + "-" + v2 + " : " + weight;
        }
    }

    public Graph getGraph() {
        return graph;
    }

    public KruskalMST(InputStream inputStream) {
        this(new GraphUndirected(inputStream, true));
    }

    public KruskalMST(GraphUndirected graph) {
        this.graph = graph;

        this.pq = new PriorityQueue<>(graph.totalEdges, (x ,y) -> x.getWeight() - y.getWeight());
        //add all edges to priority queue to retrieve minimum edges

        populateQueue();

    }

    private void populateQueue() {

        //Not very efficient, but we want to get all edges of a graph.
        Set<Edge> edges = new HashSet<>();
        for (int i = 0 ; i < graph.totalVertices; i++) {
            for (Graph.EdgeNode edgeNode: graph.getEdges(i)) {
                edges.add(new Edge(Math.min(i, edgeNode.getVertex()), Math.max(i, edgeNode.getVertex()), edgeNode.getWeight()));
            }
        }

        this.pq.addAll(edges);
        this.pq.stream().forEach(System.out::println);

        unionFind = new UnionFind(graph.totalVertices);

    }

    /**
     * Repeated find smallest edges that wont create a cycle and that is mst
     *
     * Time complexity is O(Elog(E))
     *
     * @return
     */
    public List<Edge> mst() {
        List<Edge> edges = new ArrayList<>();


        while (!pq.isEmpty()) {
            Edge minEdge = pq.remove();

            //making sure v1 and v2 dont belong to the same component, cos that would create a cycle.
            if (!unionFind.isConnected(minEdge.getV1(), minEdge.getV2())) {

                unionFind.union(minEdge.getV1(), minEdge.getV2());
                edges.add(minEdge);
            }

        }

        System.out.println("\nMST");
        edges.stream().forEach(System.out::println);

        return edges;
     }
}
