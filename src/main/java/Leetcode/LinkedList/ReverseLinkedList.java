package Leetcode.LinkedList;





/**
 * Created by George Fouche on 12/8/19.
 */
public class ReverseLinkedList {
    class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }

    private Node head;

    public static void main(String[] args) {
        ReverseLinkedList list = new ReverseLinkedList();
        list.insertAtHead(1);
        list.insertAtHead(2);
        list.insertAtHead(3);
        list.insertAtHead(4);
        list.insertAtHead(5);
        list.insertAtHead(6);
        list.insertAtHead(7);
        list.insertAtHead(8);
        System.out.println(list);
        System.out.println(list.length());
        list.reverseList();
        System.out.println(list);


    }


    public Node reverseList() {
        Node prev = null;
        Node current = head;
        Node next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }


    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        newNode.next = this.head;
        this.head = newNode;
    }

    public int length() {
        if (head == null) {
            return 0;
        }
        int length = 0;
        Node current = this.head;
        while (current != null) {
            length += 1;
            current = current.next;
        }
        return length;
    }


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
