package linkedlist.easy;

/**
 * https://leetcode.com/problems/palindrome-linked-list/
 */
public class PalindromeLinkedList_234 {

    ListNode ref = null;

    // 01/02/2021
    public boolean isPalindrome(ListNode head) {
        if (ref  == null) ref = head;
        if (head == null) return true;

        boolean res = isPalindrome(head.next) && (ref.val == head.val);

        ref = ref.next;
        return res;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
   }
}
