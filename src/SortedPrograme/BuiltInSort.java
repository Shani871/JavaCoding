package SortedPrograme;

import java.util.Arrays;

public class BuiltInSort {
    public static void main(String[] args) {
        int arr[] = { -4,7,2,6,84,47,5,9,10};
        int n = arr.length;
        for(int els:arr){
            System.out.print(els+" ");
        }
        System.out.println("Sorted Array");
        Arrays.sort(arr);
        for(int els:arr){
            System.out.print(els+" ");
        }
    }
}
