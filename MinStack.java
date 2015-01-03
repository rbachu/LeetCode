/*
 * 原题链接：https://oj.leetcode.com/problems/min-stack/
 * 2015.01.03
 *
 * 主要知识点：栈
 */

import java.util.*;

public class MinStack {
    public static void main(String[] args) {
        /* 测试 */
    }
}

/*
 * 这里比较讨巧地使用了两个栈，
 * 一个用来承载所有元素，
 * 另一个用来承载当前最小元素
 */
class Solution {
    private Stack<Integer> comStack = new Stack<Integer>();
    private Stack<Integer> minStack = new Stack<Integer>();

    public void push(int x) {
        comStack.push(x);

        if (minStack.size() > 0) {
            if (x <= minStack.peek()) {
                minStack.push(x);
            }
        } else {
            minStack.push(x);
        }
    }

    public void pop() {
        int x = comStack.pop();

        if (minStack.size() > 0) {
            if (x == minStack.peek()) {
                minStack.pop();
            }
        }
    }

    public int top() {
        return comStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
