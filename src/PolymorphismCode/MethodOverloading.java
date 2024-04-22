package PolymorphismCode;

public class MethodOverloading {
    double area(int l,int b){
        return (l*b);

    }
    double area(int s){
        return (s*s);
    }

    public static void main(String[] args) {
        MethodOverloading methodOverloading =new MethodOverloading();
        System.out.println("Area Rectangle is : "+methodOverloading.area(25,65));
        System.out.println("Area Of Square is :"+methodOverloading.area(65));
    }
}
