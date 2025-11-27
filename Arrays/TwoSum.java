/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume each input has exactly one solution.
You may not use the same element twice.
Return the answer in any order.
*/
import java.util.HashMap;
import java.util.Map;
class TwoSum {
    public static void main(String[] args) {
        int nums[] = {2,7,11,15};
        int target = 9;
        int bruteForceResult[] = twoSumBruteForce(nums, target);
        System.out.println("Brute Force Indices: [" + bruteForceResult[0] + ", " + bruteForceResult[1] + "]");

        int usingMapResult[] = twoSumUsingMap(nums, target);
        System.out.println("Map Indices: [" + usingMapResult[0] + ", " + usingMapResult[1] + "]");

        int usingTwoPointerResult[] = twoSumUsingTwoPointer(nums, target);
        System.out.println("Two Pointer Indices: [" + usingTwoPointerResult[0] + ", " + usingTwoPointerResult[1] + "]");
    }

    public static int[] twoSumBruteForce(int[] nums, int target) {
        // TC : O(n^2) & SC : O(1)
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[] {};
    }

    public static int[] twoSumUsingMap(int nums[], int target) {
        // TC : O(n) & SC : O(n)
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            if (map.containsKey(difference)) {
                return new int[]{map.get(difference), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    public static int[] twoSumUsingTwoPointer(int nums[], int target) {
        // TC : O(n log n) & SC : O(1)
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{left, right};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{};
    }
}