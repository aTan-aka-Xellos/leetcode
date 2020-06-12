public class SortColors {

    public void sortColors(int[] nums) {
        int red = 0, white = 0;
        int blue = nums.length - 1;

        while (white <= blue) {
            if (nums[white] == 0) {
                swap(red++, white++, nums);
            } else if (nums[white] == 2) {
                swap(white, blue--, nums);
            } else {
                white++;
            }
        }

    }

    void swap(int from, int to, int[] nums) {
        int temp = nums[to];
        nums[to] = nums[from];
        nums[from] = temp;
    }
}
