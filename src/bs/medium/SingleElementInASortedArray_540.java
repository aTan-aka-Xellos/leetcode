package bs.medium;

/**
 * https://leetcode.com/problems/single-element-in-a-sorted-array/
 */
public class SingleElementInASortedArray_540 {

    // init [0,len]
    // choose mid
    // compare mid with next and increment if not equal
    // compare right side size
    // if even - go left
    // else go right
    // return left
    // 02/10/2021
    public int singleNonDuplicate(int[] nums) {
        int L = 0, R = nums.length;

        while (R - L > 1) {
            int mid = (L + R) >>> 1;
            if (nums[mid] != nums[mid + 1]) mid++;

            if ((R - mid) % 2 == 0) R = mid;
            else                    L = mid;
        }
        return nums[L];
    }


    // init [-1, len/2], -1 because ans could be nums[0] and we return R
    // compare 2*mid and 2*mid+1
    // if equal - go right
    // else go left
    // return 2*R - ans is always even index
    // 02/10/2021
    public int singleNonDuplicate_v2(int[] nums) {

        int L = -1, R = nums.length / 2;
        while (R - L > 1) {
            int mid = (L + R) >>> 1;
            if (nums[2*mid] == nums[2*mid + 1]) L = mid;
            else                                R = mid;
        }
        return nums[2*R];
    }
}
