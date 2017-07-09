public final class Solution {
    private String prefix = "";

    private int charAt(String string, int index) {
        if (index < string.length()) {
            return string.charAt(index);
        }

        return -1;
    }

    private void find(String[] strings, int low, int high, int index) {
        if (high <= low) {
            return;
        }

        int left = low;
        int right = high;
        int i = low + 1;
        int cmp = charAt(strings[low], index);
        
        while (i <= right) {
            int temp = charAt(strings[i], index);
            if (temp < cmp) {
                left++;
                i++;
            } else if (temp > cmp) {
                right--;
            } else {
                i++;
            }
        }

        if (right - left < high - low || index == strings[low].length()) {
            prefix = strings[low].substring(0, index);
            return;
        }

        if (cmp >= 0) {
            find(strings, low, high, index + 1);
        }
    }

    public String longestCommonPrefix(String[] strings) {
        if (strings.length == 1) {
            return strings[0];
        }

        find(strings, 0, strings.length - 1, 0);

        return prefix;
    }
}