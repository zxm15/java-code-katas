package Trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Gavin on 4/9/2015.
 */
public class BTreeNode {

    public int val;
    public BTreeNode left;
    public BTreeNode right;
    public BTreeNode parent;
    public int leftSubtreeSize;

    public BTreeNode(int value) {
        val = value;
        left = right = parent = null;
    }

    public BTreeNode createBTree(int n) {
        return createBST(-2 * n, n);

    }

    public BTreeNode createBST(int s, int e) {
        if (s > e) return null;
        int m = (s + e) / 2;
        BTreeNode root = new BTreeNode(m);
        root.left = createBST(s, m - 1);
        root.right = createBST(m + 1, e);
        return root;
    }

    public void printBTree(BTreeNode root) {
        if (root == null) return;
        printBTree(root.left);
        System.out.print(root.val + ",");
        printBTree(root.right);
    }

    public void printBTreeByLevel(BTreeNode root) {

        if (root == null) return;
        Queue<BTreeNode> queue = new LinkedList<BTreeNode>();
        queue.add(root);
        int count = 1;
        int nextCount = 0;
        while (!queue.isEmpty()) {
            BTreeNode n = queue.poll();
            count--;
            System.out.print(n.val + " ");
            if (n.left != null) {
                queue.add(n.left);
                nextCount++;
            }
            if (n.right != null) {
                nextCount++;
                queue.add(n.right);
            }
            if (count == 0) {
                System.out.println();
                count = nextCount;
                nextCount = 0;
            }
        }

    }



    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public BTreeNode getLeft() {
        return left;
    }

    public void setLeft(BTreeNode left) {
        this.left = left;
    }

    public BTreeNode getRight() {
        return right;
    }

    public void setRight(BTreeNode right) {
        this.right = right;
    }

    public BTreeNode getParent() {
        return parent;
    }

    public void setParent(BTreeNode parent) {
        this.parent = parent;
    }

    public static void main(String[] args) {
        BTreeNode obj = new BTreeNode(0);
        BTreeNode root = obj.createBTree(5);
        obj.printBTreeByLevel(root);
        obj.printBTree(root);
        BSTIterator iterator = new BSTIterator(root);
        System.out.println();
        while (iterator.hasNext()) {
            System.out.print(iterator.next().val + ",");
        }
        System.out.println();
    }
}
