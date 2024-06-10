package Array;

public class MaximumValue {
    public static void main(String[] args) {
        int []arr = {14,25,36,74,56,96,314,4,84};
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n;  i++) {
            if(arr[i]>=max){
               max = arr[i];
            }

        }
        int smx = Integer.MIN_VALUE;
        System.out.println(max);
        for (int i = 0; i < n; i++) {
            if (arr[i]>smx && arr[i]!=max);

        }
        System.out.println(max);
        System.out.println(smx);
    }
}
