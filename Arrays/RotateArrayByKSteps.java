// rotate array
class RotateArrayByKSteps {
    public static void rotate(int[] nums, int k) {
        System.out.println(rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3));
        System.out.println(rotate2(new int[]{-1, -100, 3, 99}, 2));
    }

    public static void rotate(int[] nums, int k) {
        // This is the first solution which passed the leetcode test cases 38 out of 39.
        // Got failed due to time limit exceeded for large input cases.
        while (k > 0) {
            int size = nums.length;
            for (int i = size - 1; i > 0; i--) {
                int temp = nums[i];
                nums[i] = nums[i - 1];
                nums[i - 1] = temp;
            }
            k--;
        }
    }

    // this is the optimal solution with O(n) time complexity and O(1) space complexity.
    public static void rotate2(int[] nums, int k) {
        k = k % nums.length;
        rotateArr(nums, 0, nums.length - 1); // reverse array.
        rotateArr(nums, 0, k - 1); // first half arr of k steps rotate them to be in order
        rotateArr(nums, k, nums.length-1); // second half arr after k steps rotate them for order
    }

    public void rotateArr(int nums[], int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}