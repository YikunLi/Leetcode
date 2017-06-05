package com.leetcode;

/**
 * @author liyikun 2017/06/05
 * @see
 *      <a
 *      href=
 *      "https://leetcode.com/problems/merge-two-sorted-lists/#/description">
 *      21. Merge Two Sorted Lists</a>
 * @description
 *              Merge two sorted linked lists and return it as a new list. The
 *              new list should be made by splicing together the nodes of the
 *              first two lists.
 */
public class L021MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode pointer = null;
        ListNode node1 = new ListNode(2);
        pointer = node1;
        pointer.next = new ListNode(4);
        pointer = pointer.next;
        pointer.next = new ListNode(5);
        printList(node1);
        ListNode node2 = new ListNode(1);
        pointer = node2;
        pointer.next = new ListNode(3);
        printList(node2);
        Solution solution = new SolutionImpl();
        ListNode result = solution.mergeTwoLists(node1, node2);
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

        public ListNode mergeTwoLists(ListNode l1, ListNode l2);
    }

    public static class SolutionImpl implements Solution {

        @Override
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null && l2 == null) {
                return null;
            }
            ListNode node = null;
            ListNode pointer = null;
            while (l1 != null || l2 != null) {
                int number = 0;
                if (l1 != null && l2 != null) {
                    if (l1.val < l2.val) {
                        number = l1.val;
                        l1 = l1.next;
                    } else {
                        number = l2.val;
                        l2 = l2.next;
                    }
                } else if (l1 != null) {
                    number = l1.val;
                    l1 = l1.next;
                } else if (l2 != null) {
                    number = l2.val;
                    l2 = l2.next;
                }
                if (node == null) {
                    node = new ListNode(number);
                    pointer = node;
                } else {
                    pointer.next = new ListNode(number);
                    pointer = pointer.next;
                }
            }
            return node;
        }

    }

}
