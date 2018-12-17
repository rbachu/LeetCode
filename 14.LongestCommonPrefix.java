/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2018 Matthew Lee
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

public final class Solution {
    private String prefix = "";

    private int charAt(String string, int index) {
        if (index < string.length()) {
            return string.charAt(index);
        }

        return -1;
    }

    private void find(String[] strings, int low, int high, int index) {
        if (high <= low) {
            return;
        }

        int left = low;
        int right = high;
        int i = low + 1;
        int cmp = charAt(strings[low], index);
        
        while (i <= right) {
            int temp = charAt(strings[i], index);
            if (temp < cmp) {
                left++;
                i++;
            } else if (temp > cmp) {
                right--;
            } else {
                i++;
            }
        }

        if (right - left < high - low || index == strings[low].length()) {
            prefix = strings[low].substring(0, index);
            return;
        }

        if (cmp >= 0) {
            find(strings, low, high, index + 1);
        }
    }

    public String longestCommonPrefix(String[] strings) {
        if (strings.length == 1) {
            return strings[0];
        }

        find(strings, 0, strings.length - 1, 0);

        return prefix;
    }
}
