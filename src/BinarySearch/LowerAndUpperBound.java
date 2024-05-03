package BinarySearch;

public class LowerAndUpperBound {
    public static void main(String[] args) {
        int [] arr = {10,20,30,30,46,50,60,70};
        int n = arr.length;
        int lo =0,hi =n-1;
        int lower = n;
        int target = 46;
        while (lo<=hi){
            int mid = lo+(hi-lo)/2;
            if(arr[mid]>target){
                lower = Math.min(lower,mid);
                hi = mid-1;
            }else lo = mid+1;
        }
        System.out.println(lower);
    }
}
