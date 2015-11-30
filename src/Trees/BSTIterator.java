package Trees;

import LinkedList.SListNode;

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

    public boolean hasPrev() {
        return ! stack.isEmpty() || curr != null;
    }

    public BTreeNode prev() {
        while (curr != null) {
            stack.push(curr);
            curr = curr.right;
        }
        BTreeNode node = stack.pop();
        curr = node.left;

        return node;
    }

    public void printForward() {
        while(hasNext()) {
            System.out.print(next().getVal());
        }
        System.out.println();
    }

    public void printBackword() {
        while (hasPrev()) {
            System.out.print(prev().getVal());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SListNode dummy = new SListNode(1);
        SListNode list = dummy.create(new int[] {1,2,3,4,5});
        BST bst = new BST(list);
        BSTIterator iterator = new BSTIterator(bst.getRoot());
//        iterator.printForward();
        iterator.printBackword();
//        bst.insert(10);
//        bst.delete(3);
//        //bst.delete(1);
//        System.out.println(bst.getRank(1));
//        System.out.println(bst.getRank(2));
//        System.out.println(bst.getRank(3));
//        System.out.println(bst.getRank(4));
//        System.out.println(bst.getRank(5));
//        System.out.println(bst.getRank(6));
//
//
////        bst.insert(10);
////        bst.delete(3);
////        bst.delete(1);
//        BSTIterator iterator = new BSTIterator(bst.getRoot());
//        iterator.print();


    }

}

