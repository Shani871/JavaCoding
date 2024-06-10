package Recursion;

import java.util.Scanner;

public class PrintNto1 {
    public static int print(int n){

        System.out.println(n);
        if(n==1) return 1;
       print(n-1);

        return n;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("ENter the number: ");
        int n = sc.nextInt();
       print(n);

    }
}
