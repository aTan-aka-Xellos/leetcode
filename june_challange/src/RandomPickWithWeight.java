import java.util.Arrays;
import java.util.Random;

/**
 * Didn't solved it. Description is terrible. Solution from discussions.
 * https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3351/
 */
public class RandomPickWithWeight {

    Random random;
    int[] sum;

    public RandomPickWithWeight(int[] w) {
        this.random = new Random();
        for (int i = 1; i < w.length; i++)
            w[i] += w[i-1];
        this.sum = w;
    }

    public int pickIndex() {
        int idx = random.nextInt(sum[sum.length - 1]) + 1;
        int index = Arrays.binarySearch(sum, idx);
        return index >= 0 ? index : -index - 1;
    }

}