/*
 * 原题链接：https://leetcode.com/problems/reverse-bits/
 * 2015.03.11
 *
 * 主要知识点：比特位操作
 */

public class ReverseBits {
    public static void main(String[] args) {
        /* 测试 */
    }
}

/*
 * 获取第i位比特位方法：n & (1 << i)
 * 设置第i位比特位方法：n | (1 << i)
 *
 * 其余可参考这个链接：https://ckjoker.github.io/2015/03/02/java-bit-program/
 */
class Solution {
    public int reverseBits(int n) {
        int rev = 0;

        for (int i = 0; i < Integer.SIZE; i++) {
            if ((n & (1 << i)) != 0) {
                rev = rev | (1 << (Integer.SIZE - i - 1));
            }
        }

        return rev;
    }
}
