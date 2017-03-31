package practice.algos;

import org.junit.Test;
import practice.algos.ds.DFS;
import practice.algos.ds.GraphDirected;
import practice.algos.ds.GraphTest;
import practice.algos.ds.TopologicalSort;

import java.io.InputStream;
import java.util.Stack;

import static org.junit.Assert.assertFalse;

public class TopologicalSortTest {

    @Test
    public void testCycleDAG() {
        InputStream in = GraphTest.class.getClassLoader()
                .getResourceAsStream("tinyDAG.txt");

        GraphDirected g = new GraphDirected(in);
        TopologicalSort topologicalSort = new TopologicalSort(g);

        DFS dfs = new DFS(g);
        assertFalse(dfs.isCycle());

        Stack<Integer> stack = topologicalSort.tsort();

        System.out.println("\nTopological sort: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDGWithCycle() {
        InputStream in = GraphTest.class.getClassLoader()
                .getResourceAsStream("tinyDG.txt");

        GraphDirected g = new GraphDirected(in);
        TopologicalSort topologicalSort = new TopologicalSort(g);

        topologicalSort.tsort();
    }

    @Test
    public void testCycleDAG1() {
        InputStream in = GraphTest.class.getClassLoader()
                .getResourceAsStream("courseScheduleDAG.txt");

        GraphDirected g = new GraphDirected(in);
        TopologicalSort topologicalSort = new TopologicalSort(g);

        DFS dfs = new DFS(g);
        assertFalse(dfs.isCycle());

        Stack<Integer> stack = topologicalSort.tsort();

        System.out.println("\nTopological sort: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
