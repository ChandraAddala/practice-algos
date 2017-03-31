package practice.algos;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

public class DPMinimumNumberOfCoinsTest {

    @Test
    public void testGetMinimumCoinsCount() {

        assertEquals("", 3, DPMinimumNumberOfCoins.getMinimumCoinsCount(new int[]{1, 3, 5}, 11));
        assertEquals("", 1, DPMinimumNumberOfCoins.getMinimumCoinsCount(new int[]{1, 3, 5}, 1));
        assertEquals("", 1, DPMinimumNumberOfCoins.getMinimumCoinsCount(new int[]{1, 3, 5}, 3));
        assertEquals("", 1, DPMinimumNumberOfCoins.getMinimumCoinsCount(new int[]{1, 3, 5}, 5));
        assertEquals("", 0, DPMinimumNumberOfCoins.getMinimumCoinsCount(new int[]{1, 3, 5}, 0));


    }

    @Test
    public void testGetMinimumNumberOfCoins() {

        assertArrayEquals("", new int[]{1, 5, 5}, DPMinimumNumberOfCoins.getMinimumNumberOfCoins(new int[]{1, 3, 5}, 11));
        assertArrayEquals("", new int[]{1}, DPMinimumNumberOfCoins.getMinimumNumberOfCoins(new int[]{1, 3, 5}, 1));
        assertArrayEquals("", new int[]{3}, DPMinimumNumberOfCoins.getMinimumNumberOfCoins(new int[]{1, 3, 5}, 3));
        assertArrayEquals("", new int[]{0}, DPMinimumNumberOfCoins.getMinimumNumberOfCoins(new int[]{1, 3, 5}, 0));


    }

}
