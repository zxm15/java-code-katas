/**
 * Created by ZXM on 11/20/15.
 */
public class TrieNode {
    TrieNode[] node;
    boolean isWord;
    //String word;

    public TrieNode() {
        node = new TrieNode[26];
        isWord = false;
    }
}
