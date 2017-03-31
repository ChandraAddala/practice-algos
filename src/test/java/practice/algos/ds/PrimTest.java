package practice.algos.ds;

import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class PrimTest {

    @Test
    public void testCycle() {
        InputStream in = GraphTest.class.getClassLoader()
                                        .getResourceAsStream("primG.txt");

        PrimMST primMST = new PrimMST(in);
        List<PrimMST.Edge> edges = primMST.mst();
        Assert.assertEquals("MST does not contain all edges", primMST.getGraph().totalVertices - 1, edges.size());
        Assert.assertEquals("MST weight mismatch", 16, edges.stream().mapToInt(PrimMST.Edge::getWeight).sum());
    }

}
