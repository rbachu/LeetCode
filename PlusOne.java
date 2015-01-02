/*
 * 原题链接：https://oj.leetcode.com/problems/plus-one/
 * 2015.01.02
 *
 * 主要知识点：无
 */

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        /* 测试 */
    }
}

class Solution {
    public int[] plusOne(int[] digit) {
        int[] result = new int[digit.length + 1];

        int flag = digit.length;
        int carry = 0;

        for (int i = digit.length - 1; i >=0; i--, flag--) {
            if (i == digit.length - 1) {
                result[flag] = (digit[i] + carry + 1) % 10;
                carry = (digit[i] + carry + 1) / 10;
            } else {
                result[flag] = (digit[i] + carry) % 10;
                carry = (digit[i] + carry) / 10;
            }
        }
        result[flag] = carry;

        if (result[0] == 0) {
            return Arrays.copyOfRange(result, 1, result.length);
        } else {
            return result;
        }
    }
}
