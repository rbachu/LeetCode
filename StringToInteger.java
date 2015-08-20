/*
 * 原题链接：https://leetcode.com/problems/string-to-integer-atoi/
 * 参考链接：https://leetcode.com/discuss/32813/java-solution-with-4-steps-explanations
 * 完成日期：2015.08.20
 * 主要知识点：无
 */

public class StringToInteger {
    public static void main(String[] args) {
        /* 测试 */
    }
}

class Solution {
    private int index = 0;
    private int sign = 1;
    private int total = 0;

    public int myAtoi(String str) {
        /* 首先判断字符串是否有效，null或长度为0直接返回 */
        if(str == null || str.length() == 0) {
            return 0;
        }

        /* 消除前缀空格 */
        while (str.charAt(index) == ' ' && index < str.length()) {
            index++;
        }

        /* 处理符号 */
        if(str.charAt(index) == '+' || str.charAt(index) == '-'){
            sign = str.charAt(index) == '+' ? 1 : -1;
            index++;
        }

        /* 开始转换 */
        while(index < str.length()){
            int digit = str.charAt(index) - '0';
            if (digit < 0 || digit > 9) {
                break;
            }

            /*
             * 判断是否溢出，
             * 这一步很重要，
             * 尤其是后面的取余数判断，
             * 因为单纯的除以10不足以判断是否下一步的相加操作就是溢出；
             * 这个地方还有一种比较讨巧的方法是用double或者long来做，
             * 这样就可以直接和Integer.MAX_VALUE来比较了，
             * 不过总觉得这样做不太好
             */
            if(Integer.MAX_VALUE / 10 < total || Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            total = 10 * total + digit;
            index++;
        }

        return total * sign;
    }
}