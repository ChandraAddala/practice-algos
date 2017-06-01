package practice.algos.ds;


import org.junit.Test;

import java.util.Arrays;

public class DAGShortestPathTest {

    @Test
    public void testShortestPathUsingTopSort() {

        DAGShortestPath.DAG g = new DAGShortestPath.DAG(6);
        g.addEdge(0, 1, 5);
        g.addEdge(0, 2, 3);
        g.addEdge(1, 3, 6);
        g.addEdge(1, 2, 2);
        g.addEdge(2, 4, 4);
        g.addEdge(2, 5, 2);
        g.addEdge(2, 3, 7);
        g.addEdge(3, 4, -1);
        g.addEdge(4, 5, -2);

        DAGShortestPath shortestPath = new DAGShortestPath(g);
        int[] dist = shortestPath.shortestPathUsingTopSort(1);

        System.out.println(Arrays.toString(dist));

    }
}
