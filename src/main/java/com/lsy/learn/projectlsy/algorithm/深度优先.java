package com.lsy.learn.projectlsy.algorithm;

import com.lsy.learn.projectlsy.dto.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 深度优先 {
    public static void main(String[] args) {


        TreeNode root4 = new TreeNode(7, null, null);
        TreeNode root3 = new TreeNode(15, null, null);

        TreeNode root2 = new TreeNode(20, root3, root4);
        TreeNode root1 = new TreeNode(9, null, null);
        TreeNode root = new TreeNode(3, root1, root2);

        List<List<Integer>> res = new 深度优先().zigzagLevelOrder(root);
        System.out.println(res);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    public void dfs(TreeNode root, int level, List<List<Integer>> result) {
        if (level == result.size()) {
            LinkedList<Integer> newLevel = new LinkedList<>();
            newLevel.add(root.val);
            result.add(newLevel);
        } else {
            if (level % 2 == 0) {
                result.get(level).add(root.val);
            } else {
                result.get(level).add(0, root.val);
            }
        }

        if (root.left != null) {
            dfs(root.left, level + 1, result);
        }

        if (root.right != null) {
            dfs(root.right, level + 1, result);
        }
    }
}
