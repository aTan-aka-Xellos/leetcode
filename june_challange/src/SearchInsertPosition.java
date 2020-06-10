public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {

        int index = 0;
        if (nums.length == 0) return index;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                index = i;
                break;
            }
        }
        return target > nums[nums.length - 1] ? nums.length : index;
    }


}
