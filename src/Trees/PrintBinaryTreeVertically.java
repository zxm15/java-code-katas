package Trees;

import java.util.ArrayList;
import java.util.List;

/**
 *      1
 *    2   3
 *  4   5
 * 6  7
 *
 * for a binary tree, for all the nodes, its right children could either be a leaf node or null
 * print the tree so that it returns
 *
 * 6
 * 4
 * 2,7
 * 1,5
 * 3
 */
public class PrintBinaryTreeVertically {
    public List<List<Integer>> generateVerticalList(BTreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        int leftMostLevel = findLeftMostLevel(root);
        generateVerticalListHelper(root, leftMostLevel, res);

        return res;
    }

    private int findLeftMostLevel(BTreeNode node) {
        int level = -1;
        while (node != null) {
            level++;
            node = node.left;
        }

        return level;
    }

    private void generateVerticalListHelper(BTreeNode node, int index, List<List<Integer>> res) {
        if (node == null) return;
        res.get(index).add(node.val);
        generateVerticalListHelper(node.left, index + 1, res);
        generateVerticalListHelper(node.right, index - 1, res);
    }
}
/**
 test
 using example
 */