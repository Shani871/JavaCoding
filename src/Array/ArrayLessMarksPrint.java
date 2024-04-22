package Array;

public class ArrayLessMarksPrint {
    public static void main(String[] args) {
        int []arr = {81,95,97,100,12,34,24};
        int n = arr.length;
        for (int i =0;i<n;i++){
            if(arr[i]<35){
                System.out.println(i+" ");
            }
        }
    }
}
