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
