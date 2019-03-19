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
 * https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
 *
 * Given a string S of '(' and ')' parentheses,
 * we add the minimum number of parentheses ( '(' or ')',
 * and in any positions ) so that the resulting parentheses string is valid.
 *
 * Formally, a parentheses string is valid if and only if:
 * 1. It is the empty string, or
 * 2. It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * 3. It can be written as (A), where A is a valid string.
 *
 * Given a parentheses string,
 * return the minimum number of parentheses we must add to make the resulting string valid.
 *
 * Example 1:
 * Input:  "())"
 * Output: 1
 *
 * Example 2:
 * Input:  "((("
 * Output: 3
 *
 * Example 3:
 * Input:  "()"
 * Output: 0
 *
 * Example 4:
 * Input:  "()))(("
 * Output: 4
 *
 * Note:
 * 1. S.length <= 1000
 * 2. S only consists of '(' and ')' characters.
 */

package stack

import java.util.*

class MinimumAddToMakeParenthesesValid {
    fun minAddToMakeValid(S: String): Int {
        val stack = Stack<Char>()

        for (c in S) {
            if (stack.isEmpty()) {
                stack.push(c)
            } else {
                if (stack.peek() == '(' && c == ')') {
                    stack.pop()
                } else {
                    stack.push(c)
                }
            }
        }

        return stack.size
    }
}
