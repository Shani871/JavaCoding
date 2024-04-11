package SortedPrograme;

public class BubbleSortRevesr {
    public static void main(String[] args) {
       int arr[] ={1,2,0,4,3,0,5,0};
       // int[] arr = {3,1,2,5,4};
        int n = arr.length;
        for(int esl:arr){
            System.out.print(esl+" ");
        }
        System.out.println( );
        // swapping zero in last  
        for (int x = 0; x <n  ; x++) { 


        for (int i = 0; i < n-1; i++) {
            if(arr[i]==0){//if zero swapping

            //Revere The Array
                //if(arr[i]<arr[i+1])
            // {
                //swapping the element arr[i] and arr[i+1]
                int temp = arr[i];
                arr[i]= arr[i+1];
                arr[i+1]= temp;
            }

        }
        }
        // print the array
        for(int esl:arr){
            System.out.print(esl+" ");
        }
    }
}
