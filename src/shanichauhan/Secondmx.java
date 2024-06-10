package shanichauhan;

public class Secondmx {
    public static void main(String[] args) {
        int[] arr = {10, 54, 84, 75, 62, 81};
        int n = arr.length;
        int mx = Integer.MIN_VALUE;
        int secmx = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (arr[i] > mx) {
                secmx = mx;  // Update second max to previous max
                mx = arr[i]; // Update max to current element
            } else if (arr[i] > secmx && arr[i] != mx) {
                secmx = arr[i]; // Update second max if current element is less than max but greater than second max
            }
        }

        System.out.println("Maximum: " + mx);
        System.out.println("Second Maximum: " + secmx);
    }
}
