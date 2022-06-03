package com.lsy.learn.projectlsy.algorithm;

import com.lsy.learn.projectlsy.dto.ListNode;

public class 链表逆置_2 {
    public static void main(String[] args) {

    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = head;
        ListNode leftHead = head;
        ListNode rightHead = head;
        return null;
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
}
