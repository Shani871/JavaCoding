package Recursion;

public class FindFactUsingForLoop {
    public static void main(String[] args) {
        int n= 4;
        int f=1;
        for (int i = 1; i <=n; i++) {
            f*=i;
        }
        System.out.println(f);
    }
}
