package practice.algos.ds;

/**
 * This class is designed very poorly. It was just put together for practice.
 */
public class DFS {

    Graph g;
    int[] parent;
    boolean[] marked;
    boolean[] completed;

    public DFS(GraphUndirected g) {
        this.g = g;

        marked = new boolean[g.totalVertices];
        parent = new int[g.totalVertices];
        for (int i = 0; i < g.totalVertices; i++) {
            parent[i] = -1;
        }

        //not needed for undirected graph dfs implementation
        completed = new boolean[g.totalVertices];
    }

    public DFS(GraphDirected g) {
        this.g = g;

        marked = new boolean[g.totalVertices];
        completed = new boolean[g.totalVertices];
        parent = new int[g.totalVertices];
        for (int i = 0; i < g.totalVertices; i++) {
            parent[i] = -1;
        }
    }

    public void dfs(int vertex) {
        marked[vertex] = true;

        //process vertex early
//        System.out.print(vertex + " ");

        for (int adj : g.getAdjacentVertices(vertex)) {
            if (!marked[adj]) {
                parent[adj] = vertex;

                dfs(adj);
            }
        }

        //process vertex late
        System.out.println("");
    }

    public boolean isCycle() {
        for (int i = 0; i < g.totalVertices; i++) {
            parent[i] = -1;
            marked[i] = false;
            completed[i] = false; //used only for directed graphs
        }

        //finding cycles in all connected components
        for (int i = 0; i < g.totalVertices; i++) {

            if (!marked[i]) {
                if (g instanceof GraphUndirected) {
                    if (dfsWithCycleDetection(i)) {
                        return true;
                    }
                } else {
                    if (dfsWithCycleDetectionDG(i)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean dfsWithCycleDetection(int vertex) {
//        System.out.print(vertex + " ");

        marked[vertex] = true;
        for (int adj: g.getAdjacentVertices(vertex)) {

            if (!marked[adj]) {
                parent[adj] = vertex;
                if (dfsWithCycleDetection(adj)) {
                    return true;
                }
            } else if (adj != parent[vertex]) {
                //if it is already marked and if it is not parent, thats a back edge
                System.out.println("back edge" + adj);
                return true;
            }

        }

//        System.out.println("");
        return false;
    }

    private boolean dfsWithCycleDetectionDG(int vertex) {
//        System.out.print(vertex + " ");

        marked[vertex] = true;
        for (int adj: g.getAdjacentVertices(vertex)) {

            if (!marked[adj]) {
                parent[adj] = vertex;
                if (dfsWithCycleDetectionDG(adj)) {
                    return true;
                }
            } else if (!completed[adj]) {
                //if a node is marked but not completed, it means its a cycle
                //Going backwards in the parent array will gives us the cycle.
                int cycle = vertex;
                System.out.print("\nCycle: " + cycle + " ");
                while (cycle != adj) {
                    cycle = parent[cycle];
                    System.out.print(cycle + " ");
                }
                return true;
            }

        }
        completed[vertex] = true;

//        System.out.println("");
        return false;
    }
}
