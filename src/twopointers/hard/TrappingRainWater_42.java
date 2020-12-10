package twopointers.hard;

public class TrappingRainWater_42 {

    // 09/19/2020
    // 12/10/2020 - had a lot of difficulties with indexes, takeaway - write simple code, with all needed vars
    public int trap(int[] height) {

        int n = height.length;
        int[] left  = new int[height.length];
        int[] right = new int[height.length];

        int maxL = 0, maxR = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            left[i] = maxL;
            maxL = Math.max(maxL, height[i]);
        }

        for (int i = n - 1; i >= 0; i--) {
            right[i] = maxR;
            maxR = Math.max(maxR, height[i]);
        }


        for (int i = 0; i < n; i++) {
            if (height[i] > left[i] || height[i] > right[i]) continue;
            sum += Math.min(left[i], right[i]) - height[i];
        }

        return sum;
    }

}
