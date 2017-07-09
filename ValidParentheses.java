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
