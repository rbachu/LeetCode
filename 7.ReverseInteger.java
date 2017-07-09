public final class Solution {
    public int reverse(int x) {
        int result = 0;
        boolean isNeg = false;

        if (x < 0) {
            x = -x;
            isNeg = true;
        }
        
        while (x / 10 != 0) {
            result = result * 10 + x % 10;
            x = x / 10;
        }
        result = result * 10 + x;

        if (result > Integer.MAX_VALUE) {
            return 0;
        } else {
            if (isNeg) {
                result = -result;
            }
        }

        return result;
    }
}
