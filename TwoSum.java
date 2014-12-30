/*
 * 原题链接：https://oj.leetcode.com/problems/two-sum/
 * 2014.08.31
 *
 * 主要知识点：“并行”。
 */

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        /* 测试 */
    }
}

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        /*
         * 在这里用到了非常巧妙的思想，
         * 我们知道，要查找数字元素，
         * 使用现有的数据结构中的一些方法是比较简单的选择；
         * 通常的思想是我们先把numbers中的数全部包括在内，
         * 然后再进行判别比较，
         * 但是这样的方法效率低下，
         * 而且不利于处理数字重复的这种现象；
         * 当然有同学可能不知道什么是数字重复，
         * 举个例子，
         * 比如说[0, 4, 3, 0]，目标是0，
         * 显然0 + 0 = 0，如何处理第二个0就是关键点；
         * 那么有什么好的方法便于以上处理呢？
         * 在这里可以说用到了“并行”的细想，
         * 先比较，再加入，再比较，再加入，
         * 一旦出现符合的情况立即返回，
         * 把数据处理的时间压尽可能地缩到极限O(n)，其中n为numbers的长度；
         * 另一方面，针对处理数字重复，
         * 这里用到了比较巧妙的方法，
         * 就以上面的例子，当遇到第二个0的时候，
         * 不是先把它加入到map，而是直接获取其当前的下标，
         * 显然由于第二个0没有入map，
         * 那么通过HashMap的containsKey()方法自然可以查找到第一个符合要求的0的位置，
         * 巧妙就巧妙在，对map的put操作在比较之后进行。
         *
         * 当然在这里也可以利用List，只不过稍微麻烦些。
         */
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                result[1] = i + 1;
                result[0] = map.get(target - numbers[i]);

                return result;
            }
            map.put(numbers[i], i + 1);
        }

        return result;
    }
}
