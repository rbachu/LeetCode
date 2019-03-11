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
 * https://leetcode.com/problems/sort-array-by-parity/
 *
 * Given an array A of non-negative integers,
 * return an array consisting of all the even elements of A,
 * followed by all the odd elements of A.
 *
 * You may return any answer array that satisfies this condition.
 *
 * Example 1:
 * Input:  [3, 1, 2, 4]
 * Output: [2, 4, 3, 1]
 *         The outputs [4, 2, 3, 1], [2, 4, 1, 3], and [4, 2, 1, 3] would also be accepted.
 *
 * Note:
 * 1. 1 <= A.length <= 5000
 * 2. 0 <= A[i] <= 5000
 */

package array

class SortArrayByParity {
    fun sortArrayByParity(A: IntArray): IntArray {
        if (A.isEmpty()) {
            return intArrayOf()
        }

        sort(A, 0, A.lastIndex)
        return A
    }

    private fun sort(A: IntArray, low: Int, high: Int) {
        if (low <= high) {
            val part = part(A, low, high)
            sort(A, low, part - 1)
            sort(A, part + 1,high)
        }
    }

    private fun part(A: IntArray, low: Int, high: Int): Int {
        var i = low
        var j = high

        while (true) {
            while (A[j] % 2 != 0) {
                if (j - 1 < low) {
                    break
                } else {
                    j--
                }
            }

            while (A[i] % 2 == 0) {
                if (i + 1 > high) {
                    break
                } else {
                    i++
                }
            }

            if (i >= j) {
                break
            }

            val temp = A[i]
            A[i] = A[j]
            A[j] = temp
        }

        val temp = A[low]
        A[low] = A[j]
        A[j] = temp

        return j
    }
}
