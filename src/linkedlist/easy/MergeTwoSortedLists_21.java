package linkedlist.easy;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists
 * Time complexity: O(N)
 * Space complexity: O(1)
 */
public class MergeTwoSortedLists_21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode root = null, current = new ListNode(0);

        while (l1 != null || l2 != null) {
            if (l2 == null || (l1 != null && l1.val < l2.val)) {
                current.next = l1;
                l1 = l1.next;
            } else  {
                current.next = l2;
                l2 = l2.next;
            }
            if (root == null) root = current.next;
            current = current.next;
        }
        return root;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
