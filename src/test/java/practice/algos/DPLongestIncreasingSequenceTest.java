package practice.algos;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class DPLongestIncreasingSequenceTest {

    @Test
    public void testGetLongestIncreasingSequence() {
        assertArrayEquals("", new int[]{3, 4, 6, 7}, DPLongestIncreasingSequence.getLongestIncreasingSequence(new int[]{5, 3, 4, 8, 6, 7}));
    }
}
