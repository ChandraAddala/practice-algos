package practice.algos.ds;


public class CourseScheduleDFS {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] marked = new boolean[numCourses];
        boolean[] completed = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!marked[i])
                if (isCycle(i, numCourses, prerequisites, marked, completed)) {
                    return false;
                }
        }

        return true;
    }

    private boolean isCycle(int vertex, int numCourses, int[][] prerequisites, boolean[] marked, boolean[] completed) {
        System.out.print(vertex + " ");
        marked[vertex] = true;

        for (int i = 0; i< prerequisites.length; i++) {
            if (prerequisites[i][0] == vertex) {
                if (!marked[vertex]) {
                    if (isCycle(prerequisites[i][1], numCourses, prerequisites, marked, completed)) {
                        return true;
                    }
                } else if (!completed[prerequisites[i][1]]) {
                    System.out.println("cycle detected" + vertex);
                    return true;
                }
            }
        }
        System.out.println("");
        completed[vertex] = true;
        return false;
    }
}
