/*
 * 原题链接：https://leetcode.com/problems/house-robber/
 * 2015.04.10
 *
 * 主要知识点：动态规划
 */
public class HouseRobber {
    public static void main(String[] args) {
        /* 测试 */
    }
}

/*
 * 参考链接：https://leetcode.com/discuss/30277/java-o-n-dp-solution-with-13-lines-clean-code
 * 解题思路：
 *    考虑num[n - 1]房子的状态无非两种，一种是被抢，一种则不被抢；
 *        1. 如果被抢，则总钱数为前n - 2间房子中抢到的钱 + num[n - 1]；
 *        2. 如果不被抢，则总钱数为前n - 1间房子中抢到的钱；
 *    向前递推。
 *    只需要返回上述两种情况中最大的那个值即可。
 */
class Solution {
    public int rob(int[] num) {
        int n = num.length;
        if (n < 2) {
            return n == 0 ? 0 : num[0];
        }

        int[] cache = new int[n];
        cache[0] = num[0];
        cache[1] = num[0] > num[1] ? num[0] : num[1];
        for (int i = 2; i < n; i++) {
            cache[i] = cache[i - 2] + num[i];
            cache[i] = cache[i] > cache[i - 1] ? cache[i] : cache[i - 1];
        }

        return cache[n - 1];
    }
}
