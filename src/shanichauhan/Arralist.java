package shanichauhan;

import java.util.ArrayList;

public class Arralist {
    public static void main(String[] args) {
        ArrayList<Integer>arr = new ArrayList<>(6);
        arr.add(20);
        arr.add(54);
        arr.add(60);
        arr.add(78);
        arr.add(29);
        System.out.println(arr);
        arr.set(3,450);
        System.out.println(arr);

        System.out.println(arr.get(2));
    }
}
