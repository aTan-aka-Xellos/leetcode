package bits.medium;

/**
 * https://leetcode.com/problems/total-hamming-distance
 */
public class TotalHammingDistance_477 {

    public static void main(String[] args) {
        System.out.println(totalHammingDistance(new int[]{4,14,2}) == 6);
        System.out.println(totalHammingDistance(new int[]{4,14,2,7}) == 12);
        System.out.println(totalHammingDistance(new int[]{4,14,2,7,9}) == 24);
    }

    public static int totalHammingDistance(int[] nums) {
        int sum = 0;
        int[][] counts = new int[31][2];

        for (int i = 0; i < counts.length; i++) {
            for (int num : nums) {
                if (((num >> i) & 1) == 1) {
                    counts[i][0]++;
                } else {
                    counts[i][1]++;
                }
            }
        }

        for (int[] count : counts) {
            sum += count[0] * count[1];
        }

        return sum;
    }

    /*
    2332
    3223

    1001
    0010
    0100
    1110
    0111

    3+3+3+3=12 +12 =24

    2+2+2
    2+2+2
    =12

    3210
    0000 = 0
    0001 = 1
    0010 = 2
    0011 = 3
    0100 = 4
    0101 = 5
    0110 = 6
    0111 = 7
    1000 = 8
    1001 = 9
    1010 = 10
    1011 = 11
    1100 = 12
    1101 = 13
    1110 = 14
    1111 = 15
    */
}
