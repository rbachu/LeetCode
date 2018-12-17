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
    public String multiply(String first, String second) {
        if (first.equals("0") || second.equals("0")) {
            return "0";
        }

        int values[][] = new int[second.length()][first.length() + second.length()];

        for (int position = second.length() - 1, flag = first.length() + second.length() - 1; position >= 0; position--, flag--) {
            int lier = second.charAt(position) - '0';
            int index = flag;
            int carry = 0;

            for (int i = first.length() - 1; i >= 0; i--, index--) {
                int value = (first.charAt(i) - '0') * lier;
                values[position][index] = value % 10 + carry;
                carry = value / 10;
            }

            values[position][index] = carry;
        }

        int result[] = new int[first.length() + second.length()];

        for (int j = first.length() + second.length() - 1, carry = 0; j >= 0; j--) {
            int sum = 0;

            for (int i = 0; i < second.length(); i++) {
                sum += values[i][j];
            }
            sum += carry;

            result[j] = sum % 10;
            carry = sum / 10;
        }

        String string = "";
        int begin = 0;

        while (result[begin] == 0) {
            begin++;
        }

        for (int i = begin; i < first.length() + second.length(); i++) {
            string += (char) (result[i] + '0');
        }

        return string;
    }
}
