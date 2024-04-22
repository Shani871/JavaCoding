package Array;

public class InArrayFindTargetNumber {
    public static void main(String[] args) {
        int []arr = {10,74,5,4,6,12,82};
        int n = arr.length;
        int target = 12;
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if(arr[i]==target){
              flag = true;
                break;
            }
        }
        if(flag==true) System.out.println("Element Found ");
        else System.out.println("Element is not found i given Array");
    }
}
