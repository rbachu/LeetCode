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
 * https://leetcode.com/problems/maximum-product-subarray/
 *
 * Given an integer array nums, find the contiguous subarray within an array
 * (containing at least one number) which has the largest product.
 *
 * Example 1:
 * Input:  [2, 3, -2, 4]
 * Output: 6
 * Explanation: [2, 3] has the largest product 6.
 *
 * Example 2:
 * Input:  [-2, 0, -1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2, -1] is not a subarray.
 */

package dp

class MaximumProductSubarray {
    fun maxProduct(nums: IntArray): Int {
        var max = Int.MIN_VALUE
        var min = Int.MIN_VALUE
        var result = Int.MIN_VALUE

        for (i in 0 until nums.size) {
            if (i == 0) {
                max = nums[i]
                min = nums[i]
                result = nums[i]
            } else {
                val temp = max
                max = maxOf(maxOf(max * nums[i], min * nums[i]), nums[i])
                min = minOf(minOf(temp * nums[i], min * nums[i]), nums[i])
                result = maxOf(result, maxOf(max, min))
            }
        }

        return result
    }
}
