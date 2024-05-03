package BinarySearch;

public class SquareRoot {
   public static  int findsq()  {
        int x = 8;
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16,25};
        int n = arr.length;
        int lo = 0;
        int hi = n - 1;

        boolean flag = false; // Corrected variable name from "flag" to "flag"
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if(mid*mid==x){
                return mid;
            }
            else if(mid*mid<x) lo = mid+1;
            else if(mid*mid>x) hi = mid-1;

        }
         // Corrected the spelling of "target" in the output message
        return hi;
    }

    public static void main(String[] args) {
      int result = findsq();

        System.out.println("Square root of this"+result);
    }



}
