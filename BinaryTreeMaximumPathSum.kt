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
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 *
 * Given a **non-empty** binary tree, find the maximum path sum.
 *
 * For this problem, a path is defined as any sequence of nodes
 * from some starting node to any node in the tree along the parent-child connections.
 *
 * The path must contain **at least one node** and does not need to go through the root.
 *
 * Example 1:
 * Input: [1, 2, 3]
 * Output: 6
 *
 * Example 2:
 * Input: [-10, 9, 20, null, null, 15, 7]
 * Output: 42
 */

// Definition for a binary tree node.
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class BinaryTreeMaximumPathSum {
    private var max = Int.MIN_VALUE

    fun maxPathSum(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }

        max = Int.MIN_VALUE
        lrd(root)
        return max
    }

    private fun lrd(node: TreeNode?): Int = node?.let {
        val left = lrd(node.left)
        val right = lrd(node.right)
        val current = node.`val`

        var sum = current
        sum = Math.max(sum, current + left)
        sum = Math.max(sum, current + right)
        sum = Math.max(sum, current + left + right)
        if (max < sum) {
            max = sum
        }

        var result = current
        result = Math.max(result, current + left)
        result = Math.max(result, current + right)
        return@let result
    } ?: 0
}
