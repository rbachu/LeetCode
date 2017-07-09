public final class Solution {
    public int searchInsert(int[] arr, int target) {
        return search(arr, target, 0, arr.length - 1);
    }

    private int search(int[] arr, int target, int low, int high) {
        int middle = low + (high - low) / 2;

        if (low > high) {
            return low;
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
