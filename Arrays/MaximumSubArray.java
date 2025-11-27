/*Given an integer array nums, find the subarray with the largest sum, and return its sum.*/
class MaximumSubArray {
    public static void main(String[] args) {
        int nums[] = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(usingBruteForceMaximumSubArray(nums));

        System.out.println(usingKadaneAlgorithemForMaximumSubArray(nums));
    }
    public static int usingBruteForceMaximumSubArray(int nums[]) {
        // TC: O(n^2), SC: O(1)
        int maxSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }

    public static int usingKadaneAlgorithemForMaximumSubArray(int nums[]) {
        // TC: O(n), SC: O(1)
        if (nums.length == 0) {
            return 0;
        }
        int maxSum = nums[0];
        int currentSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentSum += nums[i];
            if (nums[i] > currentSum) {
                currentSum = nums[i];
            }
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }
        return maxSum;
    }
}