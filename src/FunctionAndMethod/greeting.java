package FunctionAndMethod;

import java.util.Scanner;

public class greeting {
    public static void main(String[] args) {
        Greetin("Shani Chauhan");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Your name :");
        String na = scanner.next();
        String s = Greetin(na);
    }
    public static String Greetin(String name){
        String Moring = "Good Morning "+name;
        System.out.println(Moring);

        return Moring;
    }
}
