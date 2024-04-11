package SelectionSort;

public class SelectionSortArrayMin {
    public static void main(String[] args) {
        int arr[] = {3,5,2,1,4};
        int n = arr.length;
        int min = Integer.MAX_VALUE;
        int minidx = -1;
        for (int i = 0; i <n ; i++) {
            if(arr[i]<min)
            {
                min = arr[i];
                minidx =i;

            }

        }
        System.out.println(min+" "+minidx);
    }
}
