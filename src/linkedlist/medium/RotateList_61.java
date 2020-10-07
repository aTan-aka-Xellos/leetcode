package linkedlist.medium;

/**
 * https://leetcode.com/problems/rotate-list/
 *
 * Second cycle was problematic to come up without mistakes.
 */
public class RotateList_61 {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;

        int length = 1;
        ListNode node = head;
        ListNode last = head;

        while (last.next != null) {
            length++;
            last = last.next;
        }

        for (int i = 1; i < length - (k % length); i++) node = node.next;

        last.next = head;
        head = node.next;
        node.next = null;

        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
