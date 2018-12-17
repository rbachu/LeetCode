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

public final class Solution {
    public int compareVersion(String first, String second) {
        String[] arrayF = first.split("\\.");
        String[] arrayS = second.split("\\.");
        int maxLength = (arrayF.length > arrayS.length) ? arrayF.length : arrayS.length;

        int[] valueF = new int[maxLength];
        for (int i = 0; i < arrayF.length; i++) {
            valueF[i] = Integer.valueOf(arrayF[i]);
        }

        int[] valueS = new int[maxLength];
        for (int i = 0; i < arrayS.length; i++) {
            valueS[i] = Integer.valueOf(arrayS[i]);
        }

        for (int i = 0; i < maxLength; i++) {
            if (valueF[i] > valueS[i]) {
                return 1;
            } else if (valueF[i] < valueS[i]) {
                return -1;
            }
        }

        return 0;
    }
}
