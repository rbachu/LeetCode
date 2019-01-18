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

/*
 * https://leetcode.com/problems/zigzag-conversion/
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 *
 *     P   A   H   N
 *     A P L S I I G
 *     Y   I   R
 *
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 *     string convert(string s, int numRows);
 *
 * Example 1:
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 *
 * Example 2:
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 *     P     I     N
 *     A   L S   I G
 *     Y A   H R
 *     P     I
 */
class ZigZagConversion {
    fun convert(s: String, numRows: Int): String {
        if (s.isEmpty() || numRows <= 1) {
            return s
        }

        val numZigZag = s.length / numRows
        if (numZigZag < 1) {
            return s
        }

        val numColumns = numZigZag * numRows - numZigZag.dec()
        val matrix2d = Array(numRows) { CharArray(numColumns) }

        var row = 0
        var column = 0
        var increase = true

        for (i in 0 until s.length) {
            matrix2d[row][column] = s[i]

            if (increase) {
                if (row.inc() > numRows.dec()) {
                    increase = false
                    row = row.dec()
                    column = column.inc()
                } else {
                    row = row.inc()
                }
            } else {
                if (row.dec() < 0) {
                    increase = true
                    row = row.inc()
                } else {
                    row = row.dec()
                    column = column.inc()
                }
            }
        }

        val builder = StringBuilder()
        for (r in 0 until numRows) {
            for (c in 0 until numColumns) {
                val temp = matrix2d[r][c]
                if (temp != '\u0000') { // Char.MIN_VALUE
                    builder.append(temp)
                }
            }
        }

        return builder.toString()
    }
}
