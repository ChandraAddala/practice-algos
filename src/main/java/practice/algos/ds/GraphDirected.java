package practice.algos.ds;

import java.io.InputStream;


public class GraphDirected extends Graph {
    public GraphDirected(int totalVertices, int totalEdges) {
        super(totalVertices, totalEdges);
    }

    public GraphDirected(InputStream inputStream) {
        super(inputStream);
    }

    @Override
    public void addEdge(int x, int y, int weight) {
        vertices[x].add(new EdgeNode(y, weight));
    }

}
