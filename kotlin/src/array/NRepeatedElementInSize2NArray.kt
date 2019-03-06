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
 * https://leetcode.com/problems/n-repeated-element-in-size-2n-array/
 *
 * In a array A of size 2N, there are N+1 unique elements,
 * and exactly one of these elements is repeated N times.
 *
 * Return the element repeated N times.
 *
 * Example 1:
 * Input: [1, 2, 3, 3]
 * Output: 3
 *
 * Example 2:
 * Input: [2, 1, 2, 5, 3, 2]
 * Output: 2
 *
 * Example 3:
 * Input: [5, 1, 5, 2, 5, 3, 5, 4]
 * Output: 5
 *
 * Note:
 * 1. 4 <= A.length <= 10000
 * 2. 0 <= A[i] < 10000
 * 3. A.length is even
 */

package array

class NRepeatedElementInSize2NArray {
    fun repeatedNTimes(A: IntArray): Int {
        val map = mutableMapOf<Int, Int>()
        var result = 0

        for (i in 0 until A.size) {
            val temp = map.getOrDefault(A[i], 0) + 1
            if (temp > 1) {
                result = A[i]
                break
            }

            map[A[i]] = temp
        }

        return result
    }
}
