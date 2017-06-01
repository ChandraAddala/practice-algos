package practice.algos;

import java.util.LinkedList;
import java.util.Queue;

public class Codec {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static final String NULL_NODE = "n";
    private static final String DELIMITER = " ";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        //level order
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append(NULL_NODE);
                sb.append(DELIMITER);
            } else {
                sb.append(node.val);
                sb.append(DELIMITER);

                queue.offer(node.left);
                queue.offer(node.right);
            }
        }

        return sb.toString().trim();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        String[] nodes = data.split(DELIMITER);
        TreeNode root = null;
        if (!NULL_NODE.equals(nodes[0])) {
            root = new TreeNode(Integer.parseInt(nodes[0]));
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        for (int i = 1; i < nodes.length; i++) {
            TreeNode parent = queue.poll();

            //left
            if (!NULL_NODE.equals(nodes[i])) {
                TreeNode left = new TreeNode(Integer.parseInt(nodes[i]));
                parent.left = left;
                queue.add(left);
            }
            i++;

            //right
            if (!NULL_NODE.equals(nodes[i])) {
                TreeNode right = new TreeNode(Integer.parseInt(nodes[i]));
                parent.right = right;
                queue.add(right);
            }
        }

        return root;
    }

    public static void main(String[] args) {
        Codec c= new Codec();

        TreeNode root = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        TreeNode r1 = new TreeNode(3);
        root.left = l1;
        root.right = r1;

        TreeNode r2 = new TreeNode(4);
        r1.right = r2;

        TreeNode r3 = new TreeNode(5);
        r2.right = r3;

        System.out.println(c.serialize(root));
        TreeNode root1 = c.deserialize(c.serialize(root));

        TreeNode t = c.deserialize("1 2 3 4 5 n n");

    }
}
