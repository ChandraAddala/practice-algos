package practice.algos.ds;

import org.junit.Test;

import java.io.InputStream;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UnionFindTest {

    @Test
    public void testUF() {
        InputStream in = UnionFindTest.class.getClassLoader()
                                        .getResourceAsStream("tinyUF.txt");

        UnionFind uf = new UnionFind(in);
        assertTrue(uf.isConnected(4, 3));
    }

    @Test
    public void testUFAllConnected() {
        UnionFind uf = new UnionFind(10);

        IntStream.range(0, 9).forEach(x -> {
            uf.union(x, x + 1);
        });

        IntStream.range(0, 10).forEach(y -> {
            assertEquals(true, uf.isConnected(0, y));
        });

    }
}
