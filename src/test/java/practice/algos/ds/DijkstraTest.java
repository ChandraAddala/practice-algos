package practice.algos.ds;

import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class DijkstraTest {


    @Test
    public void testSP() {
        InputStream in = GraphTest.class.getClassLoader()
                                        .getResourceAsStream("primG.txt");

        DijkstraSP dijkstraSP = new DijkstraSP(new GraphUndirected(in), 0);
        Assert.assertEquals("Shortest distance from 0 to 2", 5, dijkstraSP.distTo(2));
        Assert.assertEquals("Shortest distance from 0 to 4", 7, dijkstraSP.distTo(4));

        dijkstraSP.pathTo(2).stream().forEach(System.out::println);
        dijkstraSP.pathTo(4).stream().forEach(System.out::println);
    }

    @Test
    public void testSPDirectedCycle() {
        InputStream in = GraphTest.class.getClassLoader()
                                        .getResourceAsStream("tinyEWD.txt");

        DijkstraSP dijkstraSP = new DijkstraSP(new GraphDirected(in), 0);
        Assert.assertEquals("Shortest distance from 0 to 7", 60, dijkstraSP.distTo(7));
        Assert.assertEquals("Shortest distance from 0 to 1", 105, dijkstraSP.distTo(1));

        System.out.println("SP:");
        dijkstraSP.pathTo(7).stream().forEach(System.out::println);
        System.out.println("SP:");
        dijkstraSP.pathTo(1).stream().forEach(System.out::println);
    }
}
