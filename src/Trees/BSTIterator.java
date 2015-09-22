package Trees;

import java.util.Iterator;
import java.util.Stack;

/**
 * Created by ZXM on 9/22/15.
 * Implement a bst in-order iterator, it will be used as following:
 * BSTIterator iter = new BSTIterator(root);
 * while (iter.hasNext())
 *  System.out.println(iter.next());
 *
 */

public class BSTIterator implements Iterator<BTreeNode> {
    Stack<BTreeNode> stack = new Stack<>();
    BTreeNode curr = null;
    public BSTIterator(BTreeNode root) {
        curr = root;
    }

    @Override
    public boolean hasNext() {
        return ! stack.isEmpty() || curr != null;
    }

    @Override
    public BTreeNode next() {
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
        BTreeNode node = stack.pop();
        curr = node.right;

        return node;
    }


}
