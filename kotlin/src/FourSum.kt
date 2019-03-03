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
 * https://leetcode.com/problems/4sum/
 *
 * Given an array nums of n integers and an integer target,
 * are there elements a, b, c, and d in nums such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 *
 * Note:
 * The solution set must not contain duplicate quadruplets.
 *
 * Example:
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 * A solution set is:
 * [
 *     [-1,  0, 0, 1],
 *     [-2, -1, 1, 2],
 *     [-2,  0, 0, 2]
 * ]
 */

class FourSum {

    data class Four(val first: Int, val second: Int, val third: Int, val forth: Int)

    private val set = mutableSetOf<Four>()

    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        if (nums.size < 4) {
            return listOf()
        }

        nums.sort()

        val list = mutableListOf<List<Int>>()

        for (i in 0 until nums.size - 3) {
            val t = target - nums[i]

            for (j in i + 1 until nums.size - 2) {
                var start = j + 1
                var end = nums.lastIndex

                while (start < end) {
                    val sum = nums[j] + nums[start] + nums[end]
                    when {
                        sum == t -> {
                            val four = Four(nums[i], nums[j], nums[start], nums[end])
                            if (!set.contains(four)) {
                                set.add(four)
                                list.add(listOf(four.first, four.second, four.third, four.forth))
                            }

                            start++
                        }

                        sum < t -> start++
                        sum > t -> end--
                    }
                }
            }
        }

        return list
    }
}
