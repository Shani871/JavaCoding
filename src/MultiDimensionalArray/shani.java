package MultiDimensionalArray;

public class shani {
    public static void main(String[] args) {
        int [][] arr = { {10, 20, 3}, {1, 5, 4}, {3, 4, 8} };
        int [][] arr1 = { {12, 33, 40}, {2, 9, 50}, {6, 10, 5} };

        int[][] sum = new int[3][3];
        int m = arr.length;
        int n = arr[0].length; // Assumes arr and arr1 have the same dimensions

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum[i][j] = arr[i][j] + arr1[i][j];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(sum[i][j] + " ");
            }
            System.out.println();
        }
    }
}
