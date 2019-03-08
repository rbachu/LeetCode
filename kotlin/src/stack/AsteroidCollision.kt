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
 * https://leetcode.com/problems/asteroid-collision/
 *
 * We are given an array asteroids of integers representing asteroids in a row.
 *
 * For each asteroid, the absolute value represents its size,
 * and the sign represents its direction (positive meaning right, negative meaning left).
 * Each asteroid moves at the same speed.
 *
 * Find out the state of the asteroids after all collisions.
 * If two asteroids meet, the smaller one will explode.
 * If both are the same size, both will explode.
 * Two asteroids moving in the same direction will never meet.
 *
 * Example 1:
 * Input: asteroids = [5, 10, -5]
 * Output: [5, 10]
 * Explanation: The 10 and -5 collide resulting in 10.  The 5 and 10 never collide.
 *
 * Example 2:
 * Input: asteroids = [8, -8]
 * Output: []
 * Explanation: The 8 and -8 collide exploding each other.
 *
 * Example 3:
 * Input: asteroids = [10, 2, -5]
 * Output: [10]
 * Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
 *
 * Example 4:
 * Input: asteroids = [-2, -1, 1, 2]
 * Output: [-2, -1, 1, 2]
 * Explanation: The -2 and -1 are moving left, while the 1 and 2 are moving right.
 *              Asteroids moving the same direction never meet, so no asteroids will meet each other.
 *
 * Note:
 * 1. The length of asteroids will be at most 10000.
 * 2. Each asteroid will be a non-zero integer in the range [-1000, 1000].
 */

package stack

import java.util.*

class AsteroidCollision {
    fun asteroidCollision(asteroids: IntArray): IntArray {
        if (asteroids.isEmpty()) {
            return intArrayOf()
        }

        val stack = Stack<Int>()

        for (i in 0 until asteroids.size) {
            val current = asteroids[i]
            while (true) {
                if (stack.isNotEmpty()) {
                    val last = stack.peek()
                    if (last > 0 && current < 0) {
                        if (Math.abs(last) < Math.abs(current)) {
                            stack.pop()
                        } else if (Math.abs(last) == Math.abs(current)) {
                            stack.pop()
                            break
                        } else {
                            break
                        }
                    } else {
                        stack.push(current)
                        break
                    }
                } else {
                    stack.push(current)
                    break
                }
            }
        }

        return stack.toIntArray()
    }
}
