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
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 *
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Example:
 * Given linked list: 1 -> 2 -> 3 -> 4 -> 5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1 -> 2 -> 3 -> 5.
 *
 * Note:
 * Given n will always be valid.
 *
 * Follow up:
 * Could you do this in one pass?
 */

package linkedlist

class RemoveNthNodeFromEndOfList {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var mark: ListNode? = null
        var node = head
        var count = -n

        while (node != null) {
            node = node.next
            count++

            if (count > 0) {
                mark = if (mark == null) { head } else { mark.next }
            }
        }

        if (mark?.next != null) {
            mark.next = mark.next?.next
        }

        return if (mark == null) { head?.next } else { head }
    }
}
