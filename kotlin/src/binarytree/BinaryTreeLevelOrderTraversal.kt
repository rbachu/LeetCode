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
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 *
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree [3, 9, 20, null, null, 15, 7],
 *              3
 *             / \
 *            9  20
 *           / \
 *          15  7
 * return its level order traversal as:
 * [
 *     [3],
 *     [9, 20],
 *     [15, 7]
 * ]
 */

package binarytree

import java.util.*

class BinaryTreeLevelOrderTraversal {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) {
            return listOf()
        }

        val map = hashMapOf<Int, MutableList<Int>>()
        val queue = LinkedList<Pair<TreeNode, Int>>()
                .apply { offer(Pair(root, 0)) }

        while (queue.isNotEmpty()) {
            val pair = queue.poll()
            map[pair.second] = map.getOrDefault(pair.second, mutableListOf())
                    .apply { add(pair.first.`val`) }
            pair.first.left?.let { queue.offer(Pair(it, pair.second + 1)) }
            pair.first.right?.let { queue.offer(Pair(it, pair.second + 1)) }
        }

        return map.toSortedMap().map { it.value }
    }
}
