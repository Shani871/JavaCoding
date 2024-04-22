package FrameWorkOfJava;

import java.util.ArrayList;

public class ArraysListPrg {
    public static void main(String[] args) {
        ArrayList<String>x =new ArrayList<>();
        x.add("Ram");
        x.add("Shyam");
        x.add("Sohan");
        x.add("Sontosh");
        x.add("SHani CHauhan");
        System.out.println(x);
        x.remove(3);
        System.out.println(x);
    }
}
