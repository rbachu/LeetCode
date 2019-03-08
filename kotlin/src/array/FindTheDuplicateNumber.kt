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
 * https://leetcode.com/problems/find-the-duplicate-number/
 *
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
 * prove that at least one duplicate number must exist.
 * Assume that there is only one duplicate number, find the duplicate one.
 *
 * Example 1:
 * Input: [1, 3, 4, 2, 2]
 * Output: 2
 *
 * Example 2:
 * Input: [3, 1, 3, 4, 2]
 * Output: 3
 *
 * Note:
 * 1. You must not modify the array (assume the array is read only).
 * 2. You must use only constant, O(1) extra space.
 * 3. Your runtime complexity should be less than O(n^2).
 * 4. There is only one duplicate number in the array, but it could be repeated more than once.
 */

package array

class FindTheDuplicateNumber {
    fun findDuplicate(nums: IntArray): Int {
        // Find the intersection point of the two runners.
        var tortoise = nums[0]
        var hare = nums[0]
        do {
            tortoise = nums[tortoise]
            hare = nums[nums[hare]]
        } while (tortoise != hare)

        // Find the "entrance" to the cycle.
        var ptr1 = nums[0]
        var ptr2 = tortoise
        while (ptr1 != ptr2) {
            ptr1 = nums[ptr1]
            ptr2 = nums[ptr2]
        }

        return ptr1
    }
}
