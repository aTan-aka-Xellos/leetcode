package bs.medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag/
 * https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag/discuss/1066151/Java-Binary-Search-with-detailed-debug-explanation-new-pattern
 * Weekly Contest 228
 */
public class MinimumLimitOfBallsInABag_1760 {

    /**
     * 02/15/2021
     *
     * Failed miserably during the contest itself.
     * Mostly because wrote canSplit incorrectly.
     *
     */
    public int minimumSize(int[] nums, int maxOperations) {
        int L = 0, R = Arrays.stream(nums).max().orElse(-1);

        while (R - L > 1) {
            int mid = (L + R) >>> 1;

            if (canSplit(nums, mid, maxOperations)) R = mid;
            else                                    L = mid;
        }
        return R;
    }

    /**
     * The bug during contest was, that I did increment by 1, instead if decrement by 1.
     *
     * The decrement is needed because we count operations on the array.
     * Consider an example:
     * nums={10}, maxSize = 5, so 10 / 5 = 2 elements, but we did only one operation.
     * So in case if reminder is zero - we need to decrement counter by 1.
     */
    boolean canSplit(int[] nums, int size, int max) {
        int count = 0;
        for (int num: nums) {
            count += (num / size);
            if (num % size == 0) count--;

//            count += (num - 1) / size; // alternate approach from @lee215
            if (count > max) return false;
        }
        return count <= max;
    }

    /*
        nums=[10], op = 2

         0 1 2 3 4 5 6 7 8 9 10
        [0,1,2,3,4,5,6,7,8,9,10]
        L = 0, R = 10, mid = 10/2 = 5, nums[5]=5, canSplit(5)=>[5,5]     =true  => R = mid = 5

         0 1 2 3 4 5
        [0,1,2,3,4,5]
        L = 0, R = 5, mid = 5/2 = 2, nums[2]=2, canSplit(2)=>[2,2,2,2,2] =false => L = mid = 2

         0 1 2 3 4 5
            [2,3,4,5]
        L = 2, R = 5, mid = 7/2 = 3, nums[3]=3, canSplit(3)=>[3,3,3,1]   =false => L = mid = 3

         0 1 2 3 4 5
              [3,4,5]
        L = 3, R = 5, mid = 8/4 = 4, nums[4]=4, canSplit(4)=>[4,4,2]     =true  => R = mid = 4

         0 1 2 3 4 5
                [4,5]
        L = 3, R = 4, (R - L > 1) =false => return R
     */


}
