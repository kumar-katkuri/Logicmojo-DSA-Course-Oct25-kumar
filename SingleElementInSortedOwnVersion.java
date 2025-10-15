/*
Given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. Find this single element that appears only once.
* */

import java.util.List;
import java.util.Objects;

class SingleElementInSorted {
    public int singleNonDuplicate(List<Integer> arr) {
        int start = 0;
        int end = arr.size() - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (start == end) {
                return arr.get(mid);
            }
            if (mid == 0 && (!Objects.equals(arr.get(mid), arr.get(mid + 1)))) {
                return arr.get(mid);
            } else if (mid == arr.size() - 1 && (!Objects.equals(arr.get(mid), arr.get(mid - 1)))) {
                return arr.get(mid);
            }else if ( (!Objects.equals(arr.get(mid), arr.get(mid + 1))) && (!Objects.equals(arr.get(mid), arr.get(mid - 1))) ) {
                return arr.get(mid);
            }

            if (mid % 2 == 0) {
                // mid is even
                if (Objects.equals(arr.get(mid), arr.get(mid - 1))) {
                    end = mid - 2;
                } else {
                    start = mid + 1;
                }

            } else {
                if (Objects.equals(arr.get(mid), arr.get(mid + 1))) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
                // mid is odd
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        SingleElementInSorted solution = new SingleElementInSorted();
        List<Integer> nums = List.of(1, 1, 2, 3, 3, 4, 4, 8, 8);
        System.out.println("The single element is: " + solution.singleNonDuplicate(nums)); // Output: 2
    }
}