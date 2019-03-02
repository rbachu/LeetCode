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
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 *
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * Example:
 * Input: [1, null, 2, 3]
 * 1
 *  \
 *   2
 *  /
 * 3
 * Output: [1, 3, 2]
 *
 * Follow up:
 * Recursive solution is trivial, could you do it iteratively?
 */

import java.util.*

class BinaryTreeInorderTraversal {
    // Definition for a binary tree node.
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun inorderTraversal(root: TreeNode?): List<Int> {
        if (root == null) {
            return listOf()
        }

        val list = mutableListOf<Int>()
        val stack = Stack<TreeNode>()

        var node = root
        while (node != null || stack.isNotEmpty()) {
            node = node?.let {
                stack.push(it)
                it.left
            } ?: run {
                val n = stack.pop()
                list.add(n.`val`)
                n.right
            }
        }

        return list
    }
}
