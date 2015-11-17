package Trees;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by ZXM on 11/16/15.
 *
 * The key is to handle null, print # when we met a null position
 * use preorder is good.
 *
 *      3
 *     3
 *  3,3,#,#,#
 *
 *      3
 *       3
 *  3,#,3,#,#
 */
public class SerilizedBinaryTree {

    public String serialize(BTreeNode node) {
        StringBuilder sb = new StringBuilder();
        serialize(node, sb);

        return sb.substring(0, sb.length() - 1).toString();
    }

    private void serialize(BTreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("#");
            sb.append(",");
            return;
        }
        sb.append(node.val);
        sb.append(",");
        serialize(node.left, sb);
        serialize(node.right, sb);
    }

    public BTreeNode deserialize(String str) {
        str = str.trim();
        String[] strs = str.split(",");
        return deserialize(strs, new int[] {0});
    }

    private BTreeNode deserialize(String[] strs, int[] index) {
        if (index[0] == strs.length || strs[index[0]].equals("#")) {
            index[0]++;
            return null;
        }
        BTreeNode node = new BTreeNode(Integer.parseInt(strs[index[0]++]));
        node.left = deserialize(strs, index);
        node.right = deserialize(strs, index);

        return node;
    }

    public boolean hasDupSubtrees(BTreeNode node) {
        if (node == null) return false;
        //two steps: 1. get serialized tree for each subtree, 2. use hashset to find duplicates
        Map<BTreeNode, String> map = new HashMap<>();
        serializeSubTree(node, map);
        return hasDuplicateTree(map);
    }

    public String serializeSubTree(BTreeNode node, Map<BTreeNode, String> map) {
        if (node == null) {
            return "#";
        }
        String leftTree = serializeSubTree(node.left, map);
        String rightTree = serializeSubTree(node.right, map);
        String str = node.val + leftTree + rightTree;  //this is the key to convert postOrder to preOrder
        map.put(node, str);

        return str;
    }

    private boolean hasDuplicateTree(Map<BTreeNode, String> map) {
        Set<String> set = new HashSet<>();
        for (String str : map.values()) {
            if (set.contains(str)) return true;
        }

        return false;
    }




}
