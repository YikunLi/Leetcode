package com.leetcode;

/**
 * @author liyikun 2017/06/01
 * @see
 *      <a href="https://leetcode.com/problems/add-two-numbers/#/description">2.
 *      Add Two Numbers</a>
 * @description
 *              You are given two non-empty linked lists representing two
 *              non-negative integers. The digits are stored in reverse order
 *              and each of their nodes contain a single digit. Add the two
 *              numbers and return it as a linked list.
 *              You may assume the two numbers do not contain any leading zero,
 *              except the number 0 itself.
 *              Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 *              Output: 7 -> 0 -> 8
 */
public class L002AddTwoNumbers {

    public static void main(String[] args) {
        ListNode pointer = null;
        ListNode node1 = new ListNode(2);
        pointer = node1;
        pointer.next = new ListNode(4);
        pointer = pointer.next;
        pointer.next = new ListNode(3);
        printList(node1);
        ListNode node2 = new ListNode(5);
        pointer = node2;
        pointer.next = new ListNode(6);
        pointer = pointer.next;
        pointer.next = new ListNode(4);
        printList(node2);
        Solution solution = new Traverse();
        ListNode result = solution.addTwoNumbers(node1, node2);
        printList(result);
    }

    private static void printList(ListNode head) {
        ListNode pointer = head;
        while (pointer != null) {
            System.out.print(pointer.val + " -> ");
            pointer = pointer.next;
        }
        System.out.println();
    }

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }
    }

    public static interface Solution {

        public ListNode addTwoNumbers(ListNode l1, ListNode l2);
    }

    public static class Traverse implements Solution {

        @Override
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if (l1 == null && l2 == null) {
                return null;
            } else if (l1 == null) {
                return l2;
            } else if (l2 == null) {
                return l1;
            }

            ListNode pointer = null;
            ListNode header = null;
            int carry = 0;
            while (l1 != null || l2 != null || carry != 0) {
                int value = carry;
                if (l1 != null) {
                    value += l1.val;
                    l1 = l1.next;
                }
                if (l2 != null) {
                    value += l2.val;
                    l2 = l2.next;
                }
                if (value >= 10) {
                    carry = value / 10;
                    value %= 10;
                } else {
                    carry = 0;
                }
                if (header == null) {
                    header = new ListNode(value);
                    pointer = header;
                } else {
                    pointer.next = new ListNode(value);
                    pointer = pointer.next;
                }
            }
            return header;
        }

    }
}
