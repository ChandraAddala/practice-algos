package practice.algos.ds;

import org.junit.Test;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;


public class GraphTest {


    @Test
    public void test() {
        InputStream in = GraphTest.class.getClassLoader()
                .getResourceAsStream("tinyG.txt");

        Graph g = new GraphUndirected(in);
        g.print();

        List<Integer> expected = Arrays.asList(5, 1, 2, 6);
        assertTrue(g.getAdjacentVertices(0).containsAll(expected) && expected.containsAll(g.getAdjacentVertices(0)));
    }
}
