/*
 * 原题链接：https://oj.leetcode.com/problems/excel-sheet-column-number/
 * 2014.12.30
 *
 * 主要知识点：无
 */

public class ExcelSheetColumnNumber {
    public static void main(String[] args) {
        /* 测试 */
    }
}

class Solution {
    public int titleToNumber(String string) {
        int sum = 0;

        /*
         * 确保输入的字符都是大写，
         * 方便下面直接使用ASCII编码进行计算
         */
        string = string.toUpperCase();

        for (int i = 0; i < string.length(); i++) {
            sum += (string.charAt(i) - 64) * Math.pow(26, string.length() - i - 1);
        }

        return sum;
    }
}
