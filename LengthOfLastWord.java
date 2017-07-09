public final class Solution {
    public int lengthOfLastWord(String string) {
        string = string.replaceAll(" +", " ");

        if (string.length() == 1 && string.equals(" ")) {
            return 0;
        }

        return string.split(" ")[string.split(" ").length - 1].length();
    }
}
