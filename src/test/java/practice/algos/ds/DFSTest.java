package practice.algos.ds;

import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DFSTest {

    @Test
    public void test() {
        InputStream in = GraphTest.class.getClassLoader()
                .getResourceAsStream("tinyG.txt");

        DFS dfs = new DFS(new GraphUndirected(in));
    }

    @Test
    public void testCycle() {
        InputStream in = GraphTest.class.getClassLoader()
                .getResourceAsStream("tinyG.txt");

        DFS dfs = new DFS(new GraphUndirected(in));
        assertTrue(dfs.isCycle());
    }

    @Test
    public void testCycleDG() {
        InputStream in = GraphTest.class.getClassLoader()
                .getResourceAsStream("tinyDG.txt");

        DFS dfs = new DFS(new GraphDirected(in));
        assertTrue(dfs.isCycle());
    }

    @Test
    public void testCycleDG1() {
        GraphDirected g = new GraphDirected(2, 1);
        g.addEdge(1, 0, 1);

        DFS dfs = new DFS(g);
        assertFalse(dfs.isCycle());
    }
}
