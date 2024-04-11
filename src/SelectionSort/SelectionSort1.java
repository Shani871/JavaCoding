package SelectionSort;

public class SelectionSort1 {
    public static void print(int[] arr){
        for(int esl: arr){
            System.out.print(esl+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {3,5,2,1,4};
        int n =arr.length;
       print(arr);
        for (int i = 0; i < n-1; i++) {
          //  int min = Integer.MAX_VALUE; //sort the array
            int max = Integer.MIN_VALUE; //Revere the array
            int mindex = 1;
            for (int j = i; j <n ; j++) {
                if(arr[j]>max){ // reverse array suing max values
                    max = arr[j];
                    mindex = j;
                }

            }
            //swapping arr[i] and arr[index]
            int temp = arr[i];
            arr[i]= arr[mindex];
            arr[mindex] = temp;

        }
        print(arr);
    }
}
