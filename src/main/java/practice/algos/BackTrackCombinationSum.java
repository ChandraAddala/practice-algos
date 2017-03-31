package practice.algos;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BackTrackCombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();

        Arrays.sort(candidates);
        backtrack(candidates, target, output, new ArrayList<Integer>(), 0);

        return output;
    }

    private void backtrack(int[] candidates, int target, List<List<Integer>> output, List<Integer> path, int position) {
        // System.out.println("target=" + target + " path=" + path);
        if (target == 0) {
            output.add(new ArrayList<Integer>(path));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = position; i< candidates.length && candidates[i] <= target; i++) {
            path.add(candidates[i]);
            backtrack(candidates, target - candidates[i], output, path, i);
            path.remove(path.size() - 1);
        }
    }

}