package com.lsy.learn.projectlsy.algorithm;

import com.lsy.learn.projectlsy.dto.TreeNode;

import java.util.Arrays;

public class 分治相关 {
    public static void main(String[] args) {
        int[] a = new int[]{3, 9, 20, 15, 7};
        int[] b = new int[]{9, 3, 15, 20, 7};
        new 分治相关().buildTree(a, b);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        TreeNode treeNode = new TreeNode(preorder[0]);
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                treeNode.left = buildTree(Arrays.copyOfRange(preorder, 1, i + 1), Arrays.copyOfRange(inorder, 0, i));
                treeNode.right = buildTree(Arrays.copyOfRange(preorder, i + 1, preorder.length), Arrays.copyOfRange(inorder, i + 1, preorder.length));

            }
        }

        return treeNode;
    }
}
