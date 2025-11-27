/*
Given an integer array nums, return an array answer
such that answer[i] is the product of all the elements of nums except nums[i].
You must solve it without division and in O(n) time.
*/

class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4};
        int result[] = usingBruteForceProductExceptSelf(nums);
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
        /*int ownApproachResult[] = ownApproach(nums);
        System.out.println("Own Approach Result:");
        for (int i : ownApproachResult) {
            System.out.print(i + " ");
        }*/
        System.out.println("prefix & suffix approach result:");
        int[] products = prefixSuffixSolution(nums);
        for (int product : products) {
            System.out.print(product + " ");
        }
    }
    public static int[] usingBruteForceProductExceptSelf(int nums[]) {
        // TC: O(n^2) & SC: O(1) excluding result array
        if (nums.length == 0) {
            return new int[] {};
        }
        int result[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    product *= nums[j];
                }
            }
            result[i] = product;
        }
        return result;
    }

    public static int[] ownApproach(int nums[]) {
        // product of entire array
        // TC: O(n) & SC: O(1) excluding result array
        // This one is good but only works 100% correct when nums[] doesn't consist value as zero
        // It is failing for few teestcases in leetcode.
        int product = 1;
        boolean zeroPresent = false;
        int zeroCount = 0;
        for (int num : nums) {
            if (num != 0) {
                product *= num;
            } else {
                zeroPresent = true;
                zeroCount++;
            }
        }
        int result[] = new int[nums.length];
        if (zeroCount == nums.length) {
            for (int i = 0; i < nums.length; i++) {
                result[i] = 0;
            }
            return result;
        }
        for (int i = 0; i < nums.length; i++) {
            if (zeroPresent) {
                if (nums[i] == 0) {
                    result[i] = product;
                } else {
                    result[i] = 0;
                }
            } else {
                result[i] = product/nums[i];
            }
        }
        return result;
    }

    public static int[] prefixSuffixSolution (int nums[]) {
        int result[] = new int[nums.length];
        // Lets have a prefix value as 1 @index[0] for result
        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i-1] * nums[i-1];
        }

        // now have suffix variable & multiple the suffix with the result array in reverse order.
        int suffix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] = result[i] * suffix;
            suffix = suffix * nums[i];
        }
        return result;
    }
}