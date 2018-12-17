/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2018 Matthew Lee
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

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
