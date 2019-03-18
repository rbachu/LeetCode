/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2019 Matthew Lee
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
 * https://leetcode.com/problems/largest-perimeter-triangle/
 *
 * Given an array A of positive lengths,
 * return the largest perimeter of a triangle with non-zero area,
 * formed from 3 of these lengths.
 *
 * If it is impossible to form any triangle of non-zero area, return 0.
 *
 * Example 1:
 * Input:  [2, 1, 2]
 * Output: 5
 *
 * Example 2:
 * Input:  [1, 2, 1]
 * Output: 0
 *
 * Example 3:
 * Input:  [3, 2, 3, 4]
 * Output: 10
 *
 * Example 4:
 * Input:  [3, 6, 2, 3]
 * Output: 8
 *
 * Note:
 * 1. 3 <= A.length <= 10000
 * 2. 1 <= A[i] <= 10^6
 */

package array

class LargestPerimeterTriangle {
    fun largestPerimeter(A: IntArray): Int {
        if (A.size < 3) {
            return 0
        }

        A.sortDescending()

        for (i in 0 until A.size) {
            val a = A[i]
            for (j in i + 1 until A.size) {
                val b = A[j]
                for (k in j + 1 until A.size) {
                    val c = A[k]
                    if (a + b > c && a + c > b && b + c > a) {
                        return a + b + c
                    }
                }
            }
        }

        return 0
    }
}
