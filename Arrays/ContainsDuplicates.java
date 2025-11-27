/*
Given an integer array nums, return true if any value appears at least twice, and false if every element is distinct.
*/
import java.util.HashSet;
import java.util.Set;
class ContainsDuplicates {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 1};
        System.out.println(containsDuplicate(nums));
    }
    public static boolean containsDuplicate(int nums[]) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
}