package linkedlist.medium;

/**
 * https://leetcode.com/problems/add-two-numbers/
 * See 415
 */
public class AddTwoNumbers_2 {

    // 12/09/2020 was quite painful, haven't read task properly
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode();
        ListNode prev = root;

        int sum = 0;
        while (l1 != null || l2 != null || sum > 0) {
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            prev.next = new ListNode(sum % 10);
            prev = prev.next;
            sum /= 10;
        }
        return root.next;
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
