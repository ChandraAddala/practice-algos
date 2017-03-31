package practice.algos;

import java.util.Arrays;

public class NegativeAndPositive {


    public static void arrange(int[] input) {

        int i, j ,k;
        for (i = 0; i < input.length; i++) {

            if (input[i] < 0) continue;

            for (j = i; j < input.length; j++) {
                if (input[j] >= 0) continue;
                break;
            }

            if (j < input.length) {

                int temp = input[j];
                for (k = j; k > i; k --) {
                    input[k] = input[k-1];
                }
                input[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] input = {-1, -2, -3, 9, 8, -4, 7, 6, -5};
        arrange(input);

        System.out.println(Arrays.toString(input));

        int[] input1 = {-1, -2, -3, -4, -5};
        arrange(input1);

        System.out.println(Arrays.toString(input1));

        int[] input2 = {1, 2, 3, 4, 5, -6};
        arrange(input2);

        System.out.println(Arrays.toString(input2));

        int[] input3 = {0, 0, -1};
        arrange(input3);

        System.out.println(Arrays.toString(input3));
    }
}
