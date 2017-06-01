package practice.algos;


import org.junit.Assert;
import org.junit.Test;
import practice.algos.Codec.TreeNode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class CodecTest {

    @Test
    public void testSerialize0() {
        Codec c= new Codec();
        assertEquals("n", c.serialize(null));
        assertNull(c.deserialize(c.serialize(null)));
    }

    @Test
    public void testSerialize1() {
        TreeNode root = new TreeNode(1);

        Codec c= new Codec();
        String tree = "1 n n";
        assertEquals(tree, c.serialize(root));
        assertEquals(1, c.deserialize(tree).val);
    }

    @Test
    public void testSerialize2() {
        TreeNode root = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        TreeNode r1 = new TreeNode(3);
        root.left = l1;
        root.right = r1;

        TreeNode r2 = new TreeNode(4);
        r1.right = r2;

        TreeNode r3 = new TreeNode(5);
        r2.right = r3;

        Codec c= new Codec();
        assertEquals("1 2 3 n n n 4 n 5 n n", c.serialize(root));

    }

    @Test
    public void testDeserialize() {

        Codec c= new Codec();
        String testString = "1 n 2 n n";
        TreeNode root = c.deserialize(testString);
        assertEquals(testString, c.serialize(root));

    }

}
