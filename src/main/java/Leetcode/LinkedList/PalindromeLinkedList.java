package Leetcode.LinkedList;

/**
 * https://leetcode.com/problems/palindrome-linked-list/
 * Created by George Fouche on 12/8/19.
 */


public class PalindromeLinkedList {
    public static void main(String[] args) {
        PalindromeLinkedList list = new PalindromeLinkedList();
        list.insertAtEnd(1);
        list.insertAtEnd(2);
        System.out.println(list);


        PalindromeLinkedList list2 = new PalindromeLinkedList();
        list2.insertAtEnd(1);
        list2.insertAtEnd(2);
        list2.insertAtEnd(2);
        list2.insertAtEnd(1);
        System.out.println(list2);

    }

    class Node<Integer> {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }


    private Node head;

    @SuppressWarnings("Duplicates")
    private void insertAtEnd(int data) {
        if (isEmpty()) {
            insertAtHead(data);
        } else {
            Node current = this.head;
            while (current.next != null) {
                current = current.next;
            }
            Node newNode = new Node(data);
            current.next = newNode;
        }
    }

    private void insertAtHead(int data) {
        Node newNode = new Node(data);
        newNode.next = this.head;
        this.head = newNode;
    }


    private boolean isEmpty() {
        return head == null;
    }

    @SuppressWarnings("Duplicates")
    @Override
    public String toString() {
        String result = "{";
        Node current = this.head;
        while (current != null) {
            result += current.val + "->";
            current = current.next;
        }
        result += current;
        result += "}";
        return result;
    }

}
