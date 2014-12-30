/*
 * 原题链接：https://oj.leetcode.com/problems/reverse-words-in-a-string/
 * 2014.08.27
 *
 * 主要知识点：String中split()方法和trim()方法的应用。
 */

public class ReverseWordsInAString {
    public static void main(String[] args) {
        /* 测试 */
    }
}

class Solution {
    public String reverseWords(String s) {
        /* 调用String的split()方法进行分词 */
        String[] arr = s.split(" ");

        /*
         * 对于前导空格和后导空格，
         * 可以使用String的trim()方法进行去除；
         *
         * 另外值得注意的是，
         * split()方法在分割字符串的时候，
         * 遇到第一个符合分割要求的字符就开始分配了，
         * 所以当存在多个连续空格的时候，
         * 使用split(" ")这样的方法并不能保证分割出来的字符串不包含空格；
         * 如果要保证分割出来的字符串完全不包含空格，
         * 一种方法是在split()方法中使用正则表达式，
         * 二就是是连续不断地使用String的trim()方法，
         * 当然啦，也不排除其他算法。
         */
        String str = null;
        try {
            str = arr[arr.length - 1].trim();
        } catch (ArrayIndexOutOfBoundsException a) {
            return "";
        } catch (NullPointerException n) {
            return "";
        }

        for (int i = arr.length - 2; i > -1; i--) {
            str = str.trim() + " " + arr[i].trim();
        }

        return str.trim();
    }
}

