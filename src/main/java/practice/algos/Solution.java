package practice.algos;

import java.util.*;

public class Solution {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        if (k == 1) return nums;

        Deque<Integer> queue = new LinkedList<>();

        int count = 0;
        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            System.out.println(Arrays.toString(queue.toArray()));
            //removing elements out of the window
            if (!queue.isEmpty() && queue.peek() < i - k + 1) {
                queue.poll(); //FIFO
            }

            //Remove elements smaller than the newly added element.
            //This leaves the maximum for that windown as the head element
            while (!queue.isEmpty() && nums[queue.peek()] < nums[i] ) {
                // queue.poll();
                System.out.println(nums[queue.poll()]);
            }

            queue.offer(i);

            if (i >= k - 1) {
                result[count++] = nums[queue.peek()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution.maxSlidingWindow(new int[] {1,3,1,2,0,5}, 3);
    }
}
