package Array;

public class FindTheMaximumValues {
    public static void main(String[] args) {
        int []arr = {8,546,741,852,1,963,258};
        int n = arr.length;
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if(arr[i]>max) max = arr[i];

        }

        System.out.println(max);

        int min = Integer.MAX_VALUE;
        for (int j : arr) {
            if (j < min) min = j;
        }
        System.out.println(min);
    }

}
