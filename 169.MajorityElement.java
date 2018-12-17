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

        if (right - left >= num.length / 2) {
            target = num[right];
            return;
        }

        sort(num, low, left - 1);
        sort(num, right + 1, high);
    }
}
