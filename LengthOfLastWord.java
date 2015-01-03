/*
 * 原题链接：https://oj.leetcode.com/problems/length-of-last-word/
 * 2015.01.03
 *
 * 主要知识点：无
 */

public class LengthOfLastWord {
    public static void main(String[] args) {
        /* 测试 */
    }
}

class Solution {
    public int lengthOfLastWord(String string) {
        string = string.replaceAll(" +", " ");

        if (string.length() == 1 && string.equals(" ")) {
            return 0;
        }

        return string.split(" ")[string.split(" ").length - 1].length();
    }
}
