package arrays.easy;

public class RemoveElement_27 {

    public static int removeElement(int[] nums, int val) {
        int N = nums.length;
        for (int i = 0; i < N; i++) {
            if (nums[i] == val)
                nums[i--] = nums[--N];
        }
        return N;
    }

}
