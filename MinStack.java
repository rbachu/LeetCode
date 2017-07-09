import java.util.*;

public final class Solution {
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
