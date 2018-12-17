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

import java.util.HashMap;

final class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
public final class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashMap<Integer, ListNode> map = new HashMap<Integer, ListNode>();
        ListNode pointA = headA;
        ListNode pointB = headB;

        if (pointA == null || pointB == null) {
            return null;
        }

        while (pointA != null && pointB != null) {
            if (map.containsKey(pointA.val)) {
                return pointA;
            } else {
                map.put(pointA.val, pointA);
                pointA = pointA.next;
            }

            if (map.containsKey(pointB.val)) {
                return pointB;
            } else {
                map.put(pointB.val, pointB);
                pointB = pointB.next;
            }
        }

        while (pointA != null) {
            if (map.containsKey(pointA.val)) {
                return pointA;
            } else {
                pointA = pointA.next;
            }
        }

        while (pointB != null) {
            if (map.containsKey(pointB.val)) {
                return pointB;
            } else {
                pointB = pointB.next;
            }
        }

        return null;
    }
}
