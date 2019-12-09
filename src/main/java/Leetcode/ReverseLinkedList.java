package Leetcode;


class ListNode<Integer> {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}




/**
 * Created by George Fouche on 12/8/19.
 */
public class ReverseLinkedList {
    private ListNode<Integer> head;

    public static void main(String[] args) {




    }



    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }




    public void addAtStart(int data){

    }


}
