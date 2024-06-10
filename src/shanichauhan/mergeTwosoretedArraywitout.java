package shanichauhan;

import java.util.Arrays;

public class mergeTwosoretedArraywitout {
    public static void mergeArray(int[]a,int []b,int n ,int m){
        int i=n-1;
        int j= m-1;
        int k = n+m-1;
        while (j>=0){
            if(i>=0&& a[i]>b[j]){
                a[k]=a[i];
                i--;
                k--;
            }else {
                a[k--] = b[j--];
            }
        }
    }
    public static void main(String[] args) {
        int []a= {1, 3, 5, 7, 0, 0, 0, 0};
        int []b= {2, 4, 6, 8};
        int n =4;
        int m =b.length;
        mergeArray(a,b,n,m);

        System.out.println(Arrays.toString(a));
    }
}
