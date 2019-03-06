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
 * https://leetcode.com/problems/top-k-frequent-elements/
 *
 * Given a non-empty array of integers, return the k most frequent elements.
 *
 * Example 1:
 * Input: nums = [1, 1, 1, 2, 2, 3], k = 2
 * Output: [1, 2]
 *
 * Example 2:
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 * Note:
 * 1. You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * 2. Your algorithm's time complexity must be better than O(n*logn), where n is the array's size.
 */

package array

class TopKFrequentElements {
    fun topKFrequent(nums: IntArray, k: Int): List<Int> {
        val map = HashMap<Int, Int>()

        for (i in 0 until nums.size) {
            map[nums[i]] = map.getOrDefault(nums[i], 0) + 1
        }

        return map.entries.sortedWith(
                Comparator { o1, o2 ->
                    when {
                        o1.value < o2.value -> return@Comparator 1
                        o1.value > o2.value -> return@Comparator -1
                        else -> 0
                    }
                })
                .map { it.key }
                .subList(0, k)
    }
}
