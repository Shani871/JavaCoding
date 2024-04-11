package SortedPrograme;

public class PushZeroBubbleSort {
    public static void main(String[] args) {
        int []arr = {1, 2, 0, 4, 3, 0, 5, 0};
        for(int els : arr){
            System.out.print(els+" ");
        }
        int n = arr.length;
        for (int x = 0; x < n; x++) {


        for (int i =0;i<n-1;i++){
            if (arr[i]==0){
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
        }
        System.out.println( );
        for(int els : arr){
            System.out.print(els+" ");
        }
    }
}
