package practice.algos;


public class Palindrome {


    public static boolean isPalindrome(String s) {

        if (s == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        int left = 0, right = s.length() - 1;

        while (left < right) {

            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isPalindrome1(String s) {

        if (s == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        int left = s.length() / 2 - 1, right = s.length() % 2 == 0 ? s.length() / 2 : s.length() / 2 + 1;

        while (left >= 0 && right < s.length()) {

            if (s.charAt(left) != s.charAt(right)) {
                return false;
            } else {
                left--;
                right++;
            }
        }

        return true;
    }
}
