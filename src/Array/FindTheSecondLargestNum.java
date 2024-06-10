package Array;

public class FindTheSecondLargestNum {
    public static void main(String[] args) {
        int[] arr = {14, 25, 36, 74, 56, 96, 314, 4, 84};
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        int smx = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (arr[i] > max) {
                smx = max;  // Update second max to be the previous max
                max = arr[i];  // Update max to be the current element
            } else if (arr[i] > smx && arr[i] != max) {
                smx = arr[i];  // Update second max if current element is smaller than max but greater than smx
            }
        }

        System.out.println("The largest number is: " + max);
        System.out.println("The second largest number is: " + smx);
    }
}
