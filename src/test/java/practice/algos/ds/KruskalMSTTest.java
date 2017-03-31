package practice.algos.ds;

import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;


public class KruskalMSTTest {

    @Test
    public void testCycle() {
        InputStream in = GraphTest.class.getClassLoader()
                                        .getResourceAsStream("primG.txt");

        KruskalMST kruskalMST = new KruskalMST(in);
        List<KruskalMST.Edge> edges = kruskalMST.mst();
        Assert.assertEquals("MST does not contain all edges", kruskalMST.getGraph().totalVertices - 1, edges.size());
        Assert.assertEquals("MST weight mismatch", 16, edges.stream().mapToInt(KruskalMST.Edge::getWeight).sum());
    }

}
