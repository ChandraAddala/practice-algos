package practice.algos;

public class DPLongestIncreasingSequence {


    public static int[] getLongestIncreasingSequence(int[] input) {

        int[] maxSeqCount = new int[input.length];
        int[] maxSeqTracker = new int[input.length];

        maxSeqCount[0] = 1;
        maxSeqTracker[0] = 0;

        int maxCount = 1;
        int maxCountLastIndex = 0;
        for (int i = 1; i < input.length; i ++ ) {

            maxSeqCount[i] = 1;
            for (int j = i - 1; j >= 0; j--) {

                if (input[i] > input[j] && maxSeqCount[j] + 1 > maxSeqCount[i]) {

                    maxSeqCount[i] = maxSeqCount[j] + 1;
                    maxSeqTracker[i] = j;
                    if (maxCount < maxSeqCount[i]) {
                        maxCount = maxSeqCount[i];
                        maxCountLastIndex = i;
                    }
                }
            }
        }

        if (maxCount > Integer.MIN_VALUE) {
            int[] output = new int[maxCount];

            int i = maxCount - 1;
            while (maxCountLastIndex > 0) {
                output[i--] = input[maxCountLastIndex];
                maxCountLastIndex = maxSeqTracker[maxCountLastIndex];
            }

            return output;
        }

        return new int[]{};
    }
}
