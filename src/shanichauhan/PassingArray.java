package shanichauhan;

public class PassingArray {
    public static void main(String[] args) {
        int []arr ={10,54,25,30};
        System.out.println(arr[0]);
        change(arr);
        System.out.println(arr[0]);
    }
    public static void change(int []arr){
        arr[0]=50;
    }
}
