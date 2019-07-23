package greedy.easy;

/**
 * https://leetcode.com/problems/lemonade-change
 * Time complexity: O(N)
 * Space complexity: O(1)
 */
public class LemonadeChange_860 {

    /**
     * Working solution, but this one has much cleaner code:
     * https://leetcode.com/problems/lemonade-change/discuss/143719
     */
    public boolean lemonadeChange(int[] bills) {

        int five = 0, ten = 0;

        for (int bill : bills) {
            if (bill == 5) {
                five++;

            } else if (bill == 10) {
                if (five > 0) {
                    five--;
                    ten++;
                } else return false;

            } else {
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else if (five > 2) {
                    five -= 3;
                } else return false;
            }
        }
        return true;
    }

}
