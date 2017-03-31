package practice.algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BackTrackCombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();

        Arrays.sort(candidates); //to help with duplicates
        backtrack(candidates, target, output, new ArrayList<Integer>(), 0);

        return output;
    }

    private void backtrack(int[] candidates, int target, List<List<Integer>> output, List<Integer> path, int position) {
        // System.out.println("target=" + target + " position=" + position + " path=" + path);
        if (target == 0) {
            output.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = position; i < candidates.length && candidates[i] <= target; i++) {
            path.add(candidates[i]);
            backtrack(candidates, target - candidates[i], output, path, i + 1);
            path.remove(path.size() -1);
            while (i + 1 < candidates.length && candidates[i] == candidates[i+1]) i++; //eliminating duplicates

        }
    }

}