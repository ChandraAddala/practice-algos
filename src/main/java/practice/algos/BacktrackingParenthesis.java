package practice.algos;


import java.util.ArrayList;
import java.util.List;

public class BacktrackingParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    private void backtrack(List<String> list, String s, int left, int right, int n) {
        if (left == n && right == n) {
            list.add(s);
            return;
        }

        if (left < n) {
            backtrack(list, s + "(", left + 1, right, n);
        }
        if (right < left) {
            backtrack(list, s + ")", left, right + 1, n);
        }
    }

    public static void main(String[] args) {
        BacktrackingParenthesis b = new BacktrackingParenthesis();
        System.out.println(b.generateParenthesis(3));
    }
}
