package contest.biweekly_11;

/**
 * https://leetcode.com/contest/biweekly-contest-11/problems/missing-number-in-arithmetic-progression/
 */
public class MissingNumber_1228 {

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{5,7,11,13}) == 9);
        System.out.println(missingNumber(new int[]{15,13,12}) == 14);
        System.out.println(missingNumber(new int[]{15,14,12}) == 13);
    }

    public static int missingNumber(int[] arr) {
        int diff = (arr[arr.length - 1] - arr[0]) / arr.length;
        int prob = arr[0];

        for (int j = 0; j < arr.length && prob == arr[j]; j++) {
            prob += diff;
        }
        return prob;
    }
}
