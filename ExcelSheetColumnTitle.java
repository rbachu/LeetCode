public final class Solution {
    public String convertToTitle(int n) {
        String string = "";

        while (n > 0) {
            string = (char) ((--n) % 26 + 65) + string;
            n /= 26;
        }

        return string;
    }
}