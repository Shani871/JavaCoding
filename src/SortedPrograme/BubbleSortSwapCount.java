package SortedPrograme;

public class BubbleSortSwapCount {
    public static void swappingCount(int arr[]){
        for (int esl : arr){
            System.out.print(esl+" ");
        }
        System.out.println( );
    }

    public static void main(String[] args) {
        //int []arr = {6,5,4,3,2,1};
        int []arr = {1,2,3,4,5};
        System.out.println("Unsorted Array");
        swappingCount(arr);
        int n = arr.length;
        int swaps = 0;
        boolean swapped;

        for (int x =0 ;x<n;x++){
            swapped = false;
        for (int i = 0; i < n-1; i++) {
            if (arr[i]>arr[i+1]){
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1]=temp;
                swaps++;
                swapped = true;

            }

        }

        }
        System.out.println("Sorted Array");
        swappingCount(arr);
        System.out.println("Numbe  of Swapping Is occur" );
        System.out.println(swaps +" ");
    }
}
