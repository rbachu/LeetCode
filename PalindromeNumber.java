/*
 * 原题链接：https://oj.leetcode.com/problems/palindrome-number/
 * 2015.01.03
 *
 * 主要知识点：无
 */

public class PalindromeNumber {
    public static void main(String[] args) {
        /* 测试 */
    }
}

class Solution {
    public boolean isPalindrome(int x) {
        int m = x;
        int n = 0;

        if (x < 0) {
            return false;
        }

        while (x != 0) {
            n = n * 10 + x % 10;
            x = x / 10;
        }

        return (m == n);
    }
}
