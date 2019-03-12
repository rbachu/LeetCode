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
 * Given an array of integers A sorted in non-decreasing order,
 * return an array of the squares of each number, also in sorted non-decreasing order.
 *
 * Example 1:
 * Input:  [-4, -1, 0, 3, 10]
 * Output: [0, 1, 9, 16, 100]
 *
 * Example 2:
 * Input:  [-7, -3, 2, 3, 11]
 * Output: [4, 9, 9, 49, 121]
 *
 * Note:
 * 1. 1 <= A.length <= 10000
 * 2. -10000 <= A[i] <= 10000
 * 3. A is sorted in non-decreasing order.
 */

package array

class SquaresOfASortedArray {
    fun sortedSquares(A: IntArray): IntArray {
        var j = 0
        while (j < A.size && A[j] < 0) {
            j++
        }

        val result = IntArray(A.size)
        if (j == A.size) {
            for (i in A.lastIndex downTo 0) {
                result[A.lastIndex - i] = A[i] * A[i]
            }

            return result
        }

        var i = j - 1
        var k = 0

        while (i >= 0 && j < result.size) {
            val first = A[i] * A[i]
            val second = A[j] * A[j]

            if (first < second) {
                result[k] = first
                i--
            } else {
                result[k] = second
                j++
            }

            k++
        }

        while (i >= 0) {
            result[k] = A[i] * A[i]
            i--
            k++
        }

        while (j < result.size) {
            result[k] = A[j] * A[j]
            j++
            k++
        }

        return result
    }
}
