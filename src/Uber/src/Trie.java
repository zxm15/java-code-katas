import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZXM on 11/20/15.
 */
public class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        if (word == null || word.length() == 0) return;
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (curr.node[index] == null) {
                curr.node[index] = new TrieNode();
            }
            curr = curr.node[index];
        }
        curr.isWord = true;
    }

    public TrieNode isPrefix(String prefix) {
        if (prefix == null || prefix.length() == 0) return null;
        TrieNode curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if (curr.node[index] == null) return null;
            curr = curr.node[index];
        }

        return curr;

    }


//
//    public boolean isWord(String word) {
//        if (word == null || word.length() == 0) return false;
//        TrieNode curr = root;
//        for (int i = 0; i < word.length(); i++) {
//            char ch = word.charAt(i);
//            int index = ch - 'a';
//            if (curr.node[index] == null) return false;
//            curr = curr.node[index];
//        }
//
//        return curr.isWord;
//    }

    public List<String> findAllWordsStartsWithPrefix(String prefix) {
        List<String> res = new ArrayList<>();
        TrieNode curr = isPrefix(prefix);
        if (curr == null) return res;
        List<String> suffixs = findAllSuffixs(curr);
        for (String suffix : suffixs) {
            res.add(prefix + suffix);
        }

        return res;
    }

    private List<String> findAllSuffixs(TrieNode node) {
        List<String> res = new ArrayList<>();
        findAllSuffixsHelper(node, new StringBuilder(), res);
        return res;
    }

    private void findAllSuffixsHelper(TrieNode currNode, StringBuilder sb, List<String> res) {
        if (currNode == null) return;
        if (currNode.isWord) {
            res.add(sb.toString());
        }
        for (int i = 0; i < currNode.node.length; i++) {
            TrieNode nextNode = currNode.node[i];
            if (nextNode == null) continue;
            char ch = (char) ('a' + i);
            sb.append(ch);
            findAllSuffixsHelper(nextNode, sb, res);
            sb.deleteCharAt(sb.length() - 1);

        }
    }

    public void printList(List<String> list) {
        if (list.size() == 0) System.out.println("The list is empty");
        else System.out.println(list);
    }
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.addWord("uber");
        trie.addWord("ubps");
        trie.addWord("unix");
        trie.addWord("university");

        TrieNode curr = trie.isPrefix("ub");
        System.out.println(curr.node['e' - 'a'] == null);
        System.out.println(curr.node['p' - 'a'] == null);
        System.out.println(curr.node['w' - 'a'] == null);

       // System.out.println(trie.isPrefix("ub");

        List<String> list = trie.findAllWordsStartsWithPrefix("ub");
        trie.printList(list);
        trie.printList(trie.findAllWordsStartsWithPrefix("u"));
        trie.printList(trie.findAllWordsStartsWithPrefix("a"));

    }
}
