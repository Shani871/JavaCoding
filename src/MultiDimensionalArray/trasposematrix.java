package MultiDimensionalArray;

public class trasposematrix {
    public static void main(String[] args) {
        int[][]arr= {{1,2,3},{4,5,6},{7,8,9}};

        int m= arr.length;
        int n =arr[0].length;
        int [][]newm = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                newm[i][j]=arr[j][i];
                System.out.print(newm[i][j]+" ");
            }
            System.out.println();
        }
    }
}
