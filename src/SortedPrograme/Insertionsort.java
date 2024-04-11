package SortedPrograme;

public class Insertionsort {
    public static void print(int arr[]){
        for (int i : arr) {
           
            System.out.print(i+" ");
            
        }
        System.out.println( );
    }
    public static void main(String[] args) {    
        int [] arr ={10,8,9,1,3,4};
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        System.out.println("Sorted Array is ");
         print(arr);
    }
    
}
