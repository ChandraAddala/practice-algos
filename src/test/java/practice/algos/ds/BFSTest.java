package practice.algos.ds;

import org.junit.Test;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BFSTest {

    @Test
    public void test() {
        InputStream in = GraphTest.class.getClassLoader()
                .getResourceAsStream("tinyG.txt");

        BFS bfs = new BFS(new GraphUndirected(in), 0);

        List<Integer> minPath = bfs.minPath(6);
        System.out.println("minPath: " + minPath);

        assertTrue(minPath.containsAll(Arrays.asList(0, 6)) && Arrays.asList(0, 6).containsAll(minPath));

        List<Integer> minPath1 = bfs.minPath(3);
        System.out.println("minPath1: " + minPath1);

        assertTrue(minPath1.containsAll(Arrays.asList(0, 5, 3)) && Arrays.asList(0, 5, 3).containsAll(minPath1));
    }


    @Test
    public void test1() {
        InputStream in = GraphTest.class.getClassLoader()
                .getResourceAsStream("tinyG.txt");

        BFS bfs = new BFS(new GraphUndirected(in), 6);

        List<Integer> minPath = bfs.minPath(5);
        System.out.println("minPath: " + minPath);

        assertTrue(minPath.containsAll(Arrays.asList(4, 5, 6)) && Arrays.asList(4, 5, 6).containsAll(minPath));

        List<Integer> minPath1 = bfs.minPath(0);
        System.out.println("minPath1: " + minPath1);

        assertTrue(minPath1.containsAll(Arrays.asList(0, 6)) && Arrays.asList(0, 6).containsAll(minPath1));

    }

    @Test
    public void connectedComponents() {
        InputStream in = GraphTest.class.getClassLoader()
                .getResourceAsStream("tinyG.txt");

        BFS bfs = new BFS(new GraphUndirected(in), 0);
        assertEquals(3, bfs.connectedComponents());
    }


}
