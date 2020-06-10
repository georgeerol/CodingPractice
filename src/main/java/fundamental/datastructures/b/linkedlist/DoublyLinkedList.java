package fundamental.datastructures.b.linkedlist;

/**
 * Created by George Fouche on 1/14/20.
 */
public class DoublyLinkedList<T> {

    public class Node {
        public T data;
        public Node nextNode;
        public Node prevNode;
    }

    public Node headNode;
    public int size;

    public DoublyLinkedList() {
        this.headNode = null;
    }

    public boolean isEmpty() {
        return headNode == null;
    }


    private void insertAtHead(T data) {
        Node newNode = new Node();
        newNode.data = data;

        newNode.nextNode = this.headNode;
        newNode.prevNode = null;

        if (headNode != null)
            headNode.prevNode = newNode;
        this.headNode = newNode;
        size++;
    }


    public void printList() {
        if (isEmpty()) {
            System.out.println("List is empty!");
            return;
        }
        Node temp = headNode;
        System.out.print("List : null <-");

        while (temp.nextNode != null) {
            System.out.print(temp.data.toString() + "<->");
            temp = temp.nextNode;
        }
        System.out.println(temp.data.toString() + "-> null");

    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        for (int i = 0; i <= 10; i++) {
            dll.insertAtHead(i);
        }

        dll.printList();
    }

}
