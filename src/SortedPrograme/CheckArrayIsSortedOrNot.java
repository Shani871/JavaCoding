package SortedPrograme;

public class CheckArrayIsSortedOrNot {
    public static void main(String[] args) {
        int arr[] ={1,7,3,4,8,9,12,11};
        int n = arr.length;
        boolean flag = true; // if the values show true then it sorted
        for (int i = 0; i <n-1; i++) {
            if(arr[i]>arr[i+1]){
                flag = false;
                break;
            }



        }
        if(flag==true) System.out.println("Sorted");
        else System.out.println("UnSorted");
    }
}
