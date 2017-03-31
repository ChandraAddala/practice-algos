package practice.algos;

public class DPFibonacci {

    /**
     * space complexity O(n);
     * time complexity O(n)
     *
     * @param n
     * @return
     */
    public static long fib(int n) {
        long[] mem = new long[n + 1];
        mem[0] = 0;
        mem[1] = 1;
        for (int i = 2; i <= n; i++) {
            mem[i] = -1;
        }

        return fibUsingMemoization(n, mem);

    }

    private static long fibUsingMemoization(int n, long[] mem) {
        if (mem[n] == -1)
            return mem[n] = fibUsingMemoization(n - 1, mem) + fibUsingMemoization(n - 2, mem);

        return mem[n];
    }

    /**
     * The best fibonacci algorithm with neither extra space nor recursion.
     *
     * @param n
     * @return
     */
    public static long fib_ulti(int n) {
        long prev1 = 1;
        long prev0 = 0;
        if (n == 1) return prev1;
        if (n == 0) return prev0;

        long result = 0;
        for (int i = 2; i <= n ; i++) {
            result = prev0 + prev1;
            prev0 = prev1;
            prev1 = result;
        }

        return result;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(fib(45));
        long end = System.currentTimeMillis();
        System.out.println("Total time:" + (end - start) + "milli secs");

        start = System.currentTimeMillis();
        System.out.println(fib_ulti(45));
        end = System.currentTimeMillis();
        System.out.println("Total time:" + (end - start) + "milli secs");
    }
}
