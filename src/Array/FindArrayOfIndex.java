package Array;

public class FindArrayOfIndex {
    public static void main(String[] args) {
        int[]arr = {10,25,36,45,85,474,35,21};
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if(arr[i]<35){
                System.out.println(i);
            }
        }
    }
}
