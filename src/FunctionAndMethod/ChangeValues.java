package FunctionAndMethod;

import java.util.Arrays;

public class ChangeValues {
    public static void main(String[] args) {
        int[]arr = {1,21,45,36,74,85,65};
        swap(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void swap(int[]num){
        num[0]=101; // if you make a change to the object via this ref variable ,object will be change
    }
}
