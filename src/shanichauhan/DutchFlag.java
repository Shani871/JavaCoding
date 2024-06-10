package shanichauhan;

public class DutchFlag {
    public static void sort012(int[]arr){
        int low =0,mid=0,hig= arr.length-1;
        while (mid<=hig){
            switch (arr[mid]){
                case 0:
                    swap(arr,low,mid);
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(arr,mid,hig);
                    hig--;
                    break;

            }


        }
    }
    private static void swap(int[]arr,int i,int j){
        int temp =arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void main(String[] args) {
        int [] arr = {0,2,1,0,0,2,2,0,1,0,1,2,0,1,1,0,2,0,1};
        int n = arr.length;

        sort012(arr);
        for (int els:arr){
            System.out.print(els+" ");
        }

    }
}
