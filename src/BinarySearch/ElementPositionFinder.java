package BinarySearch;

class ElementPositionFinder {

    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};

        if (nums == null || nums.length == 0) {
            return result;
        }

        // Search for the first occurrence of the target
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        if (nums[left] != target) {
            return result;
        }

        result[0] = left;

        // Search for the last occurrence of the target
        right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2; // Add 1 to mid to bias right
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }

        result[1] = right;

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {10,20,20,20,20,20,20,60,70,80};
        int target = 20;
        int[] result = searchRange(nums, target);
        System.out.println("First position: " + result[0] + ", Last position: " + result[1]);
    }
}
