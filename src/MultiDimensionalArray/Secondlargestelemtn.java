package MultiDimensionalArray;

public class Secondlargestelemtn {
    public static void main(String[] args) {
        int [][]arr= {{12,25,36},{74,58,69}};
        int m=arr.length;
        int n =arr[0].length;
        int max =arr[0][0];
        int secondmax = Integer.MIN_VALUE;
        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j]>max){
                    secondmax=max;
                    max= arr[i][j];
            }else if (arr[i][j]>secondmax&&arr[i][j]!=max){
                    secondmax=arr[i][j];
        }

    }
}
        System.out.println(max);
        System.out.println(secondmax);
    }
}
