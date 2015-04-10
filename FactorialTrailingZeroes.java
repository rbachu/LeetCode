/*
 * 原题链接：https://leetcode.com/problems/factorial-trailing-zeroes/
 * 2015.04.10
 *
 * 主要知识点：无
 */
public class FactorialTrailingZeroes {
    public static void main(String[] args) {
        /* 测试 */
    }
}

/*
 * 参考链接：http://www.geeksforgeeks.org/count-trailing-zeroes-factorial-number/
 */
class Solution {
    public int trailingZeroes(int n) {
        double div = 0;
        int power = 1;
        int zeros = 0;

        while (div < n) {
            div = Math.pow(5, power);
            zeros += (int) (n / div);
            power++;
        }

        return zeros;
    }
}
