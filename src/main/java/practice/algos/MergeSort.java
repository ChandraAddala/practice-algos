package practice.algos;


public class MergeSort {

    public static void sort(int[] input) {
        if (input  == null || input.length <= 1) return;

        int[] tempArray = new int[input.length];
        mergeSort(input, 0, input.length - 1, tempArray);


    }

    public static void mergeSort(int[] input, int start, int end, int[] tempArray) {
        if (start < end) {
            System.out.println("sort start = " + start + " end=" + end);

            int middle = (start + end) / 2;
            mergeSort(input, start, middle, tempArray);
            mergeSort(input, middle + 1, end, tempArray);

            mergeParts(input, start, end, tempArray);
        }
    }

    /**
     * merge two sorted arrays
     */
    public static void mergeParts(int[] input, int start, int end, int[] tempArray) {
        System.out.println("merge start = " + start + " end=" + end);
        for (int i = start; i <= end; i ++) {
            tempArray[i] = input[i];
        }

        int left = start;
        int middle = (start + end) / 2;
        int right = middle + 1;
        int index = start;

        while (left <= middle && right <= end) {
            if (tempArray[left] < tempArray[right]) {
                input[index] = tempArray[left];
                left ++;
            } else {
                input[index] = tempArray[right];
                right ++;
            }
            index ++;
        }

        while (left <= middle) {
            input[index] = tempArray[left];
            left ++;
            index ++;
        }

        while (right <= end) {
            input[index] = tempArray[right];
            right ++;
            index ++;
        }

    }

    public static void print(int[] input) {
        for (int i: input) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        int[] input = {5, 2, 3, 4};
        print(input);
        MergeSort.sort(input);
        print(input);

    }

}


