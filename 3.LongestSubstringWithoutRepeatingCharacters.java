import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }

        List<Character> list = new ArrayList<>();
        Set<Character> set = new HashSet<>();
        int maxLength = 0;

        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                for (int i = 0; i < list.size(); i++) {
                    char e = list.get(i);
                    set.remove(e);

                    if (e == c) {
                        if (i + 1 < list.size()) {
                            list = new ArrayList<>(list.subList(i + 1, list.size()));
                        } else {
                            list.clear();
                        }
                        break;
                    }
                }
            }

            list.add(c);
            set.add(c);

            if (list.size() > maxLength) {
                maxLength = list.size();
            }
        }

        return maxLength;
    }
}