/*
 * 原题链接：https://oj.leetcode.com/problems/search-for-a-range/
 * 2014.08.31
 *
 * 主要知识点：二分查找
 */

public class SearchForARange {
    public static void main(String[] args) {
        /* System.out.println() */
    }
}

class Solution {
    public int[] searchRange(int[] arr, int target) {
        int[] result = {-1, -1};

        /*
         * 当需要查找的元素重复出现的时候，
         * 二分查找并不能保证找到的元素一定是第一个，
         * 它可能是这些元素中的任意一个；
         * 按照题目的要求，
         * 我们需要找到第一个元素的位置和最后一个元素的位置，
         * 注意如果元素只有一个，那么两个位置重叠，
         * 所以这里用到了比较讨巧的方法，
         * 就是在while()循环中循环使用二分查找，
         * 每次查找的是已上一次结果的后一位为起始位置或者前一位为终止位置的子串，
         * 这样就能在保证效率的同时，
         * 保证取得的元素一定是第一个或者最后一个。
         */
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

    /*
     * 这里使用递归实现二分查找，
     * 由于二分查找是尾递归，
     * 因此也可以使用循环来实现。
     *
     * 二分查找的时间复杂度为O(n)，
     * 而空间复杂度为O(1)。
     */
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


