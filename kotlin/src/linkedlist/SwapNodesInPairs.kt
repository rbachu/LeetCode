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
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * Example:
 * Given 1 -> 2 -> 3 -> 4, you should return the list as 2 -> 1 -> 4 -> 3.
 */

package linkedlist

class SwapNodesInPairs {
    fun swapPairs(head: ListNode?): ListNode? {
        if (head?.next == null) {
            return head
        }

        var result: ListNode? = null
        var holder: ListNode? = null
        var node = head
        var count = 0

        while (true) {
            if (node == null) {
                break
            }

            if (count % 2 == 0) {
                val i = node.next
                if (i != null) {
                    val j = i.next
                    i.next = node
                    node.next = j
                    node = i
                    holder?.next = node
                }
            } else {
                holder = node
            }

            if (result == null) {
                result = node
            }

            node = node.next
            count++
        }

        return result
    }
}
