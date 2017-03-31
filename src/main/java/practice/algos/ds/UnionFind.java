package practice.algos.ds;


import java.io.InputStream;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * This the weighted union find algorithm
 */
public class UnionFind {

    private int count;
    private int[] parent;
    private int[] weight;

    public UnionFind(int count) {
        init(count);
    }

    private void init(int count) {
        this.count = count;
        parent = new int[count];
        weight = new int[count];

        IntStream.range(0, count)
                .forEach(i -> {
                    parent[i] = i;
                    weight[i] = 1;
                });
    }

    public UnionFind(InputStream inputStream) {
        Scanner sc = new Scanner(inputStream);
        int count = sc.nextInt();

        init(count);

        while (sc.hasNext()) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (!this.isConnected(x, y)) {
                this.union(x, y);
            }
        }
    }

    /**
     * Returns component identifier.
     *
     * Each connected component is given an id. This method
     * returns the id of the connected component the input
     * element belongs to.
     *
     * O(log(n)) -> proportional to height of tree.
     */
    public int find(int x) {
        return root(x);
    }

    private int root(int x) {
        while (parent[x] != x ) {
            parent[x]= parent[parent[x]]; //path compression (Make every node in path point to its grandparent there by reducing the height of the tree)
            x = parent[x];
        }
        return x;
    }

    public boolean isConnected(int x, int y) {
        return root(x) == root(y);
    }

    /**
     * Join connected components
     *
     * O(log(n)) -> proportional to height of tree.
     *
     * @param x
     * @param y
     */
    public void union(int x, int y) {
        int rootX = root(x);
        int rootY = root(y);
        if (rootX == rootY) return;

        //smaller tree merges to larger tree to make the tree less deep.
        if (weight[rootX] < weight[rootY]) {
            parent[rootX] = rootY;
            weight[rootY] += weight[rootX];
        } else {
            parent[rootY] = rootX;
            weight[rootX] += weight[rootY];
        }
        count --; //this indicates number of connected components. If every thing is one tree we have 1 CC.
    }

}
