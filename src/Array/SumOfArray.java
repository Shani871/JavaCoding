package Array;

public class SumOfArray {
    public static void main(String[] args) {
        int []arr ={10,35,64,211,84,41};
        int n = arr.length;
        int sum =0;
        for (int i = 0; i < n; i++) {
            sum+=arr[i];

        }
        System.out.println("Sum of given Array is :                                          "+sum);
    }
}
