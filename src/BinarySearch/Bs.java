package BinarySearch;

public class Bs {
    public static void main(String[] args) {
        int []arr = {10,23,46,75,85,105};
        int n = arr.length;
        int target = 75;
        int low = 0;
            int hig = n-1;
            boolean flag = false;
            while (low<=hig){
                int mid = (low+hig)/2;
                if(arr[mid]==target){
                    flag = true;break;
                } else if (arr[mid]>target) hig=mid-1;
                else if (arr[mid]<target)low = mid+1;

                }
        if (flag) System.out.println("Traget Presnet");

        else System.out.println("Traget not present");

            }
    }

