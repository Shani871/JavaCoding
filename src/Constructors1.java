public class Constructors1 {
    int num;
    Constructors1(){
        num =100;

    }
    void Display(){
        System.out.println(num);
    }

    public static void main(String[] args) {
        Constructors1 con = new Constructors1();
        Constructors1 con1 = new Constructors1();
        con.Display();
        con1.Display();
    }
}
