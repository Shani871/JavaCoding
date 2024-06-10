package shanichauhan;

public class ZeroandonesTwo {
    public static void main(String[] args) {
        int []arr= {0,1,2,0,0,1,0,2,0,1,0,2,0,2,2,1,1,0,2,};
        int n = arr.length;
        int noOfZero=0;
        int noOfone= 0;
        for (int i = 0; i < n; i++) {
            if(arr[i]==0) noOfZero++;
            if(arr[i]==1) noOfone++;
        }
        for (int i = 0; i < n; i++) {
            if(i<noOfZero) arr[i]=0;
            else if (i<noOfZero+noOfone) arr[i]=1;

            else arr[i]=2;
        }

for (int els:arr){
    System.out.print(els+" ");
}

    }
}
