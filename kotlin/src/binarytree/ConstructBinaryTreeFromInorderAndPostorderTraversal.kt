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
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 *
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 * inorder =   [9, 3, 15, 20, 7]
 * postorder = [9, 15, 7, 20, 3]
 *
 * Return the following binary tree:
 *              3
 *             / \
 *            9  20
 *           / \
 *          15  7
 */

package binarytree

class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
        if (inorder.isEmpty() || postorder.isEmpty()) {
            return null
        }

        val root = TreeNode(postorder[postorder.lastIndex])
        val index = inorder.indexOf(postorder[postorder.lastIndex])

        if (index > 0) {
            root.left = buildTree(
                    inorder.copyOfRange(0, index),
                    postorder.copyOfRange(0, index))
        }

        if (inorder.size - index > 0) {
            root.right = buildTree(
                    inorder.copyOfRange(index + 1, inorder.size),
                    postorder.copyOfRange(index, postorder.size - 1))
        }

        return root
    }
}
