package Trees;

/**
 * Created by ZXM on 8/7/15.
 * Build a trie tree or prefix tree
 */
public class Trie {

    private static final int CHAR_SIZE = 256;

    private class TrieNode {
        TrieNode[] next;
        String word;
        public TrieNode() {
            next = new TrieNode[CHAR_SIZE];
            word = "";
        }
    }

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(String str) {
        //if (root == null) root == new TrieNode();
        if (str == null || str.length() == 0) return;
        insert(root, str);
    }

    public void insert(TrieNode node, String str) {

        final int n = str.length();
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            int index = ch - 'a';
            if (node.next[index] == null) {
                node.next[index] = new TrieNode();
            }
            node = node.next[index];
        }
        node.word = str;
    }

    public boolean searchPrefix(String str) {
        if (str == null || str.length() == 0) return false;
        return searchPrefix(root, str);
    }

    public boolean searchPrefix(TrieNode node, String str) {
        int n = str.length();
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            int index = ch - 'a';
            if (node.next[index] == null) return false;
            node = node.next[index];
        }
        return true;
    }

    public boolean searchWord(String str) {
        if (str == null || str.length() == 0) return false;
        return searchWord(root, str);

    }

    public boolean searchWord(TrieNode node, String str) {
        int n = str.length();
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            int index = ch - 'a';
            if (node.next[index] == null) return false;
            node = node.next[index];
        }
        return node.word.equals(str);
    }

    /**
     * deleting word does not make much sense
     * @param str
     * @return true if success or false if failed
     */
    public boolean deletePrefix(String str) {
        if (str == null || str.length() == 0) return false;
        return deletePrefix(root, str, 0);
    }

    public boolean deletePrefix(TrieNode node, String str, int index) {
        if (index == str.length()) {
            return true;
        }
        char ch = str.charAt(index);
        if (node.next[ch - 'a'] == null) return false;
        if (! deletePrefix(node.next[ch - 'a'], str, index + 1)) return false;
        node.next[ch - 'a'] = null;
        return true;
    }

}
