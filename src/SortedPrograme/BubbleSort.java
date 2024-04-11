package SortedPrograme;

public class BubbleSort {

    // Utility method to print an array
    public static void print(int arr[]) {
        for (int els : arr) {
            System.out.print(els + " ");
        }
        System.out.println();
    }

    // Bubble Sort method
    public static void bubbleSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {4, 2, 6, 7, 3, 8};
        System.out.println("Original array:");
        print(arr);

        // Call the bubbleSort method to sort the array
        bubbleSort(arr);

        System.out.println("Sorted array:");
        print(arr);
    }
}
