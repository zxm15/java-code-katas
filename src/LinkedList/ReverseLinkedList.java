package LinkedList;

/**
 * Created by zxm on 11/7/15.
 * Reverse a linked list in one pass and in place (two pointers)
 * follow up: can you return a copy of the list without changing the structure of the old one (backtracking)
 *
 */
public class ReverseLinkedList {
    private SListNode reversedListTail;

    public SListNode reverseCopy(SListNode list) {
        if (list == null) return null;
        reversedListTail = new SListNode(0);
        SListNode reversedListHead = reversedListTail;
        reverseCopyHelper(list);
        return reversedListHead.next;
    }

    public void reverseCopyHelper(SListNode list) {
        if (list == null) return;
        reverseCopyHelper(list.next);
        SListNode node = new SListNode(list.val);
        reversedListTail.next = node;
        reversedListTail = node;
    }

    public static void main(String[] args) {
        ReverseLinkedList solution = new ReverseLinkedList();
        SListNode list = new SListNode(1);
        list.next = new SListNode(2);
        list.next.next = new SListNode(3);
        list.print();
        solution.reverseCopy(list).print();

    }

}
