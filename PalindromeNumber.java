public final class Solution {
    public boolean isPalindrome(int x) {
        int m = x;
        int n = 0;

        if (x < 0) {
            return false;
        }

        while (x != 0) {
            n = n * 10 + x % 10;
            x = x / 10;
        }

        return (m == n);
    }
}
