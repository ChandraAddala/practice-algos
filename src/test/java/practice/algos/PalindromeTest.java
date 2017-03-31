package practice.algos;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PalindromeTest {

    @Test
    public void isPalindrome() {
        assertEquals("Empty string", true, Palindrome.isPalindrome(""));
        assertEquals("string length=1", true, Palindrome.isPalindrome("a"));
        assertEquals("string length=2 non pal", false, Palindrome.isPalindrome("ab"));
        assertEquals("string length=2 pal", true, Palindrome.isPalindrome("aa"));
        assertEquals("string non-pal1", false, Palindrome.isPalindrome1("aa1"));
        assertEquals("string non-pal2", false, Palindrome.isPalindrome1("1aa"));
        assertEquals("string same char", true, Palindrome.isPalindrome("aaaaaaaaa"));
        assertEquals("string even length", true, Palindrome.isPalindrome("abaaba"));
        assertEquals("string odd length", true, Palindrome.isPalindrome("ababa"));
    }

    @Test
    public void isPalindrome1() {
        assertEquals("Empty string", true, Palindrome.isPalindrome1(""));
        assertEquals("string length=1", true, Palindrome.isPalindrome1("a"));
        assertEquals("string length=2 non pal", false, Palindrome.isPalindrome1("ab"));
        assertEquals("string length=2 pal", true, Palindrome.isPalindrome1("aa"));
        assertEquals("string non-pal1", false, Palindrome.isPalindrome1("aa1"));
        assertEquals("string non-pal2", false, Palindrome.isPalindrome1("1aa"));
        assertEquals("string same char", true, Palindrome.isPalindrome1("aaaaaaaaa"));
        assertEquals("string even length", true, Palindrome.isPalindrome1("abaaba"));
        assertEquals("string odd length", true, Palindrome.isPalindrome1("ababa"));
    }
}
