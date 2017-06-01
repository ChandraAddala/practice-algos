package practice.algos;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class QuickSort {

    public static int[] sort(int[] input) {
        List<Integer> inputList = Arrays.stream(input)
                                        .boxed()
                                        .collect(Collectors.toList());

        Collections.shuffle(inputList);
        int[] shuffledInput = inputList.stream().mapToInt(i -> i).toArray();
        System.out.println(Arrays.toString(shuffledInput));

        quickSort(shuffledInput, 0, input.length - 1);

        return shuffledInput;
    }

    private static void quickSort(int[] input, int left, int right) {
        if ( left >= right ) return;

        System.out.println("left=" + left + " right=" + right);

        int partitionIndex = partition(input, left, right);

        quickSort(input, left, partitionIndex - 1);
        quickSort(input, partitionIndex + 1, right);
    }


    private static int partition(int[] input, int left, int right) {

        int pivot = left; //After we partition pivot will go to the correct sorted location.

        while (true) {
            while (input[left] < input[pivot]) {
                left++;
                if (left > right) break;   //to make sure we dont cross the boundary
            }
            while (input[right] > input[pivot]) {
                right--;
                if (left > right) break;   //to make sure we dont cross the boundary
            }

            if (left >= right) break;

            swap(input, left, right);

        }
        swap(input, pivot, right);          //swap with partioning item

        System.out.println("pivot=" + input[pivot] + " right=" + right + " " + Arrays.toString(input));
        return right;
    }

    public static int findKthLargest(int[] nums, int k) {
        System.out.println("Finding kth largest, k=" + k);

        if (nums == null || nums.length == 0) return -1;
        if (k < 0 && k > nums.length - 1) return -1;
        if (nums.length == 1) return nums[0];

        int left = 0, right = nums.length - 1;


        int partitionIndex = nums.length;

        while (true) {

            if (partitionIndex > k) {
                partitionIndex = partition(nums, left, partitionIndex - 1);
            } else if (partitionIndex < k) {
                partitionIndex = partition(nums, partitionIndex + 1, right);
            } else {
                return nums[partitionIndex];
            }

        }
    }


    private static void swap(int[] input, int i, int j) {
        int temp = input[j];
        input[j] = input[i];
        input[i] = temp;
    }

    public static void main(String[] args) {
        int[] input = {5,3,6,2,-1,8,1};

//        System.out.println(Arrays.toString(QuickSort.sort(input)));
//
//        System.out.println(QuickSort.findKthLargest(input, 4));

//        System.out.println(Arrays.toString(QuickSort.sort(new int[]{1, 2})));
        System.out.println(QuickSort.findKthLargest(new int[]{1, 2}, 1));
    }
}
