package linkedlist.easy;

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 * https://leetcode.com/explore/featured/card/recursion-i/250/principle-of-recursion/1681/
 */
public class SwapNodesInPairs_24 {

    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode temp = head;
        head = head.next;
        temp.next = head.next;
        head.next = temp;

        head.next.next = swapPairs(head.next.next);
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
