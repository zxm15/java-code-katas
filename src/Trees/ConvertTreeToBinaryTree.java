package Trees;

/**
 * Created by ZXM on 9/23/15.
 *1           1
 /|\         /
 2 3 4 ->    2
 / \  |      / \
 5   6 7     5   3
 \   \
 6   4
 /
 7

 */

/**analysis
 * clarification:
 * emtpy tree?
 * return null
 *
 *
 * pattern matching:
 * tree conversion problem has two key word
 * 1. recursive (bottom up - top bottom)
 * 2. each step
 *
 * algo:
 * in term of creating a tree, bottom up is more common.
 * At first thinking about it, use top bottom is easier. observer each step, assume others are done by bototm up
 *
 * for a node
 *  node.left = f(the first child of node)
 *  node.right = the second child of node;
 *  node.right.left = f(the first child of second child of node)
 *  node.right.right = third child of node;
 */
public class ConvertTreeToBinaryTree {
    public BTreeNode convertTreeToBinaryTreeRecurvise(Tree root) {
        if (root == null) return null;
        BTreeNode node = new BTreeNode(root.val);
        for (int i = 0; i < root.children.size(); i++) {
            Tree child = root.children.get(i);
            if (i == 0) {
                node.left = convertTreeToBinaryTreeRecurvise(child);
                node = node.left;
            } else {
                node.right = convertTreeToBinaryTreeRecurvise(child);
                node = node.right;
            }
        }

        return node;
    }
}

/**test
 * exmaple
 *
 */
