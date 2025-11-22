public class MinimumOperation {
    public static void main(String[] args) {
        int nums[] = {0, 3, 5, 6, 9, 12};
        int minimumOperations = recursionFun(nums, 0, 0);
        System.out.println(minimumOperations);
    }
    public static int recursionFun (int nums[], int index, int count) {
        /*
        for iteration using recursion, always consider using index = 0 & to match base condition use index == arr.length
        each time function call increase the index size
        * */
        if (index == nums.length) {
            return count;
        }
        if (nums[index] % 3 != 0) {
            count++;
        }
        return recursionFun(nums, index + 1, count);
    }
}