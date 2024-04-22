package ExceptionHandling;

public class ExceptionHandl {
    public static void main(String[] args) {
        try {
            int a = 52,b= 0;
            int c = a/b;
            System.out.println(c);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
