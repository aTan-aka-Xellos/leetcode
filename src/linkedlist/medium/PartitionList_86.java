package linkedlist.medium;

/**
 * https://leetcode.com/problems/partition-list/
 */
public class PartitionList_86 {

    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode leftDummy = new ListNode(), rightDummy = new ListNode();
        ListNode left = leftDummy, right = rightDummy;

        while (head != null) {
            if (head.val < x) {
                left.next = head;
                left = left.next;
            } else {
                right.next = head;
                right = right.next;
            }
            head = head.next;
        }
        right.next = null;
        left.next  = rightDummy.next;
        return leftDummy.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
    }
}
