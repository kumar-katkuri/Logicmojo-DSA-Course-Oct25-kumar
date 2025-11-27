class ReverseArrayUsingTwoPointerTech {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        System.out.println("Original Array:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

        int left = 0; // starting index
        int right = arr.length - 1; // last index
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        System.out.println("Reversed Array:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}