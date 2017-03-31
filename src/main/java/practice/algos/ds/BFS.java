package practice.algos.ds;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

    private Graph g;
    private int root;

    private int[] parent;
    private boolean[] marked;

    public BFS(Graph g, int root) {
        this.g = g;
        this.root = root;

        parent = new int[g.totalVertices];
        marked = new boolean[g.totalVertices];

        for (int i = 0; i < g.totalVertices; i++) {
            parent[i] = -1;
        }
    }

    public List<Integer> minPath(int y) {
        this.bfs(root);

        List<Integer> minPath = new ArrayList<Integer>();
        int vertex = y;
        while (vertex != -1) {
            minPath.add(vertex);
            vertex = parent[vertex];
        }

        return minPath;
    }

    public int connectedComponents() {

        int count = 0;

        for (int i =0; i < g.totalVertices; i++) {
            if (!marked[i]) {
                System.out.println("Connected component: " + i);
                count++;
                bfs(i);
            }
        }

        return count;

    }

    private void bfs(int start) {

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(start);
        marked[start] = true;

        while (!queue.isEmpty()) {
            int currentVertex = queue.remove();

            //process vertex early
            System.out.print(currentVertex + " ");

            for (int child: g.getAdjacentVertices(currentVertex)) {

                //process edge

                if (!marked[child]) {
                    queue.offer(child);
                    marked[child] = true;
                    parent[child] = currentVertex;
                }
            }

            //process vertex late
        }
        System.out.println("");

    }

}

