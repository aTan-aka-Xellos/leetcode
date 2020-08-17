package math.easy;

/**
 * https://leetcode.com/problems/distribute-candies-to-people/
 */
public class DistributeCandiesToPeople_1103 {

    public int[] distributeCandies(int candies, int num_people) {
        int[] people = new int[num_people];
        int n = 0, index = 0;

        while (candies > 0) {
            if (candies > n) n++;
            else n = candies;

            candies -= n;
            people[index++] += n;

            if (index == num_people) index = 0;
        }
        return people;
    }
}
