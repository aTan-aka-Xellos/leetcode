package heap.medium;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
public class KthLargestElementInAnArray_215 {

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3,2,3,1,2,4,5,5,6},4));

        System.out.println(findKthLargest(new int[]{3,2,3,1,2,4,5,5,6},5));
        System.out.println(findKthLargest(new int[]{3,2,3,1,2,4,5,5,6},6));

        System.out.println(findKthLargest(new int[]{3,2,3,1,2,4,5,5,6},7));
        System.out.println(findKthLargest(new int[]{3,2,3,1,2,4,5,5,6},8));

    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int num : nums) {
            if (queue.size() >= k && queue.peek() < num) {
                queue.poll();
                queue.add(num);
            } else if (queue.size() < k) {
                queue.add(num);
            }
        }
        return queue.peek();
    }
}
