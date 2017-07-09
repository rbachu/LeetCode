public final class Solution {
    public int[] searchRange(int[] arr, int target) {
        int[] result = {-1, -1};
        int index = search(arr, target, 0, arr.length - 1);

        if (index != -1) {
            int left = index;
            int right = index;
            result[0] = left;
            result[1] = right;

            while ((left = search(arr, target, 0, left - 1)) != -1) {
                result[0] = left;
            }

            while ((right = search(arr, target, right + 1, arr.length - 1)) != -1) {
                result[1] = right;
            }
        }

        return result;
    }
    
    private int search(int arr[], int target, int low, int high) {
        int middle = low + (high - low) / 2;

        if (low > high) {
            return -1;
        } else {
            if (arr[middle] == target) {
                return middle;
            } else if (arr[middle] > target) {
                return search(arr, target, low, middle - 1);
            } else {
                return search(arr, target, middle + 1, high);
            }
        }
    }
}


