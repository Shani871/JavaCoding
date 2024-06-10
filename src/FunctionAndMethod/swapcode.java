package FunctionAndMethod;

public class swapcode {
    public static void main(String[] args) {
        int a =10;
        int b = 20;
        int s = swap(a,b);
        System.out.println(s);
        System.out.println(a+" "+b);

    }
    static int swap(int a , int b){
        int temp =a;
        a=b;
        b=temp;


        return temp;
    }
}
