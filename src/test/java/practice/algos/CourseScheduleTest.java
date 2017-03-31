package practice.algos;


import org.junit.Test;
import practice.algos.ds.CourseScheduleDFS;

import static org.junit.Assert.assertTrue;

public class CourseScheduleTest {


    @Test
    public void test() {
        CourseScheduleDFS c = new CourseScheduleDFS();
        assertTrue(c.canFinish(2,new int[][]{{1,0}}));
    }
}
