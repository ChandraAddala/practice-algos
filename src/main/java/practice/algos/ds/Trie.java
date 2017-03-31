package practice.algos.ds;

public class Trie {

    private static class TrieNode {
        private TrieNode[] children = new TrieNode[26]; //if we need to support unicode, use Map<Character, TreeNode>
        boolean isCompleteWord;
    }

    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    /**
     * O(n) to insert, n being size of word.
     *
     * Inserts a word into the trie
     * @param word
     */
    public void insert(String word) {
        TrieNode node = root;
        for (char character: word.toCharArray()) {
            if (node.children[character - 'a'] == null) {
                node.children[character - 'a'] = new TrieNode();
            }
            node = node.children[character - 'a'];
        }
        node.isCompleteWord = true;
    }

    /**
     * O(n) to check if word exists
     *
     * @param word
     * @return true if the given word is in the trie.
     */
    public boolean isWord(String word) {
        TrieNode node = root;
        for (char character: word.toCharArray()) {
            node = node.children[character - 'a'];
            if (node == null) return false;
        }
        return node.isCompleteWord;
    }

    /**
     * O(n) to startsWith prefix
     *
     * @param prefix
     * @return true if there is a word starting with the given prefix
     */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char character: prefix.toCharArray()) {
            node = node.children[character - 'a'];
            if (node == null) return false;
        }
        return true;
    }

}
