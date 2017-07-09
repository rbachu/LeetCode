public final class Solution {
    public int trailingZeroes(int n) {
        double div = 0;
        int power = 1;
        int zeros = 0;

        while (div < n) {
            div = Math.pow(5, power);
            zeros += (int) (n / div);
            power++;
        }

        return zeros;
    }
}
