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
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Example 1:
 * Input: 1 -> 2
 * Output: false
 *
 * Example 2:
 * Input: 1 -> 2 -> 2 -> 1
 * Output: true
 *
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 */

package linkedlist

class PalindromeLinkedList {
    fun isPalindrome(head: ListNode?): Boolean {
        if (head?.next == null) {
            return true
        }

        var revert: ListNode? = ListNode(head.`val`)
        var copy: ListNode? = revert
        var node = head.next

        while (node != null) {
            copy?.next = ListNode(node.`val`)
            copy = copy?.next
            node = node.next
        }

        revert = reverseList(revert)
        if (revert == null) {
            return false
        }

        node = head
        while (node != null) {
            if (node.`val` != revert?.`val`) {
                return false
            }

            revert = revert.next
            node = node.next
        }

        return true
    }

    private fun reverseList(head: ListNode?): ListNode? {
        if (head == null) {
            return null
        }

        var before: ListNode? = null
        var current = head
        var after: ListNode?

        while (current != null) {
            after = current.next
            current.next = before
            before = current
            current = after
        }

        head.next = null
        return before
    }
}
