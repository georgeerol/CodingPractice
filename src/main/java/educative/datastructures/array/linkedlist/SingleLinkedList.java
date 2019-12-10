package educative.datastructures.array.linkedlist;

/**
 * Created by George Fouche on 12/9/19.
 */


public class SingleLinkedList {
    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        list.insertAtHead(1);
        list.insertAtHead(2);
        list.insertAtHead(3);
        System.out.println("Insert at Head");
        System.out.println(list);


        SingleLinkedList list2 = new SingleLinkedList();
        list2.insertAtEnd(1);
        list2.insertAtEnd(2);
        list2.insertAtEnd(4);
        System.out.println("Insert at End");
        System.out.println(list2);
        list2.insertAfter(3, 2);
        System.out.println(list2);


    }

    private Node head;

    private void insertAtHead(int data) {
        Node newNode = new Node(data);
        newNode.next = this.head;
        this.head = newNode;
    }

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

    private void insertAfter(int data, int previous) {
        Node newNode = new Node(data);
        Node current = this.head;

        while (current != null && current.val != previous) {
            current = current.next;
        }

        if (current != null) {
            newNode.next = current.next;
            current.next = newNode;
        }
    }




    private boolean isEmpty() {
        if (head == null) return true;
        return false;
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

