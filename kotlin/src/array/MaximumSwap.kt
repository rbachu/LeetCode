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
 * https://leetcode.com/problems/maximum-swap/
 *
 * Given a non-negative integer, you could swap two digits at most once to get the maximum valued number.
 * Return the maximum valued number you could get.
 *
 * Example 1:
 * Input:  2736
 * Output: 7236
 * Explanation: Swap the number 2 and the number 7.
 *
 * Example 2:
 * Input:  9973
 * Output: 9973
 * Explanation: No swap.
 *
 * Note:
 * The given number is in the range [0, 10^8]
 */

package array

class MaximumSwap {
    fun maximumSwap(num: Int): Int {
        val array = num.toString().toCharArray()

        var maxNum = num
        var maxToggle = -1
        for (i in array.lastIndex downTo 0) {
            if (maxToggle < array[i] - '0') {
                maxToggle = array[i] - '0'

                for (j in 0 until i) {
                    val copy = array.copyOf()
                    val temp = copy[j]
                    copy[j] = copy[i]
                    copy[i] = temp

                    val newNum = String(copy).toInt()
                    if (maxNum < newNum) {
                        maxNum = newNum
                        break
                    }
                }
            }
        }

        return maxNum
    }
}
