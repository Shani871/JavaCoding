package SortedPrograme;

public class BubbleSortPr1 {
    public static void print(int []arr){
        for (int els:arr){
            System.out.print(els+" ");
        }
        System.out.println( );
    }
    public static void main(String[] args) {
        int []arr = {6,0,3,5};
        print(arr);
        int n = arr.length;
        for (int i = 0; i <n-1; i++) {
            if(arr[i]>arr[i+1]){
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1]= temp;

            }

        }
        print(arr);
    }

}
