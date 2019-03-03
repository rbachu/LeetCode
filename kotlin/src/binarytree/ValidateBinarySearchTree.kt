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
 * https://leetcode.com/problems/validate-binary-search-tree/
 *
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 * 1. The left subtree of a node contains only nodes with keys less than the node's key.
 * 2. The right subtree of a node contains only nodes with keys greater than the node's key.
 * 3. Both the left and right subtrees must also be binary search trees.
 *
 * Example 1:
 * Input:
 *   2
 *  / \
 * 1   3
 * Output: true
 *
 * Example 2:
 * Input:
 *     5
 *    / \
 *   1   4
 *  / \
 * 3   6
 * Output: false
 * Explanation: The input is: [5, 1, 4, null, null, 3, 6].
 *              The root node's value is 5 but its right child's value is 4.
 */

package binarytree

class ValidateBinarySearchTree {
    fun isValidBST(root: TreeNode?): Boolean {
        val list = mutableListOf<Int>()
        inorder(root, list)

        for (i in 0 until list.size - 1) {
            if (list[i] > list[i + 1]) {
                return false
            }
        }

        return true
    }

    fun inorder(node: TreeNode?, list: MutableList<Int>) {
        node?.let {
            inorder(it.left, list)
            list.add(it.`val`)
            inorder(it.right, list)
        }
    }
}
