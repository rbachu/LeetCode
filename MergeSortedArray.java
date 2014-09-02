/*
 * 原题链接：https://oj.leetcode.com/problems/merge-sorted-array/
 * 2014.09.02
 *
 * 主要知识点：无
 */
public class MergeSortedArray {
    public static void main(String[] args) {
        /* System.out.println() */
    }
}

/* 
 * 和以往的思路不同。
 * 在这里直接使用了倒序的方法，
 * 直接腾出了足够的空间进行拼接；
 * 如果使用顺序的话，
 * 会因为频繁地移动元素而浪费过多的时间。
 *
 * 当然也可以直接拼接数组，
 * 然后调用Arrays.sort()进行排序，
 * 不过这样就没有利用到原有的顺序了。
 */
class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (A[i] >= B[j]) {
                A[k--] = A[i--];
            } else {
                A[k--] = B[j--];
            }
        }
        while (j >= 0) {
            A[k--] = B[j--];
        }
    }
}
