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
 * https://leetcode.com/problems/partition-equal-subset-sum/
 *
 * Given a non-empty array containing only positive integers,
 * find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 *
 * Note:
 * 1. Each of the array element will not exceed 100.
 * 2. The array size will not exceed 200.
 *
 * Example 1:
 * Input: [1, 5, 11, 5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 *
 * Example 2:
 * Input: [1, 2, 3, 5]
 * Output: false
 * Explanation: The array cannot be partitioned into equal sum subsets.
 */

package dp

class PartitionEqualSubsetSum {
    fun canPartition(nums: IntArray): Boolean {
        if (nums.isEmpty()) {
            return true
        }

        var total = 0
        for (n in nums) {
            total += n
        }

        if (total % 2 != 0) {
            return false
        }

        total /= 2

        val dp = Array(nums.size + 1) { BooleanArray(total + 1) }
                .apply { this[0][0] = true }

        for (i in 1 until nums.size + 1) {
            dp[i][0] = true
        }

        for (j in 1 until total + 1) {
            dp[0][j] = false
        }

        for (i in 1 until nums.size + 1) {
            for (j in 1 until total + 1) {
                dp[i][j] = dp[i - 1][j]
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]]
                }
            }
        }

        return dp[nums.size][total]
    }
}
