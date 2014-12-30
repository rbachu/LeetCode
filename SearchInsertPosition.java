/*
 * 原题链接：https://oj.leetcode.com/problems/search-insert-position/
 * 2014.09.01
 *
 * 主要知识点：二分查找
 */

public class SearchInsertPosition {
    public static void main(String[] args) {
        /* 测试 */
    }
}

class Solution {
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
