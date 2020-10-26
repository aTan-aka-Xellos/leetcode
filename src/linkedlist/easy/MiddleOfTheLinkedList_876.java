package linkedlist.easy;

/**
 * https://leetcode.com/problems/middle-of-the-linked-list/submissions/
 */
public class MiddleOfTheLinkedList_876 {

    // 10/26/2020
    public ListNode middleNode(ListNode slow) {
        ListNode fast = slow;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
