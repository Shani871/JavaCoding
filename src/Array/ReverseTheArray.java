package Array;

public class ReverseTheArray {
    public static void main(String[] args) {
        int []arr = {84,14,25,36,8,474,58,54};
        int n = arr.length;
        for (int i =0;i<n/2;i++){
            int temp = arr[i];
            arr[i] = arr[n-1-i];
            arr[n-1-i] = temp;
        }
        for (int els:arr){
            System.out.print(els+" ");
        }
    }
}
