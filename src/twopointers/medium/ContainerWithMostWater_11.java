package twopointers.medium;

/**
 * https://leetcode.com/problems/container-with-most-water/
 */
public class ContainerWithMostWater_11 {

    public int maxArea(int[] height) {
        int sum = 0, left = 0, right = height.length - 1;

        while (left != right) {
            int minHeight = Math.min(height[left], height[right]);

            sum = Math.max(sum, minHeight * (right - left));
            if (height[left] < height[right])  left++;
            else                               right--;
        }
        return sum;
    }
}
