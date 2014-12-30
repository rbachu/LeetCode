/*
 * 原题链接：https://oj.leetcode.com/problems/majority-element/
 * 2014.12.30
 *
 * 主要知识点：三向快速排序
 */

public class MajorityElement {
    public static void main(String[] args) {
        int[] num = {1};

        System.out.println((new Solution()).majorityElement(num));
    }
}

class Solution {
    int target = -1;

    public int majorityElement(int[] num) {
        if (num.length == 1) {
            return num[0];
        }

        sort(num, 0, num.length - 1);

        return target;
    }

    private void exch(int[] num, int first, int second) {
        int temp = num[first];

        num[first] = num[second];

        num[second] = temp;
    }

    private void sort(int[] num, int low, int high) {
        if (high <= low) {
            return;
        }

        int left = low;
        int right = high;

        int i = low + 1;

        int cmp = num[low];

        while (i <= right) {
            if (num[i] < cmp) {
                exch(num, left++, i++);
            } else if (num[i] > cmp) {
                exch(num, i, right--);
            } else {
                i++;
            }
        }

        /*
         * 当上述循环完成以后，
         * 保证了num[low..left - 1] < cmp = num[left..right] && cmp = num[left..right] < num[right + 1..high]，
         * 所以对于majority element来说，
         * 必定存在right - left >= num.length / 2
         */
        if (right - left >= num.length / 2) {
            target = num[right];

            return;
        }

        sort(num, low, left - 1);
        sort(num, right + 1, high);
    }
}
