/**
 * https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3348/
 */
public class DeleteNodeInLinkedList {

    // WTF?
    public void deleteNode(ListNode node) {

            node.val = node.next.val;
            node.next = node.next.next;

    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
