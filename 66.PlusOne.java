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

import java.util.Arrays;

public final class Solution {
    public int[] plusOne(int[] digit) {
        int[] result = new int[digit.length + 1];
        int flag = digit.length;
        int carry = 0;

        for (int i = digit.length - 1; i >=0; i--, flag--) {
            if (i == digit.length - 1) {
                result[flag] = (digit[i] + carry + 1) % 10;
                carry = (digit[i] + carry + 1) / 10;
            } else {
                result[flag] = (digit[i] + carry) % 10;
                carry = (digit[i] + carry) / 10;
            }
        }
        result[flag] = carry;

        if (result[0] == 0) {
            return Arrays.copyOfRange(result, 1, result.length);
        } else {
            return result;
        }
    }
}
