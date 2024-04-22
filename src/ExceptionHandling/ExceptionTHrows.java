package ExceptionHandling;

public class ExceptionTHrows {
   public static void checkage(int age) throws ArithmeticException{
       if(age<18){
           throw new ArithmeticException("Access deined You are not 18 year old ");

       }else System.out.println("you are eligible ");

    }

    public static void main(String[] args) {
        checkage(85);
    }
}
