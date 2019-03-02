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
 * https://leetcode.com/problems/remove-linked-list-elements/
 *
 * Remove all elements from a linked list of integers that have value val.
 *
 * Example:
 * Input:  1 -> 2 -> 6 -> 3 -> 4 -> 5 -> 6, val = 6
 * Output: 1 -> 2 -> 3 -> 4 -> 5
 */
class RemoveLinkedListElements {
    // Definition for singly-linked list.
    class ListNode(var `val`: Int = 0) {
        var next: ListNode? = null
    }

    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        if (head == null) {
            return null
        }

        var result: ListNode? = null
        var holder: ListNode? = null
        var node = head

        while (node != null) {
            if (node.`val` == `val`) {
                holder?.next = node.next
            } else {
                if (result == null) {
                    result = node
                }

                holder = node
            }

            node = node.next
        }

        return result
    }
}
