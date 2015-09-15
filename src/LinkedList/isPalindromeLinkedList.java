package LinkedList;

/**
 * Created by Gavin on 4/9/2015.
 * Given a singly linked list, determine if it is a palindrome in O(n) time and O(1) space.
 * This question expose my shallow understanding of how recursion store variables.
 */
public class isPalindromeLinkedList {
    /* This method does not work because the right pointer's address will be reset back to recursion stored address.
    class Wrapper {
        boolean reachEnd = false;
        boolean isPalindrome = false;
    }
    public boolean isPalindrome(SListNode node) {
        if(node == null) return true;
        Wrapper res = new Wrapper();
        isPalindromeHelper(node, node, res);
        return res.isPalindrome;
    }

    public void isPalindromeHelper(SListNode left, SListNode right, Wrapper res) {
        if(!res.reachEnd && (right == null || right.next == null)) {
            if(right == null ) right = left;
            else if(right.next == null) right = left.next;
            res.reachEnd = true;
            res.isPalindrome = true;
            return;
        }
        isPalindromeHelper(left.next, right.next.next, res);
        if(res.isPalindrome == false) return;
        if(left.val != right.val) {
            res.isPalindrome = false;
            return;
        }
        right = right.next;
    }*/

    class Wrapper{
        SListNode node;
        boolean isPalindrome;
        public Wrapper(SListNode node, boolean isPalindrome) {
            this.node = node;
            this.isPalindrome = isPalindrome;
        }
    }
    public boolean isPalindrome(SListNode node) {
        Wrapper res = isPalindromeHelper(node, node.size());
        return res.isPalindrome;
    }

    private Wrapper isPalindromeHelper(SListNode curr, int len) {
        if(len == 0) return new Wrapper(curr, true);
        if(len == 1) return new Wrapper(curr.next, true);
        Wrapper res = isPalindromeHelper(curr.next, len - 2);
        if(res.isPalindrome && curr.val == res.node.val) res.node = res.node.next;
        else if(res.isPalindrome && curr.val != res.node.val) res.isPalindrome = false;
        return res;
    }

    public static void main(String[] args) {
        SListNode node = new SListNode(2);
        node.next = new SListNode(1);
        node.next.next = new SListNode(3);
        //node.next.next.next = new SListNode(2);
        isPalindromeLinkedList list = new isPalindromeLinkedList();
        boolean res = list.isPalindrome(node);
        System.out.println(res);
    }
}
