package practice.algos;


import java.util.*;

public class TreeTraversals {


    //left, root, right (For BST in-order gives the sorted order)
    public static void inorder(Codec.TreeNode root, List<Integer> result) {
        if (root == null) return;

        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }

    //root, left, right
    public static void preorder(Codec.TreeNode root, List<Integer> result) {
        if (root == null) return;

        result.add(root.val);
        preorder(root.left, result);
        preorder(root.right, result);
    }

    //left, right, root
    public static void postorder(Codec.TreeNode root, List<Integer> result) {
        if (root == null) return;

        postorder(root.left, result);
        postorder(root.right, result);
        result.add(root.val);
    }

    public static List<Integer> levelOrder(Codec.TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<Codec.TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while ( !queue.isEmpty() ) {

            Codec.TreeNode node = queue.poll();
            result.add(node.val);

            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }

        return result;
    }

    //left, root, right (For BST in-order gives the sorted order)
    public static List<Integer> inorderIterative(Codec.TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Stack<Codec.TreeNode> stack = new Stack<>();
        Codec.TreeNode node = root;

        //got to the leftmost element. Thats our first element
        while (node != null) {
            stack.push(node);
            node = node.left;
        }

        while ( !stack.isEmpty() ) {

            node = stack.pop();
            result.add(node.val);


            if (node.right != null) {
                node = node.right;

                //go to the leftmost of the right node
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
        }

        return result;
    }


    //root, left, right
    public static List<Integer> preorderIterative(Codec.TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Stack<Codec.TreeNode> stack = new Stack<>();
        stack.push(root);

        while ( !stack.isEmpty() ) {

            Codec.TreeNode node = stack.pop();
            result.add(node.val);

            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }

        return result;
    }

    public static void main(String[] args) {
        Codec c = new Codec();
        Codec.TreeNode t = c.deserialize("1 2 3 4 5 n n");

        ArrayList<Integer> result = new ArrayList<>();
        TreeTraversals.inorder(t, result);

        System.out.println("inorder=" + Arrays.toString(result.toArray()));

        result = new ArrayList<>();
        TreeTraversals.preorder(t, result);
        System.out.println("preorder=" + Arrays.toString(result.toArray()));

        result = new ArrayList<>();
        TreeTraversals.postorder(t, result);
        System.out.println("postorder=" + Arrays.toString(result.toArray()));

        System.out.println("levelOrder=" + Arrays.toString(TreeTraversals.levelOrder(t).toArray()));
        System.out.println("inOrder iter=" + Arrays.toString(TreeTraversals.inorderIterative(t).toArray()));
        System.out.println("preOrder iter=" + Arrays.toString(TreeTraversals.preorderIterative(t).toArray()));
    }

}
