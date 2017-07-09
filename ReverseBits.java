public final class Solution {
    public int reverseBits(int n) {
        int rev = 0;

        for (int i = 0; i < Integer.SIZE; i++) {
            if ((n & (1 << i)) != 0) {
                rev = rev | (1 << (Integer.SIZE - i - 1));
            }
        }

        return rev;
    }
}
