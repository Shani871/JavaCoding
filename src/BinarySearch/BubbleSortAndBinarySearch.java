package BinarySearch;

public class BubbleSortAndBinarySearch {
    public static void print(int[] arr) {
        for (int els : arr) {
            System.out.print(els + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 10, 4, 7, 12, 2, 1, 9, 6, 8, 13, 71 };
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                }
            }
        }
        print(arr);
        int low = 0;
        int hig = n - 1;
        int target = 12;
        boolean flag = false;
        while (low <= hig) {
            int mid = (low + hig) / 2;
            if (arr[mid] == target) {
                flag = true;
                break;
            } else if (arr[mid] > target)
                hig = mid - 1;
            else if (arr[mid] < target)
                low = mid + 1;

        }
        if (flag)
            System.out.println("Traget Presnet");

        else
            System.out.println("Traget not present");

    }

}
