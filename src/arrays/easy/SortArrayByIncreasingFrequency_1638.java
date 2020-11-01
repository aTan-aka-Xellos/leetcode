package arrays.easy;

import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/sort-array-by-increasing-frequency/
 *
 * Biweekly 38
 */
public class SortArrayByIncreasingFrequency_1638 {

    // 11/01/2020
    public int[] frequencySort(int[] nums) {
        int[] freq = new int[201]; // [-100, 100]
        for (int num : nums) freq[num + 100]++;

        return IntStream.of(nums).boxed()
                .sorted((a, b) -> freq[a + 100] == freq[b + 100] ? (b - a) : freq[a + 100] - freq[b + 100])
                .mapToInt(i -> i)
                .toArray();
    }
}
