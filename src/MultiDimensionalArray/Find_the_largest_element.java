package MultiDimensionalArray;

public class Find_the_largest_element {
    public static void main(String[] args) {


    int [][]arr= {{12,25,36},{74,58,69}};
   int m=arr.length;
   int n =arr[0].length;
   int max =arr[0][0];
        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
               if (arr[i][j]>max)  max=arr[i][j];
            }
        }
        System.out.println(max);
    }
}
