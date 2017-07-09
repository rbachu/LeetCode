public final class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        String str = null;

        try {
            str = arr[arr.length - 1].trim();
        } catch (ArrayIndexOutOfBoundsException a) {
            return "";
        } catch (NullPointerException n) {
            return "";
        }

        for (int i = arr.length - 2; i > -1; i--) {
            str = str.trim() + " " + arr[i].trim();
        }

        return str.trim();
    }
}

