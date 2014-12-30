/*
 * 原题链接：https://oj.leetcode.com/problems/single-number/
 * 2014.08.31
 *
 * 主要知识点：XOR
 */

import java.util.Arrays;

public class SingleNumber {
    public static void main(String[] args) {
        /* 测试 */
    }
}

class Solution {
    public int singleNumber(int[] arr) {
        int result = 0;

        /*
         * 首先对数组进行排序，
         * 然后直接对比相邻的前后项就完事了。
         *
         * 但是需要注意的是，
         * 这里使用的时间并不是要求的O(n)，
         * 至少是O(n * logn)以上，
         * 因为Arrays的sort()方法使用的是Dual-Pivot Quicksort，
         * 中文名称叫做“双支点快速排序”，
         * 这种排序的时间复杂度就是O(n * logn)，
         * 显然不是题目要求的线性时间增长，
         * 再加上后面的循环比较，
         * 就更不用说了。
         * 尽管可以AC。
         *
         * 那么有什么方法可以解决上述问题呢？
         * 有一种方法是使用XOR，也就是“异或”，
         * 异或有这么一种特性：
         *     A XOR A = 0,
         *     A XOR B XOR A = B
         * 应用以上特性，
         * 我们就可以在一次遍历之后就找出这个单独的数字出来，
         * 详情可以参阅这个链接：
         * https://oj.leetcode.com/discuss/9739/easiest-way-to-solve-by-using-bit-manipulation
         */
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i = i + 2) {
            try {
                if (arr[i] != arr[i + 1]) {
                    result = arr[i];
                    break;
                }
            } catch (ArrayIndexOutOfBoundsException a) {
                result = arr[arr.length - 1];
            }
        }

        return result;
    }
}
