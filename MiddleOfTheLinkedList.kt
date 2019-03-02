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
 * https://leetcode.com/problems/middle-of-the-linked-list/
 *
 * Given a non-empty, singly linked list with head node head, return a middle node of linked list.
 * If there are two middle nodes, return the second middle node.
 *
 * Example 1:
 * Input: [1, 2, 3, 4, 5]
 * Output: Node 3 from this list (Serialization: [3,4,5]) The returned node has value 3.
 *         (The judge's serialization of this node is [3,4,5]).
 *         Note that we returned a ListNode object ans, such that:
 *         ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
 *
 * Example 2:
 * Input: [1, 2, 3, 4, 5, 6]
 * Output: Node 4 from this list (Serialization: [4,5,6])
 *         Since the list has two middle nodes with values 3 and 4, we return the second one.
 */
class MiddleOfTheLinkedList {
    // Definition for singly-linked list.
    class ListNode(var `val`: Int = 0) {
        var next: ListNode? = null
    }

    fun middleNode(head: ListNode?): ListNode? {
        if (head == null) {
            return null
        }

        var middle = head
        var node = head
        var size = 1

        while (node != null) {
            middle = if (middle!!.next != null) {
                size++
                middle.next
            } else {
                break
            }

            middle = if (middle!!.next != null) {
                size++
                middle.next
            } else {
                break
            }

            node = node.next
        }

        return if (size % 2 == 0) { node?.next } else { node }
    }
}
