package Trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Gavin on 4/9/2015.
 */
public class BTreeNode {

        int val;
        BTreeNode left;
        BTreeNode right;
        BTreeNode parent;

        public BTreeNode(int value)
        {
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
            System.out.print(root.val);
            printBTree(root.right);
        }

        public void printBTreeByLevel(BTreeNode root) {

            if (root == null) return;
            Queue<BTreeNode> queue = new LinkedList<BTreeNode>();
            queue.add(root);
            int count = 1;
            int nextCount = 0;
            while (! queue.isEmpty()) {
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

        public static void main(String[] args) {
            BTreeNode obj = new BTreeNode(0);
            BTreeNode root = obj.createBTree(5);
            obj.printBTreeByLevel(root);
        }
}
