public final class Solution {
    public int titleToNumber(String string) {
        int sum = 0;

        string = string.toUpperCase();
        for (int i = 0; i < string.length(); i++) {
            sum += (string.charAt(i) - 64) * Math.pow(26, string.length() - i - 1);
        }

        return sum;
    }
}
