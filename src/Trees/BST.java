package Trees;

import LinkedList.SListNode;

import java.util.List;

/**
 * Created by ZXM on 11/15/15.
 * We are going to create a BST with rank. Duplicate key is not allowed in the BST
 */

public class BST {
    private BTreeNode root;
    private SListNode curr;

    public BST(SListNode list) {
        root = createBSTByList(list);
    }

    private BTreeNode createBSTByList(SListNode list) {
        curr = list;
        return createBSTByList(0, list.size() - 1);
    }

    private BTreeNode createBSTByList(int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        BTreeNode leftTree = createBSTByList(start, mid - 1);
        BTreeNode node = new BTreeNode(curr.getVal());
        node.leftSubtreeSize = mid - start; //this is for leftTreeSize
        node.left = leftTree;
        curr = curr.getNext();
        node.right = createBSTByList(mid + 1, end);

        return node;
    }

    public void insert(int num) {
        if (root == null) {
            root = new BTreeNode(num);
            return;
        }
        insert(root, num);
    }

    private void insert(BTreeNode node, int num) {

        if (node.left == null && node.right == null) {
            if (num < node.val) {
                node.left = new BTreeNode(num);
                node.leftSubtreeSize++;

            } else {
                node.right = new BTreeNode(num);

            }
            return;
        }
        if (node.val == num) return;
        if (node.val > num) {
            node.leftSubtreeSize++;
            insert(node.left, num);
        }
        else insert(node.right, num);

    }

    public boolean search(int num) {
        if (root == null) return false;
        return search(root, num);
    }

    private boolean search(BTreeNode node, int num) {
        if (node == null) return false;
        if (node.val == num) return true;
        if (node.val > num) return search(node.left, num);
        else return search(node.right, num);
    }

    public boolean delete(int num) {
        if (root == null) return false;
        return delete(root, num, null);
    }

    private boolean delete(BTreeNode node, int num, BTreeNode parent) {
        if (node == null) return false;
        if (node.val > num) {
             if(delete(node.left, num, node)) {
                 node.leftSubtreeSize--;
                 return true;
             }
            return false;
        }
        else if (node.val < num) return delete(node.right, num, node);
        else {
            if (node.left == null && node.right == null) {
                if (parent.left == node) parent.left = null;
                else parent.right = null;
                return true;
            } else if (node.left != null) {
                BTreeNode rightMostNode = findFurthestPathNode(node.left, false);
                swap(rightMostNode, node);
                return delete(node.left, num, node);
            } else {
                BTreeNode leftMostNode = findFurthestPathNode(node.right, true);
                swap(leftMostNode, node);
                return delete(node.right, num, node);
            }
        }
    }

    private void swap(BTreeNode a, BTreeNode b) {

        int temp = a.val;
        a.val = b.val;
        b.val = temp;
        temp = a.leftSubtreeSize;
        a.leftSubtreeSize = b.leftSubtreeSize;
        b.leftSubtreeSize = temp;

    }

    private BTreeNode findFurthestPathNode(BTreeNode node, boolean isLeft) {
        if (isLeft) {
            while (node.left != null) {
                node = node.left;
            }
        } else {
            while (node.right != null) {
                node = node.right;
            }
        }

        return node;
    }


    //If the num does not exist in the bst, return -1;
    public int getRank(int num) {
        if (root == null) return -1;
        return getRank(root, num);
    }

    private int getRank(BTreeNode node, int num) {
        if (node == null) return -1;
        if (node.val == num) return node.leftSubtreeSize + 1;
        if (node.val > num) return getRank(node.left, num);
        else {
            int value = getRank(node.right, num);
            if (value == -1) return -1;
            return node.leftSubtreeSize + 1 + value;
        }

    }


    public BTreeNode getRoot() {
        return root;
    }

    public void setRoot(BTreeNode root) {
        this.root = root;
    }
}
