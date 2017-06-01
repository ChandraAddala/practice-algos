package practice.algos;


public class LowestCommonAncestor {

    /**
     *              1
     *         ----------
     *         |        |
     *         2        3
     *         |        |
     *       -----    -----
     *       4   5    6   7
     *           |
     *          ---
     *          8
     *
     * Time complexity of this solution is O(n)
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //found one of the treenodes p, q. We shouldnt compare values. We should implement equals() in TreeNode.
        if(root == null || root.val == p.val || root.val == q.val)  return root;
        System.out.println("root=" + root.val);

        // look for keys in left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If both of the above calls return Non-NULL, then one key
        // is present in one subtree and other is present in other,
        // So this node is the LCA
        if(left != null && right != null)   return root;

        //both p and q are present in one subtree with p or q as root of that subtree.
        // (We dont dont even recur down that subtree. Lets say we find p in left tree, and
        // we dont find anything in the right subtree, then p must be lca. (5,8) -> 5
        return left != null ? left : right;
    }



    private TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) return null;

        if (root.val == p.val || root.val == q.val) return root;

        TreeNode t1 = dfs(root.left, p, q);
        if (t1 == null) return null;

        TreeNode t2 = dfs(root.right, p, q);
        if (t2 == null) return null;

        return null;
    }

    private static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.right.left = new TreeNode(8);

        System.out.println("(5,8)->" + LowestCommonAncestor.lowestCommonAncestor(root, new TreeNode(5), new TreeNode(8)).val);
        System.out.println("(4,5)->" + LowestCommonAncestor.lowestCommonAncestor(root, new TreeNode(4), new TreeNode(5)).val);
        System.out.println("(4,8)->" + LowestCommonAncestor.lowestCommonAncestor(root, new TreeNode(4), new TreeNode(8)).val);
    }
}
