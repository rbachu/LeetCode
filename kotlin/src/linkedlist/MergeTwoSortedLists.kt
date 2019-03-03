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
 * https://leetcode.com/problems/merge-two-sorted-lists/
 *
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 *
 * Example:
 * Input: 1 -> 2 -> 4, 1 -> 3 -> 4
 * Output: 1 -> 1 -> 2 -> 3 -> 4 -> 4
 */

package linkedlist

class MergeTwoSortedLists {
    // Definition for singly-linked list.
    class ListNode(var `val`: Int = 0) {
        var next: ListNode? = null
    }

    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 != null && l2 == null) {
            return l1
        } else if (l1 == null && l2 != null) {
            return l2
        } else if (l1 == null && l2 == null) {
            return null
        }

        var n1 = l1
        var n2 = l2
        var head: ListNode? = null
        var node: ListNode? = null

        while (n1 != null && n2 != null) {
            val current = if (n1.`val` < n2.`val`) {
                val n = n1
                n1 = n1.next
                n
            } else {
                val n = n2
                n2 = n2.next
                n
            }

            if (node == null) {
                node = current
            } else {
                node.next = current
                node = node.next
            }

            if (head == null) {
                head = current
            }
        }

        if (n1 != null) {
            node?.next = n1
        } else if (n2 != null) {
            node?.next = n2
        }

        return head
    }
}
