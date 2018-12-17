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
    public int[] searchRange(int[] arr, int target) {
        int[] result = {-1, -1};
        int index = search(arr, target, 0, arr.length - 1);

        if (index != -1) {
            int left = index;
            int right = index;
            result[0] = left;
            result[1] = right;

            while ((left = search(arr, target, 0, left - 1)) != -1) {
                result[0] = left;
            }

            while ((right = search(arr, target, right + 1, arr.length - 1)) != -1) {
                result[1] = right;
            }
        }

        return result;
    }
    
    private int search(int arr[], int target, int low, int high) {
        int middle = low + (high - low) / 2;

        if (low > high) {
            return -1;
        } else {
            if (arr[middle] == target) {
                return middle;
            } else if (arr[middle] > target) {
                return search(arr, target, low, middle - 1);
            } else {
                return search(arr, target, middle + 1, high);
            }
        }
    }
}


