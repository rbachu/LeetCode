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
 * https://leetcode.com/problems/boats-to-save-people/
 *
 * The i-th person has weight people[i], and each boat can carry a maximum weight of limit.
 *
 * Each boat carries at most 2 people at the same time,
 * provided the sum of the weight of those people is at most limit.
 *
 * Return the minimum number of boats to carry every given person.
 * (It is guaranteed each person can be carried by a boat.)
 *
 * Example 1:
 * Input:  people = [1, 2], limit = 3
 * Output: 1
 * Explanation: 1 boat (1, 2)
 *
 * Example 2:
 * Input:  people = [3, 2, 2, 1], limit = 3
 * Output: 3
 * Explanation: 3 boats (1, 2), (2) and (3)
 *
 * Example 3:
 * Input:  people = [3, 5, 3, 4], limit = 5
 * Output: 4
 * Explanation: 4 boats (3), (3), (4), (5)
 *
 * Note:
 * 1. 1 <= people.length <= 50000
 * 2. 1 <= people[i] <= limit <= 30000
 */

package greedy

class BoatsToSavePeople {
    fun numRescueBoats(people: IntArray, limit: Int): Int {
        people.sort()

        var boat = 0
        var small = 0
        var large = people.lastIndex

        while (true) {
            if (small > large) {
                break
            }

            val last = limit - people[large--]
            if (last >= people[small]) {
                small++
            }

            boat++
        }

        return boat
    }
}
