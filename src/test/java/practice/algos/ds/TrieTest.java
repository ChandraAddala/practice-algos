package practice.algos.ds;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TrieTest {

    @Test
    public void addOneWord() {
        Trie trie = new Trie();
        String word = "apple";
        trie.insert(word);

        assertTrue(trie.isWord(word));

        assertFalse(trie.isWord(word.substring(0, 3)));
        assertTrue(trie.startsWith(word.substring(0, 3)));
    }

    @Test
    public void addMultipleWord() {
        Trie trie = new Trie();
        trie.insert("abc");
        trie.insert("abgl");
        trie.insert("cdf");
        trie.insert("abcd");
        trie.insert("lmn");

        assertTrue(trie.startsWith("ab"));
        assertFalse(trie.startsWith("lo"));

        assertTrue(trie.isWord("lmn"));
        assertTrue(trie.isWord("cdf"));

        assertFalse(trie.isWord("ab"));
        assertFalse(trie.isWord("ghi"));
    }
}
