package practice.algos;


import java.util.ArrayList;
import java.util.List;

public class Permutation {

    public String getPermutation(int n, int k) {
        List<String> sequences = new ArrayList<String>();
        Integer count = 1;
        return backtrack(n, k, sequences, "", count);
        // return sequences.get(k - 1);
    }

    private String backtrack(int n, int k, List<String> sequences, String sequence, Integer count) {
        if (sequence.length() == n) {
            System.out.println(sequence);
            // sequences.add(sequence);
            count++;
            return sequence;
        }

        for (int i = 1; i <= n; i++) {
            String sequence1 = null;
            if (sequence.indexOf("" + i) < 0) {
                sequence1 = backtrack(n, k, sequences, sequence + i, count);
            }
            if (count == k) return sequence1;
        }

        return "";
    }

    public static void main(String[] args) {
        Permutation p = new Permutation();
        System.out.println(p.getPermutation(3, 6));
    }
}