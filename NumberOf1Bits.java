/*
 * 原题链接：https://leetcode.com/problems/number-of-1-bits/
 * 2015.03.10
 *
 * 主要知识点：无
 */

public class NumberOf1Bits {
    public static void main(String[] args) {
        /* 测试 */
    }
}

/* 采用“位运算”等方法可以获得更快的速度 */
class Solution {
    public int hammingWeight(int n) {
        int count = 0;

        for (char c : Integer.toBinaryString(n).toCharArray()) {
            if (c == '1') {
                count++;
            }
        }

        return count;
    }
}
