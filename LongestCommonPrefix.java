/*
 * 原题链接：https://oj.leetcode.com/problems/longest-common-prefix/
 * 2014.12.31
 *
 * 主要知识点：三向字符串快速排序
 */

public class LongestCommonPrefix {
    public static void main(String[] args) {
        /* 测试 */
    }
}

class Solution {
    private String prefix = "";

    private int charAt(String string, int index) {
        if (index < string.length()) {
            return string.charAt(index);
        }

        return -1;
    }

    /*
     * 稍加修改地应用了三向字符串快速排序，
     * 在查找到公共最长子串前所有字符串都不会被排序，
     * 而查找到之后字符串就会被开始分别递归排序，
     * 所以只需要在分别递归之前返回最长子串即可。
     */
    private void find(String[] strings, int low, int high, int index) {
        if (high <= low) {
            return;
        }

        int left = low;
        int right = high;

        int i = low + 1;

        int cmp = charAt(strings[low], index);

        while (i <= right) {
            int temp = charAt(strings[i], index);

            if (temp < cmp) {
                left++;
                i++;
            } else if (temp > cmp) {
                right--;
            } else {
                i++;
            }
        }

        /* 如果出现了割裂现象或者其中一个字符串已经到达末尾 */
        if (right - left < high - low || index == strings[low].length()) {
            prefix = strings[low].substring(0, index);
            return;
        }

        if (cmp >= 0) {
            find(strings, low, high, index + 1);
        }
    }

    public String longestCommonPrefix(String[] strings) {
        if (strings.length == 1) {
            return strings[0];
        }

        find(strings, 0, strings.length - 1, 0);

        return prefix;
    }
}
