package educative.datastructures.linkedlist;

/**
 * Created by George Fouche on 12/9/19.
 */


public class SingleLinkedList {

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
        System.out.println("Insert 3 after 2");
        list2.insertAfter(3, 2);
        System.out.println("Searching for 3");
        System.out.println(list2.searchNode(3));
        System.out.println(list2);
        System.out.println("Delete at head");
        list2.deleteAtHead();
        System.out.println(list2);


        System.out.println();

        SingleLinkedList list3 = new SingleLinkedList();
        list3.insertAtEnd(1);
        list3.insertAtEnd(2);
        list3.insertAtEnd(4);
        System.out.println("Insert at End");
        System.out.println(list3);
        System.out.println("Delete by value");
        list3.deleteByValue(2);
        System.out.println(list3);


    }

    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    private Node head;

    private void insertAtHead(int data) {
        Node newNode = new Node(data);
        newNode.next = this.head;
        this.head = newNode;
    }

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


    boolean searchNode(int data) {
        Node current = this.head;
        while (current != null) {
            if (current.val == data) return true;
            current = current.next;
        }
        return false;
    }

    void deleteAtHead() {
        if (!isEmpty()) {
            head = head.next;
        }
    }

    void deleteByValue(int data) {
        if (!isEmpty()) {
            Node current = this.head;
            Node prev = null;

            // data is at head so delete from head
            if (current.val == data) {
                deleteAtHead();
                return;
            }

            while (current != null) {
                if (current.val == data) {
                    prev.next = current.next;
                    return;
                }
                prev = current;
                current = current.next;
            }

        }
    }

    private boolean isEmpty() {
        return this.head == null;
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

