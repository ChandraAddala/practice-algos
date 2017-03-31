package practice.algos;


public class MedianSortedArrays {


    /**
     * Find kth element in two sorted arrays. (Not tested)
     * We are assuming nums1 has the smallest length of both. Our complexity would be O(length of nums1)
     */
    private static int kthElement(int[] A, int[] B, int k) {

        int begin = 0;
        int end = A.length - 1;

        while(begin < end) {
            int x = (begin + end) / 2;
            if ( A[x + 1] < B[k - x] ) {
                end = x - 1;
            } else if ( A[x] > B[k - x + 1] ) {
                begin = x + 1;
            } else {
                return Math.max(A[x], B[k-x]);
            }
        }

        return -1;
    }

    //incomplete
    private static double medianOfTwoSortedArrays(int[] nums1, int[] nums2) {

        int nums1Len = nums1.length;
        int nums2Len = nums2.length;

        //we want smallest array to be nums1. We are going for a complexity of log(n). If n is the min of two lenghts we get better performance.
        if (nums1.length < nums2.length) {
            medianOfTwoSortedArrays(nums1, nums2);
        }

        int nums1begin = 0;
        int nums1end = nums1.length;
        int k = (nums1.length + nums2.length - 1) / 2; //k is the index of the median (the reason for -1).

        //we choose midpoint of num1 repeatedly(binary search) to calibrate k - x.
        while (nums1begin < nums1end) {

            //chosing first x numbers from A and k - x numbers from B
            int mid1 = (nums1begin + nums1end) / 2; // middle of nums1
            int index2 = k - mid1;                  // index from nums2, k - x

            if (nums1[mid1] < nums2[index2]) {
                nums1begin = mid1 + 1;
            } else {
                nums1end = mid1;
            }
        }

        System.out.println("kth element" + " nums1begin=" + nums1[nums1begin]);
        return -1;

    }

    public static void main(String[] args) {
//        System.out.println(medianOfTwoSortedArrays(new int[]{1, 3}, new int[]{2}));
//        System.out.println(medianOfTwoSortedArrays(new int[]{1, 2}, new int[] {3, 4}));

        System.out.println(kthElement(new int[]{1, 2}, new int[] {3, 4}, 3));

    }
}
