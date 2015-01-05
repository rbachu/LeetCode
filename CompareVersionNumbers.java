/*
 * 原题链接：https://oj.leetcode.com/problems/compare-version-numbers/
 * 2015.01.05
 *
 * 主要知识点：无
 */

public class CompareVersionNumbers {
    public static void main(String[] args) {
        System.out.println((new Solution()).compareVersion("1.0", "1"));
    }
}

class Solution {
    public int compareVersion(String first, String second) {
        String[] arrayF = first.split("\\.");
        String[] arrayS = second.split("\\.");

        int maxLength = (arrayF.length > arrayS.length) ? arrayF.length : arrayS.length;

        int[] valueF = new int[maxLength];
        int[] valueS = new int[maxLength];

        for (int i = 0; i < arrayF.length; i++) {
            valueF[i] = Integer.valueOf(arrayF[i]);
        }
        for (int i = 0; i < arrayS.length; i++) {
            valueS[i] = Integer.valueOf(arrayS[i]);
        }

        for (int i = 0; i < maxLength; i++) {
            if (valueF[i] > valueS[i]) {
                return 1;
            } else if (valueF[i] < valueS[i]) {
                return -1;
            }
        }

        return 0;
    }
}
