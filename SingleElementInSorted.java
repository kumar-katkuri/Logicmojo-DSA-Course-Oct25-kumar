// Version 1: Using Binary Search & simple logic llm version
class SingleElementSorted {

    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // Ensure mid is even for comparison
            if (mid % 2 == 1) {
                mid--;
            }

            // Check if the pair is valid
            if (nums[mid] == nums[mid + 1]) {
                left = mid + 2; // Move to the right half
            } else {
                right = mid; // Move to the left half
            }
        }

        return nums[left]; // The single element
    }

    public static void main(String[] args) {
        SingleElementSorted solution = new SingleElementSorted();
        int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        System.out.println("The single non-duplicate element is: " + solution.singleNonDuplicate(nums)); // Output: 2
    }
}