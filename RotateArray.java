/*
 * 原题链接：https://leetcode.com/problems/rotate-array/
 * 2015.04.10
 *
 * 主要知识点：无
 */
public class RotateArray {
    /* 测试 */
}

/*
 * 参考链接：https://github.com/julycoding/The-Art-Of-Programming-By-July/blob/master/ebook/zh/01.01.md
 * 注意与参考所不同的是LeetCode要求为右移k位，而不是将左边k位移只末尾。
 */
class Solution {
    public void rotate(int[] nums, int k) {
        k = nums.length - (k % nums.length);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }

    private void reverse(int[] nums, int from, int to) {
        while(from < to) {
            int temp = nums[from];
            nums[from++] = nums[to];
            nums[to--] = temp;
        }
    }
}
