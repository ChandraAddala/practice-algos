package practice.algos.ds;

import java.io.InputStream;

public class GraphUndirected extends Graph {

    public GraphUndirected(int totalVertices, int totalEdges) {
        super(totalVertices, totalEdges);
    }

    public GraphUndirected(InputStream inputStream) {
        super(inputStream);
    }

    public GraphUndirected(InputStream inputStream, boolean isWeighted) {
        super(inputStream, isWeighted);
    }

    @Override
    public void addEdge(int x, int y, int weight) {
        vertices[x].add(new EdgeNode(y, weight));
        vertices[y].add(new EdgeNode(x, weight));
    }

}
