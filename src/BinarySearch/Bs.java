package BinarySearch;

public class Bs {
    public static void main(String[] args) {
        int[] arr = {10, 15, 21, 34, 81, 105, 180, 500};
        int n = arr.length;
        int lo = 0;
        int hi = n - 1;
        int target = 34;
        boolean flag = false; // Corrected variable name from "flag" to "flag"
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] < target)
                lo = mid + 1;
            else if (arr[mid] > target)
                hi = mid - 1; // Corrected the index update from "hi = mid + 1" to "hi = mid - 1"
            else if (arr[mid] == target) {
                flag = true; // Moved the "break" statement inside the "else if" block
                break;
            }
        }
        if (flag == true)
            System.out.println("target found ");
        else
            System.out.println("target not found "); // Corrected the spelling of "target" in the output message
    }
}
