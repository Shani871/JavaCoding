package shanichauhan;

public class twosum {
    public static void main(String[] args) {
        int []arr = {10,54,36,20,36,45,74,180,46};
        int n =arr.length;
        int num =100;
        for (int i =0;i<n;i++){
            for (int j = 0; j < n; j++) {
                if(arr[i]+arr[j]==num){
                    System.out.println(arr[i]+" "+arr[j]);
                }
            }
        }
        for (int i = 0; i < n/2; i++) {
            int temp =arr[i];
            arr[i] =arr[n-1-i];
            arr[n-1-i] =temp;
        }
       for(int els:arr){
           System.out.print(els+" ");
       }
        System.out.println();
    }
}
