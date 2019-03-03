/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2019 Matthew Lee
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

/*
 * https://leetcode.com/problems/reverse-linked-list-ii/
 *
 * Reverse a linked list from position m to n. Do it in one-pass.
 *
 * Note:
 * 1 ≤ m ≤ n ≤ length of list.
 *
 * Example:
 * Input:  1 -> 2 -> 3 -> 4 -> 5 -> NULL, m = 2, n = 4
 * Output: 1 -> 4 -> 3 -> 2 -> 5 -> NULL
 */

package linkedlist

class ReverseLinkedListII {
    fun reverseBetween(head: ListNode?, m: Int, n: Int): ListNode? {
        if (head == null || m == n) {
            return head
        }

        var before: ListNode? = null
        var current = head

        var h: ListNode? = null
        var t: ListNode? = null
        var index = 1

        while (current != null) {
            if (index < m) {
                before = current
                current = current.next
                index++
            } else if (index in m..n) {
                if (h == null) {
                    h = before
                }

                val after = current.next
                current.next = before
                before = current

                if (t == null) {
                    t = current
                }

                current = after
                index++
            } else {
                break
            }
        }

        if (h != null) {
            h.next = before
        }

        if (t != null) {
            t.next = current
        }

        return if (m > 1) { head } else { before }
    }
}
