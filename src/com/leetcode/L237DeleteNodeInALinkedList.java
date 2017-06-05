package com.leetcode;

/**
 * @author liyikun 2017/06/05
 * @see
 *      <a href=
 *      "https://leetcode.com/problems/delete-node-in-a-linked-list/#/description"
 *      >237. Delete Node in a Linked List</a>
 * @description
 *              Write a function to delete a node (except the tail) in a singly
 *              linked list, given only access to that node.
 *              Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given
 *              the third node with value 3, the linked list should become 1 ->
 *              2 -> 4 after calling your function.
 */
public class L237DeleteNodeInALinkedList {

    public static void main(String[] args) {
        ListNode pointer = null;
        ListNode node1 = new ListNode(2);
        pointer = node1;
        pointer.next = new ListNode(4);
        pointer = pointer.next;
        pointer.next = new ListNode(5);
        printList(node1);
        Solution solution = new SolutionImpl();
        solution.deleteNode(pointer.next);
        printList(pointer);
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

        public void deleteNode(ListNode node);
    }

    public static class SolutionImpl implements Solution {

        @Override
        public void deleteNode(ListNode node) {
            if (node == null || node.next == null) {
                return;
            }
            node.val = node.next.val;
            node.next = node.next.next;
        }

    }
}
