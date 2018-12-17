/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2018 Matthew Lee
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

import java.util.Stack;

public final class Solution {
    private static final char ROUND_LEFT = '(';
    private static final char ROUND_RIGHT = ')';

    private static final char SQUARE_LEFT = '[';
    private static final char SQUARE_RIGHT = ']';

    private static final char BRACE_LEFT = '{';
    private static final char BRACE_RIGHT = '}';

    public boolean isValid(String string) {
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            switch (c) {
                case ROUND_LEFT:
                case SQUARE_LEFT:
                case BRACE_LEFT:
                    stack.push(c);
                    break;
                case ROUND_RIGHT:
                    if (stack.empty() || stack.peek() != ROUND_LEFT) {
                        return false;
                    }
                    stack.pop();
                    break;
                case SQUARE_RIGHT:
                    if (stack.empty() || stack.peek() != SQUARE_LEFT) {
                        return false;
                    }
                    stack.pop();
                    break;
                case BRACE_RIGHT:
                    if (stack.empty() || stack.peek() != BRACE_LEFT) {
                        return false;
                    }
                    stack.pop();
                    break;
                default:
                    break;
            }
        }

        if (!stack.empty()) {
            return false;
        }
        
        return true;
    }
}
