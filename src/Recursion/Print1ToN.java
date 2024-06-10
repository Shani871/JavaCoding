package Recursion;


import java.util.Scanner;

public class Print1ToN {
    static  int n;
    public  static void print(int x){

        if(x>n) return;

        System.out.println(x);
        print(x+1);
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("ENter the number: ");
         n = sc.nextInt();
        print(1);
    }
}
