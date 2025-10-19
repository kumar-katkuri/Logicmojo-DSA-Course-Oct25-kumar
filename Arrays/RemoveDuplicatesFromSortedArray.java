class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int i = removeDuplicates(new int[]{1, 1, 2});
        System.out.println(i);
    }

    public int removeDuplicates(int[] nums) {

        int previous = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[previous] != nums[i]) {
                previous++;
                nums[previous] = nums[i];
            }
        }
        return previous + 1;
    }
}