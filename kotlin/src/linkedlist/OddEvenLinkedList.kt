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
 * https://leetcode.com/problems/odd-even-linked-list/
 *
 * Given a singly linked list, group all odd nodes together followed by the even nodes.
 * Please note here we are talking about the node number and not the value in the nodes.
 *
 * You should try to do it in place.
 * The program should run in O(1) space complexity and O(nodes) time complexity.
 *
 * Example 1:
 * Input:  1 -> 2 -> 3 -> 4 -> 5 -> NULL
 * Output: 1 -> 3 -> 5 -> 2 -> 4 -> NULL
 *
 * Example 2:
 * Input:  2 -> 1 -> 3 -> 5 -> 6 -> 4 -> 7 -> NULL
 * Output: 2 -> 3 -> 6 -> 7 -> 1 -> 5 -> 4 -> NULL
 *
 * Note:
 * 1. The relative order inside both the even and odd groups should remain as it was in the input.
 * 2. The first node is considered odd, the second node even and so on...
 */

package linkedlist

class OddEvenLinkedList {
    fun oddEvenList(head: ListNode?): ListNode? {
        if (head?.next == null) {
            return head
        }

        var odd = head
        var even = head.next
        val evenHead = head.next

        while (even?.next != null) {
            odd?.next = even.next
            odd = odd?.next
            even.next = odd?.next
            even = even.next
        }

        odd?.next = evenHead
        return head
    }
}
