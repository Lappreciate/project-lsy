package com.lsy.learn.projectlsy.algorithm.list;

import com.lsy.learn.projectlsy.dto.ListNode;

public class SortList {
    public static void main(String[] args) {
        ListNode node5 = new ListNode(6, null);
        ListNode node4 = new ListNode(5, node5);
        ListNode node3 = new ListNode(4, node4);
        ListNode node2 = new ListNode(3, node3);
        ListNode node1 = new ListNode(2, node2);
        ListNode root = new ListNode(1, node1);

//        printList(root);
        printList(func(root));
    }

    public static void printList(ListNode root) {
        while (root != null) {
            System.out.println(root.val);
            root = root.next;
        }
    }


    /**
     * 1234
     * 1423
     *
     * @param root
     * @return
     */
    public static ListNode func(ListNode root) {

        if (root == null || root.next == null) return root;

        ListNode slow = root;
        ListNode fast = root;
        ListNode newRoot = null;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        newRoot = slow.next;
        slow.next = null;

        ListNode index = root;
        ListNode rootAfterReverse = reverseList(newRoot);
        ListNode rootAfterReverseNext = rootAfterReverse.next;
        while (rootAfterReverse != null) {
            rootAfterReverse.next = index.next;
            index.next = rootAfterReverse;
            index = index.next.next;
            rootAfterReverse = rootAfterReverseNext;
            if (rootAfterReverseNext != null) {
                rootAfterReverseNext = rootAfterReverseNext.next;
            }
        }
        return root;
    }

    private static ListNode reverseList(ListNode root) {
        ListNode pre = null;
        ListNode cur = root;
        ListNode after = root.next;

        while (true) {
            cur.next = pre;
            if (after == null) {
                return cur;
            }
            pre = cur;
            cur = after;
            after = after.next;
        }
    }
}

























