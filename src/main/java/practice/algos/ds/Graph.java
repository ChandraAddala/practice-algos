package practice.algos.ds;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * Simple graph implementation.
 */
public abstract class Graph {

    int totalVertices;
    int totalEdges;

    List<EdgeNode>[] vertices;

    static class EdgeNode {
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

    public Graph(int totalVertices, int totalEdges) {
        init(totalVertices, totalEdges);
    }

    public Graph(InputStream inputStream) {

        Scanner sc = new Scanner(inputStream);
        int totalVertices = sc.nextInt();
        int totalEdges = sc.nextInt();

        init(totalVertices, totalEdges);

        while (sc.hasNext()) {
            this.addEdge(sc.nextInt(), sc.nextInt(), 1);
        }
    }

    public Graph(InputStream inputStream, boolean isWeighted) {

        Scanner sc = new Scanner(inputStream);
        int totalVertices = sc.nextInt();
        int totalEdges = sc.nextInt();

        init(totalVertices, totalEdges);

        while (sc.hasNext()) {
            this.addEdge(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }
    }

    private void init(int totalVertices, int totalEdges) {
        this.totalVertices = totalVertices;
        this.totalEdges = totalEdges;

        this.vertices = (List<EdgeNode>[])(new ArrayList[totalVertices]);
        for (int i = 0; i < totalVertices; i++) {
            vertices[i] = new ArrayList<EdgeNode>();
        }
    }

    public abstract void addEdge(int x, int y, int weight);

    public List<Integer> getAdjacentVertices(int x) {
        List<Integer> adj = new ArrayList<Integer>();
        for (EdgeNode e: vertices[x]) {
            adj.add(e.getVertex());
        }
        return adj;
    }

    public List<EdgeNode> getEdges(int x) {
        return vertices[x];
    }

    public void print() {
        for (int i = 0; i < totalVertices; i++) {

            System.out.print(i + ": ");
            for (EdgeNode e: vertices[i]) {
                System.out.print(e.getVertex() + " ");
            }
            System.out.println("");
        }
    }

}
