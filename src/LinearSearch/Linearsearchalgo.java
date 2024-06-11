package LinearSearch;

public class Linearsearchalgo {
    public static int linearsearch(int[] arr, int n, int t) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == t) {
                return i; // Return 1-based index
            }
        }
        return -1; // Element not found
    }

    public static void main(String[] args) {
        int[] arr = {10, 25, 36, 14, 52, 74, 94};
        int n = arr.length;
        int target = 14;
        int result = linearsearch(arr, n, target);

        if (result == -1) {
            System.out.println("Element not present in the array");
        } else {
            System.out.println("Element is present in the array at position: " + result);
        }
    }
}
