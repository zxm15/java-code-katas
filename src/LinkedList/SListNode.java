package LinkedList;

/**
 * Created by Gavin on 4/9/2015.
 */
public class SListNode {
    int val;
    SListNode next;
    public SListNode(int val) {
        this.val = val;
        next = null;
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

}
