package LinkedList;

/**
 * Created by Gavin on 4/9/2015.
 */
public class SListNode {
    public int val;
    public SListNode next;
    public SListNode(int val) {
        this.val = val;
        next = null;
    }

    public SListNode create(int[] arr) {
        SListNode dummy = new SListNode(0);
        SListNode curr = dummy;
        for (int i = 0; i < arr.length; i++) {
            curr.next = new SListNode(arr[i]);
            curr = curr.next;
        }

        return dummy.next;
    }
    public int size() {
        int count = 0;
        SListNode curr = this;
        while(curr != null) {
            curr = curr.next;
            count++;
        }
        return count;
    }

    public int getVal() {
        return val;
    }

    public SListNode getNext() {
        return next;
    }

    public void setNext(SListNode next) {
        this.next = next;
    }

    public void setVal(int val) {
        this.val = val;
    }
}
