import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Haven't solved.
 * https://leetcode.com/problems/largest-divisible-subset/discuss/684677/3-STEPS-c%2B%2B-or-python-or-java-dp-PEN-PAPER-DIAGRAM-explanation-simple-and-clear
 */
public class LargestDivisibleSubset {

    public static void main(String[] args) {


        LargestDivisibleSubset l = new LargestDivisibleSubset();
        List<Integer> res =  l.largestDivisibleSubset(new int[]{2,4,6,8});

        res.forEach(s -> System.out.print(s + " "));
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();

        int[] largestSubsets = new int[nums.length]; // the length of largestDivisibleSubset that ends with element i
        int[] prev = new int[nums.length];           // the previous index of element i in the largestDivisibleSubset ends with element i

        Arrays.sort(nums);

        int max = 0;
        int index = -1;
        for (int i = 0; i < nums.length; i++){
            largestSubsets[i] = 1;
            prev[i] = -1;
            for (int j = i - 1; j >= 0; j--){
                if (nums[i] % nums[j] == 0 && largestSubsets[j] + 1 > largestSubsets[i]){
                    largestSubsets[i] = largestSubsets[j] + 1;
                    prev[i] = j;
                }
            }
            if (largestSubsets[i] > max){
                max = largestSubsets[i];
                index = i;
            }
        }

        System.out.println(Arrays.toString(largestSubsets));
        System.out.println(Arrays.toString(prev));

        System.out.println("index: " + index);

        while (index != -1){
            res.add(nums[index]);
            index = prev[index];
        }

        return res;
    }

}
