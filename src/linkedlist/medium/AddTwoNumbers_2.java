package linkedlist.medium;

/**
 * https://leetcode.com/problems/add-two-numbers/
 * See 415
 */
public class AddTwoNumbers_2 {

    // 01/13/2021
    // Issues:
    // - tried to write from the memory (and remembered it wrong)
    // - forgot the corner case with null.next when call recursion method
    public ListNode addTwoNumbers_v2(ListNode l1, ListNode l2) {
        return add(l1, l2, 0);
    }

    public ListNode add(ListNode l1, ListNode l2, int rem) {
        ListNode node = new ListNode(rem);

        if (l1 == null && l2 == null) return rem > 0 ? node : null;

        if (l1 != null) node.val += l1.val;
        if (l2 != null) node.val += l2.val;

        node.next = add(l1 == null ? null : l1.next, l2 == null ? null : l2.next, node.val / 10);
        node.val %= 10;
        return node;
    }


    // 12/09/2020
    // was quite painful, haven't read task properly
    public ListNode addTwoNumbers_v1(ListNode l1, ListNode l2) {
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
