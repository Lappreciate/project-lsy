package com.lsy.learn.projectlsy.algorithm;

import com.lsy.learn.projectlsy.dto.ListNode;

import java.util.List;

/**
 * leetcode 143
 * L0 → L1 → … → Ln - 1 → Ln
 * <p>
 * 1 2 3 4 5
 * 请将其重新排列后变为：
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 */
public class 链表相关 {


    public static void main(String[] args) {


        ListNode node_5 = new ListNode(5, null);
        ListNode node_4 = new ListNode(4, node_5);
        ListNode node_3 = new ListNode(3, node_4);
        ListNode node_2 = new ListNode(2, node_3);
        ListNode head = new ListNode(1, node_2);


        new 链表相关().reorderList(head);
        new 链表相关().printList(head);

    }

    public void printList(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
    }


    public void reorderList(ListNode head) {
        ListNode l1 = head;
        ListNode l2 = null;


        ListNode slow = head;
        ListNode quick = head;

        while (quick != null && quick.next != null) {
            slow = slow.next;
            quick = quick.next.next;
        }

        l2 = slow.next;
        slow.next = null;

        ListNode newL2 = reverseList(l2);

        head = mergeListOneByOne(l1, newL2, 1);
    }

    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null;
        ListNode cur = head;
        ListNode after = head.next;

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

    public ListNode mergeListOneByOne(ListNode l1, ListNode l2, int counter) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode l;

        if (counter % 2 == 1) {
            l = l1;
            l.next = mergeListOneByOne(l1.next, l2, counter + 1);
        } else {
            l = l2;
            l.next = mergeListOneByOne(l1, l2.next, counter + 1);
        }

        return l;
    }

    public ListNode mergeList(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode l;

        if (l1.val < l2.val) {
            l = l1;
            l.next = mergeList(l1.next, l2);
        } else {
            l = l2;
            l.next = mergeList(l1, l2.next);
        }

        return l;
    }
}
