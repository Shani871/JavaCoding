package shanichauhan;

import java.util.Arrays;

public class MergeTwoSortedArrays {
    public static int[] mergeArrays(int[] a, int[] b) {
        int alength = a.length;
        int blength = b.length;
        int[] mergedArray = new int[alength + blength];

        int i = 0, j = 0, k = 0;

        // Merge the two arrays
        while (i < alength && j < blength) {
            if (a[i] <= b[j]) {
                mergedArray[k++] = a[i++];
            } else {
                mergedArray[k++] = b[j++];
            }
        }

        // Copy remaining elements of a[] if any
        while (i < alength) {
            mergedArray[k++] = a[i++];
        }

        // Copy remaining elements of b[] if any
        while (j < blength) {
            mergedArray[k++] = b[j++];
        }

        return mergedArray;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7};
        int[] b = {2, 4, 6, 8};

        int[] mergedArray = mergeArrays(a, b);

        System.out.println("Merged array: " + Arrays.toString(mergedArray));
    }
}
