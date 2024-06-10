package Array;

import java.util.Scanner;

public class TakeInputArrayFromUser {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the traget Number ");
        int x = sc.nextInt();
        System.out.println("Enter the Array Size");
      int n = sc.nextInt();
      int []arr = new int[n];
        System.out.println("Enter the Element :");

        boolean flag = false;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            if(arr[i]==x){
                flag = true;
                break;
            }
        }
        if(flag==true) System.out.println("Element Found" );
        else System.out.println("Not found ");
    }
}
