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
 * https://leetcode.com/problems/symmetric-tree/
 *
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree [1, 2, 2, 3, 4, 4, 3] is symmetric:
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 * But the following [1, 2, 2, null, 3, null, 3] is not:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *     3   3
 *
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 */

package binarytree

class SymmetricTree {
    fun isSymmetric(root: TreeNode?): Boolean = isMirror(root, root)

    private fun isMirror(left: TreeNode?, right: TreeNode?): Boolean {
        if (left == null && right == null) {
            return true
        } else if (left == null && right != null) {
            return false
        } else if (left != null && right == null) {
            return false
        } else if (left != null && right != null) {
            val l = isMirror(left.left, right.right)
            val r = isMirror(left.right, right.left)
            return l && r && left.`val` == right.`val`
        }

        return false
    }
}
