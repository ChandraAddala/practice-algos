package practice.algos;

import java.util.ArrayList;
import java.util.List;

public class DPMinimumNumberOfCoins {

    /**
     * Get minimum number of coins required for a given sum.
     *
     * @param coins
     * @param sum
     * @return
     */
    public static int getMinimumCoinsCount(int[] coins, int sum) {

        int[] minimumNumberOfCoins = new int[sum + 1];
        int[] lastCoinUsed = new int[sum + 1];

        computeMinimumCoins(coins, sum, minimumNumberOfCoins, lastCoinUsed);

        return minimumNumberOfCoins[sum];
    }

    public static int[] getMinimumNumberOfCoins(int[] coins, int sum) {

        int[] minimumNumberOfCoins = new int[sum + 1];
        int[] lastCoinUsed = new int[sum + 1];

        computeMinimumCoins(coins, sum, minimumNumberOfCoins, lastCoinUsed);

        if (minimumNumberOfCoins[sum] > 0) {
            int[] output = new int[minimumNumberOfCoins[sum]];
            int i = sum, j = 0;
            while (lastCoinUsed[i] > 0) {
                output[j++] = lastCoinUsed[i];
                i = i - lastCoinUsed[i];
            }

            return output;
        } else {
            return new int[]{0};
        }

    }

    /**
     * This logic is as follows
     * 1) minimumNumberOfCoins contains the minimum number of coins for sums ranging from 0 to sum.
     * 2) As we construct minimumNumberOfCoins, we make sure that for any sum, we always update this array with the minimum number of coins required for that sum
     * 3) To compute minimumNumberOfCoins[i] with available coins c1, c2, c3, we just have to pick the
     *    minimum of (minimumNumberOfCoins[i - c1], minimumNumberOfCoins[i - c2], minimumNumberOfCoins[i - c3]) + 1
     * 4) We also update the coin (c1, c2 or c3) that was responsible for the minimum computed above, to return the coins corresponding to a sum in lastCoinUsed array.
     *
     * @param coins
     * @param sum
     * @param minimumNumberOfCoins
     * @param lastCoinUsed
     */
    private static void computeMinimumCoins(int[] coins, int sum, int[] minimumNumberOfCoins, int[] lastCoinUsed) {

        for (int i = 0; i <= sum; i ++) {
            minimumNumberOfCoins[i] = Integer.MAX_VALUE; //TODO: boundary condition
        }

        minimumNumberOfCoins[0] = 0; //we need 0 coins for 0 sum
        lastCoinUsed[0] = 0; //we need 0 coins for 0 sum
        for (int i = 1; i <= sum; i ++) {

            for (int j = 0; j < coins.length; j ++) {

                if (i - coins[j] >= 0 && minimumNumberOfCoins[i - coins[j]] + 1 < minimumNumberOfCoins[i]) {
                    minimumNumberOfCoins[i] = minimumNumberOfCoins[i - coins[j]] + 1;
                    lastCoinUsed[i] = coins[j];
                }
            }

        }
    }

}
