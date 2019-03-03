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
 * https://leetcode.com/problems/3sum/
 *
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * A solution set is:
 * [
 *     [-1,  0, 1],
 *     [-1, -1, 2]
 * ]
 */

package others

class ThreeSum {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val set = mutableSetOf<Triple<Int, Int, Int>>()
        val list = nums.toMutableList().sorted()

        for (i in list.indices) {
            val target = list[i]
            val copy = list.subList(i + 1, list.size).toMutableList()

            while (copy.isNotEmpty()) {
                val find = twoSum(-target, copy)
                if (find[0] == 0 && find[1] == 0) {
                    break
                }

                val first = copy[find[0]]
                val second = copy[find[1]]

                set.add(Triple(target, first, second))
                copy.remove(first)
                copy.remove(second)
            }
        }

        return set.map { triple -> triple.toList() }
    }

    // https://leetcode.com/problems/two-sum/
    private fun twoSum(target: Int, list: List<Int>): List<Int> {
        val result = arrayListOf(0, 0)
        val map = hashMapOf<Int, Int>()

        for (i in list.indices) {
            val key = target - list[i]

            if (map.containsKey(key)) {
                result[0] = map.getOrDefault(key, 0)
                result[1] = i
                return result
            }

            map[list[i]] = i
        }

        return result
    }
}
