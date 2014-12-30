/*
 * 原题链接：https://oj.leetcode.com/problems/excel-sheet-column-title/
 * 2014.12.30
 *
 * 主要知识点：进制之间的转换
 */

public class ExcelSheetColumnTitle {
    public static void main(String[] args) {
        /* 测试 */
    }
}

class Solution {
    public String convertToTitle(int n) {
        String string = "";

        /*
         * 我们一眼可以看出A~Z属于26进制，
         * 但是又不是标准的26进制，
         * 即A~Z所代表的进制并不是以0开头的进制；
         * 相反它在数轴上整体向右偏移了1位，
         * 即以1为开头的26进制。
         * 所以我们不能直接使用类似于十进制转二进制的“除2取余法”来进行转换，
         * 而应该首先解决偏移量的问题。
         * 举个简单的例子，
         * 当n = 26的时候我们知道它代表字符Z，
         * 但是对于标准的26进制来说代表字符Z的数字应该是25，
         * 所以需要在每次计算前对n自减1再进行取余等操作
         */
        while (n > 0) {
            string = (char) ((--n) % 26 + 65) + string;

            n /= 26;
        }

        return string;
    }
}
