/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveFromEndOfList_19 {

    public static void main(String[] args) {
        test();
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode point = temp;
        ListNode node  = temp;

        for (int i = 0; i <= n; i++) {
            point = point.next;
        }

        while (point != null) {
            point = point.next;
            node = node.next;
        }

        node.next = node.next.next;
        return temp.next;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    private static void test() {

        ListNode head;

        head = new ListNode(1);
        head.next = new ListNode(2);
        print(removeNthFromEnd(head, 1)); // 1

        head = new ListNode(1);
        head.next = new ListNode(2);
        print(removeNthFromEnd(head, 2)); // 2

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        print(removeNthFromEnd(head, 1)); // 1, 2

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        print(removeNthFromEnd(head, 2)); // 1, 3

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        print(removeNthFromEnd(head, 3)); // 2, 3
    }

    private static void print(ListNode result) {
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        System.out.println();
    }
}
