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
 * https://leetcode.com/problems/binary-tree-right-side-view/
 *
 * Given a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 *
 * Example:
 * Input:   [1, 2, 3, null, 5, null, 4]
 * Output:  [1, 3, 4]
 * Explanation:
 *           1            <---
 *         /   \
 *        2     3         <---
 *         \     \
 *          5     4       <---
 */

package binarytree

import java.util.*

class BinaryTreeRightSideView {
    fun rightSideView(root: TreeNode?): List<Int> {
        if (root == null) {
            return listOf()
        }

        var latest = Pair(root, 0)
        val queue = LinkedList<Pair<TreeNode, Int>>().apply { offer(latest) }
        val list = mutableListOf<Int>()

        while (queue.isNotEmpty()) {
            val pair = queue.poll()

            if (pair.second != latest.second) {
                list.add(latest.first.`val`)
            }

            latest = pair

            pair.first.left?.let {
                queue.offer(Pair(it, pair.second.inc())) }
            pair.first.right?.let {
                queue.offer(Pair(it, pair.second.inc())) }
        }

        list.add(latest.first.`val`)
        return list
    }
}
