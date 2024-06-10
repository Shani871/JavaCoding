package shanichauhan;

public class FindthemxvaluesArray {
    public static void main(String[] args) {
        int []arr = {10,54,84,75,62,81};
        int n = arr.length;
        int mx = arr[0];
        for (int i = 0; i < n; i++) {
            if(arr[i]>mx){
                mx =arr[i];
            }
        }
        System.out.println(mx);
    }
}
