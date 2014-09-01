/*
 * 原题链接：https://oj.leetcode.com/problems/remove-element/
 * 2014.09.01
 *
 * 主要知识点：无
 */

import java.util.ArrayList;
import java.util.List;

public class RemoveElement {
    public static void main(String[] args) {
        /* System.out.println() */
    }
}

/*
 * 我在这里属于偷懒的办法，
 * 直接利用List现有的属性进行操作了，
 * 这样非常不好，
 * 有时候这种简单题还是自己动脑子比较好。
 *
 * 下面是一个简单的思路，我觉得非常不错，
 * 通过动态地调整count值来实现一次遍历即可拼接数组，
 * 而不是多次遍历重复地覆盖：
 * public int removeElement(int[] arr, int elem) {
 *     int count = 0;
 *
 *     for (int i = 0; i < arr.length; i++) {
 *         if (arr[i] == elem) {
 *             count++;
 *         } else {
 *             if (count > 0) {
 *                 arr[i - count] = arr[i];
 *             
 *             }
 *         }
 *     }
 *
 *     return arr.length - count;
 * }
 */

class Solution {
    public int removeElement(int[] arr, int elem) {
        List<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }

        while (list.remove((Integer) elem));
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        return list.size();
    }
}
