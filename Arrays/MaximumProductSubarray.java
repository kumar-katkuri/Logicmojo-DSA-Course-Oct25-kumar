/*
Given an integer array nums,
find the contiguous subarray within the array that has the largest product, and return the product.
*/
class MaximumProductSubarray {
    public static void main(String[] args) {
        int[] nums = {-3,0,6,-2};
        System.out.println(bruteForceMaxProduct(nums));
        System.out.println("Own approach: " + ownApproach(nums));
        System.out.println("Youtube approach: " + youtubeSolution(nums));
    }

    // Brute Force Approach
    public static int bruteForceMaxProduct(int nums[]) {
        // TC: O(n^2) SC: O(1)
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int maxProduct = 0;
        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = i; j < nums.length; j++) {
                product *= nums[j];
                maxProduct = Math.max(maxProduct, product);
            }
        }
        return maxProduct;
    }

    public static int ownApproach(int nums[]) {
        // TC: O(n) SC: O(1)
        // This approach is not correct for all test cases.
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int maxProduct = 0;
        int productOfFullArray = 1;
        int productOfSubArray = 1;
        for (int i = 0; i < nums.length; i++) {
            maxProduct = Math.max(maxProduct, nums[i]);
            productOfFullArray *= nums[i];
            maxProduct = Math.max(maxProduct, productOfFullArray);
            if (i < nums.length - 1) {
                productOfSubArray = nums[i] * nums[i+1];
            } else {
                productOfSubArray = nums[i];
            }
            maxProduct = Math.max(maxProduct, productOfSubArray);
        }
        return maxProduct;
    }

    public static int youtubeSolution(int nums[]) {
        // TC: O(n) SC: O(1)
        if (nums.length == 0) return 0;
        int leftProduct = 1;
        int rightProduct = 1;
        int result = nums[0];
        for (int i = 0; i < nums.length; i++) {
            leftProduct = leftProduct == 0 ? 1 : leftProduct;
            rightProduct = rightProduct == 0 ? 1 : rightProduct;
            leftProduct = leftProduct * nums[i];
            rightProduct = rightProduct * nums[nums.length - 1 - i];
            result = Math.max(result, Math.max(leftProduct, rightProduct));
        }
        return result;
    }
}