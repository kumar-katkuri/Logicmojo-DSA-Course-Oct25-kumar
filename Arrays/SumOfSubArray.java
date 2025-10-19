// solved using Kadane’s Algorithm
/*
* Notes on Kadane’s Algorithm:
* 1. Kadane’s Algorithm is an efficient way to find the maximum sum of a contiguous subarray within a one-dimensional array of numbers.
* 2. The algorithm works by iterating through the array while keeping track of the current subarray sum and the maximum sum found so far.
* 3. If the current subarray sum becomes negative, it is reset to zero, as starting a new subarray from the next element may yield a higher sum.
* 4. The time complexity of Kadane’s Algorithm is O(n), where n is the number of elements in the array, making it much more efficient than the brute-force approach which has a time complexity of O(n^2).
* 5. Kadane’s Algorithm can also be modified to return the starting and ending indices of the maximum sum subarray, in addition to the maximum sum itself.
* 6. It is important to note that Kadane’s Algorithm assumes that there is at least one positive number in the array. If the array contains all negative numbers, the algorithm can be adjusted to return the maximum (least negative) number.
* 7. Kadane’s Algorithm is widely used in various applications, including financial analysis, signal processing, and computer vision, where finding optimal subarrays is essential.
* */

class SumOfSubArray {
    public static void main(String[] args) {
        int maxSubArray = maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println(maxSubArray);
    }

    public static int maxSubArray(int[] nums) {
        int currentSum = 0;
        if (nums.length == 0) {
            return -1;
        }
        int maxSum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            maxSum = Math.max(maxSum, currentSum);
            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        return maxSum;
    }
}