package SelectionSort;

public class SelectionSortPr1 {
    public static void main(String[] args) {
        int[] arr = {7, 1, 4, 2, 3};
        int n = arr.length;

        for (int x = 0; x < n - 1; x++) {
            int minIndex = x; // Initialize minIndex for each pass

            // Find the index of the minimum element in the remaining unsorted part
            for (int i = x + 1; i < n; i++) {
                if (arr[i] < arr[minIndex]) {
                    minIndex = i;
                }
            }

            // Swap the minimum element with the first element in the unsorted part
            int temp = arr[x];
            arr[x] = arr[minIndex];
            arr[minIndex] = temp;
        }

        // Print the sorted array
        System.out.println("Sorted Array:");
        for (int els : arr) {
            System.out.print(els + " ");
        }
    }
}
