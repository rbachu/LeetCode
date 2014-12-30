/*
 * 原题链接：https://oj.leetcode.com/problems/reverse-integer/
 * 2014.09.01
 *
 * 主要知识点：Integer.MAX_VALUE（Integer.MIN_VALUE）
 */
 
public class ReverseInteger {
    public static void main(String[] args) {
        /* 测试 */
    }
}

class Solution {
    public int reverse(int x) {
        int result = 0;
        boolean isNeg = false;

        if (x < 0) {
            x = -x;
            isNeg = true;
        }

        /*
         * 没啥好说的；
         * 不过这里直接使用了数乘的方式
         * 而不是像我以前那样先转换为字符串然后再处理，
         * 也算是一种新的思路吧，
         * 毕竟以前没有想过。
         */
        while (x / 10 != 0) {
            result = result * 10 + x % 10;
            x = x / 10;
        }
        result = result * 10 + x;

        if (result > Integer.MAX_VALUE) {
            return 0;
        } else {
            if (isNeg) {
                result = -result;
            }
        }

        return result;
    }
}
