/* 
 * 原题链接：https://oj.leetcode.com/problems/sort-colors/
 * 2014.09.01
 *
 * 主要知识点：List类的get()方法
 */

import java.util.ArrayList;
import java.util.List;

public class SortColors {
    public static void main(String[] args) {
        /* System.out.println() */
    }
}

/*
 * 在这里直接开辟了另一块内存空间来处理字符串，
 * 这也是题目提供的思路；
 * 另外题目要求不能使用现有的库来排序，
 * 那么怎么办呢？
 * 其实可以自己写一个排序。
 *
 * 不过下面这个链接给出了不同的思路，有兴趣可以参考一下：
 * https://oj.leetcode.com/discuss/1827/anyone-with-one-pass-and-constant-space-solution
 */
class Solution {
    public void sortColors(int[] arr) {
        List<Integer> list = new ArrayList<Integer>();
        int length = arr.length;

        for (int i = 0; i < length; i++) {
            if (arr[i] == 0) {
                list.add(arr[i]);
            }
        }
        for (int i = 0; i < length; i++) {
            if (arr[i] == 1) {
                list.add(arr[i]);
            }
        }
        for (int i = 0; i < length; i++) {
            if (arr[i] == 2) {
                list.add(arr[i]);
            }
        }

        for (int i = 0; i < length; i++) {
            arr[i] = list.get(i);
        }
    }
}
